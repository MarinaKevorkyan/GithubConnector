package com.mulesoft.connector.github.internal.Service;

import com.google.gson.Gson;
import com.mulesoft.connector.github.internal.Connection.GithubmarinaConnection;
import org.mule.runtime.api.metadata.MediaType;
import org.mule.runtime.extension.api.error.MuleErrors;
import org.mule.runtime.extension.api.exception.ModuleException;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.http.api.HttpConstants;
import org.mule.runtime.http.api.HttpHeaders;
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

public class GithubMarinaService {
    private Gson gson = new Gson();
    private static final Integer TIMEOUT = 1;

    private String baseURI = "https://api.github.com/users/";

    private GithubmarinaConnection connection;

    public GithubMarinaService(GithubmarinaConnection connection) {
        this.connection = connection;
    }

    public Result<InputStream, InputStream> getAUser (String username) throws IOException, TimeoutException {
        HttpRequest httpRequest = request (HttpConstants.Method.GET, baseURI+username, new HashMap<>()).build();
        HttpResponse httpResponse = send (httpRequest, TIMEOUT, TimeUnit.SECONDS);
        return buildResponse (getAttributes(httpResponse), httpResponse.getEntity().getContent());
    }

    public Result<InputStream, InputStream> createAnIssue () throws IOException, TimeoutException {
        HttpRequest httpRequest = request(HttpConstants.Method.POST, baseURI, new HashMap<>()).build();
        HttpResponse httpResponse = send(httpRequest, TIMEOUT, TimeUnit.SECONDS);
        return buildResponse(getAttributes(httpResponse), httpResponse.getEntity().getContent());
    }




    private Result<InputStream, InputStream> buildResponse(InputStream attributes, InputStream content) {
        return Result.<InputStream, InputStream>builder().output(content).attributes(attributes).mediaType(MediaType.APPLICATION_JSON).attributesMediaType(MediaType.APPLICATION_JSON).build();
    }

    public HttpRequestBuilder request (HttpConstants.Method method, String uri, HashMap<String, Object> body){
        ByteArrayHttpEntity httpEntity = new ByteArrayHttpEntity(new Gson().toJson(body).getBytes());
        return addHeaders(HttpRequest.builder().method(method).uri(uri).entity(httpEntity));
    }

    public HttpResponse send (HttpRequest request, Integer time, TimeUnit unit) throws IOException, TimeoutException {
        HttpRequestOptions requestOptions = HttpRequestOptions.builder().responseTimeout((int) unit.toMillis(time)).build();
        HttpResponse response = connection.getHttpClient().send(request, requestOptions);
        return response (response);
    }

    public HttpRequestBuilder addHeaders (HttpRequestBuilder requestBuilder){
        return requestBuilder.addHeader(HttpHeaders.Names.AUTHORIZATION, "Token" + connection.getToken());
    }

    public InputStream getAttributes (HttpResponse response){
        HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("StatusCode", response.getStatusCode());
        attributes.put("ReasonPhrase", response.getReasonPhrase());
        attributes.putAll(response.getHeaders());

        return new ByteArrayInputStream(gson.toJson(attributes).getBytes());
    }

    public HttpResponse response (HttpResponse response){
        int statusCodeResponse = response.getStatusCode();

        if(200 <= statusCodeResponse && statusCodeResponse < 300){
            return response;
        }
        switch (statusCodeResponse) {
            case 404:
                throw new ModuleException("Resource not found. Status code: " + statusCodeResponse, MuleErrors.ANY); //Buscar que es esto de MuleErrors
        }
        return response;
    }}
