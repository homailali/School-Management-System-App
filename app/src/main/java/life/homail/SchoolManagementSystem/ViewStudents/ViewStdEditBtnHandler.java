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
        this.viewStudentMain.viewStdEditDialogClass.getDialog().show();
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


        this.viewStudentMain.viewStdEditDialogClass.dialogFirstNameEd.setText(firstName);
        this.viewStudentMain.viewStdEditDialogClass.dialogLastNameEd.setText(lastName);
        this.viewStudentMain.viewStdEditDialogClass.dialogRollNoEd.setText(String.valueOf(rollNo));
        this.viewStudentMain.viewStdEditDialogClass.dialogClassNameEd.setText(className);
        this.viewStudentMain.viewStdEditDialogClass.dialogContactNumberEd.setText(contactNumber);
    }
}
