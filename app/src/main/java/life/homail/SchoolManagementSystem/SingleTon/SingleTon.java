package life.homail.SchoolManagementSystem.SingleTon;

import java.util.ArrayList;

import life.homail.SchoolManagementSystem.HomePage.HomeMain;
import life.homail.SchoolManagementSystem.ModelClasses.StudentModel;
import life.homail.SchoolManagementSystem.ModelClasses.TeacherModel;
import life.homail.SchoolManagementSystem.InstitutionInfo.InstitutionInfoMain;
import life.homail.SchoolManagementSystem.SplashScreen.SplashScreenMain;

public final class SingleTon {
    // Fields
    private HomeMain homeMain;
    private SplashScreenMain splashScreenMain;
    private static final SingleTon SINGLE_TON=new SingleTon();
    private ArrayList<StudentModel> studentModelArrayList=new ArrayList<>();
    private ArrayList<TeacherModel> teacherModelArrayList=new ArrayList<>();
    // Methods


    // getters
    public HomeMain getHomeMain() {

        return homeMain;
    }
    public static SingleTon getSingleTon(){

        return SINGLE_TON;
    }
    public SplashScreenMain getSplashScreenMain() {

        return splashScreenMain;
    }
    public ArrayList<StudentModel> getStudentModelArrayList() {

        return studentModelArrayList;
    }
    public ArrayList<TeacherModel> getTeacherModelArrayList() {

        return teacherModelArrayList;
    }

    // setters
    public void setHomeMain(HomeMain homeMain) {

        this.homeMain = homeMain;
    }
    public void setSplashScreenMain(SplashScreenMain splashScreenMain) {

        this.splashScreenMain = splashScreenMain;
    }
    public void setStudentModelArrayList(ArrayList<StudentModel> studentModelArrayList) {

        this.studentModelArrayList = studentModelArrayList;
    }
    public void setTeacherModelArrayList(ArrayList<TeacherModel> teacherModelArrayList) {

        this.teacherModelArrayList = teacherModelArrayList;
    }
}