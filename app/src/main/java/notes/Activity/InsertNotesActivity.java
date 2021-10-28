package notes.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;

import notes.Command.PriorityCommand.Child.InsertPriorityCommand.*;
import notes.Command.PriorityCommand.Parent.BasePriorityCommand;
import notes.Intefaces.onChangePriorityView;
import notes.Model.Notes;
import notes.ViewModel.NotesViewModel;

import com.notes.R;
import com.notes.databinding.ActivityInsertNotesBinding;

import java.util.Date;

public class InsertNotesActivity extends AppCompatActivity implements onChangePriorityView {
    private ActivityInsertNotesBinding insertBinding;
    private NotesViewModel notesViewModel;
    private BasePriorityCommand priorityCommand;
    private NullTitleOrNoteSheetActivity nullActivity;
    private int priorityLevel;
    private String title;
    private String subTitle;
    private String notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationViewComponents();
        initializationComponents();
        addNewNoteInDatabase();
        onRedPriorityClick();
        onYellowPriorityClick();
        onGreenPriorityClick();
    }

    private void initializationViewComponents() {
        insertBinding = DataBindingUtil.setContentView(this, R.layout.activity_insert_notes);
    }

    private void initializationComponents() {
        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        priorityCommand = new HighInsertPriorityCommand();
        priorityLevel = priorityCommand.getPriorityLevel();
        nullActivity = new NullTitleOrNoteSheetActivity(this);
    }


    public void onRedPriorityClick() {
        insertBinding.redPriority.setOnClickListener(v -> {
            priorityCommand = new HighInsertPriorityCommand();
            priorityCommand.changePriorityView(insertBinding);
            priorityLevel = priorityCommand.getPriorityLevel();
        });
    }

    public void onYellowPriorityClick() {
        insertBinding.yellowPriority.setOnClickListener(v -> {
            priorityCommand = new MediumInsertPriorityCommand();
            priorityCommand.changePriorityView(insertBinding);
            priorityLevel = priorityCommand.getPriorityLevel();
        });
    }

    public void onGreenPriorityClick() {
        insertBinding.greenPriority.setOnClickListener(v -> {
            priorityCommand = new LowInsertPriorityCommand();
            priorityCommand.changePriorityView(insertBinding);
            priorityLevel = priorityCommand.getPriorityLevel();
        });
    }

    private void addNewNoteInDatabase() {
        insertBinding.doneNotesButton.setOnClickListener(v -> {
            if (IsTitleOrNoteNotNull()) {
                createNote(getNotesData());
            } else {
                nullActivity.onShowNullTitleOrNoteSheet();
            }
        });
    }

    private boolean IsTitleOrNoteNotNull() {
        return !insertBinding.notesTitle.getText().toString().isEmpty() &&
                !insertBinding.notesData.getText().toString().isEmpty();
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

    private Notes getNote(String title, String subTitle, String notes) {
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
        CharSequence dataSequence = DateFormat.format("EEE, MMM d, ''yy", date.getTime());
        return dataSequence.toString();
    }
}