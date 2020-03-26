package main.java.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ProjectRandomUtils {

    private static final String signs = "#$%&‘*+—/=?^_`{|}~";
    private static Random random = new Random();

    public static <T extends Enum<?>> T getRandomEnumValue(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public static String generateCorrectRandomEmail(int userNamePartLength, int domainLength) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz";
        String emailPrefix = RandomStringUtils.random(userNamePartLength, allowedChars);
        String emailPostfix = RandomStringUtils.random(domainLength, allowedChars);
        return emailPrefix + "@" + emailPostfix + ".ru";
    }

    public static String generateCorrectRandomPassword() {
        String resultString = RandomStringUtils.randomAlphabetic(4) + RandomStringUtils.randomNumeric(4);
        return mixString(resultString);
    }

    public static String randomSignsString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(signs.charAt(new Random().nextInt(signs.length())));
        return sb.toString();
    }

    public static String mixString(String text) {
        List<String> stringList = Arrays.asList(text.split("(?=[\\w\\W])"));
        Collections.shuffle(stringList);
        StringBuilder stringBuilder = new StringBuilder();
        stringList.stream().forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
