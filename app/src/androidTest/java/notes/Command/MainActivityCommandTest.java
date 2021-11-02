package notes.Command;

import static org.junit.Assert.*;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import notes.Activity.MainActivity;

@RunWith(AndroidJUnit4.class)
public class MainActivityCommandTest {

    @Rule
    public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<>(MainActivity.class);
    private MainActivityCommand mainActivityCommand;


    @Before
    public void setUp(){
        mainActivityCommand = new MainActivityCommand();
    }

    @Test
    public void onSetDefaultNoFilterViewTest(){
        mainTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainActivityCommand.onSetDefaultNoFilterView(mainTestRule.getActivity().getMainBinding());
                assertNotNull(mainTestRule.getActivity().getMainBinding());
            }
        });
    }

    @Test
    public void onSetHighToLowFilterViewTest(){
        mainTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainActivityCommand.onSetHighToLowFilterView(mainTestRule.getActivity().getMainBinding());
                assertNotNull(mainTestRule.getActivity().getMainBinding());
            }
        });
    }

    @Test
    public void onSetLowToHighFilterViewTest(){
        mainTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainActivityCommand.onSetLowToHighFilterView(mainTestRule.getActivity().getMainBinding());
                assertNotNull(mainTestRule.getActivity().getMainBinding());
            }
        });
    }
}