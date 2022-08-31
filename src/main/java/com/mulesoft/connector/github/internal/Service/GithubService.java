package com.mulesoft.connector.github.internal.Service;

import com.mulesoft.connector.github.internal.Client.HttpClientGithub;
import com.mulesoft.connector.github.internal.Domain.Issue;
import org.mule.runtime.http.api.HttpConstants;
import org.mule.runtime.http.api.domain.message.request.HttpRequest;
import org.mule.runtime.http.api.domain.message.request.HttpRequestBuilder;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GithubService {

    private static final Integer TIMEOUT = 1;
    private HttpClientGithub httpClientGithub;

    public GithubService(HttpClientGithub httpClientGithub) {
        this.httpClientGithub = httpClientGithub;
    }

    public HttpClientGithub getHttpClientGithub() {
        return httpClientGithub;
    }

    public HttpResponse getAUser(String username) throws IOException, TimeoutException {
        HttpRequest httpRequest = httpClientGithub.request(HttpConstants.Method.GET, httpClientGithub.setUri("users/" + username), new HashMap<>()).build();
        return httpClientGithub.send(httpRequest, TIMEOUT, TimeUnit.SECONDS);
    }

    public HttpResponse createAnIssue(String username, String reponame, Issue issue) throws IOException, TimeoutException {
        HashMap<String, Object> bodyIssue = httpClientGithub.createBodyIssue(issue);
        HttpRequest httpRequest = httpClientGithub.request(HttpConstants.Method.POST, httpClientGithub.setUri("repos/" + username + "/" + reponame + "/issues"), bodyIssue).build();
        return httpClientGithub.send(httpRequest, TIMEOUT, TimeUnit.SECONDS);
    }

    public HttpResponse listRepositoryIssues(String owner, String repoName, String since) throws IOException, TimeoutException {
        HttpRequestBuilder builder = httpClientGithub.request(HttpConstants.Method.GET, httpClientGithub.setUri("repos/" + owner + "/" + repoName + "/issues"), new HashMap<>());

        builder.addQueryParam("state", "all");
        builder.addQueryParam("sort", "created");
        builder.addQueryParam("direction", "ASC");
        builder.addQueryParam("since", since);

        HttpRequest httpRequest = builder.build();
        return httpClientGithub.send(httpRequest, TIMEOUT, TimeUnit.SECONDS);
    }


}



