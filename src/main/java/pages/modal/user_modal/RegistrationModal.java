package main.java.pages.modal.user_modal;

import io.qameta.allure.Step;
import main.java.dictionaries.Gender;
import main.java.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationModal extends AbstractUserModal {
    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(id = "suName")
    private WebElement userInitialInput;

    @FindBy(id = "suBirthYear")
    private WebElement birthYearInput;

    @FindBy(xpath = "//input[@data-testid = 'genderMale']")
    private WebElement manCheckbox;

    @FindBy(xpath = "//input[@data-testid = 'genderFemale']")
    private WebElement womanCheckbox;

    @FindBy(id = "signUpButton")
    private WebElement signUpButton;

    public RegistrationModal(WebDriver driver) {
        super(driver);
    }

    @Step("Произвести нажатие по кнопке \"Регистрация\"")
    public RegistrationModal clickSignUpButton() {
        clickToElementAndWait(signUpButton);
        return this;
    }

    @Step("Проверка, что кнопка регистрации не доступна")
    public RegistrationModal signUpButtonShouldBeDisabled() {
        Assert.assertFalse(signUpButton.isEnabled());
        return this;
    }

    @Step("Заполнение информации о пользователе")
    public RegistrationModal fillUserInfo(User user) {
        fillInputAndWait(userInitialInput, user.getUserInitial());
        fillInputAndWait(emailInput, user.getEmail());
        fillInputAndWait(passwordInput, user.getPassword());
        fillInputAndWait(birthYearInput, String.valueOf(user.getBirthYear()));
        setGenderCheckbox(user.getGender());
        return this;
    }

    private void setGenderCheckbox(Gender gender) {
        if (gender != null) {
            switch (gender) {
                case MAN:
                    setCheckbox(manCheckbox, true);
                    break;
                case WOMAN:
                    setCheckbox(womanCheckbox, true);
                    break;
                default:
                    throw new IllegalArgumentException("illegal gender");
            }
        }
    }
}
