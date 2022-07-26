package com.mulesoft.connector.github.internal.Operations;

import com.mulesoft.connector.github.internal.Connection.GithubmarinaConnection;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

import org.mule.runtime.extension.api.runtime.operation.Result;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;

@Alias("getAUser")
public class GetAUserOperation {
    @MediaType(MediaType.APPLICATION_JSON)
    public Result<InputStream, InputStream> getUserInfo (@Connection GithubmarinaConnection connection, @DisplayName("Username") String username) throws IOException, TimeoutException {
        return connection.getService().getAUser(username);
    }

}
