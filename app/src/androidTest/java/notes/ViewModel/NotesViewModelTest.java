package notes.ViewModel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import notes.Activity.MainActivity;
import notes.Model.Notes;
import notes.Repository.NotesRepository;

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
    public void getAllNotesTest(){
        assertNotNull(notesViewModel.getAllNotes());
    }

    @Test
    public void getHighToLowTest(){
        assertNotNull(notesViewModel.getHighToLowNotes());
    }

    @Test
    public void getLowToHighTest(){
        assertNotNull(notesViewModel.getLowToHighNotes());
    }

}