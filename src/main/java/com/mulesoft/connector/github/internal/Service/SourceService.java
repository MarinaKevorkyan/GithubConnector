package com.mulesoft.connector.github.internal.Service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.mulesoft.connector.github.internal.Connection.GithubmarinaConnection;
import com.mulesoft.connector.github.internal.Converters.ResultConverter;
import com.mulesoft.connector.github.internal.Domain.Issue;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.extension.api.runtime.source.PollContext;
import org.mule.runtime.extension.api.runtime.source.SourceCallbackContext;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class SourceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SourceService.class);
    private GithubmarinaConnection connection;
    private ResultConverter resultConverter;
    private String watermarkField;

    public SourceService(GithubmarinaConnection connection, ResultConverter resultConverter) {
        this.connection = connection;
        this.resultConverter = resultConverter;
    }

    public void poll(PollContext<Issue, InputStream> pollContext, String owner, String repoName, String since) throws IOException, TimeoutException {
        if(pollContext.isSourceStopping()){
            return;
        }
        HttpResponse issuesResponse = getIssues(owner, repoName, since);
        List<Issue> issueList = convertInputStreamToIssue(issuesResponse.getEntity().getContent());
        for(Issue issue : issueList){
            if(pollContext.isSourceStopping()){
                break;
            }
            PollContext.PollItemStatus status = pollContext.accept(itemIssue -> {
                SourceCallbackContext context = itemIssue.getSourceCallbackContext(); //gets the context from the itemIssue
                context.addVariable("attributes", issue); //Saves the data on the SourcecallbackContext

                Result<Issue, InputStream> result = resultConverter.buildResultIssue(connection.getService().getHttpClientGithub().getAttributes(issuesResponse), issue);
                itemIssue.setResult(result);
                itemIssue.setId(issue.getUrl()); //for idempotency
                itemIssue.setWatermark(issue.created_at);
            });

            if(!status.equals(PollContext.PollItemStatus.ACCEPTED)){
                LOGGER.debug("Item rejected with code: " + status.name());
                System.out.println("Item rejected with code: " + status.name());
            }
        }
    }

    public HttpResponse getIssues (String owner, String repoName, String since) throws IOException, TimeoutException {
        return connection.getService().listRepositoryIssues(owner, repoName, since);
    }

    public List<Issue> convertInputStreamToIssue (InputStream inputStream) throws IOException {
        if(inputStream != null){
            Gson gson = new Gson();
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            List<Issue> issues = new ArrayList<>();
            jsonReader.beginArray();
            while(jsonReader.hasNext()){
                Issue issue = gson.fromJson(jsonReader, Issue.class);
                issues.add(issue);
            }
            jsonReader.endArray();
            jsonReader.close();
            return issues;
        }
        else{
            return null;
        }
    }
}


