package notes.Activity;

import android.view.LayoutInflater;
import androidx.databinding.DataBindingUtil;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.notes.R;
import com.notes.databinding.DetailsNoteSheetBinding;

import notes.Intefaces.EditNoteListener;
import notes.Model.Notes;

public class DetailsBottomSheetActivity {

    private Notes note;
    private EditNoteListener listener;
    private BottomSheetDialog bottomDialog;
    private DetailsNoteSheetBinding detailsBinding;


    public DetailsBottomSheetActivity(MainActivity mainActivity) {
        initializationComponents(mainActivity);
        onClickedEdit();
    }

    private void initializationComponents(MainActivity  mainActivity){
        bottomDialog = new BottomSheetDialog(mainActivity);
        detailsBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mainActivity),
                R.layout.details_note_sheet,
                mainActivity.findViewById(R.id.detailsBottomSheet),
                false);
        bottomDialog.setContentView(detailsBinding.getRoot());
        this.listener = mainActivity;

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
