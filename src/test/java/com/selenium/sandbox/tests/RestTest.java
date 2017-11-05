package com.selenium.sandbox.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;

//import static com.jayway.restassured.RestAssured.get;
//import static com.jayway.restassured.RestAssured.given;

public class RestTest {

    @BeforeClass
    public static void setup() {
        String port = null;
//        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(9090);
        }
        else {
            RestAssured.port = Integer.valueOf(port);
        }


//        String basePath = System.getProperty("server.base");
//        if (basePath==null) {
//            basePath = "/rest-garage-sample/";
//        }
//        RestAssured.basePath = basePath;

        String baseHost = null;
//        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://10.250.201.16";
        }
        RestAssured.baseURI = baseHost;

    }
    @Test
    public void getStatus() {
        String host = "http://10.250.201.16:9090/v2/sdn-api/status";
        String endpoint = "/v2/sdn-api/status";
        String response = get(endpoint).getBody().asString();
//        Response response = get(host).contentType(ContentType.JSON).extract().response();

        given().when().get("http://www.google.com").then().statusCode(200);
        given().when().get(host).then().statusCode(200);

    }
}
