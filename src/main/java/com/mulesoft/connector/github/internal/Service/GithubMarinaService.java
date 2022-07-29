package com.mulesoft.connector.github.internal.Service;

import com.google.gson.Gson;
import com.mulesoft.connector.github.internal.Connection.GithubmarinaConnection;
import org.mule.runtime.api.metadata.MediaType;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GithubMarinaService {

    private static final Integer TIMEOUT = 1;
    private Gson gson = new Gson();
    private GithubmarinaConnection connection;

    public GithubMarinaService(GithubmarinaConnection connection) {
        this.connection = connection;
    }

    /*public <T> T execute(Result<InputStream, InputStream> response) {
        try {
            return response;
        } catch (MuleRuntimeException e) {
            throw e;
        } catch (TimeoutException e) {
            throw new ModuleException("Request timeout exceeded.", GithubErrorType.TIMEOUT);
        } catch (ConnectException e) {
            throw new ModuleException(e.getMessage(), GithubErrorType.INVALID_CONNECTION);
        } catch (Exception e) {
            if (ExceptionUtils.containsType(e, UnresolvedAddressException.class)) {
                throw new ModuleException(e.getMessage(), GithubErrorType.INVALID_CONNECTION);
            }
            throw new MuleRuntimeException(e);
        }
    }*/

    public String setUri(String end) {
        String baseURi = "https://api.github.com/";
        return baseURi + end;
    }

    public Result<InputStream, InputStream> buildResponse(InputStream attributes, InputStream content) {
        return Result.<InputStream, InputStream>builder().output(content).attributes(attributes).mediaType(MediaType.APPLICATION_JSON).attributesMediaType(MediaType.APPLICATION_JSON).build();
    }

    public HttpRequestBuilder request(HttpConstants.Method method, String uri, HashMap<String, Object> body) {
        String s = new Gson().toJson(body);
        ByteArrayHttpEntity httpEntity = new ByteArrayHttpEntity(s.getBytes());
        return addHeaders(HttpRequest.builder().method(method).uri(uri).entity(httpEntity));
    }

    public HttpResponse send(HttpRequest request, Integer time, TimeUnit unit) throws IOException, TimeoutException {
        HttpRequestOptions requestOptions = HttpRequestOptions.builder().responseTimeout((int) unit.toMillis(time)).build();
        HttpResponse response = connection.getHttpClient().send(request, requestOptions);
        //return response(response);
        return response;
    }

    public HttpRequestBuilder addHeaders(HttpRequestBuilder requestBuilder) {
        return requestBuilder.addHeader(HttpHeaders.Names.AUTHORIZATION, "token " + connection.getToken());
    }

    public InputStream getAttributes(HttpResponse response) {
        HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("StatusCode", response.getStatusCode());
        attributes.put("ReasonPhrase", response.getReasonPhrase());
        attributes.putAll(response.getHeaders());

        return new ByteArrayInputStream(gson.toJson(attributes, HashMap.class).getBytes());
    }

//    public HttpResponse response(HttpResponse response) {
//        int statusCodeResponse = response.getStatusCode();
//        return StatusCodes.manageStatusCodes(statusCodeResponse);
//    }

    public Result<InputStream, InputStream> getAUser(String username) throws IOException, TimeoutException {
        HttpRequest httpRequest = request(HttpConstants.Method.GET, setUri("users/" + username ), new HashMap<>()).build();
        HttpResponse httpResponse = send(httpRequest, TIMEOUT, TimeUnit.SECONDS);
        return buildResponse(getAttributes(httpResponse), httpResponse.getEntity().getContent());
    }

    public Result<InputStream, InputStream> createAnIssue(String username, String reponame, String title, String body, String milestone, ArrayList<String> labels, ArrayList<String> assignees) throws IOException, TimeoutException {
        HashMap<String, Object> bodyIssue = createBodyIssue(title, body, milestone, labels, assignees);
        HttpRequest httpRequest = request(HttpConstants.Method.POST, setUri("repos/" + username + "/" + reponame + "/issues" ), bodyIssue).build();
        HttpResponse httpResponse = send(httpRequest, TIMEOUT, TimeUnit.SECONDS);
        return buildResponse(getAttributes(httpResponse), httpResponse.getEntity().getContent());
    }

    public HashMap<String, Object> createBodyIssue(String title, String body, String milestone, ArrayList<String> labels, ArrayList<String> assignees) {
        HashMap<String, Object> bodyIssue = new HashMap<>();
        bodyIssue.put("title", title);
        bodyIssue.put("body", body);
        bodyIssue.put("milestone", milestone);
        bodyIssue.put("labels", labels);
        bodyIssue.put("assignees", assignees);

        return bodyIssue;
    }
}



