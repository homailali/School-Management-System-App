package life.homail.SchoolManagementSystem.HomePage;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.InstitutionInfo.InstitutionInfoMain;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
import life.homail.SchoolManagementSystem.SplashScreen.SplashScreenMain;

public class HomeMain extends AppCompatActivity {
    private String principalName;
    private String contactNumber;
    private String institutionName;
    private String institutionLocation;
    protected HomePageViews homePageViews;
    private SplashScreenMain splashScreenMain;
    public HomeStudentsDb homeStudentsDb=new HomeStudentsDb(this);
    public HomeTeachersDb homeTeachersDb=new HomeTeachersDb(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.home_activity);
        this.homePageViewsSetting();
        this.setSomeCollegeInfoText();
        SingleTon.getSingleTon().setHomeMain(this);
    }


    private void setSomeCollegeInfoText(){
        this.getInfo();
        this.homePageViews.collegeNameTv.setText(this.institutionName);
    }



    private void getInfo(){
        splashScreenMain = SingleTon.getSingleTon().getSplashScreenMain();
        SharedPreferences sharedPreferences = splashScreenMain.getSharedPreferences(
                SplashScreenMain.SHARED_PREF_NAME, MODE_PRIVATE
        );
        institutionName = sharedPreferences.getString(SplashScreenMain.INSTITUTION_NAME_KEY, "null");
        principalName = sharedPreferences.getString(SplashScreenMain.PRINCIPAL_NAME_KEY, "null");
        institutionLocation = sharedPreferences.getString(SplashScreenMain.INSTITUTION_LOCATION_KEY, "null");
        contactNumber = sharedPreferences.getString(SplashScreenMain.CONTACT_NUMBER_KEY, "null");
    }
    private void homePageViewsSetting(){
        this.homePageViews=new HomePageViews(this);
    }

}