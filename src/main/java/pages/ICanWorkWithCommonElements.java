package main.java.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface ICanWorkWithCommonElements {

    WebDriverWait getWait();

    @Step("Дождаться окончания загрузки")
    default void waitLoader() {
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'loader__container')]")));
    }
}
