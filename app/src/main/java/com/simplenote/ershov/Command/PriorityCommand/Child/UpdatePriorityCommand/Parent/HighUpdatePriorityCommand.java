package com.simplenote.ershov.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent;

import static com.simplenote.ershov.Utilities.TempDataAdapter.HIGH_PRIORITY_KEY;

import androidx.databinding.ViewDataBinding;

import com.simplenote.ershov.R;
import com.simplenote.ershov.databinding.ActivityUpdateNotesBinding;

import com.simplenote.ershov.Command.PriorityCommand.Child.UpdatePriorityCommand.Base.BaseUpdateCommand;

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
