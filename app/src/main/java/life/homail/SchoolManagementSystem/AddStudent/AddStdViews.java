package life.homail.SchoolManagementSystem.AddStudent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import life.homail.SchoolManagementSystem.R;
public class AddStdViews {
    protected AddStdMain addStdMain;
    protected Button goBackBtn;
    protected Button saveStdBtn;
    protected Button resetBtn;
    protected EditText firstNameEd;
    protected EditText lastNameEd;
    protected EditText rollNoEd;
    protected EditText classEd;
    protected EditText contactNoEd;

    protected AddStdViews(AddStdMain addStdMain) {
        this.addStdMain = addStdMain;
        this.initializeViews();
        this.setEventHandlers();
    }

    private void initializeViews(){
        this.resetBtn=this.addStdMain.findViewById(R.id.resetBtn);
        this.goBackBtn=this.addStdMain.findViewById(R.id.goBackBtn);
        this.saveStdBtn=this.addStdMain.findViewById(R.id.saveStudentBtn);
        // initializing edit texts
        this.firstNameEd=this.addStdMain.findViewById(R.id.studentFirstNameEd);
        this.lastNameEd=this.addStdMain.findViewById(R.id.studentLastNameEd);
        this.rollNoEd=this.addStdMain.findViewById(R.id.studentRollNoEd);
        this.classEd=this.addStdMain.findViewById(R.id.studentClassNameEd);
        this.contactNoEd=this.addStdMain.findViewById(R.id.studentContactNumberEd);
    }
    private void setEventHandlers(){
        this.resetBtn.setOnClickListener(this::resetBtnHandler);
        this.goBackBtn.setOnClickListener(this::goBackBtnHandler);
        this.saveStdBtn.setOnClickListener(this.addStdMain.addStdSaveStdBtnHandler);
    }
    private void resetBtnHandler(View view){
        if (this.ifSomeFieldIsNotEmpty()) this.addStdMain.addStdSaveStdBtnHandler.makeToast("Every field cleared");
        this.firstNameEd.setText(null);
        this.lastNameEd.setText(null);
        this.rollNoEd.setText(null);
        this.classEd.setText(null);
        this.contactNoEd.setText(null);
    }
    private boolean ifSomeFieldIsNotEmpty(){
        boolean bool=
                String.valueOf(this.firstNameEd.getText()).isEmpty() &&
                String.valueOf(this.lastNameEd.getText()).isEmpty() &&
                String.valueOf(this.rollNoEd.getText()).isEmpty() &&
                String.valueOf(this.contactNoEd.getText()).isEmpty();
        return !bool;
    }
    private void goBackBtnHandler(View view){
        this.addStdMain.finish();
    }


}
