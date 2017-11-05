package com.selenium.sandbox.utils;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.logging.Level;

/**
 * Created by artem on 3/24/17.
 */
class ProfileSetup {

    static DesiredCapabilities createChromeConfig() {
//        LoggingPreferences logs = new LoggingPreferences();
//        logs.enable(LogType.BROWSER, Level.INFO);
//        logs.enable(LogType.CLIENT, Level.SEVERE);
//        logs.enable(LogType.DRIVER, Level.WARNING);
//        logs.enable(LogType.PERFORMANCE, Level.INFO);
//        logs.enable(LogType.SERVER, Level.ALL);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("-disable-cache");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
        return capabilities;
    }

    static ChromeOptions createChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            options.addArguments("start-fullscreen");
        }
        options.addArguments("start-maximized");
        options.addArguments("-disable-cache");
        return options;
    }

    static String getChromeDriverPath() {
        String path = System.getProperty("user.dir") + File.separator + "drivers" + File.separator;
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return path + "chromedriver_win.exe";
        }
        if (os.contains("mac")) {
            return path + "chromedriver_mac";
        }
        if (os.contains("linux")) {
            return path + "chromedriver_linux";
        }
        throw new InvalidArgumentException("OS is not on the list");
    }
}
