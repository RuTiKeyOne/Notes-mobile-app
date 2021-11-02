package notes.Repository;

import static org.junit.Assert.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import notes.Activity.MainActivity;

@RunWith(AndroidJUnit4.class)
public class NotesRepositoryTest {

    @Rule public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<>(MainActivity.class);
    NotesRepository notesRepository;

    @Before
    public void setUp(){
        notesRepository = new NotesRepository(mainTestRule.getActivity().getApplication());
    }

    @Test
    public void getNotesDaoTest(){
        assertNotNull(notesRepository.getNotesDao());
    }

    @Test
    public void getAllNotesTest(){
        assertNotNull(notesRepository.getAllNotes());
    }

    @Test
    public void getHighToLowNotesTest(){
        assertNotNull(notesRepository.getHighToLowNotes());
    }

    @Test
    public void getLowToHighNotesTest(){
        assertNotNull(notesRepository.getLowToHighNotes());
    }


}