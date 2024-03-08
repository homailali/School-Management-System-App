package life.homail.SchoolManagementSystem.SplashScreen;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import life.homail.SchoolManagementSystem.HomePage.HomeMain;
import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.InstitutionInfo.InstitutionInfoMain;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
public class SplashScreenMain extends AppCompatActivity {
    private Handler handler = new Handler();
    public static final String SHARED_PREF_NAME="splashSharedPref";
    public static final String INSTITUTION_INFO_BOOL_KEY="schoolInfoBool";
    public static final String INSTITUTION_NAME_KEY="institutionName";
    public static final String PRINCIPAL_NAME_KEY="principalName";
    public static final String INSTITUTION_LOCATION_KEY="institutionLocation";
    public static final String CONTACT_NUMBER_KEY="contactNumberKey";
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.splash_screen_activity);
        SingleTon.getSingleTon().setSplashScreenMain(this);
        this.handler.postDelayed(this::changeActivity,2000);
    }
    private void changeActivity(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        boolean bool=sharedPreferences.getBoolean(INSTITUTION_INFO_BOOL_KEY,true);
        if (bool) this.changeTo(InstitutionInfoMain.class);
        else this.changeTo(HomeMain.class);
    }
    private void changeTo(Class<? extends AppCompatActivity> classToSwitchTo){
        Intent intent=new Intent(this, classToSwitchTo);
        super.startActivity(intent);
        super.finish();
    }
}