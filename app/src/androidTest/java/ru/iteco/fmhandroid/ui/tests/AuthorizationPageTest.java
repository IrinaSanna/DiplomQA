package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationPage;
import ru.iteco.fmhandroid.ui.screenElements.MainPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class AuthorizationPageTest {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    private View decorView;


    @Before
    public void setUp() {
        mActivityScenarioRule.getScenario().onActivity(new ActivityScenario.ActivityAction<AppActivity>() {
            @Override
            public void perform(AppActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });
    }

    @Test
    @Description("Successful authorization")
    public void validAuthorization() {
        authorizationPage.waitElementLoginField();
        authorizationPage.fillFormAuthorization();
        authorizationPage.waitContainerListNewsFragmentMain();
        mainPage.expectedMainNewsPage();
        mainPage.menuLongOut();
    }

    @Test
    @Description("Authorization with invalid login")
    public void shouldBeInvalidLogin() {
        authorizationPage.waitElementLoginField();
        authorizationPage.inputInvalidLogin();
        authorizationPage.inputValidPassword();
        authorizationPage.clickButtonSingIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
    }

    @Test
    @Description("Authorization with empty login")
    public void shouldBeEmptyLogin() {
        authorizationPage.waitElementLoginField();
        authorizationPage.inputEmptyLogin();
        authorizationPage.inputValidPassword();
        authorizationPage.clickButtonSingIn();
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
    }

    @Test
    @Description("Authorization with invalid password")
    public void shouldBeNotInvalidPassword() {
        authorizationPage.waitElementLoginField();
        authorizationPage.inputValidLogin();
        authorizationPage.inputInvalidPassword();
        authorizationPage.clickButtonSingIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
    }

    @Test
    @Description("Authorization with empty password")
    public void shouldBeNotEmptyPassword() {
        authorizationPage.waitElementLoginField();
        authorizationPage.inputValidLogin();
        authorizationPage.inputEmptyPassword();
        authorizationPage.clickButtonSingIn();
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
    }

    @Test
    @Description("Authorization with empty login and password")
    public void shouldBeNotEmptyLoginAndPassword() {
        authorizationPage.waitElementLoginField();
        authorizationPage.inputEmptyLogin();
        authorizationPage.inputEmptyPassword();
        authorizationPage.clickButtonSingIn();
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
    }
}