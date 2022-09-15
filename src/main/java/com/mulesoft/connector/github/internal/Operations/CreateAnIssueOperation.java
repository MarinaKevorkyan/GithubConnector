package com.mulesoft.connector.github.internal.Operations;

import com.mulesoft.connector.github.api.Domain.IssueAnswer;
import com.mulesoft.connector.github.internal.Connection.GithubConnection;
import com.mulesoft.connector.github.internal.Converters.ResultConverter;
import com.mulesoft.connector.github.internal.Domain.Issue;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

@Alias("CreateAnIssue")
public class CreateAnIssueOperation {
    private ResultConverter resultConverter = new ResultConverter();
    @MediaType(MediaType.ANY)
    public Result<IssueAnswer, InputStream> createAnIssue (@Connection GithubConnection connection,
                                                           @DisplayName("Username") String username,
                                                           @DisplayName("Repository") String reponame,
                                                           @DisplayName("Title") String title,
                                                           @DisplayName("Body") @Optional String body,
                                                           @DisplayName ("Milestone") @Optional String milestone,
                                                           @DisplayName ("Labels")  @Optional ArrayList<Object> labels,
                                                           @DisplayName ("Assignees") @Optional ArrayList<Object> assignees

    ) throws IOException, TimeoutException {

        Issue issue = new Issue(title, body, milestone, labels, assignees);
        HttpResponse httpResponse = connection.getService().createAnIssue(username, reponame, issue);
        return resultConverter.buildResultIssueResponse(connection.getService().getHttpClientGithub().getAttributes(httpResponse), httpResponse.getEntity().getContent());
    }
}