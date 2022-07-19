package com.mulesoft.connector.github.internal.Connection;


import org.mule.runtime.http.api.client.HttpClient;
import org.mule.runtime.http.api.domain.message.request.HttpRequest;

/**
 * This class represents an extension connection just as example (there is no real connection with anything here c:).
 */
public final class GithubmarinaConnection {

  private HttpClient httpClient;
  private String token;

  private final String id;

  public GithubmarinaConnection(HttpClient httpClient, String token) {
    //this.id = id;
    this.httpClient = httpClient;
    this.token = token;
  }

  public String getId() {
    return id;
  }

  public void invalidate() {
    this.httpClient.stop();
    // do something to invalidate this connection!
  }
}
