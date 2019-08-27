package preparation.mobapp207.com.exam;

public class UtilityManager {

    /**************************************************************** Testing Tools *********************************/
    public static  boolean isTableDrop=false;
    public static  String XlsFileName="ExamData.xls";


    /**************************************************************** Activity Value *********************************/
    public static int SPLASH_DELAYTIME=5000;

    /**************************************************************** DATA FOR APP *********************************/
    public  static  String QUESTION_TYPE_BANGLA="BANGLA";
    public  static  String QUESTION_TYPE_ENGLISH="ENGLISH";
    public  static  String QUESTION_TYPE_MATH="MATH";
    public  static  String QUESTION_TYPE_GENERAL="GENERAL";


    /**************************************************************** For Database Table*******************************************************************************/

    public static final String DB_PASS = "1234";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "exam.db";
    //Table
    public static final String BANGLA_TABLE_NAME = "bangla_question";
    public static final String ENGLISH_TABLE_NAME = "english_question";
    public static final String MATH_TABLE_NAME = "math_question";
    public static final String GENERAL_TABLE_NAME = "general_question";
    public static final String GENERAL = "Sheet1";
    public static final String TEXT_TYPE = " TEXT";

    //Column
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_QUESTION_TYPE = "questionType";
    public static final String COLUMN_QUESTION = "question";
    public static final String COLUMN_OPTION1 = "option1";
    public static final String COLUMN_OPTION2 = "option2";
    public static final String COLUMN_OPTION3 = "option3";
    public static final String COLUMN_OPTION4 = "option4";
    public static final String COLUMN_RIGHT_OPTION = "right_answer";



}
