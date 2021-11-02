package notes.Utilities;

import static org.junit.Assert.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import notes.Activity.DetailsBottomSheetActivity;
import notes.Activity.MainActivity;
import notes.Model.Notes;

@RunWith(AndroidJUnit4.class)
public class TempDataActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onOpenSheetTest(){
        mainTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainTestRule.getActivity().onOpenSheet(new Notes());
                assertNotNull(mainTestRule.getActivity().getDetailsActivity());
            }
        });
    }

    @Test
    public void getAllNotesTest(){
        mainTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainTestRule.getActivity().getAllNotes(mainTestRule.getActivity().getNotesViewModel(),
                        mainTestRule.getActivity().getNotesData(),
                        mainTestRule.getActivity().getNotesAdapter());
                assertNotNull(mainTestRule.getActivity().getNotesData());
                assertNotNull(mainTestRule.getActivity().getNotesAdapter());
            }
        });
    }

    @Test
    public void getLowToHighNotesTest(){
        mainTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainTestRule.getActivity().getLowToHighNotes(mainTestRule.getActivity().getNotesViewModel(),
                        mainTestRule.getActivity().getNotesData(),
                        mainTestRule.getActivity().getNotesAdapter());
                assertNotNull(mainTestRule.getActivity().getNotesData());
                assertNotNull(mainTestRule.getActivity().getNotesAdapter());
            }
        });
    }

    @Test
    public void getHighToLowNotesTest(){
        mainTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainTestRule.getActivity().getHighToLowNotes(mainTestRule.getActivity().getNotesViewModel(),
                        mainTestRule.getActivity().getNotesData(),
                        mainTestRule.getActivity().getNotesAdapter());
                assertNotNull(mainTestRule.getActivity().getNotesData());
                assertNotNull(mainTestRule.getActivity().getNotesAdapter());
            }
        });
    }

}