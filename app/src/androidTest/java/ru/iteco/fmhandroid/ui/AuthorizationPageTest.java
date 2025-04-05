package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.EspressoWaitElement.waitDisplayed;

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
import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class AuthorizationPageTest {
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
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        ActivityPage.inputLogin();
        ActivityPage.inputPassword();
        ActivityPage.clickButtonSingIn();
        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include_on_fragment_main, 5000));
        ActivityPage.expectedMainNewsPage();
    }

    @Test
    @Description("Authorization with invalid login")
    public void shouldBeInvalidLogin() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        ActivityPage.inputInvalidLogin();
        ActivityPage.inputPassword();
        ActivityPage.clickButtonSingIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
    }

    @Test
    @Description("Authorization with empty login")
    public void shouldBeEmptyLogin() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        ActivityPage.inputEmptyLogin();
        ActivityPage.inputPassword();
        ActivityPage.clickButtonSingIn();
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
    }

    @Test
    @Description("Authorization with invalid password")
    public void shouldBeNotInvalidPassword() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        ActivityPage.inputLogin();
        ActivityPage.inputInvalidPassword();
        ActivityPage.clickButtonSingIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
    }

    @Test
    @Description("Authorization with empty password")
    public void shouldBeNotEmptyPassword() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        ActivityPage.inputLogin();
        ActivityPage.inputEmptyPassword();
        ActivityPage.clickButtonSingIn();
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
    }

    @Test
    @Description("Authorization with empty login and password")
    public void shouldBeNotEmptyLoginAndPassword() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        ActivityPage.inputEmptyLogin();
        ActivityPage.inputEmptyPassword();
        ActivityPage.clickButtonSingIn();
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
    }
}