package life.homail.SchoolManagementSystem.ViewTeachers;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;

public class ViewTeachersMain extends AppCompatActivity{

    protected ViewTeachersMainViews viewTeachersMainViews;

    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.view_teacher_acitvity);
        this.atEndOfOnCreate();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        SingleTon.getSingleTon().setTeacherModelArrayList(SingleTon.getSingleTon().getHomeMain().homeTeachersDb.getAllTeachers());
    }


    private void atEndOfOnCreate(){
        this.createSomeObjects();
        this.setNoTeacherTvVisibility("No teacher added");
    }
    private void createSomeObjects(){
        this.viewTeachersMainViews=new ViewTeachersMainViews(this);
    }
    private void setNoTeacherTvVisibility(String noTeacherTvText){
        this.viewTeachersMainViews.noTeacherTv.setText(noTeacherTvText);
        boolean bool=SingleTon.getSingleTon().getTeacherModelArrayList().size()==0;
        this.viewTeachersMainViews.noTeacherTv.setVisibility(bool? View.VISIBLE:View.INVISIBLE);
    }
}