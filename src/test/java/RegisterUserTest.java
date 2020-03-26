package test.java;

import io.qameta.allure.Description;
import main.java.applogic.helpers.NavigationHelper;
import main.java.dictionaries.ErrorEnum;
import main.java.model.User;
import main.java.model.UserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static main.java.dictionaries.ErrorEnum.*;

public class RegisterUserTest extends Base {

    @BeforeMethod
    public void openRegistrationModal() {
       app.getHelpers().getNavigationHelper().openRegistrationModal();
    }

    @Test
    @Description("Регистрация корректного случайного пользователя")
    public void registerCorrectUserOkTest1() {
        registerCorrectUser(userFactory.getRandomCorrectUser());
    }

    @Test
    @Description("Регистрация корректного пользователя без указания пола")
    public void registerCorrectUserWithoutGenderOkTest2() {
        registerCorrectUser(userFactory.getRandomCorrectUserWithoutGender());
    }

    @Test
    @Description("Регистрация пользователя с минимальным возможным возрастом")
    public void registerUserWithMinAgePossibleOkTest3() {
        registerCorrectUser(userFactory.getUserWithMinAgePossible());
    }

    @Test
    @Description("Регистрация пользователя с минимальным возможным возрастом минус 1")
    public void registerUserWithMinAgePossibleMinus1ErrorTest4() {
        registerIncorrectUser(UserFactory.getInstance().getUserWithMinAgePossibleMinus1(), AGE_ERROR);
    }

    @Test
    @Description("Регистрация пользователя без указания года рождения")
    public void registerUserWithoutAgeErrorTest5() {
        registerIncorrectUser(userFactory.getUserWithoutAge(), NEED_SET_AGE);
    }

    @Test
    @Description("Регистрация пользователя с указанием не верного года рождения")
    public void registerUserWithIncorrectAgeErrorTest6() {
        registerIncorrectUser(userFactory.getUserWithIncorrectAge(), INCORRECT_AGE);
    }

    @Test
    @Description("Регистрация пользователя без пароля")
    public void registerUserWithEmptyPasswordErrorTest7() {
        registerIncorrectUser(userFactory.getUserWithEmptyPassword(), NEED_SET_PASSWORD);
    }

    @Test
    @Description("Регистрация пользователя с минимальным возможным паролем")
    public void registerUserWithMinCountPasswordOkTest8() {
        registerCorrectUser(userFactory.getUserWithMinCountPassword());
    }

    @Test
    @Description("Регистрация пользователя с минимальным возможным паролем минус 1")
    public void registerUserWithMinMinus1CountPasswordErrorTest9() {
        registerIncorrectUser(userFactory.getUserWithMinMinus1CountPassword(), PASSWORD_ERROR);
    }

    @Test
    @Description("Регистрация пользователя с максимальным возможным паролем")
    public void registerUserWithMaxCountPasswordOkTest10() {
        registerCorrectUser(userFactory.getUserWithMaxCountPassword());
    }

    @Test
    @Description("Регистрация пользователя с максимальным возможным паролем + 1")
    public void registerUserWithMaxPlus1CountPasswordErrorTest11() {
        registerIncorrectUser(userFactory.getUserWithMaxPlus1CountPassword(), PASSWORD_ERROR);
    }

    @Test
    @Description("Регистрация пользователя с паролем состоящего из спец символов")
    public void registerUserWithPasswordConsistsOfSpecialCharsErrorTest12() {
        registerIncorrectUser(userFactory.getUserWithPasswordConsistsOfSpecialChars(), PASSWORD_ERROR);
    }

    @Test
    @Description("Регистрация пользователя с паролем состоящего из букв")
    public void registerUserWithPasswordConsistsOfLettersErrorTest13() {
        registerIncorrectUser(userFactory.getUserWithPasswordConsistsOfLetters(), PASSWORD_ERROR);
    }

    @Test
    @Description("Регистрация пользователя с паролем состоящего из цифр")
    public void registerUserWithPasswordConsistsOfNumbersErrorTest14() {
        registerIncorrectUser(userFactory.getUserWithPasswordConsistsOfNumbers(), PASSWORD_ERROR);
    }

    @Test
    @Description("Регистрация пользователя с паролем в верхнем регистре")
    public void registerUserWithPasswordInUppercaseOkTest15() {
        registerIncorrectUser(userFactory.getUserWithPasswordInUppercase(), PASSWORD_ERROR);
    }

    @Test
    @Description("Регистрация пользователя с пустым email")
    public void registerUserWithEmptyEmailOkTest16() {
        registerIncorrectUser(userFactory.getUserWithEmptyEmail(), NEED_SET_EMAIL);
    }

    @Test
    @Description("Регистрация пользователя с email содержащим цифры в части имени пользователя")
    public void registerUserWithEmailContainsNumberInUserNameOkTest17() {
        registerCorrectUser(userFactory.getUserWithEmailContainsNumberInUserName());
    }

    @Test
    @Description("Регистрация пользователя с email содержащим цифры в части домена")
    public void registerUserWithEmailContainsNumberInDomainOkTest18() {
        registerCorrectUser(userFactory.getUserWithEmailContainsNumberInDomain());
    }

    @Test
    @Description("Регистрация пользователя с email содержащим дефис в части имени пользователя")
    public void registerUserWithEmailContainsHyphenInUserNameOkTest19() {
        registerCorrectUser(userFactory.getUserWithEmailContainsHyphenInUserName());
    }

    @Test
    @Description("Регистрация пользователя с email содержащим дефис в части домена")
    public void registerUserWithEmailContainsHyphenInDomainOkTest20() {
        registerCorrectUser(userFactory.getUserWithEmailContainsHyphenInDomain());
    }

    @Test
    @Description("Регистрация пользователя с email содержащим знак подчеркивания в части имени пользователя")
    public void registerUserWithEmailContainsUnderscoreInUserNameOkTest21() {
        registerCorrectUser(userFactory.getUserWithEmailContainsUnderscoreInUserName());
    }

    @Test
    @Description("Регистрация пользователя с email содержащим знак подчеркивания в части домена")
    public void registerUserWithEmailContainsUnderscoreInDomainOkTest22() {
        registerCorrectUser(userFactory.getUserWithEmailContainsUnderscoreInDomain());
    }

    @Test
    @Description("Регистрация пользователя с email содержащим точку в части мени пользователя")
    public void registerUserWithEmailContainsDotInUserNameOkTest23() {
        registerCorrectUser(userFactory.getUserWithEmailContainsDotInUserName());
    }

    @Test
    @Description("Регистрация пользователя с email содержащим несколько точек в части домена")
    public void registerUserWithEmailContainsSomeDotsInDomainOkTest24() {
        registerCorrectUser(userFactory.getUserWithEmailContainsSomeDotsInDomain());
    }

    @Test
    @Description("Регистрация пользователя с email не содержащим точек")
    public void registerUserWithEmailNotContainDotsFalseTest25() {
        registerIncorrectUser(userFactory.getUserWithEmailNotContainDots(), INCORRECT_MAIL);
    }

    @Test
    @Description("Регистрация пользователя с email не содержащим @")
    public void registerUserWithEmailNotContainAtFalseTest26() {
        registerIncorrectUser(userFactory.getUserWithEmailNotContainAt(), INCORRECT_MAIL);
    }

    @Test
    @Description("Регистрация пользователя с email содержащим минимальное количество символов в части имени пользователя")
    public void registerUserWithEmailHasMinUserNameLengthOkTest27() {
        registerCorrectUser(userFactory.getUserWithEmailHasMinUserNameLength());
    }

    @Test
    @Description("Регистрация пользователя с email содержащим минимальное количество символов - 1 в части имени пользователя")
    public void registerUserWithEmailHasMinMinus1UserNameLengthFalseTest28() {
        registerIncorrectUser(userFactory.getUserWithEmailHasMinMinus1UserNameLength(), INCORRECT_MAIL);
    }

    @Test
    @Description("Регистрация пользователя с email содержащим минимальное количество символов + 1 в части имени пользователя")
    public void registerUserWithEmailHasMinPlus1UserNameLengthOkTest29() {
        registerCorrectUser(userFactory.getUserWithEmailHasMinPlus1UserNameLength());
    }

    @Test
    @Description("Регистрация пользователя с email содержащим максимальное количество символов в части имени пользователя")
    public void registerUserWithEmailHasMaxUserNameLengthOkTest30() {
        registerCorrectUser(userFactory.getUserWithEmailHasMaxUserNameLength());
    }

    @Test
    @Description("Регистрация пользователя с email содержащим максимальное количество символов - 1 в части имени пользователя")
    public void registerUserWithEmailHasMaxMinus1UserNameLengthOkTest31() {
        registerCorrectUser(userFactory.getUserWithEmailHasMaxMinus1UserNameLength());
    }

    @Test
    @Description("Регистрация пользователя с email содержащим максимальное количество символов + 1 в части имени пользователя")
    public void registerUserWithEmailHasMaxPlus1UserNameLengthFalseTest32() {
        registerIncorrectUser(userFactory.getUserWithEmailHasMaxPlus1UserNameLength(), INCORRECT_MAIL);
    }

    @Test
    @Description("Регистрация пользователя с email содержащим минимальное количество символов 1 в части домена")
    public void registerUserWithEmailHasMinDomainLengthOkTest33() {
        registerCorrectUser(userFactory.getUserWithEmailHasMinDomainLength());
    }

    @Test
    @Description("Регистрация пользователя с email содержащим минимальное количество символов - 1 в части домена")
    public void registerUserWithEmailHasMinMinus1DomainLengthErrorTest34() {
        registerIncorrectUser(userFactory.getUserWithEmailHasMinMinus1DomainLength(), INCORRECT_MAIL);
    }

    @Test
    @Description("Регистрация пользователя с email содержащим минимальное количество символов + 1 в части домена")
    public void registerUserWithEmailHasMinPlus1DomainLengthErrorTest35() {
        registerCorrectUser(userFactory.getUserWithEmailHasMinPlus1DomainLength());
    }

    @Test
    @Description("Регистрация пользователя без имени и фамилии")
    public void registerUserWithoutNamesErrorTest36() {
        registerIncorrectUser(userFactory.getUserWithoutNames(), NEED_SET_NAMES);
    }

    private void registerCorrectUser(User user) {
        app.getHelpers().getUserHelper().registerCorrectUser(user);
    }

    private void registerIncorrectUser(User user, ErrorEnum... errors) {
        app.getHelpers().getUserHelper().registerUserWithCheckingErrors(user, errors);
    }
}
