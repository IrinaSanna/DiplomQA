package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.SameElementID.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuotePage {
    public ViewInteraction buttonQuote = onView(allOf(withId(R.id.our_mission_image_button),
            withContentDescription("Our Mission")));
    public ViewInteraction quote = onView(withIndex(allOf(withId(R.id.our_mission_item_title_text_view),
            withText("«Хоспис для меня - это то, каким должен быть мир.\"")), 0));

    public void clickButtonQuote() {
        buttonQuote.perform(click());
    }

    public void selectQuote() {
        quote.perform(click());
    }
}
