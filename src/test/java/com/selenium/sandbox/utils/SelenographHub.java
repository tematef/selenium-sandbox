package com.selenium.sandbox.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SelenographHub {
    private URL hubUrl;
    private DesiredCapabilities capabilities;
    private List<WebDriver> synchronizedList = Collections.synchronizedList(new ArrayList<>());

    public SelenographHub() throws IOException {
        capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
        hubUrl = new URL(String.format("http://test:test@%s/wd/hub", SeleniumProperties.getProperty("selen.url")));
    }

    public WebDriver getRemoteDriver() {
        return new RemoteWebDriver(hubUrl, capabilities);
    }

    public List<WebDriver> getRemoteDrivers(int driverAmount) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(driverAmount);
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < driverAmount; i++) {
            Future<?> future = service.submit(new Task());
            futureList.add(future);
        }
        for (Future f: futureList) {
            f.get();
        }
        return synchronizedList;
    }

    public void setCapabilities(DesiredCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    private class Task implements Runnable {
        Task() {
        }

        @Override
        public void run() {
            synchronizedList.add(getRemoteDriver());
        }
    }
}
