package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.SameElementID.withIndex;

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
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationPage;
import ru.iteco.fmhandroid.ui.screenElements.MainPage;
import ru.iteco.fmhandroid.ui.screenElements.NewsPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsTest {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();

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
        authorizationPage.waitElementLoginField();
        authorizationPage.fillFormAuthorization();
        authorizationPage.waitContainerListNewsFragmentMain();
        mainPage.expectedMainNewsPage();
        mainPage.expectedMainNewsPage();
        mainPage.clickMainMenu();
        mainPage.clickMenuNews();
        newsPage.clickEditNews();
        newsPage.clickAddNews();
        newsPage.waitElementCategory();
    }

    @After
    public void exitApplication() {
        mainPage.waitElementAuthorizationButton();
        mainPage.menuLongOut();
    }

    @Test
    @Description("Successful create news")
    public void validCreateNews() {
        newsPage.selectInCategoryDropdownList();
        newsPage.inputTitle();
        newsPage.selectPublicationDate();
        newsPage.clickButtonOkPublicationDate();
        newsPage.selectPublicationTime();
        newsPage.clickButtonOkPublicationTime();
        newsPage.inputDescription();
        newsPage.clickSaveButtonNews();
        newsPage.waitNewsMaterialCard();
        newsPage.clickButtonDeleteNews();
        newsPage.clickButtonOkDeleteNews();
        newsPage.clickArrowDown();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0))
                .check(matches(withText("Состоится праздник для детей")));
    }

    @Test
    @Description("Creating news without a category")
    public void newsShouldNotBeCreatedWithoutACategory() {
        newsPage.inputTitle();
        newsPage.selectPublicationDate();
        newsPage.clickButtonOkPublicationDate();
        newsPage.selectPublicationTime();
        newsPage.clickButtonOkPublicationTime();
        newsPage.inputDescription();
        newsPage.clickSaveButtonNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
        newsPage.clickButtonCancel();
        newsPage.clickButtonOkInCancelSaveNews();
    }

    @Test
    @Description("Creating news without a title")
    public void newsShouldNotBeCreatedWithoutATitle() {
        newsPage.selectInCategoryDropdownList();
        newsPage.inputEmptyTitle();
        newsPage.selectPublicationDate();
        newsPage.clickButtonOkPublicationDate();
        newsPage.selectPublicationTime();
        newsPage.clickButtonOkPublicationTime();
        newsPage.inputDescription();
        newsPage.clickSaveButtonNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
        newsPage.clickButtonCancel();
        newsPage.clickButtonOkInCancelSaveNews();
    }

    @Test
    @Description("Creating news without publication date")
    public void newsShouldNotBeCreatedWithoutAPublicationDate() {
        newsPage.selectInCategoryDropdownList();
        newsPage.inputTitle();
        newsPage.selectPublicationDate();
        newsPage.clickButtonCancelPublicationDate();
        newsPage.selectPublicationTime();
        newsPage.clickButtonOkPublicationTime();
        newsPage.inputDescription();
        newsPage.clickSaveButtonNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
        newsPage.clickButtonCancel();
        newsPage.clickButtonOkInCancelSaveNews();
    }

    @Test
    @Description("Creating news without publication time")
    public void newsShouldNotBeCreatedWithoutAPublicationTime() {
        newsPage.selectInCategoryDropdownList();
        newsPage.inputTitle();
        newsPage.selectPublicationDate();
        newsPage.clickButtonOkPublicationDate();
        newsPage.selectPublicationTime();
        newsPage.clickButtonCancelPublicationTime();
        newsPage.inputDescription();
        newsPage.clickSaveButtonNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
        newsPage.clickButtonCancel();
        newsPage.clickButtonOkInCancelSaveNews();
    }

    @Test
    @Description("Creating news without publication description")
    public void newsShouldNotBeCreatedWithoutDescription() {
        newsPage.selectInCategoryDropdownList();
        newsPage.inputTitle();
        newsPage.selectPublicationDate();
        newsPage.clickButtonOkPublicationDate();
        newsPage.selectPublicationTime();
        newsPage.clickButtonOkPublicationTime();
        newsPage.inputEmptyDescription();
        newsPage.clickSaveButtonNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
        newsPage.clickButtonCancel();
        newsPage.clickButtonOkInCancelSaveNews();
    }

    @Test
    @Description("News editing")
    public void newsEditing() {
        newsPage.selectInCategoryDropdownList();
        newsPage.inputTitle();
        newsPage.selectPublicationDate();
        newsPage.clickButtonOkPublicationDate();
        newsPage.selectPublicationTime();
        newsPage.clickButtonOkPublicationTime();
        newsPage.inputDescription();
        newsPage.clickSaveButtonNews();
        newsPage.waitNewsMaterialCard();
        newsPage.clickButtonToEditCreatedNews();
        newsPage.insertNewTextIntoDescription();
        newsPage.clickSaveButtonNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0))
                .check(matches(withText("Состоится праздник для детей. Будет много конкурсов и подарков")));
    }

    @Test
    @Description("Delete news")
    public void deleteNews() {
        newsPage.selectInCategoryDropdownList();
        newsPage.inputTitleForDeleteNews();
        newsPage.selectPublicationDate();
        newsPage.clickButtonOkPublicationDate();
        newsPage.selectPublicationTime();
        newsPage.clickButtonOkPublicationTime();
        newsPage.inputDescription();
        newsPage.clickSaveButtonNews();
        newsPage.waitNewsMaterialCard();
        newsPage.clickButtonDeleteNews();
        newsPage.clickButtonOkDeleteNews();
        onView(Matchers.allOf(withId(R.id.news_item_title_text_input_edit_text),
                withText("Тестируем удаление новости"))).check(doesNotExist());
    }
}