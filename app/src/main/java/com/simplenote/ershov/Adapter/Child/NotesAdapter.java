package com.simplenote.ershov.Adapter.Child;

import com.simplenote.ershov.R;
import java.util.List;
import com.simplenote.ershov.Adapter.Parent.DataAdapter;
import com.simplenote.ershov.Command.AdapterCommand.Child.NotesAdapterCommand;
import com.simplenote.ershov.Interfaces.OpenDetailBottomSheetListener;
import com.simplenote.ershov.Model.Notes;

public class NotesAdapter extends DataAdapter<Notes, List<Notes>>{

    public NotesAdapter(List<Notes> notes, OpenDetailBottomSheetListener listener) {
        super(notes, new NotesAdapterCommand(listener), R.layout.item_notes);
    }

}
