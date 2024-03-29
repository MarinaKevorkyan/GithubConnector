package com.mulesoft.connector.github.internal.Operations;

import com.mulesoft.connector.github.internal.Connection.GithubConnection;
import com.mulesoft.connector.github.internal.Converters.ResultConverter;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;

public class ListRepoIssuesOperation {
    @Alias("ListRepoIssues")
        ResultConverter resultConverter = new ResultConverter();

        @MediaType(MediaType.APPLICATION_JSON)
        public Result<InputStream, InputStream> listRepoIssues (@Connection GithubConnection connection,
                                                               @DisplayName("Username") String username,
                                                               @DisplayName("Reponame") String reponame,
                                                                @DisplayName("Since") String since
        ) throws IOException, TimeoutException {
            HttpResponse httpResponse = connection.getService().listRepositoryIssues(username, reponame, since);
            return resultConverter.buildResult(connection.getService().getHttpClientGithub().getAttributes(httpResponse), httpResponse.getEntity().getContent());
        }
}
