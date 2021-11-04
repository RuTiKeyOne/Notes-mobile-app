package com.simplenote.ershov.Model;

import androidx.room.*;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Entity(tableName = "notes_database")
public class Notes implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    public int id;

    @ColumnInfo(name = "notes_title")
    @SerializedName("notes_title")
    public String notesTitle;

    @ColumnInfo(name = "notes_date")
    @SerializedName("notes_date")
    public String notesDate;

    @ColumnInfo(name = "notes")
    @SerializedName("notes")
    public String notes;

    @ColumnInfo(name = "notes_priority")
    @SerializedName("notes_priority")
    public int notesPriority;

    public void setId(int id) {
        this.id = id;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setNotesTitle(String notesTitle) {
        this.notesTitle = notesTitle;
    }

    public void setNotesDate(String notesDate) {
        this.notesDate = notesDate;
    }

    public void setNotesPriority(int notesPriority) {
        this.notesPriority = notesPriority;
    }

    public int getId() {
        return id;
    }

    public String getNotesTitle() {
        return notesTitle;
    }

    public String getNotesDate() {
        return notesDate;
    }

    public String getNotes() {
        return notes;
    }

    public int getNotesPriority() {
        return notesPriority;
    }
}