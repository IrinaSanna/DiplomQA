package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.EspressoWaitElement.waitDisplayed;
import static ru.iteco.fmhandroid.ui.data.SameElementID.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataGenerator;

public class NewsPage {
    public ViewInteraction editNewsButton = onView(withId(R.id.edit_news_material_button));
    public ViewInteraction addNews = onView(allOf(withId(R.id.add_news_image_view),
            withContentDescription("Add news button")));
    public ViewInteraction selectCategory = onView(withId(R.id.news_item_category_text_auto_complete_text_view));


    public ViewInteraction buttonToEditCreatedNews = onView(withIndex(allOf(withId(R.id.edit_news_item_image_view),
            withContentDescription("News editing button")), 0));
    public ViewInteraction fieldTitle = onView(withId(R.id.news_item_title_text_input_edit_text));
    public ViewInteraction publicationDate = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public ViewInteraction buttonOkPublicationDate = onView(withId(android.R.id.button1));
    public ViewInteraction buttonCancelPublicationDate = onView(withId(android.R.id.button2));
    public ViewInteraction publicationTime = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public ViewInteraction buttonOkPublicationTime = onView(withId(android.R.id.button1));
    public ViewInteraction buttonCancelPublicationTime = onView(withId(android.R.id.button2));
    public ViewInteraction fieldDescription = onView(withId(R.id.news_item_description_text_input_edit_text));
    public ViewInteraction saveNewsButton = onView(allOf(withId(R.id.save_button),
            withText("Save"), withContentDescription("Save")));
    public ViewInteraction arrowDownExpandNewsCard = onView(withIndex(withId(R.id.news_item_material_card_view), 0));
    public ViewInteraction buttonDeleteNews = onView(withIndex(withId(R.id.delete_news_item_image_view), 0));
    public ViewInteraction buttonOkDeleteNews = onView(withId(android.R.id.button1));
    public ViewInteraction buttonCancel = onView(withId(R.id.cancel_button));
    public ViewInteraction buttonOkInCancelSaveNews = onView(withId(android.R.id.button1));


    public void clickEditNews() {
        editNewsButton.check(matches(isDisplayed())).perform(click());
    }

    public void clickAddNews() {
        addNews.check(matches(isDisplayed())).perform(click());
    }

    public void selectInCategoryDropdownList() {
        selectCategory.perform(click(), clearText(), replaceText(DataGenerator.getCategory()), closeSoftKeyboard());
    }


    public void inputTitle() {
        fieldTitle.perform(click(), clearText(), replaceText(DataGenerator.getTitle()), closeSoftKeyboard());
    }

    public void inputEmptyTitle() {
        fieldTitle.perform(click(), clearText(), replaceText(DataGenerator.getEmptyTitle()), closeSoftKeyboard());
    }

    public void inputTitleForDeleteNews() {
        fieldTitle.perform(click(), clearText(), replaceText(DataGenerator.getTitleForDeleteNews()), closeSoftKeyboard());
    }

    public void selectPublicationDate() {
        publicationDate.perform(click());
    }

    public void clickButtonOkPublicationDate() {
        buttonOkPublicationDate.perform(click());
    }

    public void clickButtonCancelPublicationDate() {
        buttonCancelPublicationDate.perform(click());
    }

    public void selectPublicationTime() {
        publicationTime.perform(click());
    }

    public void clickButtonOkPublicationTime() {
        buttonOkPublicationTime.perform(click());
    }

    public void clickButtonCancelPublicationTime() {
        buttonCancelPublicationTime.perform(click());
    }

    public void inputDescription() {
        fieldDescription.perform(replaceText(DataGenerator.getDescription()), closeSoftKeyboard());
    }

    public void inputEmptyDescription() {
        fieldDescription.perform(replaceText(DataGenerator.getEmptyDescription()), closeSoftKeyboard());
    }

    public void insertNewTextIntoDescription() {
        fieldDescription.perform(click(), clearText(), replaceText(DataGenerator.getEditedDescriptionText()),
                closeSoftKeyboard());
    }

    public void clickSaveButtonNews() {
        saveNewsButton.perform(click());
    }

    public void clickArrowDown() {
        arrowDownExpandNewsCard.perform(click());
    }

    public void clickButtonDeleteNews() {
        buttonDeleteNews.perform(click());
    }

    public void clickButtonOkDeleteNews() {
        buttonOkDeleteNews.perform(click());
    }

    public void clickButtonCancel() {
        buttonCancel.perform(click());
    }

    public void clickButtonOkInCancelSaveNews() {
        buttonOkInCancelSaveNews.perform(click());
    }

    public void clickButtonToEditCreatedNews() {
        buttonToEditCreatedNews.perform(click());
    }

    // ожидание элементов

    public void waitElementCategory() {
        onView(isRoot()).perform(waitDisplayed(R.id.news_item_category_text_input_layout, 3000));
    }

    public void waitNewsMaterialCard() {
        onView(isRoot()).perform(waitDisplayed(R.id.news_item_material_card_view, 3000));
    }
}