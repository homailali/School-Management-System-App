package life.homail.SchoolManagementSystem.HomePage;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import life.homail.SchoolManagementSystem.R;
public class HomeDialogClass {
    // Fields
    private Toast toast;
    private Dialog dialog;
    private HomeMain homeMain;
    private Button dgSetNameBtn;
    private TextInputEditText dgCollegeNameEd;
    private static final String SHARED_PREF_NAME="sharedPref";
    private static final String COLLEGE_NAME_KEY="collegeName";
    private static final String DIALOG_BOOL_KEY="dialogShowBool";
    // Constructor
    public HomeDialogClass(HomeMain homeMain) {

        this.homeMain = homeMain;
    }
    // Methods
    protected void dialogSettings(){
        this.dialog=new Dialog(this.homeMain);
        this.dialog.setContentView(R.layout.home_dialog_box_activity);
        this.dialog.setCancelable(false);
        this.initializeViews();
        this.setHindOnEd();
        this.dgSetNameBtn.setOnClickListener(this::setNameBtnHandler);
    }
    private void initializeViews(){
        this.dgSetNameBtn=this.dialog.findViewById(R.id.dgSetNameBtn);
        this.dgCollegeNameEd=this.dialog.findViewById(R.id.dgCollegeNameEd);
    }
    private void setHindOnEd(){

        this.dgCollegeNameEd.setHint("Enter college/school name");
    }
    private void setNameBtnHandler(View view){
        String collegeName=String.valueOf(this.dgCollegeNameEd.getText());
        if (collegeName.isBlank()){
            makeToast("Wrong name");
        } else {
            this.dialog.dismiss();
            this.storeDataToSharedPref(collegeName);
            this.makeToast("College name setted");
            this.homeMain.homePageViews.collegeNameTv.setText(collegeName);
        }
    }
    private void storeDataToSharedPref(String collegeName){
        SharedPreferences sharedPreferences=homeMain.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(DIALOG_BOOL_KEY,false);
        editor.putString(COLLEGE_NAME_KEY,collegeName);
        editor.apply();
    }
    private void makeToast(String toastText){
        if (toast!=null) toast.cancel();
        toast=Toast.makeText(this.homeMain,toastText,Toast.LENGTH_SHORT);
        toast.show();
    }
    protected void decideShowOrNotShowDialog(){
        SharedPreferences sharedPreferences=this.homeMain.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        boolean bool=sharedPreferences.getBoolean(DIALOG_BOOL_KEY,true);
        if (bool) {
            this.dialogSettings();
            this.dialog.show();
        }
        else {
            String collegeName=sharedPreferences.getString(COLLEGE_NAME_KEY,"College name");
            this.homeMain.homePageViews.collegeNameTv.setText(collegeName);
        }
    }
    public Dialog getDialog() {

        return dialog;
    }
    public void setDialog(Dialog dialog) {

        this.dialog = dialog;
    }
}