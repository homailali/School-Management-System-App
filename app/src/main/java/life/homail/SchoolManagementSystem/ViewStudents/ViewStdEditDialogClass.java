package life.homail.SchoolManagementSystem.ViewStudents;
import android.app.Dialog;
import android.widget.Button;
import android.widget.EditText;
import life.homail.SchoolManagementSystem.R;
public class ViewStdEditDialogClass {
    private ViewStudentMain viewStudentMain;
    private Dialog editDialog;

    protected Button saveBtn;
    protected Button cancelBtn;
    protected EditText editDialogFirstNameEd;
    protected EditText editDialogLastNameEd;
    protected EditText editDialogRollNoEd;
    protected EditText editDialogClassNameEd;
    protected EditText editDialogContactNumberEd;



    protected ViewStdEditDialogClass(ViewStudentMain viewStudentMain){
        this.viewStudentMain =  viewStudentMain;
        this.setUpDialog();
        this.initializeDialogViews();
        this.setEventHandlers();
    }
    private void setUpDialog(){
        this.editDialog=new Dialog(this.viewStudentMain);
        this.editDialog.setContentView(R.layout.view_std_edit_dialog);
        this.editDialog.setCancelable(false);
    }
    private void initializeDialogViews(){
        // buttons
        this.saveBtn=this.editDialog.findViewById(R.id.saveBtn);
        this.cancelBtn=this.editDialog.findViewById(R.id.cancelBtn);
        // edittext's
        this.editDialogFirstNameEd=this.editDialog.findViewById(R.id.editDialogFirstNameEd);
        this.editDialogLastNameEd=this.editDialog.findViewById(R.id.editDialogLastNameEd);
        this.editDialogRollNoEd=this.editDialog.findViewById(R.id.editDialogRollNoEd);
        this.editDialogClassNameEd=this.editDialog.findViewById(R.id.editDialogClassNameEd);
        this.editDialogContactNumberEd=this.editDialog.findViewById(R.id.editDialogContactNumberEd);
    }
    private void setEventHandlers(){
        this.cancelBtn.setOnClickListener(e->{
            this.editDialog.dismiss();
        });
        this.saveBtn.setOnClickListener(e->{
            this.viewStudentMain.viewStdEditBtnHandler.saveBtnHandler();
        });
    }
    protected Dialog getEditDialog(){
        return editDialog;
    }
    protected void setEditDialog(Dialog editDialog){
        this.editDialog = editDialog;
    }
}