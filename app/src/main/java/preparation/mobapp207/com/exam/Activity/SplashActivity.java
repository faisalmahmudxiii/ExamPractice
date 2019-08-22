package preparation.mobapp207.com.exam.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.sqlcipher.database.SQLiteDatabase;

import java.util.List;

import preparation.mobapp207.com.exam.Adapter.ExcelToSQLite;
import preparation.mobapp207.com.exam.Adapter.QuestionDBHelper;
import preparation.mobapp207.com.exam.Model.QuestionModel;
import preparation.mobapp207.com.exam.R;
import preparation.mobapp207.com.exam.UtilityManager;

public class SplashActivity extends AppCompatActivity {

    public static String TAG="SplashActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SQLiteDatabase.loadLibs(this);

        QuestionModel questionModel=new QuestionModel();
        questionModel.setQuestionType(UtilityManager.QUESTION_TYPE_BANGLA);
        questionModel.setQuestion("আমার সোনার বাংলা");
        questionModel.setOption1("Shitul");
        questionModel.setOption2("ALU");
        questionModel.setOption3("Bapy");
        questionModel.setOption4("2sr");
        questionModel.setRightOption("Shitul");

    //   ExcelToSQLite ex=new ExcelToSQLite(this,"abc");

      //  ex.importFromAsset("বাংলা সাহিত্যের ইতিহাস.xls", null);

       // QuestionDBHelper.getInstance(this).InsertQuestion(questionModel,UtilityManager.BANGLA_TABLE_NAME);
        List<QuestionModel> questionModels =QuestionDBHelper.getInstance(this).GetAllQuestion(0,10,UtilityManager.GENERAL);

        for(QuestionModel item : questionModels){
            Log.d(TAG,item.getQuestion());
        }
//

    }
}
