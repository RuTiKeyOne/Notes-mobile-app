package notes.Command.PriorityCommand.Child.InsertPriorityCommand;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static notes.Utilities.TempDataAdapter.HIGH_PRIORITY_KEY;

import androidx.databinding.ViewDataBinding;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.notes.databinding.ActivityInsertNotesBinding;
import com.notes.databinding.ItemNotesBinding;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import notes.Activity.InsertNotesActivity;
import notes.Activity.MainActivity;

@RunWith(AndroidJUnit4.class)
public class HighInsertPriorityCommandTest {

    @Rule
    public ActivityTestRule<InsertNotesActivity> insertTestRule = new ActivityTestRule<>(InsertNotesActivity.class);
    public HighInsertPriorityCommand highInsertCommand;

    @Before
    public void setUp(){
        highInsertCommand = new HighInsertPriorityCommand();
    }

    @Test
    public void changePriorityViewTest(){
        insertTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                highInsertCommand.changePriorityView(insertTestRule.getActivity().getInsertBinding());
                assertNotNull(insertTestRule.getActivity().getInsertBinding());
            }
        });
    }

    @Test
    public void isHighInsertPriorityCommandReturnTruePriorityLevel(){
        assertEquals(HIGH_PRIORITY_KEY, highInsertCommand.getPriorityLevel());
    }
}