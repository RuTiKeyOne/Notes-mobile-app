package notes.Adapter.Child;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import notes.Activity.MainActivity;
import notes.Adapter.Parent.DataAdapter;
import notes.Adapter.Parent.DataViewHolder;
import notes.Command.AdapterCommand.Child.NotesAdapterCommand;
import notes.Command.AdapterCommand.Parent.BaseAdapterCommand;
import notes.Command.SetViewCommand.Child.SetHighPriorityCommand;
import notes.Model.Notes;
import com.notes.R;
import com.notes.databinding.ItemNotesBinding;

import java.util.List;

public class NotesAdapter extends DataAdapter<Notes, List<Notes>>{


    public NotesAdapter(List<Notes> notes, MainActivity activity) {
        super(notes, new NotesAdapterCommand(activity), R.layout.item_notes);
    }
}
