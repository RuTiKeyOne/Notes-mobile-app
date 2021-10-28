package notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent;

import static org.junit.Assert.*;

import static notes.Utilities.TempDataAdapter.LOW_PRIORITY_KEY;

import org.junit.Test;

public class LowUpdatePriorityCommandTest {

    @Test
    public void isLowUpdatePriorityCommandReturnTruePriorityLevel(){
        assertEquals(LOW_PRIORITY_KEY, new LowUpdatePriorityCommand().getPriorityLevel());
    }
}