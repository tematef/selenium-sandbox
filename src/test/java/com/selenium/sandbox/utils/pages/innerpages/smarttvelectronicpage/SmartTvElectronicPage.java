package com.selenium.sandbox.utils.pages.innerpages.smarttvelectronicpage;

import com.selenium.sandbox.utils.pages.Page;

import com.selenium.sandbox.utils.pages.innerpages.telephonespage.TelephonesPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by artem on 3/24/17.
 */
public class SmartTvElectronicPage extends Page {

    private SmartTvElectronicLeftNavBlock smartTvElectronicLeftNavBlock;

    public SmartTvElectronicPage(WebDriver driver) {
        super(driver, "/telefony-tv-i-ehlektronika/c4627949/");
    }

    public TelephonesPage clickTelephonesButton() {
        smartTvElectronicLeftNavBlock.clickTelephonesButton();
        return new TelephonesPage(driver);
    }
}
