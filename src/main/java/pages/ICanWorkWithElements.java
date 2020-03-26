package main.java.pages;

import main.java.utils.JSWaiterUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface ICanWorkWithElements {

    WebDriver getWebDriver();

    WebDriverWait getWait();

    default void fillInputAndWait(WebElement element, String value) {
        if (value != null) {
            element.sendKeys(value, Keys.TAB);
            JSWaiterUtils.executeAsyncScript(getWebDriver());
        } else {
            element.click();
        }
    }

    default void clickToElementAndWait(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element)).click();
        JSWaiterUtils.executeAsyncScript(getWebDriver());
    }

    default void setCheckbox(WebElement webElement, boolean value) {
        if (webElement.getAttribute("checked") != null) {
            if (!value) {
                webElement.click();
            }
        }
        else if (value) {
            webElement.click();
        }
    }

    default boolean elementIsVisible(WebElement element) {
        JSWaiterUtils.executeAsyncScript(getWebDriver());
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }
}
