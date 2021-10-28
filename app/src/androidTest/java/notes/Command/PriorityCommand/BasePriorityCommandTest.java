package notes.Command.PriorityCommand;

import static org.junit.Assert.*;
import static notes.Utilities.TempDataAdapter.HIGH_PRIORITY_KEY;
import static notes.Utilities.TempDataAdapter.LOW_PRIORITY_KEY;
import static notes.Utilities.TempDataAdapter.MEDIUM_PRIORITY_KEY;

import org.junit.Test;

import notes.Command.PriorityCommand.Child.InsertPriorityCommand.HighInsertPriorityCommand;
import notes.Command.PriorityCommand.Child.InsertPriorityCommand.LowInsertPriorityCommand;
import notes.Command.PriorityCommand.Child.InsertPriorityCommand.MediumInsertPriorityCommand;

public class BasePriorityCommandTest {

    @Test
    public void isHighInsertPriorityCommandReturnTruePriorityLevel(){
        assertEquals(HIGH_PRIORITY_KEY, new HighInsertPriorityCommand().getPriorityLevel());
    }

    @Test
    public void isLowInsertPriorityCommandReturnTruePriorityLevel(){
        assertEquals(LOW_PRIORITY_KEY, new LowInsertPriorityCommand().getPriorityLevel());
    }

    @Test
    public void isMediumInsertPriorityCommandReturnTruePriorityLevel(){
        assertEquals(MEDIUM_PRIORITY_KEY, new MediumInsertPriorityCommand().getPriorityLevel());
    }

}