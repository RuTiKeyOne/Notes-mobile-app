package com.simplenote.ershov.Activity;

import static org.junit.Assert.assertNotNull;
import static com.simplenote.ershov.Utilities.TempDataActivity.NOTES_DATA_KEY;
import android.content.*;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import org.junit.*;
import org.junit.runner.RunWith;
import java.io.Serializable;
import java.util.*;
import com.simplenote.ershov.Model.Notes;

@RunWith(AndroidJUnit4.class)
public class SearchActivityTest {

    private List<Notes> allNotesTest = new ArrayList<>();
    @Rule
    public ActivityTestRule<SearchActivity> searchTestRule = new ActivityTestRule<SearchActivity>(SearchActivity.class){
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent searchIntent = new Intent(targetContext, SearchActivity.class);
            searchIntent.putExtra(NOTES_DATA_KEY, (Serializable) allNotesTest);
            return searchIntent;
        }
    };

    @Test
    public void initializationComponentsTest(){
        searchTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                searchTestRule.getActivity().initializationComponents();
                assertNotNull(searchTestRule.getActivity().getNotesData());
                assertNotNull(searchTestRule.getActivity().getNotesAdapter());
                assertNotNull(searchTestRule.getActivity().getDetailsActivity());
                assertNotNull(searchTestRule.getActivity().getNotesViewModel());
            }
        });
    }

    @Test
    public void initializationComponentsViewTest(){
        searchTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                searchTestRule.getActivity().initializationComponentsView();
                assertNotNull(searchTestRule.getActivity().getSearchBinding());
                assertNotNull(searchTestRule.getActivity().getSearchBinding().searchNotesRecycleView.getLayoutManager());
                assertNotNull(searchTestRule.getActivity().getSearchBinding().searchNotesRecycleView.getAdapter());
            }
        });
    }

    @Test
    public void getSearchedNotesTest(){
        searchTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                searchTestRule.getActivity().getSearchedNotes();
                assertNotNull(searchTestRule.getActivity().getNotesData());
                assertNotNull(searchTestRule.getActivity().getNotesAdapter());
            }
        });
    }

}