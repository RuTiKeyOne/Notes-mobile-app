package notes.Adapter.Parent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import notes.Command.AdapterCommand.Parent.BaseAdapterCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataAdapter<TypeData , Data extends List<TypeData>> extends RecyclerView.Adapter<DataViewHolder> {

    protected Data data;
    private LayoutInflater layoutInflater;
    protected BaseAdapterCommand adapterCommand;
    private int idLayout;

    public Data getData() {
        return data;
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public BaseAdapterCommand getAdapterCommand() {
        return adapterCommand;
    }

    public int getIdLayout() {
        return idLayout;
    }

    public DataAdapter(Data data, BaseAdapterCommand adapterCommand, int idLayout) {
        this.data = data;
        this.adapterCommand = adapterCommand;
        this.idLayout = idLayout;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        return new DataViewHolder(adapterCommand.getItemContainerBinding(layoutInflater, idLayout, parent),
                adapterCommand);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        holder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
