package notes.Activity;

import static notes.Utilities.TemDataActivity.NOTES_DATA_KEY;
import static notes.Utilities.TempDataViewModel.NOTE_INTENT_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.notes.R;
import com.notes.databinding.ActivitySearchBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import notes.Adapter.Child.NotesAdapter;
import notes.Intefaces.EditNoteListener;
import notes.Intefaces.OpenDetailBottomSheetListener;
import notes.Model.Notes;
import notes.ViewModel.NotesViewModel;

public class SearchActivity extends AppCompatActivity implements EditNoteListener, OpenDetailBottomSheetListener {

    private ActivitySearchBinding searchBinding;
    private NotesViewModel notesViewModel;
    private DetailsBottomSheetActivity<SearchActivity> detailsActivity;
    private NotesAdapter notesAdapter;
    private List<Notes> notesData = new ArrayList<>();
    private String searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationComponents();
        initializationComponentsView();
        onSearchWithInputData();
        onBackClick();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        clearAndGetAllNotes();
    }

    @Override
    protected void onStop() {
        super.onStop();
        notesData.clear();
    }


    //TODO доделаю это после переработки адаптера

    private void initializationComponents() {
        notesData = (List<Notes>) getIntent().getSerializableExtra(NOTES_DATA_KEY);
        detailsActivity = new DetailsBottomSheetActivity<>(this);
        notesAdapter = new NotesAdapter(notesData, this);
        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);

    }

    private void initializationComponentsView() {
        searchBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        searchBinding.notesRecycleView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        searchBinding.notesRecycleView.setAdapter(notesAdapter);
    }


    private void onSearchWithInputData() {
        searchBinding.inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty()) {
                    searchText = editable.toString();
                    getSearchedNotes();
                } else {
                    getAllNotes();
                }
            }
        });
    }

    private void clearAndGetAllNotes() {
        notesData.clear();
        getAllNotes();
    }

    private void getSearchedNotes() {
        List<Notes> oldNotes = new ArrayList<>();
        oldNotes.addAll(notesData);
        notesData.clear();
        for (Notes note : oldNotes) {
            if (note.getNotesTitle().toLowerCase(Locale.ROOT).contains(searchText.toLowerCase(Locale.ROOT))
                    || note.getNotesSubTitle().toLowerCase(Locale.ROOT).contains(searchText.toLowerCase(Locale.ROOT))) {
                notesData.add(note);
            }
        }
        notesAdapter.notifyDataSetChanged();

    }

    private void onBackClick() {
        searchBinding.imageBack.setOnClickListener(v -> {
            onBackPressed();
        });
    }

    //TODO повторение кода из MainActivity

    private void getAllNotes() {
        notesData.clear();
        notesViewModel.getAllNotes().observe(this, notes -> {
            notesData.addAll(notes);
            notesAdapter.notifyDataSetChanged();
        });
    }

    //TODO вот это необходимо переделать

    @Override
    public void onNoteEdit(Notes note) {
        Intent updateIntent = new Intent(getApplicationContext(), UpdateNotesActivity.class);
        updateIntent.putExtra(NOTE_INTENT_KEY, note);
        startActivity(updateIntent);
    }

    @Override
    public void onOpenSheet(Notes note) {
        if (detailsActivity != null) {
            detailsActivity.onStartBottomSheetActivity(note);
        }
    }
}