package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.EspressoWaitElement.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public ViewInteraction mainNewsPage = onView(allOf(withText("News"),
            withParent(withParent(withId(R.id.container_list_news_include_on_fragment_main)))));
    public ViewInteraction appCompatImageButton = onView(allOf(withId(R.id.authorization_image_button),
            withContentDescription("Authorization")));
    public ViewInteraction logOut = onView(allOf(withId(android.R.id.title), withText("Log out")));
    public ViewInteraction checkLogOut = onView(allOf(withText("Authorization"),
            withParent(withParent(withId(R.id.nav_host_fragment)))));
    public ViewInteraction mainMenu = onView(allOf(withId(R.id.main_menu_image_button),
            withContentDescription("Main menu")));
    public ViewInteraction menuNews = onView(allOf(withId(android.R.id.title), withText("News")));
    public ViewInteraction menuAbout = onView(allOf(withId(android.R.id.title), withText("About")));

    public void expectedMainNewsPage() {
        mainNewsPage.check(matches(isDisplayed())).check(matches(withText("News")));
    }

    public void menuLongOut() {
        appCompatImageButton.check(matches(isDisplayed())).perform(click());
        logOut.check(matches(isDisplayed())).perform(click());
    }

    public void expectedActivityAuthorization() {
        checkLogOut.check(matches(isDisplayed())).check(matches(withText("Authorization")));
    }

    public void clickMainMenu() {
        mainMenu.check(matches(isDisplayed())).perform(click());
    }

    public void clickMenuNews() {
        menuNews.check(matches(isDisplayed())).perform(click());
    }

    public void clickMenuAbout() {
        menuAbout.check(matches(isDisplayed())).perform(click());
    }

    // ожидание элементов
    public void waitElementAuthorizationButton() {
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 5000));
    }
}