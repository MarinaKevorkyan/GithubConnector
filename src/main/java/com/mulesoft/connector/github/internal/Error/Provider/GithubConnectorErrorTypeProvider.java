package com.mulesoft.connector.github.internal.Error.Provider;

import com.mulesoft.connector.github.internal.Error.GithubConnectorErrorType;
import org.mule.runtime.extension.api.annotation.error.ErrorTypeProvider;
import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class GithubConnectorErrorTypeProvider implements ErrorTypeProvider {
    @Override
    public Set<ErrorTypeDefinition> getErrorTypes() {
        return Stream.of(GithubConnectorErrorType.values()).collect(toSet());
    }
}
