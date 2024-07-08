package org.booker.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.booker.StatusCode;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.booker.api.SpecBuilder.getRequestSpec;
import static org.booker.api.SpecBuilder.getResponseSpec;
import static org.testng.Assert.fail;

public abstract class BaseApi {

    public Response post(String endpoint, Object body) {
        return given(getRequestSpec()).
                body(body).
                when().post(endpoint).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public Response get(String endpoint, Map<String, String> queryParams) {
        return given(getRequestSpec()).
                queryParams(queryParams).
                when().get(endpoint).
                then().spec(getResponseSpec()).
                extract().
                response();
    }
    
    public Response get(String endpoint, String pathParam) {
        return given(getRequestSpec()).
                when().get(String.format("%s/%s", endpoint, pathParam)).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    protected void assertStatusCode(Response response, StatusCode expectedStatus) {
        if (response == null) fail("Response is null");
        Assertions.assertThat(response.getStatusCode())
                .as("Check status code")
                .isEqualTo(expectedStatus.code);
    }
}
