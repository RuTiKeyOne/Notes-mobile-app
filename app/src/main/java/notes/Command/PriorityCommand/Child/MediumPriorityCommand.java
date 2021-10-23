package notes.Command.PriorityCommand.Child;

import androidx.databinding.ViewDataBinding;

import notes.Command.PriorityCommand.Parent.BasePriorityCommand;
import notes.Enum.PriorityLevel;
import com.notes.R;
import com.notes.databinding.ActivityInsertNotesBinding;

public class MediumPriorityCommand extends BasePriorityCommand {


    @Override
    public void changePriorityView(ViewDataBinding dataBinding) {
        if(dataBinding instanceof ActivityInsertNotesBinding){
            ActivityInsertNotesBinding insertBinding = (ActivityInsertNotesBinding) dataBinding;
            insertBinding.greenPriority.setImageResource(0);
            insertBinding.yellowPriority.setImageResource(R.drawable.ic_done);
            insertBinding.redPriority.setImageResource(0);
        }

    }

    @Override
    public PriorityLevel getPriorityLevel() {
        return PriorityLevel.MEDIUM_PRIORITY;
    }
}
