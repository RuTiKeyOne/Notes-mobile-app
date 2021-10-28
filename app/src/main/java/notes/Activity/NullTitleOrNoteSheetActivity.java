package notes.Activity;


import android.view.LayoutInflater;

import androidx.databinding.DataBindingUtil;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.notes.R;
import com.notes.databinding.NullInputInsertBottomBinding;
import notes.Intefaces.NullTitleOrNoteListener;

public class NullTitleOrNoteSheetActivity {

    private BottomSheetDialog bottomDialog;
    private NullInputInsertBottomBinding nullInputBinding;

    public NullTitleOrNoteSheetActivity(InsertNotesActivity insertActivity) {
        initializationComponents(insertActivity);
        onClickOk();
    }

    private void initializationComponents(InsertNotesActivity insertActivity) {
        bottomDialog = new BottomSheetDialog(insertActivity);
        nullInputBinding = DataBindingUtil.inflate(
                LayoutInflater.from(insertActivity),
                R.layout.null_input_insert_bottom,
                insertActivity.findViewById(R.id.nullInputBottomSheet),
                false);
        bottomDialog.setContentView(nullInputBinding.getRoot());
    }

    private void onClickOk(){
        nullInputBinding.ok.setOnClickListener(v -> {
            onDismissNullTitleOrNoteSheet();
        });
    }

    public void onShowNullTitleOrNoteSheet(){
        bottomDialog.show();
    }

    public void onDismissNullTitleOrNoteSheet(){
        bottomDialog.dismiss();
    }



}
