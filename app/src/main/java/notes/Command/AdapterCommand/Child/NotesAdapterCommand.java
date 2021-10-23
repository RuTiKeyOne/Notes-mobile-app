package notes.Command.AdapterCommand.Child;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import notes.Command.AdapterCommand.Parent.BaseAdapterCommand;
import notes.Model.Notes;
import com.notes.databinding.ItemNotesBinding;

public class NotesAdapterCommand extends BaseAdapterCommand<Notes> {
    @Override
    public void bindData(Notes data, ViewDataBinding dataBinding) {
        setNote(data, dataBinding);
    }

    @Override
    public ViewDataBinding getItemContainerBinding(LayoutInflater layoutInflater, int idLayout, ViewGroup parent) {
        ItemNotesBinding notesBinding = DataBindingUtil.inflate(layoutInflater, idLayout, parent, false);
        return notesBinding;
    }

    private void setNote(Notes data, ViewDataBinding dataBinding){
        if(dataBinding instanceof ItemNotesBinding){
            ((ItemNotesBinding)dataBinding).setTitle(data.notesTitle);
            ((ItemNotesBinding)dataBinding).setSubTitle(data.notesSubTitle);
            ((ItemNotesBinding)dataBinding).setDate(data.notesDate);
        }
    }
}
