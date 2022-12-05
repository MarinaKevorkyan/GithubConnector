package com.mulesoft.connector.github.internal.Error;

import org.mule.runtime.extension.api.error.ErrorTypeDefinition;
import org.mule.runtime.extension.api.error.MuleErrors;

import java.util.Arrays;

public enum GithubConnectorErrorType implements ErrorTypeDefinition<GithubConnectorErrorType> {
    INVALID_CONNECTION(MuleErrors.CONNECTIVITY),
    CONNECTIVITY(MuleErrors.CONNECTIVITY),
    ;

    GithubConnectorErrorType(MuleErrors connectivity) {
    }
}
