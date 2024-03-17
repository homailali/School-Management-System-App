package life.homail.SchoolManagementSystem.ViewStudents;
import java.util.ArrayList;

import life.homail.SchoolManagementSystem.ModelClasses.StudentModel;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
import life.homail.SchoolManagementSystem.Toast.MyToast;
public class ViewStdEditBtnHandler{
    private int position;
    private StudentModel oldStudentModel;
    private ViewStudentMain viewStudentMain;
    protected ViewStdEditBtnHandler(ViewStudentMain viewStudentMain){
        this.viewStudentMain = viewStudentMain;
    }
    protected void viewStdEditBtnHandlerMain(int receivedPosition){
        this.position=receivedPosition;
        this.oldStudentModel= SingleTon.getSingleTon().getStudentModelArrayList().get(position);
        this.viewStudentMain.viewStdEditDialogClass.getEditDialog().show();
        this.setTextOnDialog();
    }
    private void setTextOnDialog(){
        String firstName=this.oldStudentModel.getStudentFirstName();
        String lastName=this.oldStudentModel.getStudentLastName();
        long rollNo= oldStudentModel.getStudentRollNumber();
        String className=oldStudentModel.getStudentClassName();
        String contactNumber=oldStudentModel.getStudentContactNumber();
        this.viewStudentMain.viewStdEditDialogClass.editDialogFirstNameEd.setText(firstName);
        this.viewStudentMain.viewStdEditDialogClass.editDialogLastNameEd.setText(lastName);
        this.viewStudentMain.viewStdEditDialogClass.editDialogRollNoEd.setText(String.valueOf(rollNo));
        this.viewStudentMain.viewStdEditDialogClass.editDialogClassNameEd.setText(className);
        this.viewStudentMain.viewStdEditDialogClass.editDialogContactNumberEd.setText(contactNumber);
    }
    protected void saveBtnHandler(){
        StudentModel newStudentModel=makeNewStudentModel();
        String toastText=
                this.ifAnyFieldIsEmpty(newStudentModel) ? "Fill all fields correctly":
                this.oldStudentModel.equals(newStudentModel) ? "Student data has not been modified":
                this.ifRollNoAlreadyExistsInDB(newStudentModel) ? "Student with this roll no already exists":
                null;
        if (toastText!=null){
            MyToast.makeToast(toastText,this.viewStudentMain);
            return;
        }
        boolean bool=SingleTon.getSingleTon().getHomeMain().homeStudentsDb.updateStudentData(oldStudentModel,newStudentModel);
        if (bool) this.ifDataSuccessfullyUpdatedInDb();
        else MyToast.makeToast("Could not update student's data",this.viewStudentMain);
    }



    private boolean ifRollNoAlreadyExistsInDB(StudentModel newStudentModel){
        ArrayList<StudentModel> studentModelsArr=new ArrayList<>(SingleTon.getSingleTon().getStudentModelArrayList());
        for (int i=0;i< studentModelsArr.size();i++){
            if (i!=this.position && studentModelsArr.get(i).getStudentRollNumber()== newStudentModel.getStudentRollNumber()) return true;
        }
        return false;
    }



    private StudentModel makeNewStudentModel(){
        String stdFirstName=String.valueOf(this.viewStudentMain.viewStdEditDialogClass.editDialogFirstNameEd.getText());
        String stdLastName=String.valueOf(this.viewStudentMain.viewStdEditDialogClass.editDialogLastNameEd.getText());
        String stdFullName=stdFirstName+" "+stdLastName;
        long stdRollNo=Long.parseLong(String.valueOf(this.viewStudentMain.viewStdEditDialogClass.editDialogRollNoEd.getText()));
        String stdClassName=String.valueOf(this.viewStudentMain.viewStdEditDialogClass.editDialogClassNameEd.getText());
        String stdContactNumber=String.valueOf(this.viewStudentMain.viewStdEditDialogClass.editDialogContactNumberEd.getText());
        StudentModel newStudentModel=new StudentModel(stdRollNo,stdFullName,stdFirstName,stdLastName,stdClassName,stdContactNumber);
        return newStudentModel;
    }
    private void ifDataSuccessfullyUpdatedInDb(){
        this.updateDataInArrayListAndSetLayoutHeight();
        MyToast.makeToast("Student data updated successfully",this.viewStudentMain);
        this.viewStudentMain.viewStdEditDialogClass.getEditDialog().dismiss();
    }
    private void updateDataInArrayListAndSetLayoutHeight(){
        SingleTon.getSingleTon().setStudentModelArrayList(SingleTon.getSingleTon().getHomeMain().homeStudentsDb.getAllStudentsData());
        this.viewStudentMain.viewStudentMainViews.viewStdRcView.setAdapter(this.viewStudentMain.viewStdAdapter);
    }
    private boolean ifAnyFieldIsEmpty(StudentModel newStudentModel){
        return newStudentModel.getStudentFirstName().isBlank() ||
        newStudentModel.getStudentLastName().isBlank() ||
        String.valueOf(newStudentModel.getStudentRollNumber()).isBlank() ||
        newStudentModel.getStudentClassName().isBlank() ||
        newStudentModel.getStudentContactNumber().isBlank();
    }
}