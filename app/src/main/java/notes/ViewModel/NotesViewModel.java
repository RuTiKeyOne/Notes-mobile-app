package notes.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import notes.Model.Notes;
import notes.Repository.NotesRepository;

import java.util.List;
import java.util.Set;

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
