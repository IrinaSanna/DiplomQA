package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.SameElementID.withIndex;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationPage;
import ru.iteco.fmhandroid.ui.screenElements.MainPage;
import ru.iteco.fmhandroid.ui.screenElements.QuotePage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class QuoteDisplayTest {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();
    QuotePage quotePage = new QuotePage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void loginToTheApplication() {
        authorizationPage.waitElementLoginField();
        authorizationPage.fillFormAuthorization();
        authorizationPage.waitContainerListNewsFragmentMain();
    }

    @After
    public void exitApplication() {
        mainPage.waitElementAuthorizationButton();
        mainPage.menuLongOut();
    }

    @Test
    @Description("Display quote")
    public void quoteDisplayTest() {
        quotePage.clickButtonQuote();
        quotePage.selectQuote();
        onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0))
                .check(matches(withText("\"Ну, идеальное устройство мира в моих глазах. " +
                        "Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, где," +
                        " если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.” Юля Капис, волонтер")));
    }
}