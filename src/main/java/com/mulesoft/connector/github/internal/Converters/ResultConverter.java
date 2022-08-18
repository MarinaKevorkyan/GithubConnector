package com.mulesoft.connector.github.internal.Converters;

import org.mule.runtime.api.metadata.MediaType;
import org.mule.runtime.extension.api.runtime.operation.Result;

import java.io.InputStream;

public class ResultConverter {
    public Result<InputStream, InputStream> buildResult(InputStream attributes, InputStream content) {
        return Result.<InputStream, InputStream>builder().output(content).attributes(attributes).mediaType(MediaType.APPLICATION_JSON).attributesMediaType(MediaType.APPLICATION_JSON).build();
    }
}
