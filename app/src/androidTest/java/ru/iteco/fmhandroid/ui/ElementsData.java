package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.ui.SameElementID.withIndex;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class ElementsData {
    public static Matcher<View> getLoginField() {
        return allOf(withHint("Login"),
                withParent(withParent(withId(R.id.login_text_input_layout))));
    }

    public static Matcher<View> getPasswordField() {
        return allOf(withHint("Password"),
                withParent(withParent(withId(R.id.password_text_input_layout))));
    }

    public static Matcher<View> materialButtonSingIn() {
        return withId(R.id.enter_button);
    }

    public static Matcher<View> mainNewsPage() {
        return allOf(withText("News"),
                withParent(withParent(withId(R.id.container_list_news_include_on_fragment_main))));
    }

    public static Matcher<View> appCompatImageButton() {
        return allOf(withId(R.id.authorization_image_button),
                withContentDescription("Authorization"));
    }

    public static Matcher<View> logOut() {
        return allOf(withId(android.R.id.title), withText("Log out"));
    }

    public static Matcher<View> checkLogOut() {
        return allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment))));
    }

    public static Matcher<View> mainMenu() {
        return allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"));
    }

    public static Matcher<View> menuNews() {
        return allOf(withId(android.R.id.title), withText("News"));
    }

    public static Matcher<View> editNewsButton() {
        return withId(R.id.edit_news_material_button);
    }

    public static Matcher<View> buttonToEditCreatedNews() {
        return withIndex(allOf(withId(R.id.edit_news_item_image_view), withContentDescription("News editing button")), 0);
    }

    public static Matcher<View> addNews() {
        return allOf(withId(R.id.add_news_image_view), withContentDescription("Add news button"));
    }

    public static Matcher<View> selectCategory() {
        return withId(R.id.news_item_category_text_auto_complete_text_view);
    }

    public static Matcher<View> fieldTitle() {
        return withId(R.id.news_item_title_text_input_edit_text);
    }

    public static Matcher<View> publicationDate() {
        return withId(R.id.news_item_publish_date_text_input_edit_text);
    }

    public static Matcher<View> buttonOkPublicationDate() {
        return withId(android.R.id.button1);
    }

    public static Matcher<View> buttonCancelPublicationDate() {
        return withId(android.R.id.button2);
    }

    public static Matcher<View> publicationTime() {
        return withId(R.id.news_item_publish_time_text_input_edit_text);
    }

    public static Matcher<View> buttonOkPublicationTime() {
        return withId(android.R.id.button1);
    }

    public static Matcher<View> buttonCancelPublicationTime() {
        return withId(android.R.id.button2);
    }

    public static Matcher<View> fieldDescription() {
        return withId(R.id.news_item_description_text_input_edit_text);
    }

    public static Matcher<View> saveNewsButton() {
        return allOf(withId(R.id.save_button), withText("Save"), withContentDescription("Save"));
    }

    public static Matcher<View> arrowDownExpandNewsCard() {
        return withIndex(withId(R.id.news_item_material_card_view), 0);
    }

    public static Matcher<View> buttonDeleteNews() {
        return withIndex(withId(R.id.delete_news_item_image_view), 0);
    }

    public static Matcher<View> buttonOkDeleteNews() {
        return withId(android.R.id.button1);
    }

    public static Matcher<View> buttonCancel() {
        return withId(R.id.cancel_button);
    }

    public static Matcher<View> buttonOkInCancelSaveNews() {
        return withId(android.R.id.button1);
    }

    public static Matcher<View> buttonQuote() {
        return allOf(withId(R.id.our_mission_image_button), withContentDescription("Our Mission"));
    }

    public static Matcher<View> quote() {
        return withIndex(allOf(withId(R.id.our_mission_item_title_text_view), withText("«Хоспис для меня - это то, каким должен быть мир.\"")), 0);
    }

    public static Matcher<View> menuAbout() {
        return allOf(withId(android.R.id.title), withText("About"));
    }
}