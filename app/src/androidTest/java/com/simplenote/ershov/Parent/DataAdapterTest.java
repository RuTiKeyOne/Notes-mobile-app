package com.simplenote.ershov.Parent;

import static org.junit.Assert.*;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.*;
import org.junit.runner.RunWith;
import com.simplenote.ershov.Activity.MainActivity;
import com.simplenote.ershov.Adapter.Child.NotesAdapter;

@RunWith(AndroidJUnit4.class)
public class DataAdapterTest {

    @Rule
    public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<>(MainActivity.class);
    private NotesAdapter adapter;

    @Before
    public void setUp(){
        adapter = mainTestRule.getActivity().getNotesAdapter();
    }

    @Test
    public void initializationComponentsTest(){
        adapter = new NotesAdapter(mainTestRule.getActivity().getNotesData(), mainTestRule.getActivity());
        assertNotNull(adapter.getData());
        assertNotNull(adapter.getAdapterCommand());
        assertNotNull(adapter.getIdLayout());
    }

    @Test
    public void getItemCountTest(){
        assertEquals(mainTestRule.getActivity().getNotesData().size(), adapter.getItemCount());
    }
}