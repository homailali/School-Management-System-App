package life.homail.SchoolManagementSystem.ProfilePage;

import android.app.Dialog;

public class ProfilePageDialog {
    private Dialog profilePageDialog;
    private ProfilePageMain profilePageMain;
    protected ProfilePageDialog(ProfilePageMain profilePageMain) {
        this.profilePageMain = profilePageMain;
        this.setUpDialog();
    }
    private void setUpDialog(){
        this.profilePageDialog=new Dialog(this.profilePageMain);
    }
}
