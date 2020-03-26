package main.java.applogic.helpers;

import io.qameta.allure.Step;
import main.java.applogic.ApplicationManager;
import main.java.applogic.PageManager;
import main.java.dictionaries.ErrorEnum;
import main.java.model.User;
import main.java.pages.modal.user_modal.LoginModal;
import main.java.pages.modal.user_modal.RegistrationModal;
import main.java.pages.modal.UserRegistrationDialog;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserHelper {

    private PageManager pages;
    private WebDriver driver;

    public UserHelper(ApplicationManager manager) {
        this.pages = manager.getPages();
        this.driver = manager.getDriver();
    }

    @Step("Войти в систему под существующим пользователем")
    public void login(String userNameOrEmail, String password) {
        LoginModal loginModal = fillInfoInLoginModal(userNameOrEmail, password);
        loginModal.waitLoader();
        loginModal.shouldBeHidden();
    }

    @Step("Попробовать войти в систему под несуществующим пользователем и проверить ошибки")
    public void tryLoginAndCheckErrors(String userNameOrEmail, String password, ErrorEnum... errors) {
        LoginModal loginModal = fillInfoInLoginModal(userNameOrEmail, password);
        loginModal.errorShouldContainTexts(convertErrorsToList(errors));
        loginModal.signInButtonShouldBeDisabled();
    }

    @Step("Зарегистрировать корректного пользователя")
    public void registerCorrectUser(User user) {
        new RegistrationModal(driver).signUpButtonShouldBeDisabled();
        tryRegisterUserInfo(user);
        new UserRegistrationDialog(driver).shouldBeVisible();
    }

    @Step("Зарегистрировать некорректного пользователя и проверить ошибки")
    public void registerUserWithCheckingErrors(User user, ErrorEnum... errors) {
        RegistrationModal modal = tryRegisterUserInfo(user);
        modal.errorShouldContainTexts(convertErrorsToList(errors));
        modal.signUpButtonShouldBeDisabled();
    }

    @Step("Выйти из системы")
    public void logout() {
        pages.getMainPage().ensurePageLoaded()
                .clickLogoutLink().waitLoader();
    }

    @Step("Произвести заполнение информации о пользователе в окне регистрации и нажать на кнопку реистрации")
    private RegistrationModal tryRegisterUserInfo(User user) {
        return new RegistrationModal(driver)
                .fillUserInfo(user)
                .clickSignUpButton();
    }

    @Step("Открытие окна логина и заполнение информации")
    private LoginModal fillInfoInLoginModal(String userNameOrEmail, String password) {
        return new LoginModal(driver).ensureModalLoaded()
                .signInButtonShouldBeDisabled()
                .fillUserInfo(userNameOrEmail, password)
                .clickSignInButton();
    }

    private List<String> convertErrorsToList(ErrorEnum... errors) {
        ArrayList<ErrorEnum> errorList = new ArrayList<>(Arrays.asList(errors));
        return errorList.stream().map(ErrorEnum::getErrorText).collect(Collectors.toList());
    }
}
