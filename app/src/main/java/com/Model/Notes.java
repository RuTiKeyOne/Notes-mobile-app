package com.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.Enum.PriorityLevel;

@Entity(tableName = "notes_database")
public class Notes {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "notes_title")
    public String notesTitle;

    @ColumnInfo(name = "notes_subtitle")
    public String notesSubTitle;

    @ColumnInfo(name = "notes_date")
    public String notesDate;

    @ColumnInfo(name = "notes")
    public String notes;

    @ColumnInfo(name = "notes_priority")
    public PriorityLevel notesPriority;

    public Notes() {
    }

    public Notes(String notesTitle, String notesSubTitle, String notes, String notesDate, PriorityLevel priorityLevel) {
        this.notesTitle = notesTitle;
        this.notesSubTitle = notesSubTitle;
        this.notes = notes;
        this.notesDate = notesDate;
        this.notesPriority = priorityLevel;
    }
}
