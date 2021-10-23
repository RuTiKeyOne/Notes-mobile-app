package notes.Adapter.Child;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import notes.Adapter.Parent.DataAdapter;
import notes.Adapter.Parent.DataViewHolder;
import notes.Command.AdapterCommand.Child.NotesAdapterCommand;
import notes.Model.Notes;
import com.notes.R;
import com.notes.databinding.ItemNotesBinding;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private List<Notes> notesData;
    private LayoutInflater layoutInflater;

    public NotesAdapter(List<Notes> notesData) {
        this.notesData = notesData;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater =  LayoutInflater.from(parent.getContext());
        }

        ItemNotesBinding notesBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.item_notes, parent, false);
        return new NotesViewHolder(notesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.bindData(notesData.get(position));
    }

    @Override
    public int getItemCount() {
        return notesData.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {

        private ItemNotesBinding notesBinding;

        public NotesViewHolder(@NonNull ItemNotesBinding notesBinding) {
            super(notesBinding.getRoot());
            this.notesBinding = notesBinding;
        }

        public void bindData(Notes notes){
            notesBinding.setTitle(notes.notesTitle);
            notesBinding.setSubTitle(notes.notesSubTitle);
            notesBinding.setDate(notes.notesDate);
        }
    }

}
