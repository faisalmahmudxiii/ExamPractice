package preparation.mobapp207.com.exam.Adapter;

import android.content.ContentValues;
import android.content.Context;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import preparation.mobapp207.com.exam.DBQueryManeger;
import preparation.mobapp207.com.exam.Model.QuestionModel;
import preparation.mobapp207.com.exam.UtilityManager;

public class QuestionDBHelper extends SQLiteOpenHelper {

    private static QuestionDBHelper instance;






    public QuestionDBHelper(Context context) {
        super(context, UtilityManager.DATABASE_NAME, null, UtilityManager.DATABASE_VERSION);
    }

    static public synchronized QuestionDBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new QuestionDBHelper(context);
        }
        return instance;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL(DBQueryManeger.CREATE_TABLE_FOR_BANGLA);
      //  db.execSQL(DBQueryManeger.CREATE_TABLE_FOR_ENGLISH);
     //   db.execSQL(DBQueryManeger.CREATE_TABLE_FOR_MATH);
     //   db.execSQL(DBQueryManeger.CREATE_TABLE_FOR_GENERAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     //   db.execSQL(DBQueryManeger.DELETE_TABLE_FOR_BANGLA);
     //   db.execSQL(DBQueryManeger.DELETE_TABLE_FOR_ENGLISH);
      //  db.execSQL(DBQueryManeger.DELETE_TABLE_FOR_MATH);
      //  db.execSQL(DBQueryManeger.DELETE_TABLE_FOR_GENERAL);
      //  onCreate(db);
    }

    /***********************************CRUD******************************************************************/
    //Insert Data
    public void InsertQuestion(QuestionModel questionModel,String tableName){

        SQLiteDatabase db=instance.getWritableDatabase(UtilityManager.DB_PASS);

        ContentValues values = new ContentValues();
        values.put(UtilityManager.COLUMN_QUESTION_TYPE,questionModel.getQuestionType());
        values.put(UtilityManager.COLUMN_QUESTION,questionModel.getQuestion());
        values.put(UtilityManager.COLUMN_OPTION1,questionModel.getOption1());
        values.put(UtilityManager.COLUMN_OPTION2,questionModel.getOption2());
        values.put(UtilityManager.COLUMN_OPTION3,questionModel.getOption3());
        values.put(UtilityManager.COLUMN_OPTION4,questionModel.getOption4());
        values.put(UtilityManager.COLUMN_RIGHT_OPTION,questionModel.getRightOption());

        db.insert(tableName,null,values);
        db.close();

    }

    //Update Data
    public void UpdateQuestion(QuestionModel questionModel,int id,String tableName){

        SQLiteDatabase db=instance.getWritableDatabase(UtilityManager.DB_PASS);

        ContentValues values = new ContentValues();
        values.put(UtilityManager.COLUMN_QUESTION_TYPE,questionModel.getQuestionType());
        values.put(UtilityManager.COLUMN_QUESTION,questionModel.getQuestion());
        values.put(UtilityManager.COLUMN_OPTION1,questionModel.getOption1());
        values.put(UtilityManager.COLUMN_OPTION2,questionModel.getOption2());
        values.put(UtilityManager.COLUMN_OPTION3,questionModel.getOption3());
        values.put(UtilityManager.COLUMN_OPTION4,questionModel.getOption4());
        values.put(UtilityManager.COLUMN_RIGHT_OPTION,questionModel.getRightOption());

        db.update(tableName,values,UtilityManager.COLUMN_ID+"='"+id+"'",null);
        db.close();

    }

    //Delete Data
    public void DeleteQuestion(int id,String tableName){

        SQLiteDatabase db=instance.getWritableDatabase(UtilityManager.DB_PASS);

        db.delete(tableName,UtilityManager.COLUMN_ID+"='"+id+"'",null);
        db.close();

    }

    //Read Data
    public List<QuestionModel> GetAllQuestion(int offsetIndex,int totalPageSize,String tableName){
        SQLiteDatabase db=instance.getWritableDatabase(UtilityManager.DB_PASS);

        Cursor cursor = db.rawQuery("SELECT * FROM " + tableName + " limit "+totalPageSize+" offset "+offsetIndex+";", null);
        List<QuestionModel> questionModels=new ArrayList<>();

        if(cursor.moveToFirst()){

            while (!cursor.isAfterLast()){

              //  int id=cursor.getInt(cursor.getColumnIndex(UtilityManager.COLUMN_ID));
               // String questionType=cursor.getString(cursor.getColumnIndex(UtilityManager.COLUMN_QUESTION_TYPE));
                String question=cursor.getString(cursor.getColumnIndex(UtilityManager.COLUMN_QUESTION));
                String option1=cursor.getString(cursor.getColumnIndex(UtilityManager.COLUMN_OPTION1));
                String option2=cursor.getString(cursor.getColumnIndex(UtilityManager.COLUMN_OPTION2));
                String option3=cursor.getString(cursor.getColumnIndex(UtilityManager.COLUMN_OPTION3));
                String option4=cursor.getString(cursor.getColumnIndex(UtilityManager.COLUMN_OPTION4));
                String rightAnswer=cursor.getString(cursor.getColumnIndex(UtilityManager.COLUMN_RIGHT_OPTION));

                QuestionModel questionModel=new QuestionModel();
              //  questionModel.setId(id);
              //  questionModel.setQuestionType(questionType);
                questionModel.setQuestion(question);
                questionModel.setOption1(option1);
                questionModel.setOption2(option2);
                questionModel.setOption3(option3);
                questionModel.setOption4(option4);
                questionModel.setRightOption(rightAnswer);

                questionModels.add(questionModel);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return questionModels;
    }


}
