package com.mulesoft.connector.github.internal.Operations;

import org.mule.runtime.http.api.HttpConstants;
import org.mule.runtime.http.api.domain.message.request.HttpRequest;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import javax.xml.transform.Result;

public class FindUserProfile {

    private static final int TIMEOUT = 1;

    public Result<,> searchProfile (String username){
        HttpRequest httpRequest = request (HttpConstants.Method.GET, URI, body);
        HttpResponse httpResponse = send (httpRequest, TIMEOUT, )
    }
}
