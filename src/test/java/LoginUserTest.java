package test.java;

import io.qameta.allure.Description;
import main.java.utils.ProjectRandomUtils;
import org.testng.annotations.*;

import static main.java.dictionaries.ErrorEnum.*;

public class LoginUserTest extends Base {

    private String notExistEmail = ProjectRandomUtils.generateCorrectRandomEmail(5, 5);
    private String notExistPassword = ProjectRandomUtils.generateCorrectRandomPassword();

    @BeforeMethod
    public void openLoginModal() {
        app.getHelpers().getNavigationHelper().openLoginModal();
    }

    @Test
    @Description("Вход в систему за пользователя при помощи email и password")
    public void loginUserOkTest1() {
        app.getHelpers().getUserHelper().login(user.getEmail(), user.getPassword());
    }

    @Test
    @Description("Попытаться войти в систему без указания email или имени и пароля")
    public void tryLoginWithoutFillingFieldsErrorTest2() {
        app.getHelpers().getUserHelper().tryLoginAndCheckErrors(null, null, NEED_SET_NAME_OR_EMAIL, NEED_SET_PASSWORD);
    }

    @Test
    @Description("Попытаться войти в систему при помощи только существующего email")
    public void tryLoginWithoutPasswordErrorTest3() {
        app.getHelpers().getUserHelper().tryLoginAndCheckErrors(user.getEmail(), null, NEED_SET_PASSWORD);
    }

    @Test
    @Description("Попытаться войти в систему при помощи только существующего пароля")
    public void tryLoginWithoutEmailErrorTest4() {
        app.getHelpers().getUserHelper().tryLoginAndCheckErrors(null, user.getPassword(), NEED_SET_NAME_OR_EMAIL);
    }

    @Test
    @Description("Вход в систему за пользователя при помощи имени и пароля")
    public void loginByFirstNameAndPasswordOkTest5() {
        app.getHelpers().getUserHelper().login(user.getFirstName(), user.getPassword());
    }

    @Test
    @Description("Вход в систему за пользователя при помощи имени и пароля")
    public void tryLoginWithoutEmailOkTest6() {
        app.getHelpers().getUserHelper().login(user.getFirstName(), user.getPassword());
    }

    @Test
    @Description("Попытаться вотйти в систему за пользователя при помощи email и не существующего пароля")
    public void tryLoginUserWithNotExistPasswordErrorTest7() {
        app.getHelpers().getUserHelper().tryLoginAndCheckErrors(user.getEmail(), notExistPassword, LOGIN_ERROR);
    }

    @Test
    @Description("Попытаться войти в систему за пользователя при помощи пароля и не существующего email")
    public void tryLoginUserWithNotExistEmailErrorTest8() {
        app.getHelpers().getUserHelper().tryLoginAndCheckErrors(notExistEmail, user.getPassword(), LOGIN_ERROR);
    }

    @Test
    @Description("Попытаться войти в систему за пользователя при помощи не существующих email и пароля")
    public void tryLoginUserWithNotExistEmailФтвЗфыыцщквErrorTest9() {
        app.getHelpers().getUserHelper().tryLoginAndCheckErrors(notExistEmail, notExistPassword, LOGIN_ERROR);
    }

    //Можно продолжить писать тесты до бесконечности) С пробелами, спец символами и тд. Думаю предыдущих 9 тестов достаточно)
}
