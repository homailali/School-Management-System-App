package life.homail.SchoolManagementSystem.ProfilePage;
import android.content.Context;
import android.content.SharedPreferences;
import life.homail.SchoolManagementSystem.HomePage.HomeMain;
import life.homail.SchoolManagementSystem.ModelClasses.InstitutionInfoModel;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
import life.homail.SchoolManagementSystem.SplashScreen.SplashScreenMain;
import life.homail.SchoolManagementSystem.Toast.MyToast;
public class EditProfileBtnHandler {
    private InstitutionInfoModel oldInstitutionInfoModel;
    private ProfilePageMain profilePageMain;
    protected EditProfileBtnHandler(ProfilePageMain profilePageMain) {

        this.profilePageMain = profilePageMain;
    }
    protected void editProfileBtnHandlerMain(){
        this.profilePageMain.getProfilePageDialogClass().getProfilePageDialog().show();
        this.setTextOnProfilePageDialog();
    }
    private void setTextOnProfilePageDialog(){
        oldInstitutionInfoModel=SingleTon.getSingleTon().getHomeMain().getHomeInstitutionInfoModel();
        this.profilePageMain.getProfilePageDialogClass().getDialogInstitutionNameEd().setText(oldInstitutionInfoModel.getInstitutionName());
        this.profilePageMain.getProfilePageDialogClass().getDialogInstitutionLocationEd().setText(oldInstitutionInfoModel.getInstitutionLocation());
        this.profilePageMain.getProfilePageDialogClass().getDialogPrincipalNameEd().setText(oldInstitutionInfoModel.getPrincipalName());
        this.profilePageMain.getProfilePageDialogClass().getDialogContactNumberEd().setText(oldInstitutionInfoModel.getContactNumber());
    }
    protected void onSaveBtnClick(){
        InstitutionInfoModel newInstitutionInfoModel=this.getNewInstitutionInfoModel();
        String errorStr=getErrorStringText(newInstitutionInfoModel);
        if (errorStr!=null) MyToast.makeToast(errorStr,this.profilePageMain);
        else this.saveInstitutionInfo(newInstitutionInfoModel);
    }
    private void saveInstitutionInfo(InstitutionInfoModel newInstitutionInfoModel){
        HomeMain homeMain=SingleTon.getSingleTon().getHomeMain();
        this.savingInSharedPref(newInstitutionInfoModel);
        homeMain.setHomeInstitutionInfoModel(homeMain.retrieveInstitutionInfoFromSharedPref());
        this.profilePageMain.setInstitutionTextOnFields(homeMain.getHomeInstitutionInfoModel());
        this.profilePageMain.getProfilePageDialogClass().getProfilePageDialog().dismiss();
        MyToast.makeToast("Institution info updated successfully",this.profilePageMain);
    }
    private void savingInSharedPref(InstitutionInfoModel newInstitutionInfoModel){
        SharedPreferences sharedPreferences=SingleTon.getSingleTon().getSplashScreenMain().getSharedPreferences(SplashScreenMain.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(SplashScreenMain.INSTITUTION_NAME_KEY, newInstitutionInfoModel.getInstitutionName());
        editor.putString(SplashScreenMain.INSTITUTION_LOCATION_KEY, newInstitutionInfoModel.getInstitutionLocation());
        editor.putString(SplashScreenMain.PRINCIPAL_NAME_KEY, newInstitutionInfoModel.getPrincipalName());
        editor.putString(SplashScreenMain.CONTACT_NUMBER_KEY, newInstitutionInfoModel.getContactNumber());
        editor.apply();
    }
    private String getErrorStringText(InstitutionInfoModel newInstitutionInfoModel){
        return
                oldInstitutionInfoModel.equals(newInstitutionInfoModel)?"Institution info has not been modified":
                this.ifSomeFieldIsEmpty(newInstitutionInfoModel)?"Fill all fields correctly":
                null;
    }
    private boolean ifSomeFieldIsEmpty(InstitutionInfoModel newInstitutionInfoModel){
        return
                newInstitutionInfoModel.getInstitutionName().isBlank() ||
                newInstitutionInfoModel.getPrincipalName().isBlank() ||
                newInstitutionInfoModel.getInstitutionLocation().isBlank() ||
                newInstitutionInfoModel.getContactNumber().isBlank()
        ;
    }
    private InstitutionInfoModel getNewInstitutionInfoModel(){
        ProfilePageDialogClass profilePageDialogClass=this.profilePageMain.getProfilePageDialogClass();
        String principalName=String.valueOf(profilePageDialogClass.getDialogPrincipalNameEd().getText());
        String contactNumber=String.valueOf(profilePageDialogClass.getDialogContactNumberEd().getText());
        String institutionName=String.valueOf(profilePageDialogClass.getDialogInstitutionNameEd().getText());
        String institutionLocation=String.valueOf(profilePageDialogClass.getDialogInstitutionLocationEd().getText());
        return new InstitutionInfoModel(principalName,contactNumber,institutionName,institutionLocation);
    }
}