package notes.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
    public String notesPriority;

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

    public void setNotesPriority(String notesPriority) {
        this.notesPriority = notesPriority;
    }
}
