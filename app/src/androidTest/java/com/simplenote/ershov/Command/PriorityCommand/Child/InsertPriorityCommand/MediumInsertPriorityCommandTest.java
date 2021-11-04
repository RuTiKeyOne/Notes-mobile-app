package com.simplenote.ershov.Command.PriorityCommand.Child.InsertPriorityCommand;

import static org.junit.Assert.*;
import static com.simplenote.ershov.Utilities.TempDataAdapter.MEDIUM_PRIORITY_KEY;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.*;
import org.junit.runner.RunWith;
import com.simplenote.ershov.Activity.InsertNotesActivity;

@RunWith(AndroidJUnit4.class)
public class MediumInsertPriorityCommandTest {

    @Rule
    public ActivityTestRule<InsertNotesActivity> insertTestRule = new ActivityTestRule<>(InsertNotesActivity.class);
    public MediumInsertPriorityCommand mediumInsertCommand;

    @Before
    public void setUp(){
        mediumInsertCommand = new MediumInsertPriorityCommand();
    }

    @Test
    public void changePriorityViewTest(){
        insertTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mediumInsertCommand.changePriorityView(insertTestRule.getActivity().getInsertBinding());
                assertNotNull(insertTestRule.getActivity().getInsertBinding());
            }
        });
    }

    @Test
    public void isMediumInsertPriorityCommandReturnTruePriorityLevel(){
        assertEquals(MEDIUM_PRIORITY_KEY, mediumInsertCommand.getPriorityLevel());
    }

}