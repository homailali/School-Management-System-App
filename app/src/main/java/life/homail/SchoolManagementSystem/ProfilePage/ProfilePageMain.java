package life.homail.SchoolManagementSystem.ProfilePage;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import life.homail.SchoolManagementSystem.HomePage.HomeMain;
import life.homail.SchoolManagementSystem.ModelClasses.InstitutionInfoModel;
import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;

public class ProfilePageMain extends AppCompatActivity {
    private ProfilePageViews profilePageViews;
    private ProfilePageDialogClass profilePageDialogClass;
    private EditProfileBtnHandler editProfileBtnHandler=new EditProfileBtnHandler(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.profile_activity);
        this.atEndOfOnCreate();
    }
    private void atEndOfOnCreate(){
        this.createSomeObjects();
        this.setInstitutionTextOnFields(SingleTon.getSingleTon().getHomeMain().getHomeInstitutionInfoModel());
    }

    private void createSomeObjects(){
        this.profilePageViews=new ProfilePageViews(this);
        this.profilePageDialogClass =new ProfilePageDialogClass(this);
    }

    protected void setInstitutionTextOnFields(InstitutionInfoModel institutionInfoModel){
        this.profilePageViews.getInstitutionNameTv().setText(institutionInfoModel.getInstitutionName());
        this.profilePageViews.getPrincipalNameTv().setText(institutionInfoModel.getPrincipalName());
        this.profilePageViews.getInstitutionLocationTv().setText(institutionInfoModel.getInstitutionLocation());
        this.profilePageViews.getContactNumberTv().setText(institutionInfoModel.getContactNumber());
    }

    public ProfilePageViews getProfilePageViews() {
        return profilePageViews;
    }

    public void setProfilePageViews(ProfilePageViews profilePageViews) {
        this.profilePageViews = profilePageViews;
    }

    public ProfilePageDialogClass getProfilePageDialogClass() {
        return profilePageDialogClass;
    }

    public void setProfilePageDialogClass(ProfilePageDialogClass profilePageDialogClass) {
        this.profilePageDialogClass = profilePageDialogClass;
    }

    public EditProfileBtnHandler getEditProfileBtnHandler() {
        return editProfileBtnHandler;
    }

    public void setEditProfileBtnHandler(EditProfileBtnHandler editProfileBtnHandler) {
        this.editProfileBtnHandler = editProfileBtnHandler;
    }
}