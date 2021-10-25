package notes.Activity;

import static notes.Utilities.TempDataViewModel.NOTE_INTENT_KEY;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import notes.Adapter.Child.NotesAdapter;
import notes.Command.MainCommand;
import notes.Intefaces.EditNoteListener;
import notes.Intefaces.OpenDetailBottomSheetListener;
import notes.Model.Notes;
import notes.ViewModel.NotesViewModel;

import com.notes.R;
import com.notes.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EditNoteListener, OpenDetailBottomSheetListener {

    private ActivityMainBinding mainBinding;
    private NotesViewModel notesViewModel;
    private NotesAdapter notesAdapter;
    private DetailsBottomSheetActivity detailsActivity;
    private MainCommand mainCommand;
    private List<Notes> notesData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationComponents();
        initializationViewComponents();
        getAllNotes();
        addNewNoteClickBehaviour();
        onClickNoFilter();
        onClickHighToLowFilter();
        onClickLowToHighFilter();
    }

    @Override
    protected void onStop() {
        super.onStop();
        notesData.clear();
    }

    private void initializationViewComponents() {
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.notesRecycleView.setAdapter(notesAdapter);
        mainBinding.notesRecycleView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mainCommand.setDefaultFilter(mainBinding);
    }

    private void initializationComponents() {
        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        notesAdapter = new NotesAdapter(notesData, this);
        detailsActivity = new DetailsBottomSheetActivity(this);
        mainCommand = new MainCommand();
    }

    private void onClickNoFilter(){
        mainBinding.noFilter.setOnClickListener(v -> {
            getAllNotes();
            mainCommand.onSetDefaultNoFilterView(mainBinding);
        });
    }

    private void getAllNotes() {
        notesViewModel.getAllNotes().observe(this, notes -> {
            notesData.clear();
            notesData.addAll(notes);
            notesAdapter.notifyDataSetChanged();
        });
    }

    private void onClickHighToLowFilter(){
        mainBinding.highToLow.setOnClickListener(v -> {
            getHighToLowNotes();
            mainCommand.onSetHighToLowFilterView(mainBinding);
        });
    }

    private void getHighToLowNotes(){
        notesViewModel.getHighToLowNotes().observe(this, notes -> {
            notesData.clear();
            notesData.addAll(notes);
            notesAdapter.notifyDataSetChanged();
        });
    }

    private void onClickLowToHighFilter(){
        mainBinding.lowToHigh.setOnClickListener(v -> {
            getLowToHighNotes();
            mainCommand.onSetLowToHighFilterView(mainBinding);
        });
    }

    private void getLowToHighNotes(){
        notesViewModel.getLowToHighNotes().observe(this, notes -> {
            notesData.clear();
            notesData.addAll(notes);
            notesAdapter.notifyDataSetChanged();
        });
    }

    private void addNewNoteClickBehaviour() {
        mainBinding.newNotesButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InsertNotesActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onNoteEdit(Notes note) {
        Intent updateIntent = new Intent(getApplicationContext(), UpdateNotesActivity.class);
        updateIntent.putExtra(NOTE_INTENT_KEY, note);
        startActivity(updateIntent);
    }

    @Override
    public void onOpenSheet(Notes note) {
        if(detailsActivity != null){
            detailsActivity.onStartBottomSheetActivity(note);
        }
    }

}