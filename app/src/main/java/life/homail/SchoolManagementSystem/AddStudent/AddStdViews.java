package life.homail.SchoolManagementSystem.AddStudent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import life.homail.SchoolManagementSystem.R;

public class AddStdViews {
    protected AddStdMain addStdMain;
    protected Button goBackBtn;
    protected Button saveStdBtn;





    protected EditText firstNameEd;
    protected EditText lastNameEd;
    protected EditText rollNoEd;
    protected EditText classEd;
    protected EditText contactNoEd;

    protected AddStdViews(AddStdMain addStdMain) {
        this.addStdMain = addStdMain;
        this.initializeViews();
        this.setEventHandlers();
    }

    private void initializeViews(){
        this.goBackBtn=this.addStdMain.findViewById(R.id.goBackBtn);
        this.saveStdBtn=this.addStdMain.findViewById(R.id.saveStudentBtn);
        // initializing edit texts
        this.firstNameEd=this.addStdMain.findViewById(R.id.firstNameEd);
        this.lastNameEd=this.addStdMain.findViewById(R.id.lastNameEd);
        this.rollNoEd=this.addStdMain.findViewById(R.id.rollNoEd);
        this.classEd=this.addStdMain.findViewById(R.id.classNameEd);
        this.contactNoEd=this.addStdMain.findViewById(R.id.contactNumberNoEd);
    }
    private void setEventHandlers(){
        this.goBackBtn.setOnClickListener(this::goBackBtnHandler);
        this.saveStdBtn.setOnClickListener(this.addStdMain.addStdSaveStdBtnHandler);
    }
    private void goBackBtnHandler(View view){
        this.addStdMain.finish();
    }


}
