package com.mulesoft.connector.github.internal.Sources;

import com.mulesoft.connector.github.api.Domain.IssueList;
import com.mulesoft.connector.github.internal.Connection.GithubConnection;
import com.mulesoft.connector.github.internal.Converters.IssueConverter;
import com.mulesoft.connector.github.internal.Converters.ResultConverter;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.exception.MuleException;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.source.EmitsResponse;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.extension.api.runtime.source.PollContext;
import org.mule.runtime.extension.api.runtime.source.PollingSource;
import org.mule.runtime.extension.api.runtime.source.SourceCallbackContext;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Alias(value = "githubSource", description = "Listener for new issues")
@DisplayName("Issue listener")
@MediaType(MediaType.ANY)
@EmitsResponse
public class GithubSource extends PollingSource<InputStream, InputStream> {

//    private static final Logger LOGGER = LoggerFactory.getLogger(GithubSource.class);
    @Connection
    private ConnectionProvider<GithubConnection> connectionProvider;

    private GithubConnection connection;
    private String watermarkField;

    private static ResultConverter resultConverter;
    private static IssueConverter issueConverter;

    @Parameter
    private String owner;
    @Parameter
       private String repoName;


    @Override
    protected void doStart() throws MuleException {
        connection = connectionProvider.connect();
        resultConverter = new ResultConverter();
        issueConverter = new IssueConverter();
    }

    @Override
    protected void doStop() {
        connectionProvider.disconnect(connection);
    }

    @Override
    public void poll(PollContext<InputStream, InputStream> pollContext) {
        try {
            pollIssue(pollContext, owner, repoName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onRejectedItem(Result<InputStream, InputStream> result, SourceCallbackContext sourceCallbackContext) {
//        LOGGER.debug("Issue: " + result.getOutput() + "has been rejected");
//        System.out.println("Issue: " + " has been rejected");
    }

    public void pollIssue(PollContext<InputStream, InputStream> pollContext, String owner, String repoName) throws IOException, TimeoutException {
        if(pollContext.isSourceStopping()){
            return;
        }
        HttpResponse issuesResponse = connection.getService().listRepositoryIssues(owner, repoName, watermarkField);
        List<IssueList> issueList = issueConverter.convertInputStreamToIssues(issuesResponse.getEntity().getContent());
        for(IssueList issue : issueList){
            if(pollContext.isSourceStopping()){
                break;
            }
            PollContext.PollItemStatus status = pollContext.accept(itemIssue -> {
                SourceCallbackContext context = itemIssue.getSourceCallbackContext(); //gets the context from the itemIssue
                context.addVariable("attributes", issue); //Saves the data on the SourcecallbackContext

                Result<InputStream, InputStream> result = null;
                try {
                    result = resultConverter.buildResultIssue(connection.getService().getHttpClientGithub().getAttributes(issuesResponse), issue);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                itemIssue.setResult(result);
                itemIssue.setId(issue.getUrl()); //for idempotency
                itemIssue.setWatermark(issue.getCreatedAt());
                watermarkField = issue.getCreatedAt();
            });

            if(!status.equals(PollContext.PollItemStatus.ACCEPTED)){
//                LOGGER.debug("Item rejected with code: " + status.name());
                System.out.println("Item rejected with code: " + status.name());
            }
        }
    }
}
