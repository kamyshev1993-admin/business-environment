package main.java.pages;

import main.java.dictionaries.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class Page implements ICanWorkWithElements, ICanWorkWithCommonElements {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Timeout.TIME_OUT_IN_SECONDS_FOR_FIND_WEB_ELEMENT.getTime());
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    @Override
    public WebDriverWait getWait() {
        return wait;
    }
}
