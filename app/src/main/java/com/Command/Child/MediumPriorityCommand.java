package com.Command.Child;

import androidx.databinding.ViewDataBinding;

import com.Command.Parent.BasePriorityCommand;
import com.Enum.PriorityLevel;
import com.notes.R;
import com.notes.databinding.ActivityInsertNotesBinding;

public class MediumPriorityCommand extends BasePriorityCommand {


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
    public PriorityLevel getPriorityLevel() {
        return PriorityLevel.MEDIUM_PRIORITY;
    }
}
