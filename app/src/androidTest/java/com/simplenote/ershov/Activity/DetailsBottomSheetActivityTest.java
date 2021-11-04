package com.simplenote.ershov.Activity;

import static org.junit.Assert.assertNotNull;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.*;
import org.junit.runner.RunWith;
import com.simplenote.ershov.Model.Notes;

@RunWith(AndroidJUnit4.class)
public class DetailsBottomSheetActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<>(MainActivity.class);
    private DetailsBottomSheetActivity detailsSheetActivity;

    @Before
    public void setUp(){
        detailsSheetActivity = mainTestRule.getActivity().detailsActivity;
    }

    @Test
    public void initializationComponentsTest(){
        mainTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                detailsSheetActivity.initializationComponents(mainTestRule.getActivity());
                assertNotNull(detailsSheetActivity.getBottomDialog());
                assertNotNull(detailsSheetActivity.getDetailsBinding());
                assertNotNull(detailsSheetActivity.getListener());
            }
        });
    }

    @Test
    public void onSetInitialDataInViewTest(){
        detailsSheetActivity.onSetInitialDataInView(new Notes());
        assertNotNull(detailsSheetActivity.getDetailsBinding());
    }


}