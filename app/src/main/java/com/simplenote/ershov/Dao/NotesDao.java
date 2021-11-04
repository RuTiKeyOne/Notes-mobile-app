package com.simplenote.ershov.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import java.util.List;
import com.simplenote.ershov.Model.Notes;

@androidx.room.Dao
public interface NotesDao {

    @Query("SELECT * FROM notes_database")
    LiveData<List<Notes>> getAllNotes();

    @Query("SELECT * FROM notes_database ORDER BY notes_priority ASC")
    LiveData<List<Notes>> highToLow();

    @Query("SELECT * FROM notes_database ORDER BY notes_priority DESC")
    LiveData<List<Notes>> lowToHigh();

    @Insert
    void insertNotes(Notes... notes);

    @Query("DELETE FROM notes_database WHERE id=:id")
    void deleteNotesById(int id);

    @Update
    void updateNotes(Notes notes);

}
