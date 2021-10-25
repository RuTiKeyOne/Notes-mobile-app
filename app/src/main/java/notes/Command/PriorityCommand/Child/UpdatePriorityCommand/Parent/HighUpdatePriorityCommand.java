package notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent;

import static notes.Utilities.TempDataAdapter.HIGH_PRIORITY_KEY;
import androidx.databinding.ViewDataBinding;
import com.notes.R;
import com.notes.databinding.ActivityUpdateNotesBinding;

import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Base.BaseUpdateCommand;
import notes.Command.PriorityCommand.Parent.BasePriorityCommand;

public class HighUpdatePriorityCommand extends BaseUpdateCommand {
    @Override
    public void changePriorityView(ViewDataBinding dataBinding) {
        if(dataBinding instanceof ActivityUpdateNotesBinding){
            ActivityUpdateNotesBinding updateBinding = (ActivityUpdateNotesBinding) dataBinding;
            updateBinding.greenPriority.setImageResource(0);
            updateBinding.yellowPriority.setImageResource(0);
            updateBinding.redPriority.setImageResource(R.drawable.ic_done);
        }
    }

    @Override
    public int getPriorityLevel(){
        return HIGH_PRIORITY_KEY;
    }
}
