package life.homail.SchoolManagementSystem.ViewTeachers;
import java.util.ArrayList;
import life.homail.SchoolManagementSystem.ModelClasses.TeacherModel;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
import life.homail.SchoolManagementSystem.Toast.MyToast;
public class ViewTeacherEditBtnHandler {
    private int position;
    private ViewTeachersMain viewTeachersMain;
    public ViewTeacherEditBtnHandler(ViewTeachersMain viewTeachersMain) {

        this.viewTeachersMain = viewTeachersMain;
    }
    protected void teacherEditBtnHandlerMain(int position){
        this.position=position;
        this.viewTeachersMain.viewTeachersEditDialogClass.getViewTeacherDialog().show();
        this.setTextOnDialogEds();
    }
    private void setTextOnDialogEds(){
        TeacherModel teacherModel= SingleTon.getSingleTon().getTeacherModelArrayList().get(position);
        this.viewTeachersMain.viewTeachersEditDialogClass.getTeacherEditDialogFirstNameEd().setText(teacherModel.getTeacherFirstName());
        this.viewTeachersMain.viewTeachersEditDialogClass.getTeacherEditDialogLastNameEd().setText(teacherModel.getTeacherLastName());
        this.viewTeachersMain.viewTeachersEditDialogClass.getTeacherEditDialogIdEd().setText(String.valueOf(teacherModel.getTeacherId()));
        this.viewTeachersMain.viewTeachersEditDialogClass.getTeacherEditDialogSubjectNameEd().setText(teacherModel.getTeacherSubject());
        this.viewTeachersMain.viewTeachersEditDialogClass.getTeacherEditDialogPhoneNumberEd().setText(teacherModel.getTeacherPhoneNumber());
    }
    protected void saveTeachersData(){
        TeacherModel newTeacherModel=this.createNewTeacherModel();
        TeacherModel oldTeacherModel=SingleTon.getSingleTon().getTeacherModelArrayList().get(position);
        if (newTeacherModel!=null) {
            String errorText = this.getErrorText(oldTeacherModel, newTeacherModel);
            if (errorText != null) MyToast.makeToast(errorText, this.viewTeachersMain);
            else this.updateTeachersData(oldTeacherModel, newTeacherModel);
        } else  MyToast.makeToast("Fill all fields correctly",this.viewTeachersMain);
    }
    private TeacherModel createNewTeacherModel(){
        try {
            String firstName = String.valueOf(this.viewTeachersMain.viewTeachersEditDialogClass.getTeacherEditDialogFirstNameEd().getText());
            String lastName = String.valueOf(this.viewTeachersMain.viewTeachersEditDialogClass.getTeacherEditDialogLastNameEd().getText());
            long id = Long.parseLong(String.valueOf(this.viewTeachersMain.viewTeachersEditDialogClass.getTeacherEditDialogIdEd().getText()));
            String subjectName = String.valueOf(this.viewTeachersMain.viewTeachersEditDialogClass.getTeacherEditDialogSubjectNameEd().getText());
            String phoneNumber = String.valueOf(this.viewTeachersMain.viewTeachersEditDialogClass.getTeacherEditDialogPhoneNumberEd().getText());
            String fullName = firstName + " " + lastName;
            return new TeacherModel(id,fullName,firstName,lastName,subjectName,phoneNumber);
        } catch (NumberFormatException numberFormatException){
            return null;
        }
    }
    private boolean ifDuplicatedId(TeacherModel newTeacherModel){
        ArrayList<TeacherModel> teacherModelsArrList=SingleTon.getSingleTon().getTeacherModelArrayList();
        for (int i=0;i<teacherModelsArrList.size();i++){
            if (i!=this.position){
                if (teacherModelsArrList.get(i).getTeacherId()== newTeacherModel.getTeacherId()) return true;
            }
        }
        return false;
    }
    private boolean ifSomeFieldIsEmpty(TeacherModel newTeacherModel){
        return
                newTeacherModel.getTeacherFirstName().isBlank() ||
                        newTeacherModel.getTeacherLastName().isBlank() ||
                        String.valueOf(newTeacherModel.getTeacherId()).isBlank() ||
                        newTeacherModel.getTeacherSubject().isBlank() ||
                        newTeacherModel.getTeacherPhoneNumber().isBlank()
                ;
    }
    private String getErrorText(TeacherModel oldTeacherModel,TeacherModel newTeacherModel){
        String errorText=
                this.ifSomeFieldIsEmpty(newTeacherModel)?"Fill all fields correctly":
                oldTeacherModel.equals(newTeacherModel)?"Teacher data has not been modified":
                this.ifDuplicatedId(newTeacherModel)?"Duplicated id is not allowed":
                null;
        return errorText;
    }
    private void updateTeachersData(TeacherModel oldTeacherModel,TeacherModel newTeacherModel){
        boolean bool=SingleTon.getSingleTon().getHomeMain().homeTeachersDb.updateTeacherData(oldTeacherModel,newTeacherModel);
        if (bool){
            MyToast.makeToast("Teacher data updated successfully",this.viewTeachersMain);
            this.viewTeachersMain.viewTeachersEditDialogClass.getViewTeacherDialog().dismiss();
            SingleTon.getSingleTon().setTeacherModelArrayList(SingleTon.getSingleTon().getHomeMain().homeTeachersDb.getAllTeachers());
            this.viewTeachersMain.viewTeachersMainViews.viewTeacherRcView.setAdapter(this.viewTeachersMain.viewTeachersAdapter);
        } else MyToast.makeToast("Could not update teacher's data",this.viewTeachersMain);
    }
}