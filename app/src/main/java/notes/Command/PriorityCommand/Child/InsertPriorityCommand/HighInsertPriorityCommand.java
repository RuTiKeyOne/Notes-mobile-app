package notes.Command.PriorityCommand.Child.InsertPriorityCommand;

import static notes.Utilities.TempDataAdapter.HIGH_PRIORITY_KEY;

import androidx.databinding.ViewDataBinding;

import notes.Command.PriorityCommand.Parent.BasePriorityCommand;
import notes.Utilities.TempDataAdapter;

import com.notes.R;
import com.notes.databinding.ActivityInsertNotesBinding;

public class HighInsertPriorityCommand extends BasePriorityCommand {

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
    public String getPriorityLevel(){
        return HIGH_PRIORITY_KEY;
    }
}
