package main.java.model;

import main.java.dictionaries.Gender;
import main.java.utils.ProjectRandomUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.time.LocalDate;

public class UserFactory {

    private int minAgePossible = 13;
    private int minCountPassword = 8;
    private int maxCountPassword = 32;
    private int minMailUserNameCount = 1;
    private int maxMailUserNameCount = 64;
    private int minDomainLengthCount = 1;

    private static UserFactory userFactory = new UserFactory();

    public static UserFactory getInstance() {
        return userFactory;
    }

    public User getRandomCorrectUserWithoutGender() {
        return getRandomCorrectUser().setGender(null);
    }

    public User getUserWithMinAgePossible() {
        return getRandomCorrectUser().setBirthYear(LocalDate.now().minusYears(minAgePossible).getYear());
    }

    public User getUserWithMinAgePossibleMinus1() {
        return getRandomCorrectUser().setBirthYear(LocalDate.now().minusYears(minAgePossible - 1).getYear());
    }

    public User getUserWithoutAge() {
        return getRandomCorrectUser().setBirthYear(null);
    }

    public User getUserWithIncorrectAge() {
        return getRandomCorrectUser().setBirthYear(RandomUtils.nextInt(0, 999));
    }

    public User getUserWithEmptyPassword() {
        return getRandomCorrectUser().setPassword(null);
    }

    public User getUserWithMinCountPassword() {
        return getRandomCorrectUser().setPassword(RandomStringUtils.randomAscii(minCountPassword));
    }

    public User getUserWithMinMinus1CountPassword() {
        return getRandomCorrectUser().setPassword(RandomStringUtils.randomAscii(minCountPassword - 1));
    }

    public User getUserWithMaxCountPassword() {
        return getRandomCorrectUser().setPassword(RandomStringUtils.randomAscii(maxCountPassword));
    }

    public User getUserWithMaxPlus1CountPassword() {
        return getRandomCorrectUser().setPassword(RandomStringUtils.randomAscii(maxCountPassword + 1));
    }

    public User getUserWithPasswordConsistsOfSpecialChars() {
        return getRandomCorrectUser().setPassword(ProjectRandomUtils.randomSignsString(minCountPassword));
    }

    public User getUserWithPasswordConsistsOfLetters() {
        return getRandomCorrectUser().setPassword(RandomStringUtils.randomAlphabetic(minCountPassword));
    }

    public User getUserWithPasswordConsistsOfNumbers() {
        return getRandomCorrectUser().setPassword(RandomStringUtils.randomNumeric(minCountPassword));
    }

    public User getUserWithPasswordInUppercase() {
        return getRandomCorrectUser().setPassword(ProjectRandomUtils.randomSignsString(minCountPassword).toUpperCase());
    }

    public User getUserWithEmptyEmail() {
        return getRandomCorrectUser().setEmail(null);
    }

    public User getUserWithEmailContainsNumberInUserName() {
        return getUserWithEmailContainNumber(false);
    }

    public User getUserWithEmailContainsNumberInDomain() {
        return getUserWithEmailContainNumber(true);
    }

    public User getUserWithEmailContainsHyphenInUserName() {
        return getUserWithEmailContainHyphen(false);
    }

    public User getUserWithEmailContainsHyphenInDomain() {
        return getUserWithEmailContainHyphen(true);
    }

    public User getUserWithEmailContainsUnderscoreInUserName() {
        return getUserWithEmailContainUnderscore(false);
    }

    public User getUserWithEmailContainsUnderscoreInDomain() {
        return getUserWithEmailContainUnderscore(true);
    }

    public User getUserWithEmailContainsDotInUserName() {
        return getUserWithEmailContainDot(false);
    }

    public User getUserWithEmailContainsSomeDotsInDomain() {
        return getUserWithEmailContainDot(true);
    }

    public User getUserWithEmailNotContainDots() {
        return getRandomCorrectUser().setEmail(deleteAnyThinkInMailString("\\."));
    }

    public User getUserWithEmailNotContainAt() {
        return getRandomCorrectUser().setEmail(deleteAnyThinkInMailString("@"));
    }

    public User getUserWithEmailHasMinUserNameLength() {
        return getRandomCorrectUser().setEmail(ProjectRandomUtils.generateCorrectRandomEmail(minMailUserNameCount, 5));
    }

    public User getUserWithEmailHasMinMinus1UserNameLength() {
        return getRandomCorrectUser().setEmail(ProjectRandomUtils.generateCorrectRandomEmail(minMailUserNameCount - 1, 5));
    }

    public User getUserWithEmailHasMinPlus1UserNameLength() {
        return getRandomCorrectUser().setEmail(ProjectRandomUtils.generateCorrectRandomEmail(minMailUserNameCount + 1, 5));
    }

    public User getUserWithEmailHasMaxUserNameLength() {
        return getRandomCorrectUser().setEmail(ProjectRandomUtils.generateCorrectRandomEmail(maxMailUserNameCount , 5));
    }

    public User getUserWithEmailHasMaxMinus1UserNameLength() {
        return getRandomCorrectUser().setEmail(ProjectRandomUtils.generateCorrectRandomEmail(maxMailUserNameCount - 1 , 5));
    }

    public User getUserWithEmailHasMaxPlus1UserNameLength() {
        return getRandomCorrectUser().setEmail(ProjectRandomUtils.generateCorrectRandomEmail(maxMailUserNameCount + 1 , 5));
    }

    public User getUserWithEmailHasMinDomainLength() {
        return getRandomCorrectUser().setEmail(ProjectRandomUtils.generateCorrectRandomEmail(15 , minDomainLengthCount));
    }

    public User getUserWithEmailHasMinMinus1DomainLength() {
        return getRandomCorrectUser().setEmail(ProjectRandomUtils.generateCorrectRandomEmail(15 , minDomainLengthCount - 1));
    }

    public User getUserWithEmailHasMinPlus1DomainLength() {
        return getRandomCorrectUser().setEmail(ProjectRandomUtils.generateCorrectRandomEmail(15 , minDomainLengthCount + 1));
    }

    public User getUserWithoutNames() {
        return getRandomCorrectUser()
                .setFirstName(null)
                .setSurName(null);
    }

    public User getRandomCorrectUser() {
        return new User().setEmail(ProjectRandomUtils.generateCorrectRandomEmail(15, 5))
                .setPassword(ProjectRandomUtils.generateCorrectRandomPassword())
                .setFirstName(RandomStringUtils.randomAscii(10))
                .setSurName(RandomStringUtils.randomAscii(10))
                .setBirthYear(LocalDate.now().minusYears(RandomUtils.nextInt(15, 50)).getYear())
                .setGender(ProjectRandomUtils.getRandomEnumValue(Gender.class));
    }

    public User getCorrectExistUser() {
        return new User().setFirstName("Andrey")
                .setSurName("Kamyshev")
                .setEmail("123kamyshev123@mail.ru")
                .setPassword("1234qwer")
                .setBirthYear(1993);
    }

    private String addAnyThinkInMailString(String email, String symbol, boolean addInDomain) {
        int atIndex = email.indexOf("@");
        StringBuilder result = new StringBuilder(email);
        if (addInDomain) {
            result.insert(RandomUtils.nextInt(atIndex + 1, email.indexOf(".ru")), symbol);
        } else {
            result.insert(RandomUtils.nextInt(0, email.indexOf("@")), symbol);
        }
        return result.toString();
    }

    private String deleteAnyThinkInMailString(String regex) {
        return ProjectRandomUtils.generateCorrectRandomEmail(15, 5).replaceAll(regex, "");
    }

    private User getUserWithEmailContainNumber(boolean inDomain) {
        User user = getRandomCorrectUser();
        return user.setEmail(addAnyThinkInMailString(user.getEmail(), RandomStringUtils.randomNumeric(1), inDomain));
    }

    private User getUserWithEmailContainHyphen(boolean inDomain) {
        User user = getRandomCorrectUser();
        return user.setEmail(addAnyThinkInMailString(user.getEmail(), "-", inDomain));
    }

    private User getUserWithEmailContainUnderscore(boolean inDomain) {
        User user = getRandomCorrectUser();
        return user.setEmail(addAnyThinkInMailString(user.getEmail(), "_", inDomain));
    }

    private User getUserWithEmailContainDot(boolean inDomain) {
        User user = getRandomCorrectUser();
        return user.setEmail(addAnyThinkInMailString(user.getEmail(), ".", inDomain));
    }
}
