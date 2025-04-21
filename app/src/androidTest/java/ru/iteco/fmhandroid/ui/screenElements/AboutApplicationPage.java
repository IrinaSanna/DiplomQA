package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;

import androidx.test.espresso.intent.Intents;

public class AboutApplicationPage {
    public void goToPolicyPage() {
        Intents.init();
        intended(hasData("https://vhospice.org/#/privacy-policy"));
        Intents.release();
    }

    public void goToUserAgreement() {
        Intents.init();
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        Intents.release();
    }
}
