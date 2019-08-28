package preparation.mobapp207.com.exam.Service;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import preparation.mobapp207.com.exam.Model.UserExamState;

@Dao
public interface UserExamStateDao {
    @Query("SELECT * FROM UserExamState")
    List<UserExamState> getAll();

    @Query("SELECT * FROM UserExamState WHERE uid IN (:userIds)")
    List<UserExamState> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM UserExamState O LIMIT 1")
    UserExamState findByName(String first, String last);

    @Insert
    void insertAll(UserExamState... userExamStates);

    @Delete
    void delete(UserExamState userExamState);
}
