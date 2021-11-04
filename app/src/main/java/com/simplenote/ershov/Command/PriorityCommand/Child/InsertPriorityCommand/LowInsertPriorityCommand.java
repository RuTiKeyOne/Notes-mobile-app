package com.simplenote.ershov.Command.PriorityCommand.Child.InsertPriorityCommand;

import static com.simplenote.ershov.Utilities.TempDataAdapter.LOW_PRIORITY_KEY;
import androidx.databinding.ViewDataBinding;
import com.simplenote.ershov.R;
import com.simplenote.ershov.databinding.ActivityInsertNotesBinding;
import com.simplenote.ershov.Command.PriorityCommand.Parent.BasePriorityCommand;

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
