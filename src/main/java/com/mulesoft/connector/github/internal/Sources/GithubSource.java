package com.mulesoft.connector.github.internal.Sources;

import com.mulesoft.connector.github.internal.Connection.GithubmarinaConnection;
import com.mulesoft.connector.github.internal.Connection.Provider.GithubmarinaConnectionProvider;
import com.mulesoft.connector.github.internal.Converters.ResultConverter;
import com.mulesoft.connector.github.internal.Service.SourceService;
import org.mule.runtime.api.exception.MuleException;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.source.EmitsResponse;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.extension.api.runtime.source.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;

@Alias("")
@EmitsResponse
public class GithubSource extends PollingSource<InputStream, InputStream> {

    @Connection
    private GithubmarinaConnectionProvider connectionProvider;

    private GithubmarinaConnection connection;

    private ResultConverter resultConverter;

    @Parameter
    private String watermarkField;

    private SourceService sourceService;
    @Parameter
    private String owner;
    @Parameter
    private String repoName;


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
    public void poll(PollContext<InputStream, InputStream> pollContext) {
        try {
            sourceService.poll(pollContext, watermarkField, owner, repoName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onRejectedItem(Result<InputStream, InputStream> result, SourceCallbackContext sourceCallbackContext) {

    }
}
