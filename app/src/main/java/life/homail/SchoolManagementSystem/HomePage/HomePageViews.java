package life.homail.SchoolManagementSystem.HomePage;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import life.homail.SchoolManagementSystem.AddStudent.AddStdMain;
import life.homail.SchoolManagementSystem.AddTeacher.AddTeacherMain;
import life.homail.SchoolManagementSystem.R;
public class HomePageViews {
    // fields
    private HomeMain homeMain;
    protected Button addStudentBtn;
    protected Button addTeacherBtn;
    protected Button viewStudentsBtn;
    protected Button viewTeachersBtn;
    protected TextView collegeNameTv;
    // constructor
    public HomePageViews(HomeMain homeMain) {
        this.homeMain = homeMain;
        this.initializeViews();
        this.handleEvents();
    }
    // methods
    private void initializeViews(){
        this.collegeNameTv=this.homeMain.findViewById(R.id.collegeNameTv);
        this.addStudentBtn=this.homeMain.findViewById(R.id.addStudentBtn);
        this.addTeacherBtn=this.homeMain.findViewById(R.id.addTeacherBtn);
        this.viewStudentsBtn=this.homeMain.findViewById(R.id.viewStudentsBtn);
        this.viewTeachersBtn=this.homeMain.findViewById(R.id.viewTeachersBtn);
    }
    private void handleEvents(){
        this.addStudentBtn.setOnClickListener(e->{
            this.changeIntent(AddStdMain.class);
        });
        this.addTeacherBtn.setOnClickListener(e->{
            this.changeIntent(AddTeacherMain.class);
        });
        this.viewStudentsBtn.setOnClickListener(e->{
        });
        this.viewTeachersBtn.setOnClickListener(e->{
        });
    }

    private void changeIntent(Class<? extends AppCompatActivity> classToSwitchToo){
        Intent intent=new Intent(this.homeMain,classToSwitchToo);
        this.homeMain.startActivity(intent);
    }
}
