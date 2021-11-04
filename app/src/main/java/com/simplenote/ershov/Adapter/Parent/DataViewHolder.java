package com.simplenote.ershov.Adapter.Parent;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.simplenote.ershov.Command.AdapterCommand.Parent.BaseAdapterCommand;

public class DataViewHolder<DataBinding extends ViewDataBinding, Data> extends RecyclerView.ViewHolder {

    BaseAdapterCommand adapterCommand;
    DataBinding dataBinding;

    public DataViewHolder(@NonNull DataBinding dataBinding, @NonNull BaseAdapterCommand adapterCommand) {
        super(dataBinding.getRoot());
        this.dataBinding = dataBinding;
        this.adapterCommand = adapterCommand;
    }

    public void bindData(Data data){
        adapterCommand.bindItem(data, dataBinding);
    }
}