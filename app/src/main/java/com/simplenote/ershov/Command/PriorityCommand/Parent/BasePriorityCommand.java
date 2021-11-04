package com.simplenote.ershov.Command.PriorityCommand.Parent;

import androidx.databinding.ViewDataBinding;

public abstract class BasePriorityCommand {

    public abstract void changePriorityView(ViewDataBinding dataBinding);
    public abstract int getPriorityLevel();

}
