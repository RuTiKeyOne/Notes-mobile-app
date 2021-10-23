package notes.Adapter.Parent;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import notes.Command.AdapterCommand.Parent.BaseAdapterCommand;

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