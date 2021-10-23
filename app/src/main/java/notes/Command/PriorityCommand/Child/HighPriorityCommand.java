package notes.Command.PriorityCommand.Child;

import androidx.databinding.ViewDataBinding;

import notes.Command.PriorityCommand.Parent.BasePriorityCommand;
import notes.Enum.PriorityLevel;
import com.notes.R;
import com.notes.databinding.ActivityInsertNotesBinding;

public class HighPriorityCommand extends BasePriorityCommand {



    @Override
    public void changePriorityView(ViewDataBinding dataBinding) {
        if(dataBinding instanceof ActivityInsertNotesBinding){
            ActivityInsertNotesBinding insertBinding = (ActivityInsertNotesBinding) dataBinding;
            insertBinding.greenPriority.setImageResource(0);
            insertBinding.yellowPriority.setImageResource(0);
            insertBinding.redPriority.setImageResource(R.drawable.ic_done);
        }
    }

    @Override
    public PriorityLevel getPriorityLevel(){
        return PriorityLevel.HIGH_PRIORITY;
    }
}
