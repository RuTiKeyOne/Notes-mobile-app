package notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent;

import static notes.Utilities.TempDataAdapter.MEDIUM_PRIORITY_KEY;
import androidx.databinding.ViewDataBinding;
import com.notes.R;
import com.notes.databinding.ActivityUpdateNotesBinding;
import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Base.BaseUpdateCommand;

public class MediumUpdatePriorityCommand extends BaseUpdateCommand {

    @Override
    public void changePriorityView(ViewDataBinding dataBinding) {
        if(dataBinding instanceof ActivityUpdateNotesBinding){
            ActivityUpdateNotesBinding updateBinding = (ActivityUpdateNotesBinding) dataBinding;
            updateBinding.greenPriority.setImageResource(0);
            updateBinding.yellowPriority.setImageResource(R.drawable.ic_done);
            updateBinding.redPriority.setImageResource(0);
        }

    }

    @Override
    public int getPriorityLevel() {
        return MEDIUM_PRIORITY_KEY;
    }

}
