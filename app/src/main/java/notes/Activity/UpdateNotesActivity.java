package notes.Activity;

import static notes.Utilities.TempDataViewModel.NOTE_INTENT_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

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
    private String subTitle;
    private String notes;
    private int priorityLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationComponents();
        initializationViewComponents();
        setInitialDataView();
        getUpdatedDataWithInput();
        onDeleteNoteClick();
        onRedPriorityClick();
        onYellowPriorityClick();
        onGreenPriorityClick();
        updatedNote();

    }

    private void initializationComponents() {
        bottomSheetActivity = new DeleteBottomSheetActivity(UpdateNotesActivity.this, this);
        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        note = (Notes) getIntent().getSerializableExtra(NOTE_INTENT_KEY);
        title = note.getNotesTitle();
        subTitle = note.getNotesSubTitle();
        notes = note.getNotes();
        priorityLevel = note.getNotesPriority();
        changePriorityCommand = new HighUpdatePriorityCommand();
    }

    private void initializationViewComponents() {
        updateBinding = DataBindingUtil.setContentView(this, R.layout.activity_update_notes);
        changePriorityCommand.getPriorityViewWithData(note.getNotesPriority(), updateBinding);
    }

    private void setInitialDataView() {
        if (note != null) {
            updateBinding.setTitle(note.notesTitle);
            updateBinding.setSubTitle(note.notesSubTitle);
            updateBinding.setNotes(note.notes);
        }
    }

    private void updatedNote() {
        updateBinding.updateNotesButton.setOnClickListener(v -> {
            notesViewModel.updateNote(getUpdatedNote());
            finish();
        });
    }

    private Notes getUpdatedNote() {
        Notes updatedNote = this.note;
        updatedNote.setNotesTitle(title);
        updatedNote.setNotesSubTitle(subTitle);
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
        getUpdatedSubTitle();
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

    private void getUpdatedSubTitle() {
        updateBinding.inputSubTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty()) {
                    subTitle = editable.toString();
                } else {
                    subTitle = note.getNotesSubTitle();
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