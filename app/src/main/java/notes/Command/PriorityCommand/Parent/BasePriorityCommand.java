package notes.Command.PriorityCommand.Parent;

import androidx.databinding.ViewDataBinding;

public abstract class BasePriorityCommand {

    public abstract void changePriorityView(ViewDataBinding dataBinding);
    public abstract String getPriorityLevel();

}
