package notes.Activity;

import android.view.LayoutInflater;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.notes.R;
import com.notes.databinding.DeleteBottomSheetBinding;

import notes.Intefaces.DeleteNoteListener;

public class DeleteBottomSheetActivity{

    private DeleteNoteListener deleteListener;
    private BottomSheetDialog bottomDialog;
    private DeleteBottomSheetBinding deleteBinding;

    public DeleteNoteListener getDeleteListener() {
        return deleteListener;
    }

    public BottomSheetDialog getBottomDialog() {
        return bottomDialog;
    }

    public DeleteBottomSheetBinding getDeleteBinding() {
        return deleteBinding;
    }

    public DeleteBottomSheetActivity(UpdateNotesActivity updateActivity, DeleteNoteListener deleteListener) {
        initializationComponents(updateActivity, deleteListener);
        addOnYesClicked();
        addOnNoClicked();
    }

    public void initializationComponents(UpdateNotesActivity updateActivity, DeleteNoteListener listener){
        deleteListener = listener;
        bottomDialog = new BottomSheetDialog(updateActivity);
        deleteBinding = DataBindingUtil.inflate(
                        LayoutInflater.from(updateActivity),
                        R.layout.delete_bottom_sheet,
                        updateActivity.findViewById(R.id.deleteBottomSheet),
                        false);
        bottomDialog.setContentView(deleteBinding.getRoot());

    }

    private void addOnYesClicked(){
        deleteBinding.deleteYes.setOnClickListener(v -> {
            deleteListener.onDeleteNote();
            onDismissDeleteButtonSheet();
        });
    }

    private void addOnNoClicked(){
        deleteBinding.deleteNo.setOnClickListener(v -> {
            onDismissDeleteButtonSheet();
        });
    }

    public void onShowDeleteBottomSheet(){
        bottomDialog.show();
    }

    public void onDismissDeleteButtonSheet(){
        bottomDialog.dismiss();
    }



}
