package com.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.Model.Notes;
import com.Repository.NotesRepository;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {

    public NotesRepository repository;
    public LiveData<List<Notes>> allNotes;

    public NotesViewModel(@NonNull Application application) {
        super(application);
        repository = new NotesRepository(application);
        allNotes = repository.getAllNotes();
    }

    public void insertNotes(Notes notes){
        repository.insertNotes(notes);
    }

    public void deleteNoteById(int id){
        repository.deleteNotesById(id);
    }

    public void updateNote(Notes note){
        repository.updateNotes(note);
    }
}
