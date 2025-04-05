package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.EspressoWaitElement.waitDisplayed;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutApplicationTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void loginToTheApplication() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        ActivityPage.inputLogin();
        ActivityPage.inputPassword();
        ActivityPage.clickButtonSingIn();
        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include_on_fragment_main, 5000));
        ActivityPage.expectedMainNewsPage();
        ActivityPage.clickMainMenu();
    }

    @Test
    @Description("Follow the link \"Privacy Policy\"")
    public void followPagePrivacyPolicy() {
        ActivityPage.clickMenuAbout();
        Intents.init();
        intended(hasData("https://vhospice.org/#/privacy-policy"));
        Intents.release();
    }

    @Test
    @Description("Follow the link \"User Agreement\"")
    public void followPageUserAgreement() {
        ActivityPage.clickMenuAbout();
        Intents.init();
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        Intents.release();
    }
}