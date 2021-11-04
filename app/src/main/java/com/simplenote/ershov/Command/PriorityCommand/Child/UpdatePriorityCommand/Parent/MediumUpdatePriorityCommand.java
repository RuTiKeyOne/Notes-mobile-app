package com.simplenote.ershov.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent;

import static com.simplenote.ershov.Utilities.TempDataAdapter.MEDIUM_PRIORITY_KEY;

import androidx.databinding.ViewDataBinding;

import com.simplenote.ershov.R;
import com.simplenote.ershov.databinding.ActivityUpdateNotesBinding;

import com.simplenote.ershov.Command.PriorityCommand.Child.UpdatePriorityCommand.Base.BaseUpdateCommand;

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
