package notes.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

    @ColumnInfo(name = "notes_subtitle")
    @SerializedName("notes_sub_title")
    public String notesSubTitle;

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

    public void setNotesSubTitle(String notesSubTitle) {
        this.notesSubTitle = notesSubTitle;
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

    public String getNotesSubTitle() {
        return notesSubTitle;
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
