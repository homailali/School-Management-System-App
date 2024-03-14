package life.homail.SchoolManagementSystem.ViewStudents;
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
        String firstName=this.oldStudentModel.getFirstName();
        String lastName=this.oldStudentModel.getLastName();
        long rollNo= oldStudentModel.getRollNumber();
        String className=oldStudentModel.getClassName();
        String contactNumber=oldStudentModel.getContactNumber();
        this.viewStudentMain.viewStdEditDialogClass.editDialogFirstNameEd.setText(firstName);
        this.viewStudentMain.viewStdEditDialogClass.editDialogLastNameEd.setText(lastName);
        this.viewStudentMain.viewStdEditDialogClass.editDialogRollNoEd.setText(String.valueOf(rollNo));
        this.viewStudentMain.viewStdEditDialogClass.editDialogClassNameEd.setText(className);
        this.viewStudentMain.viewStdEditDialogClass.editDialogContactNumberEd.setText(contactNumber);
    }
    protected void saveBtnHandler(){
       StudentModel newStudentModel=makeNewStudentModel();
        if (this.ifAnyFieldIsEmpty(newStudentModel)) {
            MyToast.makeToast("Fill all fields correctly",this.viewStudentMain);
            return;
        } else if (this.oldStudentModel.equals(newStudentModel)){
            MyToast.makeToast("Student data has not been modified",this.viewStudentMain);
            return;
        }
        boolean bool=SingleTon.getSingleTon().getHomeMain().homeStudentsDb.updateStudentData(oldStudentModel,newStudentModel);
        if (bool) this.ifDataSuccessfullyUpdatedInDb(newStudentModel);
        else MyToast.makeToast("Could not update student's data",this.viewStudentMain);
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
    private void ifDataSuccessfullyUpdatedInDb(StudentModel newStudentModel){
        this.updateDataInArrayListAndSetLayoutHeight(newStudentModel);
        MyToast.makeToast("Student data updated successfully",this.viewStudentMain);
        this.viewStudentMain.viewStdEditDialogClass.getEditDialog().dismiss();
    }
    private void updateDataInArrayListAndSetLayoutHeight(StudentModel newStudentModel){
        SingleTon.getSingleTon().getStudentModelArrayList().set(this.position,newStudentModel);
        this.viewStudentMain.viewStdRcView.setAdapter(this.viewStudentMain.viewStdAdapter);
    }
    private boolean ifAnyFieldIsEmpty(StudentModel newStudentModel){
        return newStudentModel.getFirstName().isBlank() ||
        newStudentModel.getLastName().isBlank() ||
        String.valueOf(newStudentModel.getRollNumber()).isBlank() ||
        newStudentModel.getClassName().isBlank() ||
        newStudentModel.getContactNumber().isBlank();
    }
}