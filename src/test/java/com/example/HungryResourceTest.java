package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class HungryResourceTest {

    @Test
    public void testEat() {
        given()
          .when().get("/eat")
          .then()
             .statusCode(200)
             .body(is("Added 1048576 bytes"));
    }

    @Test
    public void testCheck() {
        given()
          .when().get("/check")
          .then()
             .statusCode(200);
    }

}