package notes.Command.AdapterCommand.Parent;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import notes.Intefaces.EditNoteListener;
import notes.Intefaces.OpenDetailBottomSheetListener;

public abstract class BaseAdapterCommand<T>{

    public abstract void bindItem(T data, ViewDataBinding dataBinding);
    public abstract ViewDataBinding getItemContainerBinding(LayoutInflater layoutInflater,
                                                            int idLayout, ViewGroup parent);
}
