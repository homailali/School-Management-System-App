package life.homail.SchoolManagementSystem.AddStudent;

import android.view.View;
import android.widget.Toast;

import life.homail.SchoolManagementSystem.ModelClasses.StudentModel;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;

public class AddStdSaveStdBtnHandler implements View.OnClickListener{
    private AddStdMain addStdMain;
    private int rollNo;
    private String firstName;
    private String lastname;
    private String className;
    private String phoneNumber;
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
        StudentModel studentModel=new StudentModel(this.rollNo,this.fullName,this.className,this.phoneNumber);
        SingleTon.getSingleTon().getStudentModelArrayList().add(studentModel);
        boolean bool=SingleTon.getSingleTon().getHomeMain().homeStudentsDb.addStudent(studentModel);
        if (bool) {
            this.clearDataFromFields();
            this.makeToast("Student saved successfully");
        }
        else this.onError("Could not save student");
    }


    private void clearDataFromFields(){
        this.addStdMain.addStdViews.getFirstNameEd().setText(null);
        this.addStdMain.addStdViews.getLastNameEd().setText(null);
        this.addStdMain.addStdViews.getRollNoEd().setText(null);
        this.addStdMain.addStdViews.getClassEd().setText(null);
        this.addStdMain.addStdViews.getPhoneNoEd().setText(null);
    }
    private boolean ifSomeDataIsNotCorrect(){
        if (
                firstName.isBlank() || lastname.isBlank() || className.isBlank() || phoneNumber.isBlank()
                || String.valueOf(this.addStdMain.addStdViews.getRollNoEd().getText()).isBlank()

        ) return true;
        return false;
    }
    private void extractDataFromFields(){
        try {
            this.firstName = String.valueOf(this.addStdMain.addStdViews.getFirstNameEd().getText());
            this.lastname = String.valueOf(this.addStdMain.addStdViews.getLastNameEd().getText());
            this.rollNo = Integer.parseInt(String.valueOf(this.addStdMain.addStdViews.getRollNoEd().getText()));
            this.className = String.valueOf(this.addStdMain.addStdViews.getClassEd().getText());
            this.phoneNumber = String.valueOf(this.addStdMain.addStdViews.getPhoneNoEd().getText());
            this.fullName = firstName+" "+lastname;
        } catch (Exception ignored){}
    }
    private void onError(String toastText){

        this.makeToast(toastText);
    }
    private void makeToast(String toastText){
        if (toast!=null) toast.cancel();
        toast=Toast.makeText(this.addStdMain,toastText,Toast.LENGTH_SHORT);
        toast.show();
    }
}
