package com.simplenote.ershov.Command.AdapterCommand.Parent;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

public abstract class BaseAdapterCommand<T>{

    public abstract void bindItem(T data, ViewDataBinding dataBinding);
    public abstract ViewDataBinding getItemContainerBinding(LayoutInflater layoutInflater,
                                                            int idLayout, ViewGroup parent);
}
