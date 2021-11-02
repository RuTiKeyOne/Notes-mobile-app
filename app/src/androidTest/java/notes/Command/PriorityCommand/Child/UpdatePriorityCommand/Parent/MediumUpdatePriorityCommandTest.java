package notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent;

import static org.junit.Assert.*;

import static notes.Utilities.TempDataAdapter.MEDIUM_PRIORITY_KEY;
import static notes.Utilities.TempDataViewModel.NOTE_INTENT_KEY;

import android.content.Context;
import android.content.Intent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import notes.Activity.UpdateNotesActivity;
import notes.Model.Notes;

@RunWith(AndroidJUnit4.class)
public class MediumUpdatePriorityCommandTest {

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

    public MediumUpdatePriorityCommand mediumUpdateCommand;

    @Before
    public void setUp(){
        mediumUpdateCommand = new MediumUpdatePriorityCommand();
    }

    @Test
    public void changePriorityViewTest(){
        updateTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mediumUpdateCommand.changePriorityView(updateTestRule.getActivity().getUpdateBinding());
                assertNotNull(updateTestRule.getActivity().getUpdateBinding());
            }
        });
    }

    @Test
    public void isMediumUpdatePriorityCommandReturnTruePriorityLevel(){
        assertEquals(MEDIUM_PRIORITY_KEY, new MediumUpdatePriorityCommand().getPriorityLevel());
    }
}