package life.homail.SchoolManagementSystem.AddStudent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import life.homail.SchoolManagementSystem.R;

public class AddStdViews {
    private AddStdMain addStdMain;
    private Button goBackBtn;
    private Button saveStdBtn;





    private EditText firstNameEd;
    private EditText lastNameEd;
    private EditText rollNoEd;
    private EditText classEd;
    private EditText phoneNoEd;

    protected AddStdViews(AddStdMain addStdMain) {
        this.addStdMain = addStdMain;
        this.initializeViews();
        this.setEventHandlers();
    }

    private void initializeViews(){
        this.goBackBtn=this.addStdMain.findViewById(R.id.goBackBtn);
        this.saveStdBtn=this.addStdMain.findViewById(R.id.saveStdBtn);
        // initializing edit texts
        this.firstNameEd=this.addStdMain.findViewById(R.id.firstNameEd);
        this.lastNameEd=this.addStdMain.findViewById(R.id.lastNameEd);
        this.rollNoEd=this.addStdMain.findViewById(R.id.rollNoEd);
        this.classEd=this.addStdMain.findViewById(R.id.classEd);
        this.phoneNoEd=this.addStdMain.findViewById(R.id.phoneNoEd);
    }
    private void setEventHandlers(){
        this.goBackBtn.setOnClickListener(this::goBackBtnHandler);
        this.saveStdBtn.setOnClickListener(this.addStdMain.addStdSaveStdBtnHandler);
    }
    private void goBackBtnHandler(View view){
        this.addStdMain.finish();
    }

    protected Button getGoBackBtn() {
        return goBackBtn;
    }

    protected void setGoBackBtn(Button goBackBtn) {
        this.goBackBtn = goBackBtn;
    }

    protected Button getSaveStdBtn() {
        return saveStdBtn;
    }

    protected void setSaveStdBtn(Button saveStdBtn) {
        this.saveStdBtn = saveStdBtn;
    }

    protected EditText getFirstNameEd() {
        return firstNameEd;
    }

    protected void setFirstNameEd(EditText firstNameEd) {
        this.firstNameEd = firstNameEd;
    }

    protected EditText getLastNameEd() {
        return lastNameEd;
    }

    protected void setLastNameEd(EditText lastNameEd) {
        this.lastNameEd = lastNameEd;
    }

    protected EditText getRollNoEd() {
        return rollNoEd;
    }

    protected void setRollNoEd(EditText rollNoEd) {
        this.rollNoEd = rollNoEd;
    }

    protected EditText getClassEd() {
        return classEd;
    }

    protected void setClassEd(EditText classEd) {
        this.classEd = classEd;
    }

    protected EditText getPhoneNoEd() {
        return phoneNoEd;
    }

    protected void setPhoneNoEd(EditText phoneNoEd) {
        this.phoneNoEd = phoneNoEd;
    }

}
