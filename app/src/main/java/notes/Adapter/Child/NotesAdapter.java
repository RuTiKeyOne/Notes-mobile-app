package notes.Adapter.Child;

import notes.Activity.MainActivity;
import notes.Adapter.Parent.DataAdapter;
import notes.Command.AdapterCommand.Child.NotesAdapterCommand;
import notes.Intefaces.OpenDetailBottomSheetListener;
import notes.Model.Notes;
import com.notes.R;

import java.util.List;

public class NotesAdapter extends DataAdapter<Notes, List<Notes>>{

    public NotesAdapter(List<Notes> notes, OpenDetailBottomSheetListener listener) {
        super(notes, new NotesAdapterCommand(listener), R.layout.item_notes);
    }


}
