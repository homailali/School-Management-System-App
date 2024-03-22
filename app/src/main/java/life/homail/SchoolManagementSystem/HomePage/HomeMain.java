package life.homail.SchoolManagementSystem.HomePage;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;

import life.homail.SchoolManagementSystem.ModelClasses.InstitutionInfoModel;
import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
import life.homail.SchoolManagementSystem.SplashScreen.SplashScreenMain;
public class HomeMain extends AppCompatActivity {
    // Fields
    private InstitutionInfoModel institutionInfoModel;
    protected HomePageViews homePageViews;
    private SplashScreenMain splashScreenMain;
    public HomeStudentsDb homeStudentsDb=new HomeStudentsDb(this);
    public HomeTeachersDb homeTeachersDb=new HomeTeachersDb(this);
    // Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.home_activity);
        this.retrieveDataFromDB();
        this.homePageViewsSetting();
        this.institutionInfoModel=this.retrieveInstitutionInfoFromSharedPref();
        SingleTon.getSingleTon().setHomeMain(this);
    }
    private void retrieveDataFromDB(){
        SingleTon.getSingleTon().setStudentModelArrayList(this.homeStudentsDb.getAllStudentsData());
        SingleTon.getSingleTon().setTeacherModelArrayList(this.homeTeachersDb.getAllTeachers());
    }
    private void homePageViewsSetting(){

        this.homePageViews=new HomePageViews(this);
    }
    public InstitutionInfoModel retrieveInstitutionInfoFromSharedPref(){
        splashScreenMain = SingleTon.getSingleTon().getSplashScreenMain();
        SharedPreferences sharedPreferences = splashScreenMain.getSharedPreferences(
                SplashScreenMain.SHARED_PREF_NAME, MODE_PRIVATE
        );
        String institutionName = sharedPreferences.getString(SplashScreenMain.INSTITUTION_NAME_KEY, "null");
        String principalName = sharedPreferences.getString(SplashScreenMain.PRINCIPAL_NAME_KEY, "null");
        String institutionLocation = sharedPreferences.getString(SplashScreenMain.INSTITUTION_LOCATION_KEY, "null");
        String contactNumber = sharedPreferences.getString(SplashScreenMain.CONTACT_NUMBER_KEY, "null");
        return new InstitutionInfoModel(principalName,contactNumber,institutionName,institutionLocation);
    }
    @Override
    public void onStart(){
        super.onStart();
        this.homePageViews.setStudentsAndTeachersCountOnTv();
    }


    public InstitutionInfoModel getHomeInstitutionInfoModel() {
        return institutionInfoModel;
    }

    public void setHomeInstitutionInfoModel(InstitutionInfoModel institutionInfoModel) {
        this.institutionInfoModel = institutionInfoModel;
    }
}