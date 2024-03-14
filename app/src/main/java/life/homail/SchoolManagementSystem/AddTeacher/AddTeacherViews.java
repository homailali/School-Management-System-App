package life.homail.SchoolManagementSystem.AddTeacher;



import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import life.homail.SchoolManagementSystem.R;

public class AddTeacherViews {
    // fields
    protected AddTeacherMain addTeacherMain;
    protected Button goBackBtn;
    private Button resetBtn;
    protected Button saveTeacherBtn;
    protected EditText firstNameEd;
    protected EditText lastNameEd;
    protected EditText teacherIdEd;
    protected EditText subjectNameEd;
    protected EditText phoneNumberEd;
    // constructor
    protected AddTeacherViews(AddTeacherMain addTeacherMain) {
        this.addTeacherMain = addTeacherMain;
        this.initializeViews();
        this.setEventHandlers();
    }
    // methods
    private void initializeViews(){
        this.goBackBtn=this.addTeacherMain.findViewById(R.id.teacherGoBackBtn);
        this.resetBtn=this.addTeacherMain.findViewById(R.id.teacherResetBtn);
        this.saveTeacherBtn=this.addTeacherMain.findViewById(R.id.teacherSaveTeacherBtn);
        // initializing edit texts
        this.firstNameEd=this.addTeacherMain.findViewById(R.id.teacherFirstNameEd);
        this.lastNameEd=this.addTeacherMain.findViewById(R.id.teacherLastNameEd);
        this.teacherIdEd=this.addTeacherMain.findViewById(R.id.teacherIdEd);
        this.subjectNameEd=this.addTeacherMain.findViewById(R.id.teacherSubjectNameEd);
        this.phoneNumberEd=this.addTeacherMain.findViewById(R.id.teacherPhoneNumberEd);
    }
    private void setEventHandlers(){
        this.resetBtn.setOnClickListener(this::resetBtnHandler);
        this.goBackBtn.setOnClickListener(this::goBackBtnHandler);
        this.saveTeacherBtn.setOnClickListener(this.addTeacherMain.addTeacSaveTeacBtnHandler);
    }

    private void resetBtnHandler(View view){
        if (this.ifSomeFieldIsFilled()) this.addTeacherMain.addTeacSaveTeacBtnHandler.makeToast("Every field cleared");
        this.firstNameEd.setText(null);
        this.lastNameEd.setText(null);
        this.teacherIdEd.setText(null);
        this.subjectNameEd.setText(null);
        this.phoneNumberEd.setText(null);
    }
    private boolean ifSomeFieldIsFilled(){
        boolean bool=
                String.valueOf(this.firstNameEd.getText()).isEmpty() &&
                String.valueOf(this.lastNameEd.getText()).isEmpty() &&
                String.valueOf(this.teacherIdEd.getText()).isEmpty() &&
                String.valueOf(this.subjectNameEd.getText()).isEmpty() &&
                String.valueOf(this.phoneNumberEd.getText()).isEmpty();
        return !bool;
    }

    private void goBackBtnHandler(View view){
        this.addTeacherMain.finish();
    }
}