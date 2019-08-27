package preparation.mobapp207.com.exam.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import net.sqlcipher.database.SQLiteDatabase;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import preparation.mobapp207.com.exam.UtilityManager;


public class ExcelToSQLite {

    private  static  String TAG="ExcelToSQLite";
    private static Handler handler = new Handler(Looper.getMainLooper());

    private Context mContext;
    private SQLiteDatabase database;
    private boolean dropTable = false;

    public ExcelToSQLite(Context context) {
        mContext = context;
        try {
            database = QuestionDBHelper.getInstance(context).getWritableDatabase(UtilityManager.DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ExcelToSQLite(Context context, boolean dropTable) {
        mContext = context;
        this.dropTable=dropTable;
        try {
            database = QuestionDBHelper.getInstance(context).getWritableDatabase(UtilityManager.DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void importFromAsset(final String assetFileName, final ImportListener listener) {
        if (listener != null) {
            listener.onStart();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    working(mContext.getAssets().open(assetFileName));
                    if (listener != null) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onCompleted(true);
                            }
                        });
                    }
                } catch (final Exception e) {
                    Log.d(TAG,"Error"+e);
                    if (database != null && database.isOpen()) {
                        database.close();
                    }
                    if (listener != null) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onError(e);
                            }
                        });
                    }
                }
            }
        }).start();
    }

    public void importFromFile(String filePath, ImportListener listener) {
        importFromFile(new File(filePath), listener);
    }

    private void importFromFile(final File file, final ImportListener listener) {
        if (listener != null) {
            listener.onStart();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    working(new FileInputStream(file));
                    if (listener != null) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onCompleted(true);
                            }
                        });
                    }
                } catch (final Exception e) {
                    Log.d(TAG,"Error"+e);
                    if (database != null && database.isOpen()) {
                        database.close();
                    }
                    if (listener != null) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onError(e);
                            }
                        });
                    }
                }
            }
        }).start();

    }

    private void working(InputStream stream) throws Exception {
      //  Workbook workbook= WorkbookFactory.create(stream);
        //XSSFWorkbook workbook = new XSSFWorkbook(stream);
        HSSFWorkbook workbook = new HSSFWorkbook(stream);
        int sheetNumber = workbook.getNumberOfSheets();
        for (int i = 0; i < sheetNumber; i++) {
            createTable(workbook.getSheetAt(i));
        }
        database.close();
    }

    private void createTable(Sheet sheet) {
        Cursor cursor = null;
        try {
            StringBuilder createTableSql = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
            createTableSql.append(sheet.getSheetName());
            createTableSql.append("(");
            Iterator<Row> rit = sheet.rowIterator();
            Row rowHeader = rit.next();
            List<String> columns = new ArrayList<>();
            for (int i = 0; i < rowHeader.getPhysicalNumberOfCells(); i++) {
                createTableSql.append(rowHeader.getCell(i).getStringCellValue());
                if (i == rowHeader.getPhysicalNumberOfCells() - 1) {
                    createTableSql.append(" TEXT");
                } else {
                    createTableSql.append(" TEXT,");
                }
                columns.add(rowHeader.getCell(i).getStringCellValue());
            }
            createTableSql.append(")");

            if (dropTable)
                database.execSQL("DROP TABLE IF EXISTS " + sheet.getSheetName());

            database.execSQL(createTableSql.toString());

            for (String column : columns) {
                SQLiteDatabase database=QuestionDBHelper.getInstance(mContext).getWritableDatabase(UtilityManager.DB_PASS);
                cursor = database.rawQuery("SELECT * FROM " + sheet.getSheetName(), null);
                // grab cursor for all data
                int deleteStateColumnIndex = cursor.getColumnIndex(column);  // see if the column is there
                if (deleteStateColumnIndex < 0) {
                    String type = "TEXT";
                    // missing_column not there - add it
                    database=QuestionDBHelper.getInstance(mContext).getWritableDatabase(UtilityManager.DB_PASS);
                    database.execSQL("ALTER TABLE " + sheet.getSheetName()
                            + " ADD COLUMN " + column + " " + type + " NULL;");
                }
            }

            while (rit.hasNext()) {
                Row row = rit.next();
                ContentValues values = new ContentValues();
                for (int n = 0; n < row.getPhysicalNumberOfCells(); n++) {
                    if (row.getCell(n).getCellTypeEnum() == CellType.NUMERIC) {
                        values.put(columns.get(n), row.getCell(n).getNumericCellValue());
                    } else {
                        values.put(columns.get(n), row.getCell(n).getStringCellValue());
                    }
                }
                long result = database.insertWithOnConflict(sheet.getSheetName(),
                        null, values, SQLiteDatabase.CONFLICT_IGNORE);
                if (result < 0) {
                    throw new RuntimeException("Insert value failed!");
                }
            }
            if (cursor != null)
                cursor.close();
        }catch (Exception e){

            if (cursor != null)
                cursor.close();
        }finally {
            if (cursor != null)
                cursor.close();
        }

    }

    public interface ImportListener {
       public void onStart();

        public void onCompleted(boolean isCompleted);

        public void onError(Exception e);
    }

}
