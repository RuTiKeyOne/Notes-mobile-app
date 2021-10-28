package notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent;

import static org.junit.Assert.*;

import static notes.Utilities.TempDataAdapter.HIGH_PRIORITY_KEY;

import org.junit.Test;

public class HighUpdatePriorityCommandTest {

    @Test
    public void isHighUpdatePriorityCommandReturnTruePriorityLevel(){
        assertEquals(HIGH_PRIORITY_KEY, new HighUpdatePriorityCommand().getPriorityLevel());
    }

}