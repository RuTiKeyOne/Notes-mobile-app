package notes.Command.PriorityCommand.Child.InsertPriorityCommand;

import static notes.Utilities.TempDataAdapter.MEDIUM_PRIORITY_KEY;

import androidx.databinding.ViewDataBinding;

import notes.Command.PriorityCommand.Parent.BasePriorityCommand;
import notes.Utilities.TempDataAdapter;

import com.notes.R;
import com.notes.databinding.ActivityInsertNotesBinding;

public class MediumInsertPriorityCommand extends BasePriorityCommand {


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
    public int getPriorityLevel() {
        return MEDIUM_PRIORITY_KEY;
    }
}
