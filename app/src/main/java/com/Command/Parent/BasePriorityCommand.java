package com.Command.Parent;

import androidx.databinding.ViewDataBinding;

import com.Enum.PriorityLevel;

public abstract class BasePriorityCommand {

    public abstract void changePriorityView(ViewDataBinding dataBinding);
    public abstract PriorityLevel getPriorityLevel();

}
