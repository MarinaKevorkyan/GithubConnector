package com.mulesoft.connector.github.internal.Operations;

import com.mulesoft.connector.github.internal.Connection.GithubmarinaConnection;
import org.mule.runtime.api.metadata.TypedValue;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.runtime.operation.Result;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

@Alias("CreateAnIssue")
public class CreateAnIssueOperation {
    @MediaType(MediaType.APPLICATION_JSON)
    public Result<InputStream, InputStream> createAnIssue (@Connection GithubmarinaConnection connection,
                                                           @DisplayName("Username") String username,
                                                           @DisplayName("Reponame") String reponame,
                                                           @DisplayName("Title") String title,
                                                           @DisplayName("Body") @Optional String body,
                                                           @DisplayName ("Milestone") @Optional String milestone,
                                                           @DisplayName ("Labels")  @Optional ArrayList<String> labels,
                                                           @DisplayName ("Assignees") @Optional ArrayList<String> assignees


    )throws IOException, TimeoutException {
        return connection.getService().createAnIssue(username, reponame, title, body, milestone, labels, assignees);
    }
}