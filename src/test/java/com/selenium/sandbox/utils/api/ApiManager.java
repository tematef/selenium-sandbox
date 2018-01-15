package com.selenium.sandbox.utils.api;

import com.selenium.sandbox.utils.SeleniumProperties;

import java.util.Optional;

public class ApiManager {

    private static final String host = SeleniumProperties.getProperty("rest.host");
    private StatusApi statusApi;

    public StatusApi statusApi() {
        return Optional.ofNullable(statusApi).orElse(new StatusApi(host));
    }
}
