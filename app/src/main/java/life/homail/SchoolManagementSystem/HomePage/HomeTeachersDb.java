package life.homail.SchoolManagementSystem.HomePage;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class HomeTeachersDb extends SQLiteOpenHelper {

    private HomeMain homeMain;



    // Constructor
    protected HomeTeachersDb(HomeMain homeMain){
        super(homeMain,"name",null,1);
        this.homeMain=homeMain;
    }


    // Methods
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int oldVersion,int newVersion){

    }

}