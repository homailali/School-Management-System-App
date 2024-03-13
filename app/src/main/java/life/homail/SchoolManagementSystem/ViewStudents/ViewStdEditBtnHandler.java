package life.homail.SchoolManagementSystem.ViewStudents;
public class ViewStdEditBtnHandler{
    private ViewStudentMain viewStudentMain;
    protected ViewStdEditBtnHandler(ViewStudentMain viewStudentMain){
        this.viewStudentMain = viewStudentMain;
    }
    protected void viewStdEditBtnHandlerMain(int position){
        this.viewStudentMain.viewStdDialogClass.getDialog().show();
    }
}
