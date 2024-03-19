package life.homail.SchoolManagementSystem.ViewTeachers;

import android.app.Dialog;
import android.widget.Button;
import android.widget.EditText;

import life.homail.SchoolManagementSystem.R;

public class ViewTeachersEditDialogClass {
    private Dialog viewTeacherDialog;
    private ViewTeachersMain viewTeachersMain;

    private Button viewTeacherCancelBtn;
    private Button viewTeacherSaveBtn;

    private EditText teacherEditDialogIdEd;
    private EditText teacherEditDialogLastNameEd;
    private EditText teacherEditDialogFirstNameEd;
    private EditText teacherEditDialogSubjectNameEd;
    private EditText teacherEditDialogPhoneNumberEd;


    protected ViewTeachersEditDialogClass(ViewTeachersMain viewTeachersMain){
        this.viewTeachersMain=viewTeachersMain;
        this.setUpDialog();
    }
    private void setUpDialog(){
        this.initialSettings();
        this.initializeViews();
        this.setEventHandler();
    }
    private void initialSettings(){
        this.viewTeacherDialog=new Dialog(this.viewTeachersMain);
        this.viewTeacherDialog.setCancelable(false);
        this.viewTeacherDialog.setContentView(R.layout.view_teacher_edit_dialog);
    }
    private void initializeViews(){
        this.viewTeacherSaveBtn=this.viewTeacherDialog.findViewById(R.id.viewTeacherSaveBtn);
        this.viewTeacherCancelBtn=this.viewTeacherDialog.findViewById(R.id.viewTeacherCancelBtn);
        this.teacherEditDialogIdEd=this.viewTeacherDialog.findViewById(R.id.teacherEditDialogIdEd);
        this.teacherEditDialogLastNameEd=this.viewTeacherDialog.findViewById(R.id.teacherEditDialogLastNameEd);
        this.teacherEditDialogFirstNameEd=this.viewTeacherDialog.findViewById(R.id.teacherEditDialogFirstNameEd);
        this.teacherEditDialogSubjectNameEd=this.viewTeacherDialog.findViewById(R.id.teacherEditDialogSubjectNameEd);
        this.teacherEditDialogPhoneNumberEd=this.viewTeacherDialog.findViewById(R.id.teacherEditDialogPhoneNumberEd);
    }
    private void setEventHandler(){
        this.viewTeacherCancelBtn.setOnClickListener(e->{
            this.viewTeacherDialog.dismiss();
        });
        this.viewTeacherSaveBtn.setOnClickListener(e->{
            this.viewTeachersMain.viewTeacherEditBtnHandler.saveTeachersData();
        });
    }

    public Dialog getViewTeacherDialog() {
        return viewTeacherDialog;
    }

    public void setViewTeacherDialog(Dialog viewTeacherDialog) {
        this.viewTeacherDialog = viewTeacherDialog;
    }

    public Button getViewTeacherCancelBtn() {
        return viewTeacherCancelBtn;
    }

    public void setViewTeacherCancelBtn(Button viewTeacherCancelBtn) {
        this.viewTeacherCancelBtn = viewTeacherCancelBtn;
    }

    public Button getViewTeacherSaveBtn() {
        return viewTeacherSaveBtn;
    }

    public void setViewTeacherSaveBtn(Button viewTeacherSaveBtn) {
        this.viewTeacherSaveBtn = viewTeacherSaveBtn;
    }

    public EditText getTeacherEditDialogIdEd() {
        return teacherEditDialogIdEd;
    }

    public void setTeacherEditDialogIdEd(EditText teacherEditDialogIdEd) {
        this.teacherEditDialogIdEd = teacherEditDialogIdEd;
    }

    public EditText getTeacherEditDialogLastNameEd() {
        return teacherEditDialogLastNameEd;
    }

    public void setTeacherEditDialogLastNameEd(EditText teacherEditDialogLastNameEd) {
        this.teacherEditDialogLastNameEd = teacherEditDialogLastNameEd;
    }

    public EditText getTeacherEditDialogFirstNameEd() {
        return teacherEditDialogFirstNameEd;
    }

    public void setTeacherEditDialogFirstNameEd(EditText teacherEditDialogFirstNameEd) {
        this.teacherEditDialogFirstNameEd = teacherEditDialogFirstNameEd;
    }

    public EditText getTeacherEditDialogSubjectNameEd() {
        return teacherEditDialogSubjectNameEd;
    }

    public void setTeacherEditDialogSubjectNameEd(EditText teacherEditDialogSubjectNameEd) {
        this.teacherEditDialogSubjectNameEd = teacherEditDialogSubjectNameEd;
    }

    public EditText getTeacherEditDialogPhoneNumberEd() {
        return teacherEditDialogPhoneNumberEd;
    }

    public void setTeacherEditDialogPhoneNumberEd(EditText teacherEditDialogPhoneNumberEd) {
        this.teacherEditDialogPhoneNumberEd = teacherEditDialogPhoneNumberEd;
    }
}
