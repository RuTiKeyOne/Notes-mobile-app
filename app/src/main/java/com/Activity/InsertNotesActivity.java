package com.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;

import com.Model.Notes;
import com.ViewModel.NotesViewModel;
import com.notes.R;
import com.notes.databinding.ActivityInsertNotesBinding;

import java.util.Date;

public class InsertNotesActivity extends AppCompatActivity {

    private ActivityInsertNotesBinding insertBinding;
    private NotesViewModel notesViewModel;

    private String title;
    private String subTitle;
    private String notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationViewComponents();
        initializationComponents();
        addNewNoteInDatabaseBehaviour();
    }

    private void initializationViewComponents(){
        insertBinding = DataBindingUtil.setContentView(this, R.layout.activity_insert_notes);
    }

    private void initializationComponents(){
        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
    }

    private void addNewNoteInDatabaseBehaviour(){

        insertBinding.doneNotesButton.setOnClickListener(v -> {
             createNote(getNotesData());
        });
    }

    private void createNote(Notes note) {
        notesViewModel.insertNotes(note);
        finish();
    }

    private Notes getNotesData(){
        title = insertBinding.notesTitle.getText().toString();
        subTitle = insertBinding.notesSubTitle.getText().toString();
        notes = insertBinding.notesData.getText().toString();
        return new Notes(title, subTitle, notes, getDate());
    }

    private String getDate(){
        Date date = new Date();
        CharSequence dataSequence = DateFormat.format("MMMM d, YYYY", date.getTime());
        return dataSequence.toString();
    }
}