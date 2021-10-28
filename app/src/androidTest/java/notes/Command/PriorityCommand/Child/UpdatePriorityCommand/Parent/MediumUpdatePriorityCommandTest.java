package notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent;

import static org.junit.Assert.*;

import static notes.Utilities.TempDataAdapter.MEDIUM_PRIORITY_KEY;

import org.junit.Test;

public class MediumUpdatePriorityCommandTest {

    @Test
    public void isMediumUpdatePriorityCommandReturnTruePriorityLevel(){
        assertEquals(MEDIUM_PRIORITY_KEY, new MediumUpdatePriorityCommand().getPriorityLevel());
    }
}