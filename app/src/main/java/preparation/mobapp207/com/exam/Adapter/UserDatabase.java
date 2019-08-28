package preparation.mobapp207.com.exam.Adapter;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import preparation.mobapp207.com.exam.Model.UserExamState;
import preparation.mobapp207.com.exam.Service.UserExamStateDao;

@Database(entities = {UserExamState.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static UserDatabase INSTANCE;
    public abstract UserExamStateDao userDao();



    public static UserDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}

