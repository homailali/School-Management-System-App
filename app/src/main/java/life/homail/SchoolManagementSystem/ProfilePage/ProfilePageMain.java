package life.homail.SchoolManagementSystem.ProfilePage;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import life.homail.SchoolManagementSystem.HomePage.HomeMain;
import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;

public class ProfilePageMain extends AppCompatActivity {
    private ProfilePageViews profilePageViews;
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.profile_activity);
        this.atEndOfOnCreate();
    }
    private void atEndOfOnCreate(){
        this.profilePageViews=new ProfilePageViews(this);
        this.setTextOnFields();
    }
    private void setTextOnFields(){
        HomeMain homeMain=SingleTon.getSingleTon().getHomeMain();
        this.profilePageViews.getInstitutionNameTv().setText(homeMain.getInstitutionName());
        this.profilePageViews.getPrincipalNameTv().setText(homeMain.getPrincipalName());
        this.profilePageViews.getInstitutionLocationTv().setText(homeMain.getInstitutionLocation());
        this.profilePageViews.getContactNumberTv().setText(homeMain.getContactNumber());
    }
}