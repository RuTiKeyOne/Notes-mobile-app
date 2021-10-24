package notes.Adapter.Child;

import notes.Activity.MainActivity;
import notes.Adapter.Parent.DataAdapter;
import notes.Command.AdapterCommand.Child.NotesAdapterCommand;
import notes.Model.Notes;
import com.notes.R;

import java.util.List;

public class NotesAdapter extends DataAdapter<Notes, List<Notes>>{


    public NotesAdapter(List<Notes> notes, MainActivity activity) {
        super(notes, new NotesAdapterCommand(activity), R.layout.item_notes);
    }
}
