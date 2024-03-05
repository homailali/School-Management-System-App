package life.homail.SchoolManagementSystem.AddTeacher;



import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import life.homail.SchoolManagementSystem.R;

public class AddTeacherViews {
    // fields
    protected AddTeacherMain addTeacherMain;
    protected Button goBackBtn;
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
        this.goBackBtn=this.addTeacherMain.findViewById(R.id.goBackBtn);
        this.saveTeacherBtn=this.addTeacherMain.findViewById(R.id.saveTeacherBtn);
        // initializing edit texts
        this.firstNameEd=this.addTeacherMain.findViewById(R.id.firstNameEd);
        this.lastNameEd=this.addTeacherMain.findViewById(R.id.lastNameEd);
        this.teacherIdEd=this.addTeacherMain.findViewById(R.id.teacherIdEd);
        this.subjectNameEd=this.addTeacherMain.findViewById(R.id.subjectNameEd);
        this.phoneNumberEd=this.addTeacherMain.findViewById(R.id.phoneNumberEd);
    }
    private void setEventHandlers(){
        this.goBackBtn.setOnClickListener(this::goBackBtnHandler);
        this.saveTeacherBtn.setOnClickListener(this.addTeacherMain.addTeacSaveTeacBtnHandler);
    }
    private void goBackBtnHandler(View view){
        this.addTeacherMain.finish();
    }
}