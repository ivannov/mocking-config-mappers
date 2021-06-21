package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceMockConfigTest {

    @InjectMock
    AppConfig appConfig;

    @Test
    public void testHelloEndpoint() {
        Mockito.when(appConfig.showName()).thenReturn(true);
        given()
                .when().get("/hello-resteasy")
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy! My name is Joe"));
    }

}
