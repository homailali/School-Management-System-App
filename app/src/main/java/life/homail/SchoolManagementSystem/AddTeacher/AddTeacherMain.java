package life.homail.SchoolManagementSystem.AddTeacher;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;

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
