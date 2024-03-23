package life.homail.SchoolManagementSystem.InstitutionInfo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;

import life.homail.SchoolManagementSystem.HomePage.HomeMain;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
import life.homail.SchoolManagementSystem.SplashScreen.SplashScreenMain;

public class SubmitInfoBtnHandler implements View.OnClickListener{
    private InstitutionInfoMain institutionInfoMain;
    private String schoolName;
    private String principalName;
    private String schoolLocation;
    private String contactNumber;
    private Toast toast;
    private SplashScreenMain splashScreenMain;

    protected SubmitInfoBtnHandler (InstitutionInfoMain institutionInfoMain){
        this.institutionInfoMain = institutionInfoMain;
    }
    @Override
    public void onClick(View view){
        this.extractDataFromFields();
        if (this.ifSomeDataIsInCorrect()) this.makeToast("Fill all fields correctly");
        else this.ifAllDataIsCorrect();
        this.institutionInfoMain.finish();
    }

    private void ifAllDataIsCorrect(){
        this.addBoolToSplashScreenSharedPref();
        this.putDataToThisSharedPref();
        this.changeActivity();
    }
    private void changeActivity(){
        Intent intent=new Intent(this.institutionInfoMain, HomeMain.class);
        this.institutionInfoMain.startActivity(intent);
    }
    private void putDataToThisSharedPref(){
        SharedPreferences sharedPreferences=SingleTon.getSingleTon().getSplashScreenMain().getSharedPreferences(SplashScreenMain.SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(SplashScreenMain.INSTITUTION_NAME_KEY,schoolName);
        editor.putString(SplashScreenMain.PRINCIPAL_NAME_KEY,principalName);
        editor.putString(SplashScreenMain.INSTITUTION_LOCATION_KEY,schoolLocation);
        editor.putString(SplashScreenMain.CONTACT_NUMBER_KEY,contactNumber);
        editor.apply();
    }
    private void addBoolToSplashScreenSharedPref(){
        this.splashScreenMain=SingleTon.getSingleTon().getSplashScreenMain();
        SharedPreferences sharedPreferences=this.splashScreenMain.getSharedPreferences(
                SplashScreenMain.SHARED_PREF_NAME, Context.MODE_PRIVATE
        );
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putBoolean(SplashScreenMain.INSTITUTION_INFO_BOOL_KEY,false);
        editor.apply();
    }
    private boolean ifSomeDataIsInCorrect(){
        if (
              this.schoolName.isBlank() ||
              this.principalName.isBlank() ||
              this.schoolLocation.isBlank() ||
              this.contactNumber.isBlank()
        ) return true;
        return false;
    }
    private void extractDataFromFields(){
        this.schoolName=String.valueOf(this.institutionInfoMain.institutionNameEd.getText());
        this.principalName=String.valueOf(this.institutionInfoMain.principalNameEd.getText());
        this.schoolLocation=String.valueOf(this.institutionInfoMain.institutionLocationEd.getText());
        this.contactNumber=String.valueOf(this.institutionInfoMain.contactNumberEd.getText());
    }
    protected void makeToast(String toastText){
        if (toast!=null) toast.cancel();
        toast=Toast.makeText(this.institutionInfoMain,toastText,Toast.LENGTH_SHORT);
        toast.show();
    }
}