package notes.Command.PriorityCommand.Child.InsertPriorityCommand;

import static org.junit.Assert.*;

import static notes.Utilities.TempDataAdapter.MEDIUM_PRIORITY_KEY;

import org.junit.Test;

public class MediumInsertPriorityCommandTest {

    @Test
    public void isMediumInsertPriorityCommandReturnTruePriorityLevel(){
        assertEquals(MEDIUM_PRIORITY_KEY, new MediumInsertPriorityCommand().getPriorityLevel());
    }

}