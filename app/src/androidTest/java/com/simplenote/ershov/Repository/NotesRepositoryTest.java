package com.simplenote.ershov.Repository;

import static org.junit.Assert.assertNotNull;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.*;
import org.junit.runner.RunWith;

import com.simplenote.ershov.Activity.MainActivity;

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