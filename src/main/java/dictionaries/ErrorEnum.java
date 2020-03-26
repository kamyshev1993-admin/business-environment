package main.java.dictionaries;

public enum ErrorEnum {
    AGE_ERROR("Извините, вам должно быть как минимум 13 лет, чтобы вы могли пользоваться TuneIn."),
    NEED_SET_AGE("Необходимо ввести год рождения"),
    INCORRECT_AGE("Год рождения должен быть в формате - 4 цифры ГГГГ"),
    NEED_SET_PASSWORD("Необходимо ввести пароль"),
    PASSWORD_ERROR("Ваш пароль должен быть от 8 до 32 символов и должен содержать буквы и цифры или же специальные символы."),
    NEED_SET_EMAIL("Необходимо ввести ваш email"),
    INCORRECT_MAIL("Неверный email. Пожалуйста, введите действующий адрес электронной почты"),
    NEED_SET_NAMES("Необходимо ввести имя и фамилию"),
    NEED_SET_NAME_OR_EMAIL("Необходимо ввести имя пользователя/email"),
    LOGIN_ERROR("Ошибка входа. Пожалуйста, попробуйте еще раз.");

    private String errorText;

    ErrorEnum(String errorText) {
        this.errorText = errorText;
    }

    public String getErrorText() {
        return errorText;
    }
}
