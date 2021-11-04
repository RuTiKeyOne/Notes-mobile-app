package com.simplenote.ershov.Activity;

import android.view.LayoutInflater;

import androidx.databinding.DataBindingUtil;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.simplenote.ershov.R;
import com.simplenote.ershov.databinding.DetailsNoteSheetBinding;
import com.simplenote.ershov.Interfaces.EditNoteListener;
import com.simplenote.ershov.Model.Notes;
import com.simplenote.ershov.Utilities.TempDataActivity;

public class DetailsBottomSheetActivity{

    private Notes note;
    private EditNoteListener listener;
    private BottomSheetDialog bottomDialog;
    private DetailsNoteSheetBinding detailsBinding;

    public Notes getNote() {
        return note;
    }

    public EditNoteListener getListener() {
        return listener;
    }

    public BottomSheetDialog getBottomDialog() {
        return bottomDialog;
    }

    public DetailsNoteSheetBinding getDetailsBinding() {
        return detailsBinding;
    }

    public DetailsBottomSheetActivity(TempDataActivity activity) {
        initializationComponents(activity);
        onClickedEdit();
        onCancelDialog();
    }

    public void initializationComponents(TempDataActivity activity){
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

    private void onCancelDialog(){
        bottomDialog.setOnCancelListener(dialogInterface -> onDismissDetailsButtonSheet());
    }

    public void onStartBottomSheetActivity(Notes note){
        onShowDetailsBottomSheet();
        onSetInitialDataInView(note);
    }

    private void onShowDetailsBottomSheet(){
        bottomDialog.show();
    }

    public void onSetInitialDataInView(Notes note){
        this.note = note;
        detailsBinding.setTitle(this.note.getNotesTitle());
        detailsBinding.setDate(this.note.getNotesDate());
        detailsBinding.setNote(this.note.getNotes());
    }

    public void onDismissDetailsButtonSheet(){
        bottomDialog.dismiss();
    }

}
