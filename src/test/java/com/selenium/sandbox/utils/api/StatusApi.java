package com.selenium.sandbox.utils.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;
import static com.selenium.sandbox.utils.UriSetup.getRegularUri;

public class StatusApi {

    private static final int port = 9090;
    private static final String endpoint = "/v2/sdn-api/status";

    StatusApi(String host) {
        RestAssured.port = port;
        RestAssured.baseURI = getRegularUri(host);
    }

    public Response getStatus() {
        return given().log().all()
                .get(endpoint)
                .then().contentType(ContentType.JSON).log().all()
                .extract().response();
    }
}
