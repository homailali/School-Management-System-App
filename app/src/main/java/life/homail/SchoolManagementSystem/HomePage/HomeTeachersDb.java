package life.homail.SchoolManagementSystem.HomePage;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import life.homail.SchoolManagementSystem.ModelClasses.TeacherModel;

public class HomeTeachersDb extends SQLiteOpenHelper {
    // fields
    private HomeMain homeMain;
    private static final int DB_VERSION=1;
    private static final String DB_NAME="TeachersDB";
    private static final String TABLE_NAME="TeachersData";
    private static final String TEACHER_ID_COLUMN="Id";
    private static final String TEACHER_FIRST_NAME_COLUMN="FirstName";
    private static final String TEACHER_LAST_NAME_COLUMN="LastName";
    private static final String TEACHER_FULL_NAME_COLUMN="Name";
    private static final String TEACHER_SUBJECT_COLUMN="Subject";
    private static final String TEACHER_PHONE_NUMBER_COLUMN="PhoneNumber";

    // Constructor
    protected HomeTeachersDb(HomeMain homeMain){
        super(homeMain,DB_NAME,null,DB_VERSION);
        this.homeMain=homeMain;
    }


    // Methods
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String createTableQuery=
                "create table "+TABLE_NAME
                +" ("
                +TEACHER_ID_COLUMN+" integer primary key,"
                +TEACHER_FULL_NAME_COLUMN+" text ,"
                +TEACHER_FIRST_NAME_COLUMN+" text,"
                +TEACHER_LAST_NAME_COLUMN+"text,"
                +TEACHER_SUBJECT_COLUMN+" text ,"
                +TEACHER_PHONE_NUMBER_COLUMN+" text "
                +")";
        sqLiteDatabase.execSQL(createTableQuery);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int oldVersion,int newVersion){}
    public boolean addTeacher(TeacherModel teacherModel){
        SQLiteDatabase sqLiteDatabase=super.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(TEACHER_FULL_NAME_COLUMN,teacherModel.getTeacherFullName());
        contentValues.put(TEACHER_ID_COLUMN,teacherModel.getTeacherId());
        contentValues.put(TEACHER_SUBJECT_COLUMN,teacherModel.getTeacherSubject());
        contentValues.put(TEACHER_PHONE_NUMBER_COLUMN,teacherModel.getTeacherPhoneNumber());
        long temp=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        return temp!=-1;
    }
    public ArrayList<TeacherModel> getAllTeachers(){
        ArrayList<TeacherModel> tempArrList=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=super.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        if (cursor.moveToFirst()){
            do {
                long teacherId=cursor.getLong(0);
                String teacherFullName=cursor.getString(1);
                String teacherFirstName=cursor.getString(2);
                String teacherLastName=cursor.getString(3);
                String teacherSubject=cursor.getString(4);
                String phoneNumber=cursor.getString(5);
                TeacherModel teacherModel=new TeacherModel(teacherId,teacherFullName,teacherFirstName,teacherLastName,teacherSubject,phoneNumber);
                tempArrList.add(teacherModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return tempArrList;
    }
    public boolean deleteTeacher(TeacherModel teacherModel){
        SQLiteDatabase sqLiteDatabase=super.getWritableDatabase();
        long temp=sqLiteDatabase.delete(TABLE_NAME,TEACHER_ID_COLUMN+"=?",new String[]{String.valueOf(teacherModel.getTeacherId())});
        sqLiteDatabase.close();
        return temp!=0;
    }
    public boolean updateTeacherData(TeacherModel oldModel,TeacherModel newModel){
        SQLiteDatabase sqLiteDatabase=super.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(TEACHER_FULL_NAME_COLUMN,newModel.getTeacherFullName());
        contentValues.put(TEACHER_FIRST_NAME_COLUMN,newModel.getTeacherFirstName());
        contentValues.put(TEACHER_LAST_NAME_COLUMN,newModel.getTeacherLastName());
        contentValues.put(TEACHER_ID_COLUMN,newModel.getTeacherId());
        contentValues.put(TEACHER_SUBJECT_COLUMN,newModel.getTeacherSubject());
        contentValues.put(TEACHER_PHONE_NUMBER_COLUMN,newModel.getTeacherPhoneNumber());
        long temp=sqLiteDatabase.update(TABLE_NAME,contentValues,TEACHER_ID_COLUMN+"=?",new String[]{String.valueOf(oldModel.getTeacherId())});
        sqLiteDatabase.close();
        return temp!=0;
    }
}