package life.homail.SchoolManagementSystem.ViewStudents;
import life.homail.SchoolManagementSystem.ModelClasses.StudentModel;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
import life.homail.SchoolManagementSystem.Toast.MyToast;
public class ViewStdDeleteBtnHandler {
    private int position;
    private ViewStudentMain viewStudentMain;
    protected ViewStdDeleteBtnHandler (ViewStudentMain viewStudentMain){
        this.viewStudentMain=viewStudentMain;
    }
    protected void viewStdDeleteBtnHandlerMain(int position){
        this.position=position;
        this.viewStudentMain.viewStdDeleteDialogClass.getDeleteDialog().show();
    }
    protected void removeItem(){
        StudentModel modelToDelete=SingleTon.getSingleTon().getStudentModelArrayList().get(this.position);
        boolean bool=SingleTon.getSingleTon().getHomeMain().homeStudentsDb.deleteStudent(modelToDelete);
        if (bool){
            MyToast.makeToast("Student deleted successfully",this.viewStudentMain);
            SingleTon.getSingleTon().getStudentModelArrayList().remove(this.position);
            this.viewStudentMain.viewStdAdapter.notifyDataSetChanged();
            this.viewStudentMain.viewStdDeleteDialogClass.getDeleteDialog().dismiss();
        } else MyToast.makeToast("Student could not be deleted",this.viewStudentMain);
    }
}
