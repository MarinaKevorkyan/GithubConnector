package com.mulesoft.connector.github.internal.Extension;

import com.mulesoft.connector.github.internal.Configuration.GithubConfiguration;
import com.mulesoft.connector.github.internal.Connection.Provider.GithubConnectionProvider;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;


/**
 * This is the main class of an extension, is the entry point from which configurations, connection providers, operations
 * and sources are going to be declared.
 */
@Xml(prefix = "github-marina")
@Extension(name = "Github-marina")
@Configurations(GithubConfiguration.class)
@ConnectionProviders(GithubConnectionProvider.class)
public class GithubmarinaExtension {

}
