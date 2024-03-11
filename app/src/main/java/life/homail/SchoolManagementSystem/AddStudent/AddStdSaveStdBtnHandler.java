package life.homail.SchoolManagementSystem.AddStudent;

import android.view.View;
import android.widget.Toast;

import life.homail.SchoolManagementSystem.ModelClasses.StudentModel;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;

public class AddStdSaveStdBtnHandler implements View.OnClickListener{
    private AddStdMain addStdMain;
    private long rollNo;
    private String firstName;
    private String lastname;
    private String className;
    private String contactNumber;
    private String fullName;
    private Toast toast;

    public AddStdSaveStdBtnHandler(AddStdMain addStdMain) {
        this.addStdMain = addStdMain;
    }
    @Override
    public void onClick(View view){
        this.extractDataFromFields();
        if (this.ifSomeDataIsNotCorrect()) this.onError("Fill all fields correctly");
        else this.addDataToDb();
    }


    private void addDataToDb(){
        StudentModel studentModel=new StudentModel(this.rollNo,this.fullName,this.className,this.contactNumber);
        boolean bool=SingleTon.getSingleTon().getHomeMain().homeStudentsDb.addStudent(studentModel);
        if (bool) {
            this.clearDataFromFields();
            this.makeToast("Student saved successfully");
            SingleTon.getSingleTon().getStudentModelArrayList().add(studentModel);
        } else this.onError("Could not save student");
    }


    private void clearDataFromFields(){
        this.addStdMain.addStdViews.firstNameEd.setText(null);
        this.addStdMain.addStdViews.lastNameEd.setText(null);
        this.addStdMain.addStdViews.rollNoEd.setText(null);
        this.addStdMain.addStdViews.classEd.setText(null);
        this.addStdMain.addStdViews.contactNoEd.setText(null);
    }
    protected boolean ifSomeDataIsNotCorrect(){
        if (
                firstName.isBlank() || lastname.isBlank() || className.isBlank() || contactNumber.isBlank()
                || String.valueOf(this.addStdMain.addStdViews.rollNoEd.getText()).isBlank()

        ) return true;
        return false;
    }
    protected void extractDataFromFields(){
        try {
            this.firstName = String.valueOf(this.addStdMain.addStdViews.firstNameEd.getText());
            this.lastname = String.valueOf(this.addStdMain.addStdViews.lastNameEd.getText());
            this.rollNo = Long.parseLong(String.valueOf(this.addStdMain.addStdViews.rollNoEd.getText()));
            this.className = String.valueOf(this.addStdMain.addStdViews.classEd.getText());
            this.contactNumber = String.valueOf(this.addStdMain.addStdViews.contactNoEd.getText());
            this.fullName = firstName+" "+lastname;
        } catch (Exception ignored){}
    }
    private void onError(String toastText){

        this.makeToast(toastText);
    }
    protected void makeToast(String toastText){
        if (toast!=null) toast.cancel();
        toast=Toast.makeText(this.addStdMain,toastText,Toast.LENGTH_SHORT);
        toast.show();
    }
}
