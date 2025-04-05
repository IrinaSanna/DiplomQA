package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.EspressoWaitElement.waitDisplayed;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class ExitTheApplicationTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    @Description("Log out the application")
    public void exitTheApplication() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        ActivityPage.inputLogin();
        ActivityPage.inputPassword();
        ActivityPage.clickButtonSingIn();
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 5000));
        ActivityPage.expectedMainNewsPage();
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 3000));
        ActivityPage.menuLongOut();
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        ActivityPage.expectedActivityAuthorization();
    }
}