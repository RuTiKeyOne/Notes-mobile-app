package notes.Activity;

import static notes.Utilities.TempDataViewModel.NOTE_INTENT_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;

import com.notes.R;
import com.notes.databinding.ActivityUpdateNotesBinding;

import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Base.BaseUpdateCommand;
import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent.*;
import notes.Intefaces.DeleteNoteListener;
import notes.Intefaces.onChangePriorityView;
import notes.Model.Notes;
import notes.ViewModel.NotesViewModel;

public class UpdateNotesActivity extends AppCompatActivity implements DeleteNoteListener, onChangePriorityView {

    private ActivityUpdateNotesBinding updateBinding;
    private NotesViewModel notesViewModel;
    private BaseUpdateCommand changePriorityCommand;
    private DeleteBottomSheetActivity bottomSheetActivity;
    private Notes note;
    private String title;
    private String notes;
    private int priorityLevel;

    public ActivityUpdateNotesBinding getUpdateBinding() {
        return updateBinding;
    }

    public NotesViewModel getNotesViewModel() {
        return notesViewModel;
    }

    public BaseUpdateCommand getChangePriorityCommand() {
        return changePriorityCommand;
    }

    public DeleteBottomSheetActivity getBottomSheetActivity() {
        return bottomSheetActivity;
    }

    public Notes getNote() {
        return note;
    }


    public String getNotes() {
        return notes;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationComponents();
        initializationComponentsView();
        setInitialDataView();
        getUpdatedDataWithInput();
        onBackClick();
        onDeleteNoteClick();
        onRedPriorityClick();
        onYellowPriorityClick();
        onGreenPriorityClick();
        updatedNote();

    }

    public void initializationComponents() {
        bottomSheetActivity = new DeleteBottomSheetActivity(UpdateNotesActivity.this, this);
        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        note = (Notes) getIntent().getSerializableExtra(NOTE_INTENT_KEY);
        title = note.getNotesTitle();
        notes = note.getNotes();
        priorityLevel = note.getNotesPriority();
        changePriorityCommand = new HighUpdatePriorityCommand();
    }

    public void initializationComponentsView() {
        updateBinding = DataBindingUtil.setContentView(this, R.layout.activity_update_notes);
        changePriorityCommand.getPriorityViewWithData(note.getNotesPriority(), updateBinding);
        updateBinding.inputTitle.setMovementMethod(new ScrollingMovementMethod());
        updateBinding.inputData.setMovementMethod(new ScrollingMovementMethod());
    }

    public void setInitialDataView() {
        if (note != null) {
            updateBinding.setTitle(note.notesTitle);
            updateBinding.setNotes(note.notes);
        }
    }

    public void updatedNote() {
        updateBinding.updateNotesButton.setOnClickListener(v -> {
            notesViewModel.updateNote(getUpdatedNote());
            finish();
        });
    }

    public Notes getUpdatedNote() {
        Notes updatedNote = this.note;
        updatedNote.setNotesTitle(title);
        updatedNote.setNotes(notes);
        updatedNote.setNotesPriority(priorityLevel);
        return updatedNote;
    }

    @Override
    public void onRedPriorityClick() {
        updateBinding.redPriority.setOnClickListener(v -> {
            changePriorityCommand = new HighUpdatePriorityCommand();
            changePriorityCommand.changePriorityView(updateBinding);
            priorityLevel = changePriorityCommand.getPriorityLevel();
        });
    }

    @Override
    public void onYellowPriorityClick() {
        updateBinding.yellowPriority.setOnClickListener(v -> {
            changePriorityCommand = new MediumUpdatePriorityCommand();
            changePriorityCommand.changePriorityView(updateBinding);
            priorityLevel = changePriorityCommand.getPriorityLevel();
        });
    }

    @Override
    public void onGreenPriorityClick() {
        updateBinding.greenPriority.setOnClickListener(v -> {
            changePriorityCommand = new LowUpdatePriorityCommand();
            changePriorityCommand.changePriorityView(updateBinding);
            priorityLevel = changePriorityCommand.getPriorityLevel();
        });
    }

    private void getUpdatedDataWithInput() {
        getUpdatedTitle();
        getUpdatedNotes();
    }

    private void getUpdatedTitle() {
        updateBinding.inputTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty()) {
                    title = editable.toString();
                } else {
                    title = note.getNotesTitle();
                }
            }
        });
    }


    private void getUpdatedNotes() {
        updateBinding.inputData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty()) {
                    notes = editable.toString();
                } else {
                    notes = note.getNotes();
                }
            }
        });
    }

    private void onBackClick(){
        updateBinding.editImageBack.setOnClickListener(v -> {
            finish();
        });
    }

    private void onDeleteNoteClick() {
        updateBinding.imageDelete.setOnClickListener(v -> {
            bottomSheetActivity.onShowDeleteBottomSheet();
        });
    }

    @Override
    public void onDeleteNote() {
        notesViewModel.deleteNoteById(note.getId());
        onBackPressed();
    }

}