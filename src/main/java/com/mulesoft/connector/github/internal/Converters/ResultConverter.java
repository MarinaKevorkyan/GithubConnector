package com.mulesoft.connector.github.internal.Converters;

import com.google.gson.Gson;
import com.mulesoft.connector.github.internal.Domain.Issue;
import org.mule.runtime.api.metadata.MediaType;
import org.mule.runtime.extension.api.runtime.operation.Result;

import java.io.IOException;
import java.io.InputStream;

import static org.apache.commons.io.IOUtils.toInputStream;

public class ResultConverter {
    public Result<InputStream, InputStream> buildResult(InputStream attributes, InputStream content) {
        if(content == null){
            throw new RuntimeException();
        }
        return Result.<InputStream, InputStream>builder().output(content).attributes(attributes).mediaType(MediaType.APPLICATION_JSON).attributesMediaType(MediaType.APPLICATION_JSON).build();
    }

    public Result<InputStream, InputStream> buildResultIssue(InputStream attributes, Issue content) throws IOException {
        if(content == null){
            throw new RuntimeException();
        }
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(baos);
//
//        oos.writeObject(content);
//
//        oos.flush();
//        oos.close();
//
//        InputStream inputStreamIssue = new ByteArrayInputStream(baos.toByteArray());


        InputStream inputStreamIssue = toInputStream(new Gson().toJson(content));

        return Result.<InputStream, InputStream>builder().output(inputStreamIssue).attributes(attributes).build();
    }
}
