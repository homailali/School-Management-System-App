package life.homail.SchoolManagementSystem.ViewStudents;

import android.util.Log;

import life.homail.SchoolManagementSystem.ModelClasses.StudentModel;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;

public class ViewStdEditBtnHandler{
    private StudentModel studentModel;
    private ViewStudentMain viewStudentMain;
    protected ViewStdEditBtnHandler(ViewStudentMain viewStudentMain){
        this.viewStudentMain = viewStudentMain;
    }
    protected void viewStdEditBtnHandlerMain(int position){
        this.studentModel= SingleTon.getSingleTon().getStudentModelArrayList().get(position);
        this.viewStudentMain.viewStdDialogClass.getDialog().show();
        try {
            this.setTextOnDialog();
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }



    private void setTextOnDialog(){
        String firstName=this.studentModel.getFirstName();
        String lastName=this.studentModel.getLastName();
        long rollNo= studentModel.getRollNumber();
        String className=studentModel.getClassName();
        String contactNumber=studentModel.getContactNumber();

        Log.d("temp",firstName);
        Log.d("temp",lastName);
        Log.d("temp",String.valueOf(rollNo));
        Log.d("temp",className);
        Log.d("temp",contactNumber);


        this.viewStudentMain.viewStdDialogClass.dialogFirstNameEd.setText(firstName);
        this.viewStudentMain.viewStdDialogClass.dialogLastNameEd.setText(lastName);
        this.viewStudentMain.viewStdDialogClass.dialogRollNoEd.setText(String.valueOf(rollNo));
        this.viewStudentMain.viewStdDialogClass.dialogClassNameEd.setText(className);
        this.viewStudentMain.viewStdDialogClass.dialogContactNumberEd.setText(contactNumber);
    }
}
