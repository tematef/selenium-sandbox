package com.selenium.sandbox.utils;

public class UriSetup {

    private static final String REGULAR_URI_PATTERN = "http://%s";

    public static String getRegularUri(String host) {
        return String.format(REGULAR_URI_PATTERN, host);
    }
}
