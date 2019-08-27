package preparation.mobapp207.com.exam.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import net.sqlcipher.database.SQLiteDatabase;

import java.util.List;

import preparation.mobapp207.com.exam.Adapter.ExcelToDBHelper;
import preparation.mobapp207.com.exam.Adapter.ExcelToSQLite;
import preparation.mobapp207.com.exam.Adapter.QuestionDBHelper;
import preparation.mobapp207.com.exam.Model.QuestionModel;
import preparation.mobapp207.com.exam.R;
import preparation.mobapp207.com.exam.Service.QuestionService;
import preparation.mobapp207.com.exam.Service.QuestionServiceImpl;
import preparation.mobapp207.com.exam.UtilityManager;

public class SplashActivity extends AppCompatActivity {

    public static String TAG="SplashActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SQLiteDatabase.loadLibs(this);

        DelayForSecond(UtilityManager.SPLASH_DELAYTIME);

        
       // new ExcelToDBHelper(this).ImportExcelData();
        List<QuestionModel> questionModels = new QuestionServiceImpl().GetQuestion(this);



        for(QuestionModel item : questionModels){
            Log.d(TAG,item.getQuestion());
        }

    }

    void DelayForSecond(int delayTime){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // yourMethod();
            }
        }, delayTime);   //5 seconds

    }
}
