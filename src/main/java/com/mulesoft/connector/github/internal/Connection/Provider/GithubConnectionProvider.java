package com.mulesoft.connector.github.internal.Connection.Provider;

import com.mulesoft.connector.github.internal.Connection.GithubConnection;
import org.mule.runtime.api.connection.*;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.RefName;
import org.mule.runtime.http.api.HttpService;
import org.mule.runtime.http.api.client.HttpClient;
import org.mule.runtime.http.api.client.HttpClientConfiguration;

import javax.inject.Inject;


/**
 * This class (as it's name implies) provides connection instances and the funcionality to disconnect and validate those
 * connections.
 * <p>
 * All connection related parameters (values required in order to create a connection) must be
 * declared in the connection providers.
 * <p>
 * This particular example is a {@link PoolingConnectionProvider} which declares that connections resolved by this provider
 * will be pooled and reused. There are other implementations like {@link CachedConnectionProvider} which lazily creates and
 * caches connections or simply {@link ConnectionProvider} if you want a new connection each time something requires one.
 */
public class GithubConnectionProvider implements PoolingConnectionProvider<GithubConnection> {

//  private final Logger LOGGER = LoggerFactory.getLogger(GithubConnectionProvider.class);

  @RefName
  private String configName;

  @Parameter
  private String token;

  @Inject
  private HttpService httpService;

  @Override
  public GithubConnection connect() throws ConnectionException {
      HttpClient httpClient = httpService.getClientFactory().create(new HttpClientConfiguration.Builder().setName(configName).build());
      httpClient.start();
      return new GithubConnection(httpClient, token);
  }

  @Override
  public void disconnect(GithubConnection connection) {
    try {
      connection.invalidate();
    } catch (Exception e) {
//      LOGGER.error("Error while disconnecting" + e.getMessage(), e);
    }
  }

  @Override
  public ConnectionValidationResult validate(GithubConnection connection) {
    return ConnectionValidationResult.success();
  }
}
