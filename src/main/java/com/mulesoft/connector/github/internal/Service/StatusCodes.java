package com.mulesoft.connector.github.internal.Service;

import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import java.util.HashMap;

public class StatusCodes {

    private static StatusCodes statusCodes = null;
    private HashMap<Integer, String> mapCode = new HashMap<>();

    public HashMap<Integer, String> fillMapCode(){
        mapCode.put(200, "");
        mapCode.put(301, "");
        mapCode.put(401, "");
        mapCode.put(403, "");
        mapCode.put(404, "");
        mapCode.put(407, "");
        mapCode.put(422, "");
        mapCode.put(500, "");
        mapCode.put(502, "");

        return mapCode;
    }

    public static StatusCodes generateCodesMap (){
        if(statusCodes == null){
            statusCodes = new StatusCodes();
            statusCodes.mapCode = statusCodes.fillMapCode();
        }
        return statusCodes;
    }

    public HashMap<Integer, String> getStatusCodes() {
        mapCode = this.fillMapCode();
        return mapCode;
    }

    public HttpResponse manageStatusCodes (int statusCode){

        return null;
    }
}
