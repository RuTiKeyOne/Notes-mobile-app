package com.simplenote.ershov.Activity;

import static org.junit.Assert.*;
import static com.simplenote.ershov.Utilities.TempDataViewModel.NOTE_INTENT_KEY;
import android.content.*;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import org.junit.*;
import org.junit.runner.RunWith;
import com.simplenote.ershov.Model.Notes;

@RunWith(AndroidJUnit4.class)
public class DeleteBottomSheetActivityTest {

    @Rule
    public ActivityTestRule<UpdateNotesActivity> updateTestRule = new ActivityTestRule<UpdateNotesActivity>(UpdateNotesActivity.class) {
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

    private DeleteBottomSheetActivity deleteSheetActivity;

    @Before
    public void setUp() {
        deleteSheetActivity = updateTestRule.getActivity().getBottomSheetActivity();
    }

    @Test
    public void initializationComponentsTest() {
        updateTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                deleteSheetActivity.initializationComponents(updateTestRule.getActivity(), updateTestRule.getActivity());
                assertNotNull(updateTestRule.getActivity().getBottomSheetActivity().getDeleteListener());
            }
        });
    }

    @Test
    public void onShowDeleteBottomSheetTest() {
        updateTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                deleteSheetActivity.onShowDeleteBottomSheet();
                assertTrue(deleteSheetActivity.getBottomDialog().isShowing());
            }
        });
    }

}