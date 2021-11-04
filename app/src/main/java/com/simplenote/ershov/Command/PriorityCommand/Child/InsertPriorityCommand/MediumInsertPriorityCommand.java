package com.simplenote.ershov.Command.PriorityCommand.Child.InsertPriorityCommand;

import static com.simplenote.ershov.Utilities.TempDataAdapter.MEDIUM_PRIORITY_KEY;
import androidx.databinding.ViewDataBinding;
import com.simplenote.ershov.R;
import com.simplenote.ershov.databinding.ActivityInsertNotesBinding;
import com.simplenote.ershov.Command.PriorityCommand.Parent.BasePriorityCommand;

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
