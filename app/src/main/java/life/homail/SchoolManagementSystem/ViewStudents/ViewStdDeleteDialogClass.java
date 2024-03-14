package life.homail.SchoolManagementSystem.ViewStudents;

import android.app.Dialog;

public class ViewStdDeleteDialogClass {
    private ViewStudentMain viewStudentMain;

    private Dialog dialog;

    protected ViewStdDeleteDialogClass(ViewStudentMain viewStudentMain){
        this.viewStudentMain=viewStudentMain;
        this.setUpDialog();
    }



    private void setUpDialog(){
        this.dialog=new Dialog(this.viewStudentMain);
    }



    public Dialog getDialog() {
        return dialog;
    }
    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }
}
