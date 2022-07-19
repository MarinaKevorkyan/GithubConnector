package com.mulesoft.connector.github.internal.Extension;

import com.mulesoft.connector.github.internal.Configuration.GithubmarinaConfiguration;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;


/**
 * This is the main class of an extension, is the entry point from which configurations, connection providers, operations
 * and sources are going to be declared.
 */
@Xml(prefix = "github-marina")
@Extension(name = "Github-marina")
@Configurations(GithubmarinaConfiguration.class)
public class GithubmarinaExtension {

}
