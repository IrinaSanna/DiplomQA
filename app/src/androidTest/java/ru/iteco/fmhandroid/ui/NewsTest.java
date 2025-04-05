package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.EspressoWaitElement.waitDisplayed;
import static ru.iteco.fmhandroid.ui.SameElementID.withIndex;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
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
public class NewsTest {

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

    @Before
    public void loginToTheApplication() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        ActivityPage.inputLogin();
        ActivityPage.inputPassword();
        ActivityPage.clickButtonSingIn();
        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include_on_fragment_main, 5000));
        ActivityPage.expectedMainNewsPage();
        ActivityPage.clickMainMenu();
        ActivityPage.clickMenuNews();
        ActivityPage.clickEditNews();
        ActivityPage.clickAddNews();
        onView(isRoot()).perform(waitDisplayed(R.id.news_item_category_text_input_layout, 3000));
    }

    @After
    public void exitApplication() {
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 5000));
        ActivityPage.menuLongOut();
    }

    @Test
    @Description("Successful create news")
    public void validCreateNews() {
        ActivityPage.selectInCategoryDropdownList();
        ActivityPage.inputTitle();
        ActivityPage.selectPublicationDate();
        ActivityPage.clickButtonOkPublicationDate();
        ActivityPage.selectPublicationTime();
        ActivityPage.clickButtonOkPublicationTime();
        ActivityPage.inputDescription();
        ActivityPage.clickSaveButtonNews();
        onView(isRoot()).perform(waitDisplayed(R.id.news_item_material_card_view, 3000));
        ActivityPage.clickButtonDeleteNews();
        ActivityPage.clickButtonOkDeleteNews();
        ActivityPage.clickArrowDown();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0))
                .check(matches(withText("Состоится праздник для детей")));
    }

    @Test
    @Description("Creating news without a category")
    public void newsShouldNotBeCreatedWithoutACategory() {
        ActivityPage.inputTitle();
        ActivityPage.selectPublicationDate();
        ActivityPage.clickButtonOkPublicationDate();
        ActivityPage.selectPublicationTime();
        ActivityPage.clickButtonOkPublicationTime();
        ActivityPage.inputDescription();
        ActivityPage.clickSaveButtonNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
        ActivityPage.clickButtonCancel();
        ActivityPage.clickButtonOkInCancelSaveNews();
    }

    @Test
    @Description("Creating news without a title")
    public void newsShouldNotBeCreatedWithoutATitle() {
        ActivityPage.selectInCategoryDropdownList();
        ActivityPage.inputEmptyTitle();
        ActivityPage.selectPublicationDate();
        ActivityPage.clickButtonOkPublicationDate();
        ActivityPage.selectPublicationTime();
        ActivityPage.clickButtonOkPublicationTime();
        ActivityPage.inputDescription();
        ActivityPage.clickSaveButtonNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
        ActivityPage.clickButtonCancel();
        ActivityPage.clickButtonOkInCancelSaveNews();
    }

    @Test
    @Description("Creating news without publication date")
    public void newsShouldNotBeCreatedWithoutAPublicationDate() {
        ActivityPage.selectInCategoryDropdownList();
        ActivityPage.inputTitle();
        ActivityPage.selectPublicationDate();
        ActivityPage.clickButtonCancelPublicationDate();
        ActivityPage.selectPublicationTime();
        ActivityPage.clickButtonOkPublicationTime();
        ActivityPage.inputDescription();
        ActivityPage.clickSaveButtonNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
        ActivityPage.clickButtonCancel();
        ActivityPage.clickButtonOkInCancelSaveNews();
    }

    @Test
    @Description("Creating news without publication time")
    public void newsShouldNotBeCreatedWithoutAPublicationTime() {
        ActivityPage.selectInCategoryDropdownList();
        ActivityPage.inputTitle();
        ActivityPage.selectPublicationDate();
        ActivityPage.clickButtonOkPublicationDate();
        ActivityPage.selectPublicationTime();
        ActivityPage.clickButtonCancelPublicationTime();
        ActivityPage.inputDescription();
        ActivityPage.clickSaveButtonNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
        ActivityPage.clickButtonCancel();
        ActivityPage.clickButtonOkInCancelSaveNews();
    }

    @Test
    @Description("Creating news without publication description")
    public void newsShouldNotBeCreatedWithoutDescription() {
        ActivityPage.selectInCategoryDropdownList();
        ActivityPage.inputTitle();
        ActivityPage.selectPublicationDate();
        ActivityPage.clickButtonOkPublicationDate();
        ActivityPage.selectPublicationTime();
        ActivityPage.clickButtonOkPublicationTime();
        ActivityPage.inputEmptyDescription();
        ActivityPage.clickSaveButtonNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
        ActivityPage.clickButtonCancel();
        ActivityPage.clickButtonOkInCancelSaveNews();
    }

    @Test
    @Description("News editing")
    public void newsEditing() {
        ActivityPage.selectInCategoryDropdownList();
        ActivityPage.inputTitle();
        ActivityPage.selectPublicationDate();
        ActivityPage.clickButtonOkPublicationDate();
        ActivityPage.selectPublicationTime();
        ActivityPage.clickButtonOkPublicationTime();
        ActivityPage.inputDescription();
        ActivityPage.clickSaveButtonNews();
        onView(isRoot()).perform(waitDisplayed(R.id.news_item_material_card_view, 3000));
        ActivityPage.clickButtonToEditCreatedNews();
        ActivityPage.insertNewTextIntoDescription();
        ActivityPage.clickSaveButtonNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0))
                .check(matches(withText("Состоится праздник для детей. Будет много конкурсов и подарков")));
    }

    @Test
    @Description("Delete news")
    public void deleteNews() {
        ActivityPage.selectInCategoryDropdownList();
        ActivityPage.inputTitleForDeleteNews();
        ActivityPage.selectPublicationDate();
        ActivityPage.clickButtonOkPublicationDate();
        ActivityPage.selectPublicationTime();
        ActivityPage.clickButtonOkPublicationTime();
        ActivityPage.inputDescription();
        ActivityPage.clickSaveButtonNews();
        onView(isRoot()).perform(waitDisplayed(R.id.news_item_material_card_view, 3000));
        ActivityPage.clickButtonDeleteNews();
        ActivityPage.clickButtonOkDeleteNews();
        onView(Matchers.allOf(withId(R.id.news_item_title_text_input_edit_text),
                withText("Тестируем удаление новости"))).check(doesNotExist());
    }
}