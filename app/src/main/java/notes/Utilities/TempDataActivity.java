package notes.Utilities;

import static notes.Utilities.TempDataViewModel.NOTE_INTENT_KEY;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import notes.Activity.DetailsBottomSheetActivity;
import notes.Activity.UpdateNotesActivity;
import notes.Adapter.Child.NotesAdapter;
import notes.Intefaces.*;
import notes.Model.Notes;

public class TempDataActivity extends AppCompatActivity implements EditNoteListener, OpenDetailBottomSheetListener {

    protected DetailsBottomSheetActivity detailsActivity;
    public static final String NOTES_DATA_KEY = "NOTES_DATA";


    protected void initializationComponents(){
        this.detailsActivity = new DetailsBottomSheetActivity(this);
    }

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
        }
    }


}
