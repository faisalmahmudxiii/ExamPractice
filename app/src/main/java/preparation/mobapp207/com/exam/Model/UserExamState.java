package preparation.mobapp207.com.exam.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserExamState {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "total_exam")
    public int totalExam;

    @ColumnInfo(name = "total_time")
    public int totalTime;


}
