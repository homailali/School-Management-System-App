package life.homail.SchoolManagementSystem.HomePage;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import life.homail.SchoolManagementSystem.ModelClasses.StudentModel;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;

public class HomeStudentsDb extends SQLiteOpenHelper{
    // fields
    private HomeMain homeMain;
    private static final int DB_VERSION=1;
    private static final String DB_NAME="StudentsDB";
    private static final String TABLE_NAME="StudentsData";
    private static final String ROLL_NO_COL="RollNo";
    private static final String FULL_NAME="EntireName";
    private static final String FIRST_NAME_COL="FirstName";
    private static final String LAST_NAME_COL="LastName";
    private static final String CLASS_NAME_COL="ClassName";
    private static final String CONTACT_NUMBER_COL="ContactNumber";
    // Constructor
    protected HomeStudentsDb(HomeMain homeMain){
        super(homeMain,DB_NAME,null,DB_VERSION);
        this.homeMain=homeMain;
    }
    // Methods
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query =
                "create table " + TABLE_NAME +
                        "("
                        + ROLL_NO_COL + " integer primary key, "
                        + FULL_NAME + " text, "
                        + FIRST_NAME_COL + " text, "
                        + LAST_NAME_COL + " text, "
                        + CLASS_NAME_COL + " text, "
                        + CONTACT_NUMBER_COL + " text"
                        + ")";
        sqLiteDatabase.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int oldVersion,int newVersion){}
    public boolean addStudent(StudentModel studentModel){
        SQLiteDatabase sqLiteDatabase=super.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ROLL_NO_COL,studentModel.getStudentRollNumber());
        contentValues.put(FULL_NAME,studentModel.getStudentFullName());
        contentValues.put(FIRST_NAME_COL,studentModel.getStudentFirstName());
        contentValues.put(LAST_NAME_COL, studentModel.getStudentLastName());
        contentValues.put(CLASS_NAME_COL,studentModel.getStudentClassName());
        contentValues.put(CONTACT_NUMBER_COL,studentModel.getStudentContactNumber());
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
                long rollNo=cursor.getLong(0);
                String fullName=cursor.getString(1);
                String firstName=cursor.getString(2);
                String lastName=cursor.getString(3);
                String className=cursor.getString(4);
                String contactNumber=cursor.getString(5);
                StudentModel studentModel=new StudentModel(rollNo,fullName,firstName,lastName,className,contactNumber);
                tempArrList.add(studentModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return tempArrList;
    }
    public boolean deleteStudent(StudentModel studentModel){
        SQLiteDatabase sqLiteDatabase=super.getWritableDatabase();
        int temp=sqLiteDatabase.delete(TABLE_NAME,ROLL_NO_COL+"=?",new String[]{String.valueOf(studentModel.getStudentRollNumber())});
        sqLiteDatabase.close();
        return temp!=0;
    }
    public boolean updateStudentData(StudentModel oldModel,StudentModel newModel){
        SQLiteDatabase sqLiteDatabase=super.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ROLL_NO_COL,newModel.getStudentRollNumber());
        contentValues.put(FULL_NAME,newModel.getStudentFullName());
        contentValues.put(FIRST_NAME_COL,newModel.getStudentFirstName());
        contentValues.put(LAST_NAME_COL,newModel.getStudentLastName());
        contentValues.put(CLASS_NAME_COL,newModel.getStudentClassName());
        contentValues.put(CONTACT_NUMBER_COL,newModel.getStudentContactNumber());
        int temp=sqLiteDatabase.update(TABLE_NAME,contentValues,ROLL_NO_COL+"=?",new String[]{String.valueOf(oldModel.getStudentRollNumber())});
        sqLiteDatabase.close();
        return temp!=0;
    }
}