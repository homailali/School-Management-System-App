package life.homail.SchoolManagementSystem.AddTeacher;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import life.homail.SchoolManagementSystem.R;
public class AddTeacherMain extends AppCompatActivity{
    protected AddTeacherViews addTeacherViews;
    protected AddTeacSaveTeacBtnHandler addTeacSaveTeacBtnHandler=new AddTeacSaveTeacBtnHandler(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.add_teacher_activity);
        this.addTeacherViewsSettings();
    }

    private void addTeacherViewsSettings(){
        this.addTeacherViews=new AddTeacherViews(this);
    }

}
