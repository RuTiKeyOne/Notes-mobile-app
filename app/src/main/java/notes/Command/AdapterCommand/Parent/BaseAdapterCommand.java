package notes.Command.AdapterCommand.Parent;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import notes.Intefaces.NoteListener;

public abstract class BaseAdapterCommand<T>{

    protected NoteListener listener;

    public BaseAdapterCommand(NoteListener listener) {
        this.listener = listener;
    }

    public abstract void bindItem(T data, ViewDataBinding dataBinding);
    public abstract ViewDataBinding getItemContainerBinding(LayoutInflater layoutInflater,
                                                            int idLayout, ViewGroup parent);
}
