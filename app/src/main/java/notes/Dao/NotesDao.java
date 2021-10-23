package notes.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import notes.Model.Notes;

import java.util.List;
import java.util.Set;

@androidx.room.Dao
public interface NotesDao {

    @Query("SELECT * FROM notes_database")
    LiveData<List<Notes>> getAllNotes();

    @Insert
    void insertNotes(Notes... notes);

    @Query("DELETE FROM notes_database WHERE id=:id")
    void deleteNotesById(int id);

    @Update
    void updateNotes(Notes notes);

}
