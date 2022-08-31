package com.mulesoft.connector.github.internal.Connection;


import com.mulesoft.connector.github.internal.Client.HttpClientGithub;
import com.mulesoft.connector.github.internal.Service.GithubService;
import org.mule.runtime.http.api.client.HttpClient;

/**
 * This class represents an extension connection just as example (there is no real connection with anything here c:).
 */
public final class GithubConnection {

  private GithubService service;
  public GithubService getService() {
    return service;
  }

  public GithubConnection(HttpClient httpClient, String token) {
    this.service = new GithubService(new HttpClientGithub(httpClient, token));
  }

  public void invalidate() {
    service.getHttpClientGithub().getHttpClient().stop();
  }
}
