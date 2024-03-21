package life.homail.SchoolManagementSystem.ProfilePage;

import android.widget.Button;
import android.widget.TextView;

import life.homail.SchoolManagementSystem.R;

public class ProfilePageViews {
    private ProfilePageMain profilePageMain;

    private Button editProfileBtn;
    private TextView principalNameTv;
    private TextView contactNumberTv;
    private TextView institutionNameTv;
    private TextView institutionLocationTv;


    protected ProfilePageViews(ProfilePageMain profilePageMain) {
        this.profilePageMain = profilePageMain;
        this.initializeViews();
    }

    private void initializeViews(){
        this.editProfileBtn=this.profilePageMain.findViewById(R.id.editProfileBtn);
        this.contactNumberTv=this.profilePageMain.findViewById(R.id.contactNumberTv);
        this.principalNameTv=this.profilePageMain.findViewById(R.id.principalNameTv);
        this.institutionNameTv=this.profilePageMain.findViewById(R.id.institutionNameTv);
        this.institutionLocationTv=this.profilePageMain.findViewById(R.id.institutionLocationTv);
    }

    protected TextView getPrincipalNameTv() {
        return principalNameTv;
    }

    protected void setPrincipalNameTv(TextView principalNameTv) {
        this.principalNameTv = principalNameTv;
    }

    protected TextView getContactNumberTv() {
        return contactNumberTv;
    }

    protected void setContactNumberTv(TextView contactNumberTv) {
        this.contactNumberTv = contactNumberTv;
    }

    protected TextView getInstitutionNameTv() {
        return institutionNameTv;
    }

    protected void setInstitutionNameTv(TextView institutionNameTv) {
        this.institutionNameTv = institutionNameTv;
    }

    protected TextView getInstitutionLocationTv() {
        return institutionLocationTv;
    }

    protected void setInstitutionLocationTv(TextView institutionLocationTv) {
        this.institutionLocationTv = institutionLocationTv;
    }

    protected Button getEditProfileBtn() {
        return editProfileBtn;
    }

    protected void setEditProfileBtn(Button editProfileBtn) {
        this.editProfileBtn = editProfileBtn;
    }
}