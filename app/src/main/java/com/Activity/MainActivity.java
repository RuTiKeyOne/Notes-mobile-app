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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationViewComponents();
        addNewNoteClickBehaviour();
    }

    private void initializationViewComponents(){
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private void addNewNoteClickBehaviour(){
        mainBinding.newNotesButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InsertNotesActivity.class);
            startActivity(intent);
        });
    }

}