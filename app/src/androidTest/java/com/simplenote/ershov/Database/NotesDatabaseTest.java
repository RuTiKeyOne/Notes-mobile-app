package com.simplenote.ershov.Database;

import static org.junit.Assert.assertNotNull;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import org.junit.*;
import org.junit.runner.RunWith;
import com.simplenote.ershov.Activity.MainActivity;

@RunWith(AndroidJUnit4.class)
public class NotesDatabaseTest {

    @Rule
    public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void getDatabaseInstanceTest(){
        assertNotNull(NotesDatabase.getDatabaseInstance(InstrumentationRegistry.getInstrumentation().getContext()));
    }

}