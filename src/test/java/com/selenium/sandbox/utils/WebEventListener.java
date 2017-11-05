package com.selenium.sandbox.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import static com.selenium.sandbox.utils.Logger.LOG;

public class WebEventListener extends AbstractWebDriverEventListener {

    public void beforeNavigateTo(String url, WebDriver driver) {
        LOG.debug("Before navigating to: '" + url + "'");
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        LOG.debug("Trying to click on: " + element.toString());
    }

    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Exception occured: " + error);
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        LOG.debug("Trying to find Element By : " + by.toString());
    }
}