package life.homail.SchoolManagementSystem.ProfilePage;

import android.app.Dialog;
import android.widget.Button;
import android.widget.EditText;

import life.homail.SchoolManagementSystem.R;

public class ProfilePageDialogClass {
    private Dialog profilePageDialog;

    private EditText dialogInstitutionNameEd;
    private EditText dialogPrincipalNameEd;
    private EditText dialogContactNumberEd;
    private EditText dialogInstitutionLocationEd;
    private Button dialogCancelBtn;
    private Button dialogSaveBtn;

    private ProfilePageMain profilePageMain;
    protected ProfilePageDialogClass(ProfilePageMain profilePageMain) {
        this.profilePageMain = profilePageMain;
        this.setUpDialog();
    }
    private void setUpDialog(){
        this.initialSettings();
        this.initializeViews();
        this.setEventHandlers();
    }

    private void setEventHandlers(){
        this.dialogCancelBtn.setOnClickListener(e->{
            this.profilePageDialog.cancel();
        });
        this.dialogSaveBtn.setOnClickListener(e-> this.profilePageMain.getEditProfileBtnHandler().onSaveBtnClick());
    }

    private void initialSettings(){
        this.profilePageDialog=new Dialog(this.profilePageMain);
        this.profilePageDialog.setContentView(R.layout.profile_page_dialog);
        this.profilePageDialog.setCancelable(false);
    }

    private void initializeViews(){
        this.dialogSaveBtn=this.profilePageDialog.findViewById(R.id.dialogSaveBtn);
        this.dialogCancelBtn=this.profilePageDialog.findViewById(R.id.dialogCancelBtn);

        this.dialogPrincipalNameEd=this.profilePageDialog.findViewById(R.id.dialogPrincipalNameEd);
        this.dialogContactNumberEd=this.profilePageDialog.findViewById(R.id.dialogContactNumberEd);
        this.dialogInstitutionNameEd=this.profilePageDialog.findViewById(R.id.dialogInstitutionNameEd);
        this.dialogInstitutionLocationEd=this.profilePageDialog.findViewById(R.id.dialogInstitutionLocationEd);
    }


    protected EditText getDialogInstitutionNameEd() {
        return dialogInstitutionNameEd;
    }

    protected void setDialogInstitutionNameEd(EditText dialogInstitutionNameEd) {
        this.dialogInstitutionNameEd = dialogInstitutionNameEd;
    }

    protected EditText getDialogPrincipalNameEd() {
        return dialogPrincipalNameEd;
    }

    protected void setDialogPrincipalNameEd(EditText dialogPrincipalNameEd) {
        this.dialogPrincipalNameEd = dialogPrincipalNameEd;
    }

    protected EditText getDialogContactNumberEd() {
        return dialogContactNumberEd;
    }

    protected void setDialogContactNumberEd(EditText dialogContactNumberEd) {
        this.dialogContactNumberEd = dialogContactNumberEd;
    }

    protected EditText getDialogInstitutionLocationEd() {
        return dialogInstitutionLocationEd;
    }

    protected void setDialogInstitutionLocationEd(EditText dialogInstitutionLocationEd) {
        this.dialogInstitutionLocationEd = dialogInstitutionLocationEd;
    }

    protected Button getDialogCancelBtn() {
        return dialogCancelBtn;
    }

    protected void setDialogCancelBtn(Button dialogCancelBtn) {
        this.dialogCancelBtn = dialogCancelBtn;
    }

    protected Button getDialogSaveBtn() {
        return dialogSaveBtn;
    }

    protected void setDialogSaveBtn(Button dialogSaveBtn) {
        this.dialogSaveBtn = dialogSaveBtn;
    }

    protected Dialog getProfilePageDialog() {
        return profilePageDialog;
    }

    protected void setProfilePageDialog(Dialog profilePageDialog) {
        this.profilePageDialog = profilePageDialog;
    }
}
