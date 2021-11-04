package com.simplenote.ershov.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent;

import static org.junit.Assert.*;
import static com.simplenote.ershov.Utilities.TempDataAdapter.HIGH_PRIORITY_KEY;
import static com.simplenote.ershov.Utilities.TempDataViewModel.NOTE_INTENT_KEY;
import android.content.*;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import org.junit.*;
import org.junit.runner.RunWith;
import com.simplenote.ershov.Activity.UpdateNotesActivity;
import com.simplenote.ershov.Model.Notes;

@RunWith(AndroidJUnit4.class)
public class HighUpdatePriorityCommandTest {

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
    public HighUpdatePriorityCommand highUpdateCommand;

    @Before
    public void setUp(){
        highUpdateCommand = new HighUpdatePriorityCommand();
    }

    @Test
    public void changePriorityViewTest(){
        updateTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                highUpdateCommand.changePriorityView(updateTestRule.getActivity().getUpdateBinding());
                assertNotNull(updateTestRule.getActivity().getUpdateBinding());
            }
        });
    }

    @Test
    public void isHighUpdatePriorityCommandReturnTruePriorityLevel(){
        assertEquals(HIGH_PRIORITY_KEY, highUpdateCommand.getPriorityLevel());
    }

}