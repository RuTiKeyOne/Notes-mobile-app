package com.simplenote.ershov.Command.PriorityCommand.Child.InsertPriorityCommand;

import static org.junit.Assert.*;
import static com.simplenote.ershov.Utilities.TempDataAdapter.HIGH_PRIORITY_KEY;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.*;
import org.junit.runner.RunWith;
import com.simplenote.ershov.Activity.InsertNotesActivity;

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