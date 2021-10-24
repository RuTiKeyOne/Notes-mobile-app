package notes.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.format.DateFormat;

import notes.Command.PriorityCommand.Child.HighPriorityCommand;
import notes.Command.PriorityCommand.Child.LowPriorityCommand;
import notes.Command.PriorityCommand.Child.MediumPriorityCommand;
import notes.Command.PriorityCommand.Parent.BasePriorityCommand;
import notes.Model.Notes;
import notes.ViewModel.NotesViewModel;
import com.notes.R;
import com.notes.databinding.ActivityInsertNotesBinding;

import java.util.Date;

public class InsertNotesActivity extends AppCompatActivity {

    private ActivityInsertNotesBinding insertBinding;
    private NotesViewModel notesViewModel;
    private BasePriorityCommand priorityCommand;
    private String priorityLevel;
    private String title;
    private String subTitle;
    private String notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationViewComponents();
        initializationComponents();
        addNewNoteInDatabase();
        addChangePriorityLevel();
    }

    private void initializationViewComponents() {
        insertBinding = DataBindingUtil.setContentView(this, R.layout.activity_insert_notes);
    }

    private void initializationComponents() {
        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        priorityCommand = new HighPriorityCommand();
        priorityLevel = priorityCommand.getPriorityLevel();
    }

    private void addChangePriorityLevel() {

        insertBinding.redPriority.setOnClickListener(v -> {
            priorityCommand = new HighPriorityCommand();
            priorityCommand.changePriorityView(insertBinding);
            priorityLevel =  priorityCommand.getPriorityLevel();
        });

        insertBinding.yellowPriority.setOnClickListener(v -> {
            priorityCommand = new MediumPriorityCommand();
            priorityCommand.changePriorityView(insertBinding);
            priorityLevel =  priorityCommand.getPriorityLevel();
        });

        insertBinding.greenPriority.setOnClickListener(v -> {
            priorityCommand = new LowPriorityCommand();
            priorityCommand.changePriorityView(insertBinding);
            priorityLevel =  priorityCommand.getPriorityLevel();
        });

    }

    private void addNewNoteInDatabase() {

        insertBinding.doneNotesButton.setOnClickListener(v -> {
            createNote(getNotesData());
        });
    }

    private void createNote(Notes note) {
        notesViewModel.insertNotes(note);
        finish();
    }

    private Notes getNotesData() {
        title = insertBinding.notesTitle.getText().toString();
        subTitle = insertBinding.notesSubTitle.getText().toString();
        notes = insertBinding.notesData.getText().toString();
        return getNote(title, subTitle, notes);
    }

    private Notes getNote(String title, String subTitle, String notes){
        Notes note = new Notes();
        note.setNotesTitle(title);
        note.setNotesSubTitle(subTitle);
        note.setNotes(notes);
        note.setNotesDate(getDate());
        note.setNotesPriority(priorityLevel);
        return note;
    }

    private String getDate() {
        Date date = new Date();
        CharSequence dataSequence = DateFormat.format("MMMM d, YYYY", date.getTime());
        return dataSequence.toString();
    }
}