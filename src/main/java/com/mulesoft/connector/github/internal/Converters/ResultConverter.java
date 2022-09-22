package com.mulesoft.connector.github.internal.Converters;

import com.google.gson.Gson;
import com.mulesoft.connector.github.api.Domain.IssueList;
import com.mulesoft.connector.github.api.Domain.IssueResponse;
import org.mule.runtime.api.metadata.MediaType;
import org.mule.runtime.extension.api.runtime.operation.Result;

import java.io.IOException;
import java.io.InputStream;

import static org.apache.commons.io.IOUtils.toInputStream;

public class ResultConverter {

    IssueConverter issueConverter = new IssueConverter();
    public Result<InputStream, InputStream> buildResult(InputStream attributes, InputStream content) {
        if(content != null){
            return Result.<InputStream, InputStream>builder().output(content).attributes(attributes).mediaType(MediaType.APPLICATION_JSON).attributesMediaType(MediaType.APPLICATION_JSON).build();
        }else{
            return null;
        }

    }

    public Result<InputStream, InputStream> buildResultIssue(InputStream attributes, IssueList content) throws IOException {
        if(content != null){
            InputStream inputStreamIssue = toInputStream(new Gson().toJson(content));
            return Result.<InputStream, InputStream>builder().output(inputStreamIssue).attributes(attributes).build();
        } else {
            return null;
        }


    }

    public Result<IssueResponse, InputStream> buildResultIssueResponse (InputStream attributes, InputStream content) throws IOException {
        if(content != null){
            return Result.<IssueResponse, InputStream>builder().output(issueConverter.convertInputStreamToIssue(content)).attributes(attributes).build();
        }else {
            return null;
        }

    }
}
