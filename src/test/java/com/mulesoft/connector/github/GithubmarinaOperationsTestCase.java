package com.mulesoft.connector.github;

import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;

public class GithubmarinaOperationsTestCase extends MuleArtifactFunctionalTestCase {

//  /**
//   * Specifies the mule config xml with the flows that are going to be executed in the tests, this file lives in the test resources.
//   */
//  @Override
//  protected String getConfigFile() {
//    return "test-mule-config.xml";
//  }
//
//  @Test
//  public void executeSayHiOperation() throws Exception {
//    String payloadValue = ((String) flowRunner("sayHiFlow").run()
//                                      .getMessage()
//                                      .getPayload()
//                                      .getValue());
//    assertThat(payloadValue, is("Hello Mariano Gonzalez!!!"));
//  }
//
//  @Test
//  public void executeRetrieveInfoOperation() throws Exception {
//    String payloadValue = ((String) flowRunner("retrieveInfoFlow")
//                                      .run()
//                                      .getMessage()
//                                      .getPayload()
//                                      .getValue());
//    assertThat(payloadValue, is("Using Configuration [configId] with Connection id [aValue:100]"));
//  }

//  @Test
//  public void testConvertion() throws Exception{
//    Issue issue = new Issue("https://api.github.com/repos/MarinaKevorkyan/GithubConnector/issues/1",
//            "https://api.github.com/repos/MarinaKevorkyan/GithubConnector",
//            "https://api.github.com/repos/MarinaKevorkyan/GithubConnector/issues/1/labels{/name}",
//            "https://api.github.com/repos/MarinaKevorkyan/GithubConnector/issues/1/comments",
//            "https://api.github.com/repos/MarinaKevorkyan/GithubConnector/issues/1/events",
//            "https://github.com/MarinaKevorkyan/GithubConnector/issues/1",
//            1322492000,
//            "I_kwDOHpC9qc5O06Bg",
//            1,
//            "Probando",
//            new User("MarinaKevorkyan",
//                    106099659,
//            "U_kgDOBlLzyw",
//            "https://avatars.githubusercontent.com/u/106099659?v=4",
//            "",
//            "https://api.github.com/users/MarinaKevorkyan",
//            "https://github.com/MarinaKevorkyan",
//            "https://api.github.com/users/MarinaKevorkyan/followers",
//            "https://api.github.com/users/MarinaKevorkyan/following{/other_user}",
//            "https://api.github.com/users/MarinaKevorkyan/gists{/gist_id}",
//            "https://api.github.com/users/MarinaKevorkyan/starred{/owner}{/repo}",
//            "https://api.github.com/users/MarinaKevorkyan/subscriptions",
//            "https://api.github.com/users/MarinaKevorkyan/orgs",
//            "https://api.github.com/users/MarinaKevorkyan/repos",
//            "https://api.github.com/users/MarinaKevorkyan/events{/privacy}",
//            "https://api.github.com/users/MarinaKevorkyan/received_events",
//            "User",
//            false),
//            new ArrayList<>(), "closed", false, null, new ArrayList<>(), null,
//            0, "2022-07-29T17:06:40Z",
//            "2022-08-02T17:10:06Z",
//            "2022-08-02T17:10:06Z",
//            "OWNER",
//            null,
//            "Primer issue completo",
//            new Reactions("https://api.github.com/repos/MarinaKevorkyan/GithubConnector/issues/1/reactions",
//                    0, 0,0, 0, 0, 0, 0, 0, 0),
//            "https://api.github.com/repos/MarinaKevorkyan/GithubConnector/issues/1/timeline",
//            null,
//            "completed"
//    );
//
//    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//    ObjectOutputStream oos = new ObjectOutputStream(baos);
//
//    oos.writeObject(issue);
//
//    oos.flush();
//    oos.close();
//
//    InputStream inputStreamIssue = new ByteArrayInputStream(baos.toByteArray());




//  }
}
