package preparation.mobapp207.com.exam.Service;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import preparation.mobapp207.com.exam.Model.UserExamState;

@Dao
public interface UserExamStateDao {



    @Insert
    void insertAll(UserExamState... userExamStates);

    @Delete
    void delete(UserExamState userExamState);
}
