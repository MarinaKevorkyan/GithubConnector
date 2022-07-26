package com.mulesoft.connector.github.internal.Operations;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import com.mulesoft.connector.github.internal.Configuration.GithubmarinaConfiguration;
import com.mulesoft.connector.github.internal.Connection.GithubmarinaConnection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.runtime.operation.Result;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;


/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class GithubmarinaOperations {

  /**
   * Example of an operation that uses the configuration and a connection instance to perform some action.
   */
  @MediaType(value = ANY, strict = false)
  public String retrieveInfo(@Config GithubmarinaConfiguration configuration, @Connection GithubmarinaConnection connection){
    return "Using Configuration [" + configuration.getConfigId() + "] with Connection id";
  }

  /**
   * Example of a simple operation that receives a string parameter and returns a new string message that will be set on the payload.
   */
  @MediaType(value = ANY, strict = false)
  public String sayHi(String person) {
    return buildHelloMessage(person);
  }

  /**
   * Private Methods are not exposed as operations
   */
  private String buildHelloMessage(String person) {
    return "Hello " + person + "!!!";
  }

}
