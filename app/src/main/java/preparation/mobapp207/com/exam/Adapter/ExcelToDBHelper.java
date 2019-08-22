package preparation.mobapp207.com.exam.Adapter;

import android.content.Context;
import android.util.Log;

import com.ajts.androidmads.library.ExcelToSQLite;

import preparation.mobapp207.com.exam.UtilityManager;

public class ExcelToDBHelper {

    private static  String TAG="ExcelToDBHelper";

    public ExcelToDBHelper(Context context) {

        ExcelToSQLite excelToSQLite = new ExcelToSQLite(context, UtilityManager.DATABASE_NAME, true);
        excelToSQLite.importFromAsset("বাংলা সাহিত্যের ইতিহাস ১.xls", new ExcelToSQLite.ImportListener() {
            @Override
            public void onStart() {
                Log.d(TAG,"One Create");
            }

            @Override
            public void onCompleted(String dbName) {
                Log.d(TAG,"One Completed");
            }

            @Override
            public void onError(Exception e) {
                Log.d(TAG,"One Error");
            }
        });
    }
}
