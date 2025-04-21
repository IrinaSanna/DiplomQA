package ru.iteco.fmhandroid.ui.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

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

public class ExitTheApplicationTest {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    @Description("Log out the application")
    public void exitTheApplication() {
        authorizationPage.waitElementLoginField();
        authorizationPage.fillFormAuthorization();
        mainPage.waitElementAuthorizationButton();
        mainPage.expectedMainNewsPage();
        mainPage.waitElementAuthorizationButton();
        mainPage.menuLongOut();
        authorizationPage.waitElementLoginField();
        mainPage.expectedActivityAuthorization();
    }
}