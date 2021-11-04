package com.simplenote.ershov.Activity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.junit.Assert.*;
import static com.simplenote.ershov.Utilities.TempDataViewModel.NOTE_INTENT_KEY;
import android.content.*;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import com.simplenote.ershov.R;
import org.junit.*;
import org.junit.runner.RunWith;
import com.simplenote.ershov.Model.Notes;

@RunWith(AndroidJUnit4.class)
public class UpdateNotesActivityTest {

    @Rule
    public ActivityTestRule<UpdateNotesActivity> updateTestRule = new ActivityTestRule<UpdateNotesActivity>(UpdateNotesActivity.class){
        @Override
        protected Intent getActivityIntent() {
            Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent updateIntent = new Intent(context, UpdateNotesActivity.class);
            Notes note = new Notes();
            note.setNotesTitle("Hello");
            note.setNotes("Hello");
            updateIntent.putExtra(NOTE_INTENT_KEY, note);
            return updateIntent;
        }
    };

    @Test
    public void initializationComponents(){
        updateTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                updateTestRule.getActivity().initializationComponents();
                assertNotNull(updateTestRule.getActivity().getBottomSheetActivity());
                assertNotNull(updateTestRule.getActivity().getNotesViewModel());
                assertNotNull(updateTestRule.getActivity().getNote());
                assertNotNull(updateTestRule.getActivity().getTitle());
                assertNotNull(updateTestRule.getActivity().getNote());
                assertNotNull(updateTestRule.getActivity().getPriorityLevel());
                assertNotNull(updateTestRule.getActivity().getChangePriorityCommand());
            }
        });
    }

    @Test
    public void initializationComponentsView(){
        updateTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                updateTestRule.getActivity().initializationComponentsView();
                assertNotNull(updateTestRule.getActivity().getUpdateBinding());
                assertNotNull(updateTestRule.getActivity().getChangePriorityCommand());
            }
        });
    }

    @Test
    public void setInitialDataViewTest(){
        updateTestRule.getActivity().setInitialDataView();
        assertEquals("Hello", updateTestRule.getActivity().getUpdateBinding().getTitle());
        assertEquals("Hello", updateTestRule.getActivity().getUpdateBinding().getNotes());
    }

    @Test
    public void getUpdatedNoteTest(){
        assertNotNull(updateTestRule.getActivity().getUpdatedNote());
    }

    @Test
    public void onRedPriorityClickTest(){
        onView(ViewMatchers.withId(R.id.redPriority)).perform(click());
        assertNotNull(updateTestRule.getActivity().getChangePriorityCommand());
        assertEquals(1, updateTestRule.getActivity().getPriorityLevel());
    }

    @Test
    public void onYellowPriorityClickTest(){
        onView(ViewMatchers.withId(R.id.yellowPriority)).perform(click());
        assertNotNull(updateTestRule.getActivity().getChangePriorityCommand());
        assertEquals(2, updateTestRule.getActivity().getPriorityLevel());
    }

    @Test
    public void onGreenPriorityClickTest(){
        onView(ViewMatchers.withId(R.id.greenPriority)).perform(click());
        assertNotNull(updateTestRule.getActivity().getChangePriorityCommand());
        assertEquals(3, updateTestRule.getActivity().getPriorityLevel());
    }

    @Test
    public void checkMainUpdateLayoutIsDisplayed(){
        onView(ViewMatchers.withId(R.id.mainUpdateLayout)).check(matches(isDisplayed()));
    }

    @Test
    public void checkLayoutHeaderIsDisplayed(){
        onView(ViewMatchers.withId(R.id.layoutHeader)).check(matches(isDisplayed()));
    }

    @Test
    public void checkEditImageBackIsDisplayed(){
        onView(ViewMatchers.withId(R.id.editImageBack)).check(matches(isDisplayed()));
    }

    @Test
    public void checkNameActivityIsDisplayed(){
        onView(ViewMatchers.withId(R.id.nameActivity)).check(matches(isDisplayed()));
    }

    @Test
    public void checkMainInputLayoutIsDisplayed(){
        onView(ViewMatchers.withId(R.id.mainInputLayout)).check(matches(isDisplayed()));
    }

    @Test
    public void checkInputTitleIsDisplayed(){
        onView(ViewMatchers.withId(R.id.inputTitle)).check(matches(isDisplayed()));
    }

    @Test
    public void checkNotesPriorityIsDisplayed(){
        onView(ViewMatchers.withId(R.id.notesPriority)).check(matches(isDisplayed()));
    }

    @Test
    public void checkPriorityTextTest(){
        onView(ViewMatchers.withId(R.id.priorityText)).check(matches(isDisplayed()));
    }

    @Test
    public void checkRedPriorityTest(){
        onView(ViewMatchers.withId(R.id.redPriority)).check(matches(isDisplayed()));
    }

    @Test
    public void checkYellowPriorityTest(){
        onView(ViewMatchers.withId(R.id.yellowPriority)).check(matches(isDisplayed()));
    }

    @Test
    public void checkGreenPriorityTest(){
        onView(ViewMatchers.withId(R.id.greenPriority)).check(matches(isDisplayed()));
    }

    @Test
    public void checkInputDataTest(){
        onView(ViewMatchers.withId(R.id.inputData)).check(matches(isDisplayed()));
    }

    @Test
    public void checkUpdateNotesButtonTest(){
        onView(ViewMatchers.withId(R.id.updateNotesButton)).check(matches(isDisplayed()));
    }
}