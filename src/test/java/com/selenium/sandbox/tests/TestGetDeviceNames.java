package com.selenium.sandbox.tests;

import com.selenium.sandbox.utils.BasicTestCase;
import com.selenium.sandbox.utils.SeleniumProperties;
import com.selenium.sandbox.utils.objects.Device;
import com.selenium.sandbox.utils.pages.MainPage;
import com.selenium.sandbox.utils.pages.innerpages.smarttvelectronicpage.SmartTvElectronicPage;
import com.selenium.sandbox.utils.pages.innerpages.telephonespage.TelephonesPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artem on 3/24/17.
 */
public class TestGetDeviceNames extends BasicTestCase {

    private List<Device> topSoldDevices = new ArrayList<>();
    private String emailSendToReport = SeleniumProperties.getProperty("report.email");

    @Test
    public void testGetAndStoreToDbTopSoldDevices() throws SQLException {
        MainPage mainPage = MainPage.navigateTo(driver);
        SmartTvElectronicPage smartTvElectronicPage = mainPage.navigateToSmartTvElectronicPage();
        TelephonesPage telephonesPage = smartTvElectronicPage.clickTelephonesButton();
        telephonesPage.clickSmartPhonesButton();
        telephonesPage.sortItemsByPopularity();
        topSoldDevices.addAll(telephonesPage.getTopSoldDevices());
        telephonesPage.openNextPage();
        topSoldDevices.addAll(telephonesPage.getTopSoldDevices());
        telephonesPage.openNextPage();
        topSoldDevices.addAll(telephonesPage.getTopSoldDevices());
//        sendEmailReport(emailSendToReport, generateReport());
    }

    @AfterMethod(alwaysRun = true)
    private void cleaningDB() throws SQLException {
//        removeTestingDataFromDb();
    }
}
