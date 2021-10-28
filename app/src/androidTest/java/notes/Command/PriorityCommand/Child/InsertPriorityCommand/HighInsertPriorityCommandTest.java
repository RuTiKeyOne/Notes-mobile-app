package notes.Command.PriorityCommand.Child.InsertPriorityCommand;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static notes.Utilities.TempDataAdapter.HIGH_PRIORITY_KEY;

import androidx.databinding.ViewDataBinding;

import com.notes.databinding.ActivityInsertNotesBinding;
import com.notes.databinding.ItemNotesBinding;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HighInsertPriorityCommandTest {

    @Test
    public void isHighInsertPriorityCommandReturnTruePriorityLevel(){
        assertEquals(HIGH_PRIORITY_KEY, new HighInsertPriorityCommand().getPriorityLevel());
    }
}