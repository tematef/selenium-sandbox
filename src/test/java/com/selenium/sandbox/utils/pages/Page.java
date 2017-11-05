package com.selenium.sandbox.utils.pages;

import com.selenium.sandbox.utils.SeleniumProperties;
import com.selenium.sandbox.utils.pages.blocks.PaginationBlock;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by artem on 3/24/17.
 */
public abstract class Page {

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    private PaginationBlock paginationBlock;
    private String pageUrl;

    public Page(WebDriver driver, String url) {
        this.driver = driver;
        this.pageUrl = SeleniumProperties.getProperty("selenium.hostname") + url;
        driverWait = new WebDriverWait(driver, 20);
        driverWait.ignoring(StaleElementReferenceException.class);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public void openNextPage() {
        paginationBlock.openNextPage(driverWait);
    }

    public void openPreviousPage() {
        paginationBlock.openPreviousPage(driverWait);
    }

    void open() {
        driver.get(this.pageUrl);
    }
}
