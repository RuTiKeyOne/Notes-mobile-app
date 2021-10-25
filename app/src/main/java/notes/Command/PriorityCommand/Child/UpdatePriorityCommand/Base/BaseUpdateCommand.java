package notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Base;

import static notes.Utilities.TempDataAdapter.HIGH_PRIORITY_KEY;
import static notes.Utilities.TempDataAdapter.LOW_PRIORITY_KEY;
import static notes.Utilities.TempDataAdapter.MEDIUM_PRIORITY_KEY;

import androidx.databinding.ViewDataBinding;

import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent.HighUpdatePriorityCommand;
import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent.LowUpdatePriorityCommand;
import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent.MediumUpdatePriorityCommand;
import notes.Command.PriorityCommand.Parent.BasePriorityCommand;

public abstract class BaseUpdateCommand extends BasePriorityCommand {

    public void getPriorityViewWithData(int priorityLevel, ViewDataBinding dataBinding){
        if(priorityLevel != 0){
            getPriorityView(priorityLevel, dataBinding);
        }else{
            new HighUpdatePriorityCommand().changePriorityView(dataBinding);
        }
    }

    private void getPriorityView(int priorityLevel, ViewDataBinding dataBinding){
        switch (priorityLevel){
            case HIGH_PRIORITY_KEY :
                new HighUpdatePriorityCommand().changePriorityView(dataBinding);
                break;
            case MEDIUM_PRIORITY_KEY:
                new MediumUpdatePriorityCommand().changePriorityView(dataBinding);
                break;
            case LOW_PRIORITY_KEY:
                new LowUpdatePriorityCommand().changePriorityView(dataBinding);
                break;
        }
    }

    @Override
    public abstract void changePriorityView(ViewDataBinding dataBinding);

    @Override
    public abstract int getPriorityLevel();
}
