package com.selenium.sandbox.utils;

import com.selenium.sandbox.utils.db.MySqlDb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

/**
 * Created by artem on 3/24/17.
 */
public abstract class BasicTestCase {

    protected WebDriver webDriver;
    protected MySqlDb db;
    protected EventFiringWebDriver driver;
    private WebEventListener eventListener;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", ProfileSetup.getChromeDriverPath());
        webDriver = new ChromeDriver(ProfileSetup.createChromeOptions());
        driver = new EventFiringWebDriver(webDriver);
        eventListener = new WebEventListener();
        driver.register(eventListener);

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
