package life.homail.SchoolManagementSystem.ViewStudents;

import life.homail.SchoolManagementSystem.ModelClasses.StudentModel;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
import life.homail.SchoolManagementSystem.Toast.MyToast;

public class ViewStdDeleteBtnHandler {
    private ViewStudentMain viewStudentMain;
    protected ViewStdDeleteBtnHandler (ViewStudentMain viewStudentMain){
        this.viewStudentMain=viewStudentMain;
    }
    protected void viewStdDeleteBtnHandlerMain(int position){
        StudentModel modelToDelete=SingleTon.getSingleTon().getStudentModelArrayList().get(position);
        boolean bool=SingleTon.getSingleTon().getHomeMain().homeStudentsDb.deleteStudent(modelToDelete);
        if (bool){
            MyToast.makeToast("Student deleted successfully",this.viewStudentMain);
            SingleTon.getSingleTon().getStudentModelArrayList().remove(position);
            this.viewStudentMain.viewStdAdapter.notifyDataSetChanged();
        } else MyToast.makeToast("Student could not be deleted",this.viewStudentMain);
    }
}
