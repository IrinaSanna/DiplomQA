package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.EspressoWaitElement.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataGenerator;

public class AuthorizationPage {
    public ViewInteraction loginField = onView(allOf(withHint("Login"),
            withParent(withParent(withId(R.id.login_text_input_layout)))));

    public ViewInteraction passwordField = onView(allOf(withHint("Password"),
            withParent(withParent(withId(R.id.password_text_input_layout)))));

    public ViewInteraction buttonSingIn = onView(withId(R.id.enter_button));

    public void fillFormAuthorization() {
        loginField.check(matches(isDisplayed()))
                .perform(replaceText(DataGenerator.getLogin()), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed()))
                .perform(replaceText(DataGenerator.getPassword()), closeSoftKeyboard());
        buttonSingIn.check(matches(isDisplayed())).perform(click());
    }

    public void clickButtonSingIn() {
        buttonSingIn.check(matches(isDisplayed())).perform(click());
    }

    // для позитивных проверок авторизации
    public void inputValidLogin() {
        loginField.check(matches(isDisplayed())).perform(replaceText(DataGenerator.getLogin()), closeSoftKeyboard());
    }

    public void inputValidPassword() {
        passwordField.check(matches(isDisplayed())).perform(replaceText(DataGenerator.getPassword()), closeSoftKeyboard());
    }

    // для негативных проверок авторизации
    public void inputInvalidLogin() {
        loginField.check(matches(isDisplayed()))
                .perform(replaceText(DataGenerator.getInvalidLogin()), closeSoftKeyboard());
    }

    public void inputEmptyLogin() {
        loginField.check(matches(isDisplayed()))
                .perform(replaceText(DataGenerator.getEmptyLogin()), closeSoftKeyboard());
    }

    public void inputInvalidPassword() {
        passwordField.check(matches(isDisplayed()))
                .perform(replaceText(DataGenerator.getInvalidPassword()), closeSoftKeyboard());
    }

    public void inputEmptyPassword() {
        passwordField.check(matches(isDisplayed()))
                .perform(replaceText(DataGenerator.getEmptyPassword()));
    }

    // ожидание элементов
    public void waitElementLoginField() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
    }

    public void waitContainerListNewsFragmentMain() {
        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include_on_fragment_main, 5000));
    }
}