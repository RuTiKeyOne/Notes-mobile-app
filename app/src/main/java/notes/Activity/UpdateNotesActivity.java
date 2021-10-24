package notes.Activity;

import static notes.Utilities.TempDataViewModel.NOTE_INTENT_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.notes.R;
import com.notes.databinding.ActivityUpdateNotesBinding;

import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Base.BaseUpdateCommand;
import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent.HighUpdatePriorityCommand;
import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent.LowUpdatePriorityCommand;
import notes.Command.PriorityCommand.Child.UpdatePriorityCommand.Parent.MediumUpdatePriorityCommand;
import notes.Command.PriorityCommand.Parent.BasePriorityCommand;
import notes.Model.Notes;
import notes.ViewModel.NotesViewModel;

public class UpdateNotesActivity extends AppCompatActivity {

    private ActivityUpdateNotesBinding updateBinding;
    private NotesViewModel notesViewModel;
    private BaseUpdateCommand changePriorityCommand;
    private Notes note;
    private String title;
    private String subTitle;
    private String notes;
    private String priorityLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationComponents();
        initializationViewComponents();
        setInitialDataView();
        getUpdatedDataWithInput();
        addChangePriorityLevel();
        updatedNote();

    }

    private void initializationComponents() {
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

    private void updatedNote(){
        updateBinding.updateNotesButton.setOnClickListener(v -> {
            notesViewModel.updateNote(getUpdatedNote());
            onBackPressed();
        });
    }

    private Notes getUpdatedNote(){
        Notes updatedNote = this.note;
        updatedNote.setNotesTitle(title);
        updatedNote.setNotesSubTitle(subTitle);
        updatedNote.setNotes(notes);
        updatedNote.setNotesPriority(priorityLevel);
        return updatedNote;
    }

    private void addChangePriorityLevel() {

        updateBinding.redPriority.setOnClickListener(v -> {
            changePriorityCommand = new HighUpdatePriorityCommand();
            changePriorityCommand.changePriorityView(updateBinding);
            priorityLevel =  changePriorityCommand.getPriorityLevel();
        });

        updateBinding.yellowPriority.setOnClickListener(v -> {
            changePriorityCommand = new MediumUpdatePriorityCommand();
            changePriorityCommand.changePriorityView(updateBinding);
            priorityLevel =  changePriorityCommand.getPriorityLevel();
        });

        updateBinding.greenPriority.setOnClickListener(v -> {
            changePriorityCommand = new LowUpdatePriorityCommand();
            changePriorityCommand.changePriorityView(updateBinding);
            priorityLevel =  changePriorityCommand.getPriorityLevel();
        });

    }

    private void getUpdatedDataWithInput(){
        getUpdatedTitle();
        getUpdatedSubTitle();
        getUpdatedNotes();
    }

    private void getUpdatedTitle(){
        updateBinding.inputTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().isEmpty()){
                    title = editable.toString();
                }else{
                    title = note.getNotesTitle();
                }
            }
        });
    }

    private void getUpdatedSubTitle(){
        updateBinding.inputSubTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().isEmpty()){
                    subTitle = editable.toString();
                }else{
                    subTitle = note.getNotesSubTitle();
                }
            }
        });
    }

    private void getUpdatedNotes(){
        updateBinding.inputData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().isEmpty()){
                    notes = editable.toString();
                }else{
                    notes = note.getNotes();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}