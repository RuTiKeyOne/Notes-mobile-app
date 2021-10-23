package notes.Command.PriorityCommand.Parent;

import androidx.databinding.ViewDataBinding;

import notes.Enum.PriorityLevel;

public abstract class BasePriorityCommand {

    public abstract void changePriorityView(ViewDataBinding dataBinding);
    public abstract PriorityLevel getPriorityLevel();

}
