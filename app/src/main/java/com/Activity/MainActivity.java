package com.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.ViewModel.NotesViewModel;
import com.notes.R;
import com.notes.databinding.ActivityInsertNotesBinding;
import com.notes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private NotesViewModel notesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationViewComponents();
        initializationComponents();
        getAllNotes();
        addNewNoteClickBehaviour();
    }

    private void initializationViewComponents(){
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private void initializationComponents(){
        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
    }

    private void getAllNotes(){
        notesViewModel.repository.getAllNotes().observe(this, notes -> {

        });
    }

    private void addNewNoteClickBehaviour(){
        mainBinding.newNotesButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InsertNotesActivity.class);
            startActivity(intent);
        });
    }

}