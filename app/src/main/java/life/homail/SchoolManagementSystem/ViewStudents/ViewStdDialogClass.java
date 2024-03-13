package life.homail.SchoolManagementSystem.ViewStudents;
import android.app.Dialog;
import android.widget.Button;
import android.widget.EditText;

import life.homail.SchoolManagementSystem.R;
public class ViewStdDialogClass{
    private ViewStudentMain viewStudentMain;
    private Dialog dialog;

    protected Button saveBtn;
    protected Button cancelBtn;
    protected EditText dialogFirstNameEd;
    protected EditText dialogLastNameEd;
    protected EditText dialogRollNoEd;
    protected EditText dialogClassNameEd;
    protected EditText dialogContactNumberEd;



    protected ViewStdDialogClass (ViewStudentMain viewStudentMain){
        this.viewStudentMain =  viewStudentMain;
        this.setUpDialog();
        this.initializeDialogViews();
        this.setEventHandlers();
    }
    private void setUpDialog(){
        this.dialog=new Dialog(this.viewStudentMain);
        this.dialog.setContentView(R.layout.view_std_dialog);
        this.dialog.setCancelable(false);
    }
    private void initializeDialogViews(){
        // buttons
        this.saveBtn=this.dialog.findViewById(R.id.saveBtn);
        this.cancelBtn=this.dialog.findViewById(R.id.cancelBtn);
        // edittext's
        this.dialogFirstNameEd=this.dialog.findViewById(R.id.dialogFirstNameEd);
        this.dialogLastNameEd=this.dialog.findViewById(R.id.dialogLastNameEd);
        this.dialogRollNoEd=this.dialog.findViewById(R.id.dialogRollNoEd);
        this.dialogClassNameEd=this.dialog.findViewById(R.id.dialogClassNameEd);
        this.dialogContactNumberEd=this.dialog.findViewById(R.id.dialogContactNumberEd);
    }

    private void setEventHandlers(){
        this.cancelBtn.setOnClickListener(e->{
            this.dialog.dismiss();
        });
    }

    protected Dialog getDialog(){
        return dialog;
    }
    protected void setDialog(Dialog dialog){
        this.dialog = dialog;
    }
}