package notes.Repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import notes.Dao.NotesDao;
import notes.Database.NotesDatabase;
import notes.Model.Notes;
import java.util.List;

public class NotesRepository {
    private NotesDao notesDao;
    private NotesDatabase database;

    public NotesRepository(Application application) {
        database = NotesDatabase.getDatabaseInstance(application);
        notesDao = database.notesDao();
    }

    public NotesDao getNotesDao() {
        return notesDao;
    }

    public LiveData<List<Notes>> getAllNotes() {
        return notesDao.getAllNotes();
    }

    public LiveData<List<Notes>> getHighToLowNotes(){return notesDao.highToLow();}

    public LiveData<List<Notes>> getLowToHighNotes(){return notesDao.lowToHigh();}

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
