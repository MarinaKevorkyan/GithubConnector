package com.mulesoft.connector.github.internal.Converters;

import com.mulesoft.connector.github.internal.Domain.Issue;
import org.mule.runtime.api.metadata.MediaType;
import org.mule.runtime.extension.api.runtime.operation.Result;

import java.io.InputStream;

public class ResultConverter {
    public Result<InputStream, InputStream> buildResult(InputStream attributes, InputStream content) {
        if(content == null){
            throw new RuntimeException();
        }
        return Result.<InputStream, InputStream>builder().output(content).attributes(attributes).mediaType(MediaType.APPLICATION_JSON).attributesMediaType(MediaType.APPLICATION_JSON).build();
    }

    public Result<Issue, InputStream> buildResultIssue(InputStream attributes, Issue content) {
        if(content == null){
            throw new RuntimeException();
        }
        return Result.<Issue, InputStream>builder().output(content).attributes(attributes).build();
    }
}
