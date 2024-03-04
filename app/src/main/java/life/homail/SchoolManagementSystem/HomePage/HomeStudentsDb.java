package life.homail.SchoolManagementSystem.HomePage;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import life.homail.SchoolManagementSystem.ModelClasses.StudentModel;

public class HomeStudentsDb extends SQLiteOpenHelper{


    private HomeMain homeMain;
    private static final int DB_VERSION=1;
    private static final String DB_NAME="StudentDB";
    private static final String TABLE_NAME="StudentData";
    private static final String ROLL_NO_COL="RollNo";
    private static final String NAME_COL="Name";
    private static final String CLASS_COL="Class";
    private static final String PHONE_NUMBER_COL="PhoneNumber";


    // Constructor
    protected HomeStudentsDb(HomeMain homeMain){
        super(homeMain,DB_NAME,null,DB_VERSION);
        this.homeMain=homeMain;
    }



    // Methods
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String query=
                "create table "+TABLE_NAME+
                "("
                +ROLL_NO_COL+" integer primary key ,"
                +NAME_COL+" text ,"
                +CLASS_COL+" text ,"
                +PHONE_NUMBER_COL+" text"+
                ")";
        sqLiteDatabase.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int oldVersion,int newVersion){

    }
    public boolean addStudent(StudentModel studentModel){
        SQLiteDatabase sqLiteDatabase=super.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ROLL_NO_COL,studentModel.getRollNumber());
        contentValues.put(NAME_COL, studentModel.getName());
        contentValues.put(CLASS_COL,studentModel.getClassName());
        contentValues.put(PHONE_NUMBER_COL,studentModel.getPhoneNumber());
        long temp=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        return temp!=-1;
    }
    public ArrayList<StudentModel> getAllStudentsData(){
        ArrayList<StudentModel> tempArrList=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=super.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        if (cursor.moveToFirst()){
            do {
                int rollNo=cursor.getInt(0);
                String name=cursor.getString(1);
                String className=cursor.getString(2);
                String phoneNumber=cursor.getString(3);
                StudentModel studentModel=new StudentModel(rollNo,name,className,phoneNumber);
                tempArrList.add(studentModel);
            } while (cursor.moveToNext());
        }
        return tempArrList;
    }
//    protected boolean deleteStudent(StudentModel studentModel){}
//
//    protected boolean updateStudentData(StudentModel studentModel){
//
//    }


}
