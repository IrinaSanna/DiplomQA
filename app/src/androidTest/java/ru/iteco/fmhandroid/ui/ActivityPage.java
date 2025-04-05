package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


public class ActivityPage extends ElementsData {
    // для позитивных проверок авторизации
    public static void inputLogin() {
        onView(getLoginField()).check(matches(isDisplayed()))
                .perform(replaceText(DataGenerator.getLogin()), closeSoftKeyboard());
    }

    public static void inputPassword() {
        onView(getPasswordField()).check(matches(isDisplayed()))
                .perform(replaceText(DataGenerator.getPassword()), closeSoftKeyboard());
    }

    public static void clickButtonSingIn() {
        onView(materialButtonSingIn()).check(matches(isDisplayed())).perform(click());
    }

    public static void expectedMainNewsPage() {
        onView(mainNewsPage()).check(matches(isDisplayed())).check(matches(withText("News")));
    }

    // для негативных проверок авторизации
    public static void inputInvalidLogin() {
        onView(getLoginField()).check(matches(isDisplayed()))
                .perform(replaceText(DataGenerator.getInvalidLogin()), closeSoftKeyboard());

    }

    public static void inputEmptyLogin() {
        onView(getLoginField()).check(matches(isDisplayed()))
                .perform(replaceText(DataGenerator.getEmptyLogin()), closeSoftKeyboard());
    }

    public static void inputInvalidPassword() {
        onView(getPasswordField()).check(matches(isDisplayed()))
                .perform(replaceText(DataGenerator.getInvalidPassword()), closeSoftKeyboard());
    }

    public static void inputEmptyPassword() {
        onView(getPasswordField()).check(matches(isDisplayed()))
                .perform(replaceText(DataGenerator.getEmptyPassword()));
    }

    // для проверки выхода из приложения
    public static void menuLongOut() {
        onView(appCompatImageButton()).check(matches(isDisplayed())).perform(click());
        onView(logOut()).check(matches(isDisplayed())).perform(click());
    }

    public static void expectedActivityAuthorization() {
        onView(checkLogOut()).check(matches(isDisplayed())).check(matches(withText("Authorization")));
    }

    // для проверки новостей: добавление, редактирование, удаление

    public static void clickMainMenu() {
        onView(mainMenu()).check(matches(isDisplayed())).perform(click());
    }

    public static void clickMenuNews() {
        onView(menuNews()).check(matches(isDisplayed())).perform(click());
    }

    public static void clickEditNews() {
        onView(editNewsButton()).check(matches(isDisplayed())).perform(click());
    }

    public static void clickAddNews() {
        onView(addNews()).check(matches(isDisplayed())).perform(click());
    }

    public static void selectInCategoryDropdownList() {
        onView(selectCategory()).perform(click(), clearText(), replaceText(DataGenerator.getCategory()), closeSoftKeyboard());
    }

    public static void inputTitle() {
        onView(fieldTitle()).perform(click(), clearText(), replaceText(DataGenerator.getTitle()), closeSoftKeyboard());
    }

    public static void inputEmptyTitle() {
        onView(fieldTitle()).perform(click(), clearText(), replaceText(DataGenerator.getEmptyTitle()), closeSoftKeyboard());
    }

    public static void inputTitleForDeleteNews() {
        onView(fieldTitle()).perform(click(), clearText(), replaceText(DataGenerator.getTitleForDeleteNews()), closeSoftKeyboard());
    }

    public static void selectPublicationDate() {
        onView(publicationDate()).perform(click());
    }

    public static void clickButtonOkPublicationDate() {
        onView(buttonOkPublicationDate()).perform(click());
    }

    public static void clickButtonCancelPublicationDate() {
        onView(buttonCancelPublicationDate()).perform(click());
    }

    public static void selectPublicationTime() {
        onView(publicationTime()).perform(click());
    }

    public static void clickButtonOkPublicationTime() {
        onView(buttonOkPublicationTime()).perform(click());
    }

    public static void clickButtonCancelPublicationTime() {
        onView(buttonCancelPublicationTime()).perform(click());
    }

    public static void inputDescription() {
        onView(fieldDescription()).perform(replaceText(DataGenerator.getDescription()), closeSoftKeyboard());
    }

    public static void inputEmptyDescription() {
        onView(fieldDescription()).perform(replaceText(DataGenerator.getEmptyDescription()), closeSoftKeyboard());
    }

    public static void insertNewTextIntoDescription() {
        onView(fieldDescription()).perform(click(), clearText(), replaceText(DataGenerator.getEditedDescriptionText()), closeSoftKeyboard());
    }

    public static void clickSaveButtonNews() {
        onView(saveNewsButton()).perform(click());
    }

    public static void clickArrowDown() {
        onView(arrowDownExpandNewsCard()).perform(click());
    }

    public static void clickButtonDeleteNews() {
        onView(buttonDeleteNews()).perform(click());
    }

    public static void clickButtonOkDeleteNews() {
        onView(buttonOkDeleteNews()).perform(click());
    }

    public static void clickButtonCancel() {
        onView(buttonCancel()).perform(click());
    }

    public static void clickButtonOkInCancelSaveNews() {
        onView(buttonOkInCancelSaveNews()).perform(click());
    }

    public static void clickButtonToEditCreatedNews() {
        onView(buttonToEditCreatedNews()).perform(click());
    }

    // для проверки отображения цитат

    public static void clickButtonQuote() {
        onView(buttonQuote()).perform(click());
    }

    public static void selectQuote() {
        onView(quote()).perform(click());
    }

    // для проверки перехода по ссылкам в меню "О приложении"

    public static void clickMenuAbout() {
        onView(menuAbout()).check(matches(isDisplayed())).perform(click());
    }
}