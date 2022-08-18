package com.mulesoft.connector.github.internal.Service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.mulesoft.connector.github.internal.Connection.GithubmarinaConnection;
import com.mulesoft.connector.github.internal.Converters.ResultConverter;
import com.mulesoft.connector.github.internal.Domain.Issue;
import org.mule.runtime.extension.api.runtime.source.PollContext;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class SourceService {

    private GithubmarinaConnection connection;
    private ResultConverter resultConverter;

    public SourceService(GithubmarinaConnection connection, ResultConverter resultConverter) {
        this.connection = connection;
        this.resultConverter = resultConverter;
    }

    public void poll(PollContext<InputStream, InputStream> pollContext, String watermarkField, String owner, String repoName) throws IOException, TimeoutException {
        if(pollContext.isSourceStopping()){
            return;
        }
        HttpResponse issuesResponse = getIssues(owner, repoName);
        List<Issue> issues = convertInputStreamToIssue(issuesResponse.getEntity().getContent());
        for(int i = 0; i < issues.size(); i++){
            if(pollContext.isSourceStopping()){
                break;
            }
            pollContext.accept(issue -> {
                //Result<InputStream, InputStream> result = resultConverter.buildResult(connection.getService().getHttpClientGithub().getAttributes(issuesResponse), );
                //issue.setResult(result);
            });

        }


    }

    public HttpResponse getIssues (String owner, String repoName) throws IOException, TimeoutException {
        return connection.getService().listRepositoryIssues(owner, repoName);
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


