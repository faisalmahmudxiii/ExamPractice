package preparation.mobapp207.com.exam;

public class DBQueryManeger {

    public static  final String CREATE_TABLE_FOR_BANGLA = "CREATE TABLE " + UtilityManager.BANGLA_TABLE_NAME + " (" +
            UtilityManager.COLUMN_ID + " INTEGER PRIMARY KEY," +
            UtilityManager.COLUMN_QUESTION_TYPE + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_QUESTION + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION1 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION2 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION3 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION4 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_RIGHT_OPTION + UtilityManager.TEXT_TYPE +
            " )";
    public static  final String CREATE_TABLE_FOR_ENGLISH ="CREATE TABLE " + UtilityManager.ENGLISH_TABLE_NAME + " (" +
            UtilityManager.COLUMN_ID + " INTEGER PRIMARY KEY," +
            UtilityManager.COLUMN_QUESTION_TYPE + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_QUESTION + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION1 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION2 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION3 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION4 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_RIGHT_OPTION + UtilityManager.TEXT_TYPE +
            " )";
    public static  final String CREATE_TABLE_FOR_MATH ="CREATE TABLE " + UtilityManager.MATH_TABLE_NAME + " (" +
            UtilityManager.COLUMN_ID + " INTEGER PRIMARY KEY," +
            UtilityManager.COLUMN_QUESTION_TYPE + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_QUESTION + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION1 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION2 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION3 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION4 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_RIGHT_OPTION + UtilityManager.TEXT_TYPE +
            " )";
    public static  final String CREATE_TABLE_FOR_GENERAL ="CREATE TABLE " + UtilityManager.GENERAL_TABLE_NAME + " (" +
            UtilityManager.COLUMN_ID + " INTEGER PRIMARY KEY," +
            UtilityManager.COLUMN_QUESTION_TYPE + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_QUESTION + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION1 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION2 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION3 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_OPTION4 + UtilityManager.TEXT_TYPE + "," +
            UtilityManager.COLUMN_RIGHT_OPTION + UtilityManager.TEXT_TYPE +
            " )";


    public static  final String DELETE_TABLE_FOR_BANGLA= "DROP TABLE IF EXISTS " + UtilityManager.BANGLA_TABLE_NAME ;
    public static  final String DELETE_TABLE_FOR_ENGLISH= "DROP TABLE IF EXISTS " + UtilityManager.ENGLISH_TABLE_NAME ;
    public static  final String DELETE_TABLE_FOR_MATH= "DROP TABLE IF EXISTS " + UtilityManager.MATH_TABLE_NAME ;
    public static  final String DELETE_TABLE_FOR_GENERAL= "DROP TABLE IF EXISTS " + UtilityManager.GENERAL_TABLE_NAME ;
}
