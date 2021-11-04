package com.simplenote.ershov.Utilities;

import static com.simplenote.ershov.Utilities.TempDataViewModel.NOTE_INTENT_KEY;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import com.simplenote.ershov.Activity.*;
import com.simplenote.ershov.Adapter.Child.NotesAdapter;
import com.simplenote.ershov.Interfaces.*;
import com.simplenote.ershov.Model.Notes;
import com.simplenote.ershov.ViewModel.NotesViewModel;

public class TempDataActivity extends AppCompatActivity implements EditNoteListener, OpenDetailBottomSheetListener {

    public DetailsBottomSheetActivity detailsActivity;
    public static final String NOTES_DATA_KEY = "NOTES_DATA";


    @Override
    public void onNoteEdit(Notes note) {
        Intent updateIntent = new Intent(getApplicationContext(), UpdateNotesActivity.class);
        updateIntent.putExtra(NOTE_INTENT_KEY, note);
        startActivity(updateIntent);
    }

    @Override
    public void onOpenSheet(Notes note) {
        if (this.detailsActivity != null) {
            this.detailsActivity.onStartBottomSheetActivity(note);
            this.detailsActivity = new DetailsBottomSheetActivity(this);
        }
    }

    public DetailsBottomSheetActivity getDetailsActivity() {
        return detailsActivity;
    }

    protected void getAllNotes(NotesViewModel notesViewModel,
                               List<Notes> notesData, NotesAdapter notesAdapter) {
        notesViewModel.getAllNotes().observe(this, notes -> {
            notesData.clear();
            notesData.addAll(notes);
            notesAdapter.notifyDataSetChanged();
        });
    }

    protected void getLowToHighNotes(NotesViewModel notesViewModel,
                                     List<Notes> notesData, NotesAdapter notesAdapter) {
        notesViewModel.getLowToHighNotes().observe(this, notes -> {
            notesData.clear();
            notesData.addAll(notes);
            notesAdapter.notifyDataSetChanged();
        });
    }

    protected void getHighToLowNotes(NotesViewModel notesViewModel,
                                     List<Notes> notesData, NotesAdapter notesAdapter) {
        notesViewModel.getHighToLowNotes().observe(this, notes -> {
            notesData.clear();
            notesData.addAll(notes);
            notesAdapter.notifyDataSetChanged();
        });
    }


}
