package life.homail.SchoolManagementSystem.ViewStudents;

import android.app.Dialog;

import life.homail.SchoolManagementSystem.R;

public class ViewStdDialogClass {
    private ViewStudentMain viewStudentMain;
    private Dialog dialog;
    protected ViewStdDialogClass (ViewStudentMain viewStudentMain){
        this.viewStudentMain =  viewStudentMain;
        this.setUpDialog();
    }



    private void setUpDialog(){
        this.dialog=new Dialog(this.viewStudentMain);
        this.dialog.setContentView(R.layout.view_std_dialog);
        this.dialog.setCancelable(false);
    }
    protected Dialog getDialog(){
        return dialog;
    }
    protected void setDialog(Dialog dialog){
        this.dialog = dialog;
    }
}