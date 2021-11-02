package notes.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.*;
import notes.Model.Notes;
import notes.Repository.NotesRepository;
import java.util.List;

public class NotesViewModel extends AndroidViewModel {


    private NotesRepository repository;

    public NotesViewModel(@NonNull Application application) {
        super(application);
        repository = new NotesRepository(application);
    }

    public LiveData<List<Notes>> getAllNotes(){
        return repository.getAllNotes();
    }

    public LiveData<List<Notes>> getHighToLowNotes(){return repository.getHighToLowNotes();}

    public LiveData<List<Notes>> getLowToHighNotes(){return repository.getLowToHighNotes();}

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
