package com.mulesoft.connector.github.internal.Operations;

import com.mulesoft.connector.github.internal.Connection.GithubConnection;
import com.mulesoft.connector.github.internal.Converters.ResultConverter;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;

public class ListReposForAUser {
    ResultConverter resultConverter = new ResultConverter();

    @MediaType(MediaType.APPLICATION_JSON)
    public Result<InputStream, InputStream> listReposForUser (@Connection GithubConnection connection,
                                                              @DisplayName("Username") String username) throws IOException, TimeoutException {

        HttpResponse httpResponse = connection.getService().listRepositoriesForUser(username);
        return resultConverter.buildResult(connection.getService().getHttpClientGithub().getAttributes(httpResponse), httpResponse.getEntity().getContent());
    }
}
