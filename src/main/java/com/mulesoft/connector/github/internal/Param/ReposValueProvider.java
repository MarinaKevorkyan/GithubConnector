package com.mulesoft.connector.github.internal.Param;

import org.mule.runtime.api.value.Value;
import org.mule.runtime.extension.api.annotation.metadata.MetadataKeyPart;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.values.ValueProvider;

import java.util.List;
import java.util.Set;

public class ReposValueProvider implements ValueProvider {

    @Parameter
    @MetadataKeyPart(order = 1)
    private String username;

    @Parameter
    @MetadataKeyPart(order = 2)
    private List<String> userRepos;

    public String getUsername() {
        return username;
    }

    public List<String> getUserRepos() {
        return userRepos;
    }

    public Set<Value> resolve() {
        return null;
    }


}
