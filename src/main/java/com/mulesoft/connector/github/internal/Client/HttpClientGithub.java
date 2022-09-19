package com.mulesoft.connector.github.internal.Client;

import com.google.gson.Gson;
import com.mulesoft.connector.github.api.Domain.IssueList;
import org.mule.runtime.http.api.HttpConstants;
import org.mule.runtime.http.api.HttpHeaders;
import org.mule.runtime.http.api.client.HttpClient;
import org.mule.runtime.http.api.client.HttpRequestOptions;
import org.mule.runtime.http.api.domain.entity.ByteArrayHttpEntity;
import org.mule.runtime.http.api.domain.message.request.HttpRequest;
import org.mule.runtime.http.api.domain.message.request.HttpRequestBuilder;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HttpClientGithub {

    private final Gson gson = new Gson();
    private final HttpClient httpClient;
    private final String token;

    public HttpClientGithub(HttpClient httpClient, String token) {
        this.httpClient = httpClient;
        this.token = token;
    }

    public String setUri(String end) {
        String baseURi = "https://api.github.com/";
        return baseURi + end;
    }

    public HttpRequestBuilder request(HttpConstants.Method method, String uri, HashMap<String, Object> body) {
        String s = new Gson().toJson(body);
        ByteArrayHttpEntity httpEntity = new ByteArrayHttpEntity(s.getBytes());
        return addHeaders(HttpRequest.builder().method(method).uri(uri).entity(httpEntity));
    }

    public HttpResponse send(HttpRequest request, Integer time, TimeUnit unit) throws IOException, TimeoutException {
        HttpRequestOptions requestOptions = HttpRequestOptions.builder().responseTimeout((int) unit.toMillis(time)).build();
        HttpResponse response = httpClient.send(request, requestOptions);
        //return response(response);
        return response;
    }

    public HttpRequestBuilder addHeaders(HttpRequestBuilder requestBuilder) {
        return requestBuilder.addHeader(HttpHeaders.Names.AUTHORIZATION, "token " + token);
    }

    public InputStream getAttributes(HttpResponse response) {
        HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("StatusCode", response.getStatusCode());
        attributes.put("ReasonPhrase", response.getReasonPhrase());
        attributes.putAll(response.getHeaders());

        return new ByteArrayInputStream(gson.toJson(attributes, HashMap.class).getBytes());
    }

//    --------------------------- Create an issue ----------------------
    public HashMap<String, Object> createBodyIssue(IssueList issue) {
        HashMap<String, Object> bodyIssue = new HashMap<>();
        bodyIssue.put("title", issue.getTitle());
        bodyIssue.put("body", issue.getBody());
        bodyIssue.put("milestone", issue.getMilestone());
        bodyIssue.put("labels", issue.getLabels());
        bodyIssue.put("assignees", issue.getAssignees());

        return bodyIssue;
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }
}
