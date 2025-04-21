package ru.iteco.fmhandroid.ui.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.AboutApplicationPage;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationPage;
import ru.iteco.fmhandroid.ui.screenElements.MainPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutApplicationTest {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();
    AboutApplicationPage aboutApplicationPage = new AboutApplicationPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void loginToTheApplication() {
        authorizationPage.waitElementLoginField();
        authorizationPage.fillFormAuthorization();
        authorizationPage.waitContainerListNewsFragmentMain();
        mainPage.expectedMainNewsPage();
        mainPage.clickMainMenu();
    }

    @Test
    @Description("Follow the link \"Privacy Policy\"")
    public void followPagePrivacyPolicy() {
        mainPage.clickMenuAbout();
        aboutApplicationPage.goToPolicyPage();
    }

    @Test
    @Description("Follow the link \"User Agreement\"")
    public void followPageUserAgreement() {
        mainPage.clickMenuAbout();
        aboutApplicationPage.goToUserAgreement();
    }
}