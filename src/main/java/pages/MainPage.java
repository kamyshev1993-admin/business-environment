package main.java.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends Page {
    @FindBy(xpath = "//div[@data-testid='sidebarLogin']")
    private WebElement loginLink;

    @FindBy(xpath = "//div[@data-testid='logout']")
    private WebElement logoutLink;

    @FindBy(xpath = "//div[@data-testid='sidebarSignUp']")
    private WebElement registerLink;

    @FindBy(xpath = "//div[contains(@class, 'userRegistrationDialog')]")
    private WebElement userRegistrationDialog;

    @FindBy(xpath = "//a[@data-testid='footerSitemap']")
    private WebElement siteMapLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка, что главная страница загружена")
    public MainPage ensurePageLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(siteMapLink));
        return this;
    }

    @Step("Нажать по ссылке \"Регистрация\"")
    public void clickRegisterLink() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink));
        clickToElementAndWait(registerLink);
    }

    @Step("Нажать по ссылке \"Вход\"")
    public void clickLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        clickToElementAndWait(loginLink);
    }

    @Step("Нажать по ссылке \"Выход\"")
    public MainPage clickLogoutLink() {
        if (elementIsVisible(logoutLink)) {
            clickToElementAndWait(logoutLink);
        }
        return this;
    }
}
