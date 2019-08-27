package preparation.mobapp207.com.exam.Adapter;

import android.content.Context;
import android.util.Log;

import preparation.mobapp207.com.exam.UtilityManager;

public class ExcelToDBHelper {

    private static  String TAG="ExcelToDBHelper";

    private Context context;

    public ExcelToDBHelper(Context context) {
        this.context=context;


    }

    public void SetXlsFilePath(String filePath){
        UtilityManager.XlsFileName=filePath;
    }
    public String GetXlsFilePath(){
        return UtilityManager.XlsFileName;
    }

    public void ImportExcelData(){
        ExcelToSQLite excelToSQLite = new ExcelToSQLite(context, true);
        excelToSQLite.importFromAsset(UtilityManager.XlsFileName, new ExcelToSQLite.ImportListener() {
            @Override
            public void onStart() {
                Log.d(TAG,"Loading Start");
            }

            @Override
            public void onCompleted(boolean isCompleted) {
                Log.d(TAG,"Loading Completed : "+isCompleted);
            }

            @Override
            public void onError(Exception e) {
                Log.d(TAG,"Loading Completed : "+e);
            }
        });
    }

}
