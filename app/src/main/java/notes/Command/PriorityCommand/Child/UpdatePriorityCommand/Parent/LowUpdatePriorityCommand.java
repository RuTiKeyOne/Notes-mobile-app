package notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent;

import static notes.Utilities.TempDataAdapter.LOW_PRIORITY_KEY;
import androidx.databinding.ViewDataBinding;
import com.notes.R;
import com.notes.databinding.ActivityUpdateNotesBinding;

import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Base.BaseUpdateCommand;
import notes.Command.PriorityCommand.Parent.BasePriorityCommand;

public class LowUpdatePriorityCommand extends BaseUpdateCommand {


    @Override
    public void changePriorityView(ViewDataBinding dataBinding) {
        if(dataBinding instanceof ActivityUpdateNotesBinding){
            ActivityUpdateNotesBinding updateBinding = (ActivityUpdateNotesBinding) dataBinding;
            updateBinding.greenPriority.setImageResource(R.drawable.ic_done);
            updateBinding.yellowPriority.setImageResource(0);
            updateBinding.redPriority.setImageResource(0);
        }
    }

    @Override
    public int getPriorityLevel() {
        return LOW_PRIORITY_KEY;
    }

}
