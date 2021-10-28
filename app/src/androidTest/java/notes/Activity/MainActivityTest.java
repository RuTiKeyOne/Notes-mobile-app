package notes.Activity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import com.notes.R;
import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkMainIsDisplayed(){
        onView(ViewMatchers.withId(R.id.mainNotesLayout)).check(matches(isDisplayed()));
    }

    @Test
    public void checkMainLayoutHeaderIsDisplayed(){
        onView(ViewMatchers.withId(R.id.mainLayoutHeader)).check(matches(isDisplayed()));
    }

    @Test
    public void checkMainActionBarIsDisplayed(){
        onView(ViewMatchers.withId(R.id.mainActionBar)).check(matches(isDisplayed()));
    }

    @Test
    public void checkNotesRecycleIsDisplayed(){
        onView(ViewMatchers.withId(R.id.notesRecycleView)).check(matches(isDisplayed()));
    }

    @Test
    public void checkNewNotesButtonIsDisplayed(){
        onView(ViewMatchers.withId(R.id.newNotesButton)).check(matches(isDisplayed()));
    }

    @Test
    public void checkNewNotesButtonIsClickable(){
        onView(ViewMatchers.withId(R.id.newNotesButton)).check(matches(isClickable()));
    }

    @Test
    public void checkImageSearchIsDisplayed(){
        onView(ViewMatchers.withId(R.id.imageSearch)).check(matches(isDisplayed()));
    }

    @Test
    public void checkImageSearchIsClickable(){
        onView(ViewMatchers.withId(R.id.imageSearch)).check(matches(isClickable()));
    }

    @Test
    public void checkNoFilterIsDisplayed(){
        onView(ViewMatchers.withId(R.id.no_filter)).check(matches(isDisplayed()));
    }

    @Test
    public void checkHighToLowIsDisplayed(){
        onView(ViewMatchers.withId(R.id.high_to_low)).check(matches(isDisplayed()));
    }

    @Test
    public void checkLowToHighIsDisplayed(){
        onView(ViewMatchers.withId(R.id.low_to_high)).check(matches(isDisplayed()));
    }

    @Test
    public void checkImageFilterIsDisplayed(){
        onView(ViewMatchers.withId(R.id.imageFilter)).check(matches(isDisplayed()));
    }

    @Test
    public void checkMainNameApplicationIsDisplayed(){
        onView(ViewMatchers.withId(R.id.mainNameApplication)).check(matches(isDisplayed()));
    }
}