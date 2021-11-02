package notes.Activity;


import android.view.LayoutInflater;

import androidx.databinding.DataBindingUtil;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.notes.R;
import com.notes.databinding.NullInputInsertBottomBinding;
import notes.Intefaces.NullTitleOrNoteListener;

public class NullTitleSheetActivity {

    private BottomSheetDialog bottomDialog;
    private NullInputInsertBottomBinding nullInputBinding;

    public BottomSheetDialog getBottomDialog() {
        return bottomDialog;
    }

    public NullInputInsertBottomBinding getNullInputBinding() {
        return nullInputBinding;
    }

    public NullTitleSheetActivity(InsertNotesActivity insertActivity) {
        initializationComponents(insertActivity);
        onClickOk();
    }

    public void initializationComponents(InsertNotesActivity insertActivity) {
        bottomDialog = new BottomSheetDialog(insertActivity);
        nullInputBinding = DataBindingUtil.inflate(
                LayoutInflater.from(insertActivity),
                R.layout.null_input_insert_bottom,
                insertActivity.findViewById(R.id.nullInputBottomSheet),
                false);
        bottomDialog.setContentView(nullInputBinding.getRoot());
    }

    public void onClickOk(){
        nullInputBinding.ok.setOnClickListener(v -> {
            onDismissNullTitleSheet();
        });
    }

    public void onShowNullTitleSheet(){
        bottomDialog.show();
    }

    public void onDismissNullTitleSheet(){
        bottomDialog.dismiss();
    }



}
