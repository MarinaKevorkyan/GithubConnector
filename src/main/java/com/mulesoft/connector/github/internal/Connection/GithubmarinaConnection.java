package com.mulesoft.connector.github.internal.Connection;


import com.mulesoft.connector.github.internal.Client.HttpClientGithub;
import com.mulesoft.connector.github.internal.Service.GithubMarinaService;
import org.mule.runtime.http.api.client.HttpClient;

/**
 * This class represents an extension connection just as example (there is no real connection with anything here c:).
 */
public final class GithubmarinaConnection {

  private GithubMarinaService service;
  private HttpClientGithub httpClientGithub;
  public GithubMarinaService getService() {
    return service;
  }

  public GithubmarinaConnection(HttpClient httpClient, String token) {
    this.httpClientGithub = new HttpClientGithub(httpClient, token);
    this.service = new GithubMarinaService(this.httpClientGithub);
  }

  public void invalidate() {
    this.httpClientGithub.getHttpClient().stop();
    // do something to invalidate this connection!
  }
}
