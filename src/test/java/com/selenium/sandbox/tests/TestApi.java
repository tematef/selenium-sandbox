package com.selenium.sandbox.tests;

import com.jayway.restassured.response.Response;
import com.selenium.sandbox.utils.api.ApiManager;
import com.selenium.sandbox.utils.api.StatusApi;
import com.selenium.sandbox.utils.objects.TestObject;
import org.testng.annotations.Test;

public class TestApi {

    @Test
    public void test() {
        StatusApi statusApi = new ApiManager().statusApi();
        Response statusResponse = statusApi.getStatus();
        int responseCode = statusResponse.getStatusCode();
        TestObject testObject = statusResponse.as(TestObject.class);
    }
}
