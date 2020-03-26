package main.java.pages.modal.user_modal;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginModal extends AbstractUserModal {
    @FindBy(name = "usernameEmail")
    private WebElement usernameEmail;

    @FindBy(id = "signInButton")
    private WebElement signInButton;

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка, что модальное окно загружено")
    public LoginModal ensureModalLoaded() {
        wait.until(ExpectedConditions.visibilityOf(usernameEmail));
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        return this;
    }

    @Step("Проверка, что кнопка входа недоступна")
    public LoginModal signInButtonShouldBeDisabled() {
        Assert.assertFalse(signInButton.isEnabled());
        return this;
    }

    @Step("Произвести нажатие по кнопке \"Войти\"")
    public LoginModal clickSignInButton() {
        clickToElementAndWait(signInButton);
        return this;
    }

    @Step("Заполнение информации о пользователе")
    public LoginModal fillUserInfo(String emailOrName, String password) {
        fillInputAndWait(usernameEmail, emailOrName);
        fillInputAndWait(passwordInput, password);
        return this;
    }
}
