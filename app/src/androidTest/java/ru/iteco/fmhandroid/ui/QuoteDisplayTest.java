package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.EspressoWaitElement.waitDisplayed;
import static ru.iteco.fmhandroid.ui.SameElementID.withIndex;

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

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class QuoteDisplayTest {

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
    }

    @After
    public void exitApplication() {
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 5000));
        ActivityPage.menuLongOut();
    }

    @Test
    @Description("Display quote")
    public void quoteDisplayTest() {
        ActivityPage.clickButtonQuote();
        ActivityPage.selectQuote();
        onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0))
                .check(matches(withText("\"Ну, идеальное устройство мира в моих глазах. " +
                        "Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, где," +
                        " если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.” Юля Капис, волонтер")));
    }
}