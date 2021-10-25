package notes.Command.PriorityCommand.Child.InsertPriorityCommand;

import static notes.Utilities.TempDataAdapter.LOW_PRIORITY_KEY;

import androidx.databinding.ViewDataBinding;

import notes.Command.PriorityCommand.Parent.BasePriorityCommand;

import com.notes.R;
import com.notes.databinding.ActivityInsertNotesBinding;

public class LowInsertPriorityCommand extends BasePriorityCommand {

    @Override
    public void changePriorityView(ViewDataBinding dataBinding) {
        if(dataBinding instanceof ActivityInsertNotesBinding){
            ActivityInsertNotesBinding insertBinding = (ActivityInsertNotesBinding) dataBinding;
            insertBinding.greenPriority.setImageResource(R.drawable.ic_done);
            insertBinding.yellowPriority.setImageResource(0);
            insertBinding.redPriority.setImageResource(0);
        }
    }

    @Override
    public int getPriorityLevel() {
        return LOW_PRIORITY_KEY;
    }
}
