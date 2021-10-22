package com.Command.Child;

import androidx.databinding.ViewDataBinding;

import com.Command.Parent.BasePriorityCommand;
import com.Enum.PriorityLevel;
import com.notes.R;
import com.notes.databinding.ActivityInsertNotesBinding;

public class HighPriorityCommand extends BasePriorityCommand {



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
    public PriorityLevel getPriorityLevel(){
        return PriorityLevel.HIGH_PRIORITY;
    }
}
