package notes.Activity;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import com.notes.R;
import com.notes.databinding.ActivitySearchBinding;
import java.util.*;
import notes.Adapter.Child.NotesAdapter;
import notes.Model.Notes;
import notes.Utilities.TempDataActivity;
import notes.ViewModel.NotesViewModel;

public class SearchActivity extends TempDataActivity {

    private ActivitySearchBinding searchBinding;
    private NotesViewModel notesViewModel;
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
        notesData.clear();
        getAllNotes(notesViewModel, notesData, notesAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        notesData.clear();
    }

    private void initializationComponents() {
        notesData = (List<Notes>) getIntent().getSerializableExtra(NOTES_DATA_KEY);
        notesAdapter = new NotesAdapter(notesData, this);
        this.detailsActivity = new DetailsBottomSheetActivity(this);
        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);

    }

    private void initializationComponentsView() {
        searchBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        searchBinding.searchNotesRecycleView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        searchBinding.searchNotesRecycleView.setAdapter(notesAdapter);
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
                    getAllNotes(notesViewModel, notesData, notesAdapter);
                }
            }
        });
    }


    private void getSearchedNotes() {
        List<Notes> oldNotes = new ArrayList<>();
        oldNotes.addAll(notesData);
        notesData.clear();
        for (Notes note : oldNotes) {
            if (note.getNotesTitle().toLowerCase(Locale.ROOT).contains(searchText.toLowerCase(Locale.ROOT))){
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


}