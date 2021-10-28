package notes.Command.PriorityCommand.Child.UpdatePriorityCommand;

import static org.junit.Assert.*;

import static notes.Utilities.TempDataAdapter.HIGH_PRIORITY_KEY;
import static notes.Utilities.TempDataAdapter.LOW_PRIORITY_KEY;
import static notes.Utilities.TempDataAdapter.MEDIUM_PRIORITY_KEY;

import org.junit.Test;

import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent.HighUpdatePriorityCommand;
import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent.LowUpdatePriorityCommand;
import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent.MediumUpdatePriorityCommand;

public class BaseUpdateCommandTest {

    @Test
    public void isHighUpdatePriorityCommandReturnTruePriorityLevel(){
        assertEquals(HIGH_PRIORITY_KEY, new HighUpdatePriorityCommand().getPriorityLevel());
    }

    @Test
    public void isLowUpdatePriorityCommandReturnTruePriorityLevel(){
        assertEquals(LOW_PRIORITY_KEY, new LowUpdatePriorityCommand().getPriorityLevel());
    }

    @Test
    public void isMediumUpdatePriorityCommandReturnTruePriorityLevel(){
        assertEquals(MEDIUM_PRIORITY_KEY, new MediumUpdatePriorityCommand().getPriorityLevel());
    }

}