package life.homail.SchoolManagementSystem.ViewTeachers;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;

public class ViewTeachersMain extends AppCompatActivity{
    protected String currentSearchSelectedOption="id";
    protected ViewTeachersMainViews viewTeachersMainViews;
    protected TeachersSearchByBtnHandler teachersSearchByBtnHandler;
    protected ViewTeachersEditDialogClass viewTeachersEditDialogClass;
    protected ViewTeachersDeleteDialogClass viewTeachersDeleteDialogClass;
    protected ViewTeachersAdapter viewTeachersAdapter=new ViewTeachersAdapter(this);
    protected ViewTeacherEditBtnHandler viewTeacherEditBtnHandler=new ViewTeacherEditBtnHandler(this);
    protected ViewTeacherDeleteBtnHandler viewTeacherDeleteBtnHandler=new ViewTeacherDeleteBtnHandler(this);
    protected TeacherSearchEdTextChangedListener teacherSearchEdTextChangedListener=new TeacherSearchEdTextChangedListener(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.view_teacher_acitvity);
        this.atEndOfOnCreate();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SingleTon.getSingleTon().setTeacherModelArrayList(this.teacherSearchEdTextChangedListener.getTeacherArrTemp());
    }


    private void atEndOfOnCreate(){
        this.createSomeObjects();
        this.rcViewSettings();
        this.setNoTeacherTvVisibility("No teacher added");
        this.teacherSearchEdTextChangedListener.setTeacherArrTemp(SingleTon.getSingleTon().getTeacherModelArrayList());
    }


    private void rcViewSettings(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        this.viewTeachersMainViews.viewTeacherRcView.setAdapter(this.viewTeachersAdapter);
        this.viewTeachersMainViews.viewTeacherRcView.setLayoutManager(linearLayoutManager);
    }

    private void createSomeObjects(){
        this.viewTeachersMainViews=new ViewTeachersMainViews(this);
        this.teachersSearchByBtnHandler=new TeachersSearchByBtnHandler(this);
        this.viewTeachersEditDialogClass=new ViewTeachersEditDialogClass(this);
        this.viewTeachersDeleteDialogClass=new ViewTeachersDeleteDialogClass(this);
    }
    protected void setNoTeacherTvVisibility(String noTeacherTvText){
        this.viewTeachersMainViews.noTeacherTv.setText(noTeacherTvText);
        boolean bool=SingleTon.getSingleTon().getTeacherModelArrayList().size()==0;
        this.viewTeachersMainViews.noTeacherTv.setVisibility(bool? View.VISIBLE:View.INVISIBLE);
    }
}