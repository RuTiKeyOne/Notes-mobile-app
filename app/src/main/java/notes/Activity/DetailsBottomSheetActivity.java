package notes.Activity;

import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.notes.R;
import com.notes.databinding.DetailsNoteSheetBinding;

import notes.Intefaces.EditNoteListener;
import notes.Intefaces.OpenDetailBottomSheetListener;
import notes.Model.Notes;

public class DetailsBottomSheetActivity<T extends AppCompatActivity & OpenDetailBottomSheetListener & EditNoteListener>{

    private Notes note;
    private EditNoteListener listener;
    private BottomSheetDialog bottomDialog;
    private DetailsNoteSheetBinding detailsBinding;


    public DetailsBottomSheetActivity(T activity) {
        initializationComponents(activity);
        onClickedEdit();
    }

    private void initializationComponents(T activity){
        bottomDialog = new BottomSheetDialog(activity);
        detailsBinding = DataBindingUtil.inflate(
                LayoutInflater.from(activity),
                R.layout.details_note_sheet,
                activity.findViewById(R.id.detailsBottomSheet),
                false);
        bottomDialog.setContentView(detailsBinding.getRoot());
        this.listener = activity;

    }

    private void onClickedEdit(){
        detailsBinding.editNoteButton.setOnClickListener(v -> {
            if(note != null){
                listener.onNoteEdit(note);
                onDismissDetailsButtonSheet();
            }
        });
    }

    public void onStartBottomSheetActivity(Notes note){
        onShowDetailsBottomSheet();
        onSetInitialDataInView(note);
    }

    private void onShowDetailsBottomSheet(){
        bottomDialog.show();
    }

    private void onSetInitialDataInView(Notes note){
        this.note = note;
        detailsBinding.setTitle(this.note.getNotesTitle());
        detailsBinding.setSubTitle(this.note.getNotesSubTitle());
        detailsBinding.setDate(this.note.getNotesDate());
        detailsBinding.setNote(this.note.getNotes());
    }

    public void onDismissDetailsButtonSheet(){
        bottomDialog.dismiss();
    }

}
