package notes.Activity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.assertion.ViewAssertions.selectedDescendantsMatch;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import android.util.Log;

import androidx.lifecycle.ViewModelProvider;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.notes.R;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.Serializable;

import notes.ViewModel.NotesViewModel;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void initializationComponentsViewTest(){
        activityTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activityTestRule.getActivity().initializationViewComponents();
                assertNotNull(activityTestRule.getActivity().getMainBinding());
                assertNotNull(activityTestRule.getActivity().getMainBinding().notesRecycleView.getAdapter());
                assertNotNull(activityTestRule.getActivity().getMainBinding().notesRecycleView.getLayoutManager());
            }
        });
    }

    @Test
    public void initializationComponentsTest() {
        activityTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activityTestRule.getActivity().initializationComponents();
                assertNotNull(activityTestRule.getActivity().getNotesViewModel());
                assertNotNull(activityTestRule.getActivity().getNotesAdapter());
                assertNotNull(activityTestRule.getActivity().getDetailsActivity());
                assertNotNull(activityTestRule.getActivity().getMainActivityCommand());
            }
        });
    }

    @Test
    public void onClickSearchTest(){
        assertNotNull(activityTestRule.getActivity().getMainBinding());
        onView(ViewMatchers.withId(R.id.imageSearch)).perform(click());
    }

    @Test
    public void intentSearchActivityTest(){
        assertNotNull((Serializable)activityTestRule.getActivity().getNotesData());
        activityTestRule.getActivity().intentSearchActivity();
    }


    @Test
    public void onClickNoFilterTest(){
        onView(ViewMatchers.withId(R.id.no_filter)).perform(click());
        assertNotNull(activityTestRule.getActivity().getNotesViewModel());
        assertNotNull(activityTestRule.getActivity().getNotesData());
        assertNotNull(activityTestRule.getActivity().getNotesAdapter());
        assertNotNull(activityTestRule.getActivity().getMainBinding());
    }

    @Test
    public void onClickHighToLowTest(){
        onView(ViewMatchers.withId(R.id.high_to_low)).perform(click());
        assertNotNull(activityTestRule.getActivity().getNotesViewModel());
        assertNotNull(activityTestRule.getActivity().getNotesData());
        assertNotNull(activityTestRule.getActivity().getNotesAdapter());
        assertNotNull(activityTestRule.getActivity().getMainBinding());
    }

    @Test
    public void onClickLowToHighTest(){
        onView(ViewMatchers.withId(R.id.low_to_high)).perform(click());
        assertNotNull(activityTestRule.getActivity().getNotesViewModel());
        assertNotNull(activityTestRule.getActivity().getNotesData());
        assertNotNull(activityTestRule.getActivity().getNotesAdapter());
        assertNotNull(activityTestRule.getActivity().getMainBinding());
    }

    @Test
    public void getAllNotesTest() {
        assertNotNull(activityTestRule.getActivity().getNotesData());
    }

    @Test
    public void highToLowNotesTest() {
        assertNotNull(activityTestRule.getActivity().getNotesViewModel().getHighToLowNotes());
    }

    @Test
    public void lowToHighNotesTest() {
        assertNotNull(activityTestRule.getActivity().getNotesViewModel().getLowToHighNotes());
    }

    @Test
    public void checkMainIsDisplayed() {
        onView(ViewMatchers.withId(R.id.mainNotesLayout)).check(matches(isDisplayed()));
    }

    @Test
    public void checkMainLayoutHeaderIsDisplayed() {
        onView(ViewMatchers.withId(R.id.mainLayoutHeader)).check(matches(isDisplayed()));
    }

    @Test
    public void checkMainActionBarIsDisplayed() {
        onView(ViewMatchers.withId(R.id.mainActionBar)).check(matches(isDisplayed()));
    }

    @Test
    public void checkNotesRecycleIsDisplayed() {
        onView(ViewMatchers.withId(R.id.notesRecycleView)).check(matches(isDisplayed()));
    }

    @Test
    public void checkNewNotesButtonIsDisplayed() {
        onView(ViewMatchers.withId(R.id.newNotesButton)).check(matches(isDisplayed()));
    }

    @Test
    public void checkNewNotesButtonIsClickable() {
        onView(ViewMatchers.withId(R.id.newNotesButton)).check(matches(isClickable()));
    }

    @Test
    public void checkImageSearchIsDisplayed() {
        onView(ViewMatchers.withId(R.id.imageSearch)).check(matches(isDisplayed()));
    }

    @Test
    public void checkImageSearchIsClickable() {
        onView(ViewMatchers.withId(R.id.imageSearch)).check(matches(isClickable()));
    }

    @Test
    public void checkNoFilterIsDisplayed() {
        onView(ViewMatchers.withId(R.id.no_filter)).check(matches(isDisplayed()));
    }

    @Test
    public void checkHighToLowIsDisplayed() {
        onView(ViewMatchers.withId(R.id.high_to_low)).check(matches(isDisplayed()));
    }

    @Test
    public void checkLowToHighIsDisplayed() {
        onView(ViewMatchers.withId(R.id.low_to_high)).check(matches(isDisplayed()));
    }

    @Test
    public void checkImageFilterIsDisplayed() {
        onView(ViewMatchers.withId(R.id.imageFilter)).check(matches(isDisplayed()));
    }

    @Test
    public void checkMainNameApplicationIsDisplayed() {
        onView(ViewMatchers.withId(R.id.mainNameApplication)).check(matches(isDisplayed()));
    }
}