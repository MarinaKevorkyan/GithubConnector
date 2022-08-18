package com.mulesoft.connector.github.internal.Configuration;

import com.mulesoft.connector.github.internal.Connection.Provider.GithubmarinaConnectionProvider;
import com.mulesoft.connector.github.internal.Operations.CreateAnIssueOperation;
import com.mulesoft.connector.github.internal.Operations.GetAUserOperation;
import com.mulesoft.connector.github.internal.Operations.ListRepoIssuesOperation;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;

/**
 * This class represents an extension configuration, values set in this class are commonly used across multiple
 * operations since they represent something core from the extension.
 */
@Operations({GetAUserOperation.class, CreateAnIssueOperation.class, ListRepoIssuesOperation.class})
//@Sources(GithubSource.class)
@ConnectionProviders(GithubmarinaConnectionProvider.class)
public class GithubmarinaConfiguration {
    @Parameter
    @Optional
    private String configId;


}
