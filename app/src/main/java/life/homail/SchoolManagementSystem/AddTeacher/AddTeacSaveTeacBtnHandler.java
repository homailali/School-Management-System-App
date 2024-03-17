package life.homail.SchoolManagementSystem.AddTeacher;
import android.view.View;
import android.widget.Toast;
import life.homail.SchoolManagementSystem.ModelClasses.TeacherModel;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
public class AddTeacSaveTeacBtnHandler implements View.OnClickListener{
    private AddTeacherMain addTeacherMain;
    private long teacherId;
    private String teacherFullName;
    private String teacherSubject;
    private String teacherPhoneNumber;
    private String teacherFirstName;
    private String teacherLastName;
    private Toast toast;
    protected AddTeacSaveTeacBtnHandler (AddTeacherMain addTeacherMain){
        this.addTeacherMain=addTeacherMain;
    }
    @Override
    public void onClick(View view){
        this.extractDataFromFields();
        if (this.ifSomeFieldIsNotFilledCorrectly()) this.makeToast("Fill all fields correctly");
        else this.addDataToDb();
    }
    private void addDataToDb(){
        TeacherModel teacherModel=new TeacherModel(this.teacherId,this.teacherFullName,this.teacherFirstName,this.teacherLastName,this.teacherSubject,this.teacherPhoneNumber);
        boolean bool=SingleTon.getSingleTon().getHomeMain().homeTeachersDb.addTeacher(teacherModel);
        if (bool){
            this.makeEveryEdEmpty();
            this.makeToast("Teacher saved successfully");
            SingleTon.getSingleTon().setTeacherModelArrayList(SingleTon.getSingleTon().getHomeMain().homeTeachersDb.getAllTeachers());
        } else this.makeToast("Could not save teacher");
    }
    private void makeEveryEdEmpty(){
        this.addTeacherMain.addTeacherViews.firstNameEd.setText(null);
        this.addTeacherMain.addTeacherViews.lastNameEd.setText(null);
        this.addTeacherMain.addTeacherViews.teacherIdEd.setText(null);
        this.addTeacherMain.addTeacherViews.subjectNameEd.setText(null);
        this.addTeacherMain.addTeacherViews.phoneNumberEd.setText(null);
    }
    private boolean ifSomeFieldIsNotFilledCorrectly(){
        if (
                teacherFirstName.isBlank() || teacherLastName.isBlank() || teacherSubject.isBlank() || teacherPhoneNumber.isBlank()
                || String.valueOf(this.addTeacherMain.addTeacherViews.teacherIdEd.getText()).isBlank()
        ) return true;
        return false;
    }
    private void extractDataFromFields(){
        try {
            this.teacherFirstName=String.valueOf(this.addTeacherMain.addTeacherViews.firstNameEd.getText());
            this.teacherLastName=String.valueOf(this.addTeacherMain.addTeacherViews.lastNameEd.getText());
            this.teacherId=Long.parseLong(String.valueOf(this.addTeacherMain.addTeacherViews.teacherIdEd.getText()));
            this.teacherSubject=String.valueOf(this.addTeacherMain.addTeacherViews.subjectNameEd.getText());
            this.teacherPhoneNumber=String.valueOf(this.addTeacherMain.addTeacherViews.phoneNumberEd.getText());
            this.teacherFullName=this.teacherFirstName+" "+this.teacherLastName;
        } catch (Exception exception){}
    }
    protected void makeToast(String toastText){
        if (toast!=null) toast.cancel();
        toast=Toast.makeText(this.addTeacherMain,toastText,Toast.LENGTH_SHORT);
        toast.show();
    }
}