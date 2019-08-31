package preparation.mobapp207.com.exam.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import net.sqlcipher.database.SQLiteDatabase;

import java.util.List;

import preparation.mobapp207.com.exam.Adapter.ExcelToDBHelper;
import preparation.mobapp207.com.exam.Model.QuestionModel;
import preparation.mobapp207.com.exam.R;
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

        //Test
        new ExcelToDBHelper(this).ImportExcelData();
        List<QuestionModel> questionModels = new QuestionServiceImpl().GetQuestion(this);



        for(QuestionModel item : questionModels){
            Log.d(TAG,item.getQuestion());
        }

    }

    void DelayForSecond(int delayTime){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent goToNextActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goToNextActivity);
            }
        }, delayTime);   //5 seconds

    }
}
