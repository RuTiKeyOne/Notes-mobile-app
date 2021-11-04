package com.simplenote.ershov.ViewModel;

import androidx.lifecycle.ViewModelProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.RunWith;
import com.simplenote.ershov.Activity.MainActivity;

@RunWith(AndroidJUnit4.class)
public class NotesViewModelTest extends TestCase {

    @Rule
    public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<>(MainActivity.class);
    private NotesViewModel notesViewModel;

    @Before
    public void setUp(){
        notesViewModel = new ViewModelProvider(mainTestRule.getActivity()).get(NotesViewModel.class);
    }

    @Test
    public void getAllNotesTest(){ assertNotNull(notesViewModel.getAllNotes()); }

    @Test
    public void getHighToLowTest(){
        assertNotNull(notesViewModel.getHighToLowNotes());
    }

    @Test
    public void getLowToHighTest(){
        assertNotNull(notesViewModel.getLowToHighNotes());
    }

}