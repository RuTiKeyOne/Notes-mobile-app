package notes.Command.AdapterCommand.Child;

import static notes.Utilities.TempDataAdapter.HIGH_PRIORITY_KEY;
import static notes.Utilities.TempDataAdapter.LOW_PRIORITY_KEY;
import static notes.Utilities.TempDataAdapter.MEDIUM_PRIORITY_KEY;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import notes.Command.AdapterCommand.Parent.BaseAdapterCommand;
import notes.Command.SetViewCommand.Child.SetHighPriorityCommand;
import notes.Command.SetViewCommand.Child.SetLowPriorityCommand;
import notes.Command.SetViewCommand.Child.SetMediumPriorityCommand;
import notes.Command.SetViewCommand.Parent.BaseSetViewCommand;
import notes.Model.Notes;

import com.notes.databinding.ItemNotesBinding;

public class NotesAdapterCommand extends BaseAdapterCommand<Notes> {

    private BaseSetViewCommand setViewCommand;

    @Override
    public void bindItem(Notes data, ViewDataBinding dataBinding) {
        setNote(data, dataBinding);
        setPriorityViewBehaviour(data, dataBinding);
    }

    @Override
    public ViewDataBinding getItemContainerBinding(LayoutInflater layoutInflater, int idLayout, ViewGroup parent) {
        ItemNotesBinding notesBinding = DataBindingUtil.inflate(layoutInflater, idLayout, parent, false);
        return notesBinding;
    }

    private void setNote(Notes data, ViewDataBinding dataBinding) {
        if (dataBinding instanceof ItemNotesBinding) {
            ((ItemNotesBinding) dataBinding).setTitle(data.notesTitle);
            ((ItemNotesBinding) dataBinding).setSubTitle(data.notesSubTitle);
            ((ItemNotesBinding) dataBinding).setDate(data.notesDate);
        }
    }

    private void setPriorityViewBehaviour(Notes data, ViewDataBinding dataBinding) {
        if (dataBinding instanceof ItemNotesBinding) {
            setPriorityView(data, dataBinding);
        }
    }

    private void setPriorityView(Notes data, ViewDataBinding dataBinding) {
        ItemNotesBinding notesBinding = (ItemNotesBinding) dataBinding;
        if (data.notesPriority != null) {
            setPriorityView(data.notesPriority, dataBinding);
        } else {
            setDefaultPriorityView(dataBinding);
        }
    }

    private void setPriorityView(String priorityLevel, ViewDataBinding dataBinding) {
        Log.d("log", priorityLevel);
        switch (priorityLevel) {
            case HIGH_PRIORITY_KEY:
                setDefaultPriorityView(dataBinding);
                break;
            case MEDIUM_PRIORITY_KEY:
                setMediumPriorityView(dataBinding);
                break;
            case LOW_PRIORITY_KEY:
                setLowPriorityView(dataBinding);
                break;
        }
    }

    private void setDefaultPriorityView(ViewDataBinding dataBinding) {
        setViewCommand = new SetHighPriorityCommand();
        setViewCommand.setViewCommand(dataBinding);
    }

    private void setMediumPriorityView(ViewDataBinding dataBinding) {
        setViewCommand = new SetMediumPriorityCommand();
        setViewCommand.setViewCommand(dataBinding);
    }

    private void setLowPriorityView(ViewDataBinding dataBinding) {
        setViewCommand = new SetLowPriorityCommand();
        setViewCommand.setViewCommand(dataBinding);
    }


}
