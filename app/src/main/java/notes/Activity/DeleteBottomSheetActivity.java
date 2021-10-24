package notes.Activity;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.notes.R;
import com.notes.databinding.DeleteBottomSheetBinding;

import notes.Intefaces.DeleteNoteListener;

public class DeleteBottomSheetActivity{

    private DeleteNoteListener deleteListener;
    private BottomSheetDialog bottomDialog;
    private DeleteBottomSheetBinding deleteBinding;

    public DeleteBottomSheetActivity(UpdateNotesActivity updateActivity, DeleteNoteListener deleteListener) {
        initializationComponents(updateActivity, deleteListener);
        addOnYesClicked();
        addOnNoClicked();
    }

    private void initializationComponents(UpdateNotesActivity updateActivity, DeleteNoteListener listener){
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
        });
    }

    private void addOnNoClicked(){
        deleteBinding.deleteNo.setOnClickListener(v -> {
            onDismissDeleteButtonSheet();
        });
    }

    public boolean onCreateMenu(AppCompatActivity activity, Menu menu){
        activity.getMenuInflater().inflate(R.menu.delete_menu, menu);
        return true;
    }

    public void onShowDeleteBottomSheet(){
        bottomDialog.show();
    }

    public void onDismissDeleteButtonSheet(){
        bottomDialog.dismiss();
    }



}
