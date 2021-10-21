package com.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.Dao.NotesDao;
import com.Database.NotesDatabase;
import com.Model.Notes;

import java.util.List;

public class NotesRepository {
    private NotesDao notesDao;
    private LiveData<List<Notes>> allNotes;
    private NotesDatabase database;

    public NotesRepository(Application application) {
        database = NotesDatabase.getDatabaseInstance(application);
        notesDao = database.notesDao();
        allNotes = notesDao.getAllNotes();
    }

    public NotesDao getNotesDao() {
        return notesDao;
    }

    public LiveData<List<Notes>> getAllNotes() {
        return allNotes;
    }

    public NotesDatabase getDatabase() {
        return database;
    }

    public void insertNotes(Notes notes){
        notesDao.insertNotes(notes);
    }

    public void deleteNotesById(int id){
        notesDao.deleteNotesById(id);
    }

    public void updateNotes(Notes notes){
        notesDao.updateNotes(notes);
    }
}
