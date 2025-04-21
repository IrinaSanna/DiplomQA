package ru.iteco.fmhandroid.ui.data;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String getLogin() {
        return "login2";
    }

    public static String getInvalidLogin() {
        return "login";
    }

    public static String getEmptyLogin() {
        return "";
    }

    public static String getPassword() {
        return "password2";
    }

    public static String getInvalidPassword() {
        return "Password";
    }

    public static String getEmptyPassword() {
        return "";
    }

    public static String getCategory() {
        return "Праздник";
    }

    public static String getTitle() {
        return "Праздник для детей";
    }

    public static String getEmptyTitle() {
        return "";
    }

    public static String getDescription() {
        return "Состоится праздник для детей";
    }

    public static String getEmptyDescription() {
        return "";
    }

    public static String getEditedDescriptionText() {
        return "Состоится праздник для детей. Будет много конкурсов и подарков";
    }

    public static String getTitleForDeleteNews() {
        return "Тестируем удаление новости";
    }
}