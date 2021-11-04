package com.simplenote.ershov.Activity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import com.simplenote.ershov.R;
import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SplashScreenTest {

    @Rule
    public ActivityTestRule<SplashScreen> splashTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Test
    public void checkSplashScreenMainLayoutIsDisplayed(){
        onView(ViewMatchers.withId(R.id.splashScreenMainLayout)).check(matches(isDisplayed()));
    }

    @Test
    public void checkImagesNotesIsDisplayed(){
        onView(ViewMatchers.withId(R.id.imageNotes)).check(matches(isDisplayed()));
    }

    @Test
    public void checkAppNameIsDisplayed(){
        onView(ViewMatchers.withId(R.id.appName)).check(matches(isDisplayed()));
    }

    @Test
    public void checkPhraseAppIsDisplayed(){
        onView(ViewMatchers.withId(R.id.phraseApp)).check(matches(isDisplayed()));
    }


    @Test
    public void checkAuthorNameIsDisplayed(){
        onView(ViewMatchers.withId(R.id.authorName)).check(matches(isDisplayed()));
    }

}