package life.homail.SchoolManagementSystem.ViewStudents;

import android.app.Dialog;
import android.widget.Button;

import life.homail.SchoolManagementSystem.R;

public class ViewStdDeleteDialogClass {
    private ViewStudentMain viewStudentMain;
    private Dialog deleteDialog;
    private Button deleteDialogYesBtn;
    private Button deleteDialogNoBtn;
    protected ViewStdDeleteDialogClass(ViewStudentMain viewStudentMain){
        this.viewStudentMain=viewStudentMain;
        this.setUpDialog();
        this.initializeViews();
        this.setEventHandlers();
    }


    private void initializeViews(){
        this.deleteDialogNoBtn=this.deleteDialog.findViewById(R.id.deleteDialogNoBtn);
        this.deleteDialogYesBtn=this.deleteDialog.findViewById(R.id.deleteDialogYesBtn);
    }

    private void setUpDialog(){
        this.deleteDialog=new Dialog(this.viewStudentMain);
        this.deleteDialog.setContentView(R.layout.view_std_delete_dialog);
        this.deleteDialog.setCancelable(false);
    }

    private void setEventHandlers(){
        this.deleteDialogNoBtn.setOnClickListener(e->{
            this.deleteDialog.dismiss();
        });
        this.deleteDialogYesBtn.setOnClickListener(e->{
            this.viewStudentMain.viewStdDeleteBtnHandler.removeItem();
        });
    }



    public Dialog getDeleteDialog() {
        return deleteDialog;
    }
    public void setDeleteDialog(Dialog deleteDialog) {
        this.deleteDialog = deleteDialog;
    }
}
