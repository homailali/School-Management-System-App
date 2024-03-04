package life.homail.SchoolManagementSystem.SingleTon;

import java.util.ArrayList;

import life.homail.SchoolManagementSystem.HomePage.HomeMain;
import life.homail.SchoolManagementSystem.ModelClasses.StudentModel;
import life.homail.SchoolManagementSystem.ModelClasses.TeacherModel;

public final class SingleTon {
    // Fields
    private ArrayList<StudentModel> studentModelArrayList=new ArrayList<>();
    private ArrayList<TeacherModel> teacherModelArrayList=new ArrayList<>();


    private HomeMain homeMain;
    private static final SingleTon SINGLE_TON=new SingleTon();
    // Methods
    public static SingleTon getSingleTon(){
        return SINGLE_TON;
    }
    public HomeMain getHomeMain() {
        return homeMain;
    }
    public void setHomeMain(HomeMain homeMain) {
        this.homeMain = homeMain;
    }

    public ArrayList<StudentModel> getStudentModelArrayList() {
        return studentModelArrayList;
    }

    public void setStudentModelArrayList(ArrayList<StudentModel> studentModelArrayList) {
        this.studentModelArrayList = studentModelArrayList;
    }

    public ArrayList<TeacherModel> getTeacherModelArrayList() {
        return teacherModelArrayList;
    }

    public void setTeacherModelArrayList(ArrayList<TeacherModel> teacherModelArrayList) {
        this.teacherModelArrayList = teacherModelArrayList;
    }
}
