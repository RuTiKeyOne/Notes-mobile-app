package com.simplenote.ershov.Command.PriorityCommand.Child.InsertPriorityCommand;

import static com.simplenote.ershov.Utilities.TempDataAdapter.HIGH_PRIORITY_KEY;

import androidx.databinding.ViewDataBinding;
import com.simplenote.ershov.R;
import com.simplenote.ershov.databinding.ActivityInsertNotesBinding;
import com.simplenote.ershov.Command.PriorityCommand.Parent.BasePriorityCommand;

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
    public int getPriorityLevel(){
        return HIGH_PRIORITY_KEY;
    }
}
