package notes.Database;

import static notes.Utilities.TempDatabase.DATABASE_NAME;

import android.content.Context;
import androidx.room.*;
import notes.Dao.NotesDao;
import notes.Model.Notes;

@Database(entities = {Notes.class}, version = 1)
public abstract class NotesDatabase extends RoomDatabase {
    public abstract NotesDao notesDao();

    public static NotesDatabase instance;

    public static NotesDatabase getDatabaseInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NotesDatabase.class,
                    DATABASE_NAME).allowMainThreadQueries().build();
        }

        return instance;
    }


}
