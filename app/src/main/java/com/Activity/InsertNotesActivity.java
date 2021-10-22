package com.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;

import com.Command.Child.HighPriorityCommand;
import com.Command.Child.LowPriorityCommand;
import com.Command.Child.MediumPriorityCommand;
import com.Command.Parent.BasePriorityCommand;
import com.Enum.PriorityLevel;
import com.Model.Notes;
import com.ViewModel.NotesViewModel;
import com.notes.R;
import com.notes.databinding.ActivityInsertNotesBinding;

import java.util.Date;

public class InsertNotesActivity extends AppCompatActivity {

    private ActivityInsertNotesBinding insertBinding;
    private NotesViewModel notesViewModel;
    private BasePriorityCommand priorityCommand;
    private PriorityLevel priorityLevel;

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
        priorityLevel = PriorityLevel.HIGH_PRIORITY;
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
        return new Notes(title, subTitle, notes, getDate(), priorityLevel);
    }

    private String getDate() {
        Date date = new Date();
        CharSequence dataSequence = DateFormat.format("MMMM d, YYYY", date.getTime());
        return dataSequence.toString();
    }
}