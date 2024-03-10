package life.homail.SchoolManagementSystem.HomePage;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.ArrayList;
import life.homail.SchoolManagementSystem.ModelClasses.HomeAdpModel;
import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
import life.homail.SchoolManagementSystem.SplashScreen.SplashScreenMain;
public class HomeMain extends AppCompatActivity {
    // Fields
    private String principalName;
    private String contactNumber;
    private String institutionName;
    private String institutionLocation;
    protected HomePageViews homePageViews;
    private SplashScreenMain splashScreenMain;
    protected ArrayList<HomeAdpModel> homeAdpModelsArr=new ArrayList<>();
    public HomeStudentsDb homeStudentsDb=new HomeStudentsDb(this);
    public HomeTeachersDb homeTeachersDb=new HomeTeachersDb(this);
    // Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.home_activity);
        this.retrieveDataFromDB();
        this.homePageViewsSetting();
        this.retrieveDataFromSharedPref();
        SingleTon.getSingleTon().setHomeMain(this);
    }
    private void retrieveDataFromDB(){
        SingleTon.getSingleTon().setStudentModelArrayList(this.homeStudentsDb.getAllStudentsData());
        SingleTon.getSingleTon().setTeacherModelArrayList(this.homeTeachersDb.getAllTeachers());
    }
    private void homePageViewsSetting(){

        this.homePageViews=new HomePageViews(this);
    }
    private void retrieveDataFromSharedPref(){
        splashScreenMain = SingleTon.getSingleTon().getSplashScreenMain();
        SharedPreferences sharedPreferences = splashScreenMain.getSharedPreferences(
                SplashScreenMain.SHARED_PREF_NAME, MODE_PRIVATE
        );
        institutionName = sharedPreferences.getString(SplashScreenMain.INSTITUTION_NAME_KEY, "null");
        principalName = sharedPreferences.getString(SplashScreenMain.PRINCIPAL_NAME_KEY, "null");
        institutionLocation = sharedPreferences.getString(SplashScreenMain.INSTITUTION_LOCATION_KEY, "null");
        contactNumber = sharedPreferences.getString(SplashScreenMain.CONTACT_NUMBER_KEY, "null");
    }
}