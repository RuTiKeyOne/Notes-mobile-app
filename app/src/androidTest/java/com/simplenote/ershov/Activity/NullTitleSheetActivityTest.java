package com.simplenote.ershov.Activity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.junit.Assert.*;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import com.simplenote.ershov.R;
import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class NullTitleSheetActivityTest {

    @Rule
    public ActivityTestRule<InsertNotesActivity> insertTestRule = new ActivityTestRule<>(InsertNotesActivity.class);
    private NullTitleSheetActivity nullTitleSheetActivity;

    @Before
    public void setUp() {
        nullTitleSheetActivity = insertTestRule.getActivity().getNullActivity();
    }

    @Test
    public void initializationComponentsTest() {
        insertTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                nullTitleSheetActivity.initializationComponents(insertTestRule.getActivity());
                assertNotNull(nullTitleSheetActivity.getNullInputBinding());
                assertNotNull(  nullTitleSheetActivity.getBottomDialog());
            }
        });
    }

    @Test
    public void onClickOkTest() {
        insertTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                nullTitleSheetActivity.onClickOk();
                assertNotNull(nullTitleSheetActivity.getBottomDialog());
            }
        });
    }

    @Test
    public void onShowNullTitleSheetTest() {
        insertTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                nullTitleSheetActivity.onShowNullTitleSheet();
                assertTrue(nullTitleSheetActivity.getBottomDialog().isShowing());
            }
        });
    }

    @Test
    public void onDismissNullTitleSheetTest() {
        insertTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                nullTitleSheetActivity.onDismissNullTitleSheet();
                assertNotNull(nullTitleSheetActivity.getBottomDialog());
            }
        });
    }

    @Test
    public void checkNullInputBottomSheetIsDisplayed() {
        onView(ViewMatchers.withId(R.id.doneNotesButton)).perform(click());
        onView(ViewMatchers.
                withId(R.id.nullInputBottomSheet)).check(matches(isDisplayed()));
    }

    @Test
    public void checkNullTitleTextIsDisplayed(){
        onView(ViewMatchers.withId(R.id.doneNotesButton)).perform(click());
        onView(ViewMatchers.withId(R.id.nullTitleText)).check(matches(isDisplayed()));
    }

    @Test
    public void checkOkIsDisplayed(){
        onView(ViewMatchers.withId(R.id.doneNotesButton)).perform(click());
        onView(ViewMatchers.withId(R.id.ok)).check(matches(isDisplayed()));
    }

    @Test
    public void checkOkIsClickable(){
        onView(ViewMatchers.withId(R.id.doneNotesButton)).perform(click());
        onView(ViewMatchers.withId(R.id.ok)).check(matches(isClickable()));
    }

}