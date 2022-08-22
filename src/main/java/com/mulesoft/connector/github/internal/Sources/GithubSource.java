package com.mulesoft.connector.github.internal.Sources;

import com.mulesoft.connector.github.internal.Connection.GithubmarinaConnection;
import com.mulesoft.connector.github.internal.Converters.ResultConverter;
import com.mulesoft.connector.github.internal.Domain.Issue;
import com.mulesoft.connector.github.internal.Service.SourceService;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.exception.MuleException;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.source.EmitsResponse;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.extension.api.runtime.source.PollContext;
import org.mule.runtime.extension.api.runtime.source.PollingSource;
import org.mule.runtime.extension.api.runtime.source.SourceCallbackContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;

@Alias(value = "githubSource", description = "Listener for new issues")
@DisplayName("Issue listener")
@EmitsResponse
public class GithubSource extends PollingSource<Issue, InputStream> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SourceService.class);
    @Connection
    private ConnectionProvider<GithubmarinaConnection> connectionProvider;

    private GithubmarinaConnection connection;

    private ResultConverter resultConverter;

    private SourceService sourceService;
    @Parameter
    private String owner;
    @Parameter
    private String repoName;
    @Parameter
    private String since;

    @Override
    protected void doStart() throws MuleException {
        connection = connectionProvider.connect();
        resultConverter = new ResultConverter();
        sourceService = new SourceService(connection, resultConverter);
    }

    @Override
    protected void doStop() {
        connectionProvider.disconnect(connection);
    }

    @Override
    public void poll(PollContext<Issue, InputStream> pollContext) {
        try {
            sourceService.poll(pollContext, owner, repoName, since);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onRejectedItem(Result<Issue, InputStream> result, SourceCallbackContext sourceCallbackContext) {
        LOGGER.debug("Issue: " + result.getOutput() + "has been rejected");
        System.out.println("Issue: " + result.getOutput().getNumber() + "has been rejected");
    }
}
