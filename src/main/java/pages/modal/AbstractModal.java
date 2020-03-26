package main.java.pages.modal;

import io.qameta.allure.Step;
import main.java.dictionaries.Timeout;
import main.java.pages.ICanWorkWithCommonElements;
import main.java.pages.ICanWorkWithElements;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractModal implements ICanWorkWithElements, ICanWorkWithCommonElements {
    protected WebDriverWait wait;
    protected WebDriver driver;
    protected WebElement modalBody;

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    @Override
    public WebDriverWait getWait() {
        return wait;
    }

    public AbstractModal(WebDriver driver, String modalClassPart) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        try {
            wait = new WebDriverWait(driver, Timeout.TIME_OUT_IN_SECONDS_FOR_FIND_WEB_ELEMENT.getTime());
            modalBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, '" + modalClassPart + "')]")));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Step("Закрыть модальное окно")
    public void closeModal() {
        clickToElementAndWait(modalBody.findElement(By.xpath(".//i")));
    }

    @Step("Проверка того, что окно отображается")
    public void shouldBeVisible() {
        if (!isVisible()) {
            throw new AssertionError("Диалоговое окно не появилось");
        }
    }

    @Step("Проверка того, что окно не отображается")
    public void shouldBeHidden() {
        if (isVisible()) {
            throw new AssertionError("Диалоговое окно отображается");
        }
    }

    public boolean isVisible() {
        return elementIsVisible(modalBody);
    }
}
