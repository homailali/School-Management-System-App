package life.homail.SchoolManagementSystem.HomePage;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import life.homail.SchoolManagementSystem.AddStudent.AddStdMain;
import life.homail.SchoolManagementSystem.AddTeacher.AddTeacherMain;
import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;

public class HomePageViews {
    // fields
    private HomeMain homeMain;
    protected Button addStudentBtn;
    protected Button addTeacherBtn;
    protected Button viewStudentsBtn;
    protected Button viewTeachersBtn;
    protected TextView totalTeacherNumberTv;
    protected TextView totalStudentNumberTv;
    // constructor
    public HomePageViews(HomeMain homeMain) {
        this.homeMain = homeMain;
        this.initializeViews();
        this.handleEvents();
    }
    // methods
    private void initializeViews(){
        this.addStudentBtn=this.homeMain.findViewById(R.id.addStudentBtn);
        this.addTeacherBtn=this.homeMain.findViewById(R.id.addTeachetBtn);
        this.viewStudentsBtn=this.homeMain.findViewById(R.id.viewStudentsBtn);
        this.viewTeachersBtn=this.homeMain.findViewById(R.id.viewTeachersBtn);
        this.totalStudentNumberTv=this.homeMain.findViewById(R.id.totalStudentsNumberTv);
        this.totalTeacherNumberTv=this.homeMain.findViewById(R.id.totalTeacherNumberTv);
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
    private void setStudentsAndTeachersCountOnTv(){
        int stdNumber=SingleTon.getSingleTon().getStudentModelArrayList().size();
        int teacherNumber=SingleTon.getSingleTon().getTeacherModelArrayList().size();
        this.totalStudentNumberTv.setText(String.valueOf(stdNumber));
        this.totalTeacherNumberTv.setText(String.valueOf(teacherNumber));
    }
}
