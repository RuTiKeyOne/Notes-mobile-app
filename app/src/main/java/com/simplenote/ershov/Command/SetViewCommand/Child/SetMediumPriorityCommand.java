package com.simplenote.ershov.Command.SetViewCommand.Child;

import androidx.databinding.ViewDataBinding;
import com.simplenote.ershov.R;
import com.simplenote.ershov.databinding.ItemNotesBinding;
import com.simplenote.ershov.Command.SetViewCommand.Parent.BaseSetViewCommand;

public class SetMediumPriorityCommand extends BaseSetViewCommand {
    @Override
    public void setViewCommand(ViewDataBinding dataBinding) {
        if(dataBinding instanceof ItemNotesBinding){
            ItemNotesBinding notesBinding = (ItemNotesBinding) dataBinding;
            notesBinding.notesPriority.setBackgroundResource(R.drawable.yellow_shape);
        }
    }
}
