package com.mulesoft.connector.github.internal.Operations;

import com.mulesoft.connector.github.api.Domain.IssueList;
import com.mulesoft.connector.github.api.Domain.IssueResponse;
import com.mulesoft.connector.github.internal.Connection.GithubConnection;
import com.mulesoft.connector.github.internal.Converters.ResultConverter;
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
    public Result<IssueResponse, InputStream> createAnIssue (@Connection GithubConnection connection,
                                                             @DisplayName("Username") String username,
                                                             @DisplayName("Repository") String reponame,
                                                             @DisplayName("Title") String title,
                                                             @DisplayName("Body") @Optional String body,
                                                             @DisplayName ("Milestone") @Optional String milestone,
                                                             @DisplayName ("Labels")  @Optional ArrayList<String> labels,
                                                             @DisplayName ("Assignees") @Optional ArrayList<String> assignees

    ) throws IOException, TimeoutException {

        IssueList issue = new IssueList(title, body, labels, assignees, milestone);
        HttpResponse httpResponse = connection.getService().createAnIssue(username, reponame, issue);
        return resultConverter.buildResultIssueResponse(connection.getService().getHttpClientGithub().getAttributes(httpResponse), httpResponse.getEntity().getContent());
    }
}