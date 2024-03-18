package life.homail.SchoolManagementSystem.ViewTeachers;

import android.app.Dialog;
import android.widget.Button;

import life.homail.SchoolManagementSystem.R;

public class ViewTeachersDeleteDialogClass {
    private Button deleteDialogNoBtn;
    private Button deleteDialogYesBtn;
    private Dialog teacherDeleteDialog;
    private ViewTeachersMain viewTeachersMain;
    protected ViewTeachersDeleteDialogClass(ViewTeachersMain viewTeachersMain){
        this.viewTeachersMain=viewTeachersMain;
        this.setUpDialog();
    }

    private void setUpDialog(){
        this.teacherDeleteDialog=new Dialog(this.viewTeachersMain);
        this.teacherDeleteDialog.setContentView(R.layout.view_std_teacher_delete_dialog);
        this.teacherDeleteDialog.setCancelable(false);
        this.initializeViews();
        this.setEventHandlers();
    }
    private void initializeViews(){
        this.deleteDialogNoBtn=this.teacherDeleteDialog.findViewById(R.id.deleteDialogNoBtn);
        this.deleteDialogYesBtn=this.teacherDeleteDialog.findViewById(R.id.deleteDialogYesBtn);
    }
    private void setEventHandlers(){
        this.deleteDialogNoBtn.setOnClickListener((view) ->{
            this.teacherDeleteDialog.dismiss();
        });
        this.deleteDialogYesBtn.setOnClickListener((view)->{
            this.viewTeachersMain.viewTeacherDeleteBtnHandler.deleteTeacher();
        });
    }

    public Dialog getTeacherDeleteDialog() {
        return teacherDeleteDialog;
    }

    public void setTeacherDeleteDialog(Dialog teacherDeleteDialog) {
        this.teacherDeleteDialog = teacherDeleteDialog;
    }
}