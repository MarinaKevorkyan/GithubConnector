package com.mulesoft.connector.github.internal.Connection;


import com.mulesoft.connector.github.internal.Service.GithubMarinaService;
import org.mule.runtime.http.api.client.HttpClient;

/**
 * This class represents an extension connection just as example (there is no real connection with anything here c:).
 */
public final class GithubmarinaConnection {

  private HttpClient httpClient;
  private String token;
  private GithubMarinaService service;
  //private GithubMarinaGeneral utils;
  public GithubMarinaService getService() {
    return service;
  }

  public HttpClient getHttpClient() {
    return httpClient;
  }

  public String getToken() {
    return token;
  }

  public GithubmarinaConnection(HttpClient httpClient, String token) {
    this.httpClient = httpClient;
    this.token = token;
    this.service = new GithubMarinaService(this);
    //this.utils = new GithubMarinaGeneral(this);

  }

  public void invalidate() {
    this.httpClient.stop();
    // do something to invalidate this connection!
  }
}
