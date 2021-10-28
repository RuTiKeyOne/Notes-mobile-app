package notes.Command.PriorityCommand.Child.InsertPriorityCommand;

import static org.junit.Assert.*;

import static notes.Utilities.TempDataAdapter.LOW_PRIORITY_KEY;

import org.junit.Test;

public class LowInsertPriorityCommandTest {

    @Test
    public void isLowInsertPriorityCommandReturnTruePriorityLevel(){
        assertEquals(LOW_PRIORITY_KEY, new LowInsertPriorityCommand().getPriorityLevel());
    }

}