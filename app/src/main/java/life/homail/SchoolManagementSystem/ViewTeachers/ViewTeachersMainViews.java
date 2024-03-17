package life.homail.SchoolManagementSystem.ViewTeachers;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import life.homail.SchoolManagementSystem.R;
public class ViewTeachersMainViews {
    protected TextView noTeacherTv;
    protected EditText viewTeacherSearchEd;
    protected Button viewTeachersGoBackBtn;
    protected Button viewTeachersSearchByBtn;
    private ViewTeachersMain viewTeachersMain;
    protected ViewTeachersMainViews(ViewTeachersMain viewTeachersMain){
        this.viewTeachersMain=viewTeachersMain;
        this.initializeViews();
        this.setEventHandlers();
    }
    private void initializeViews(){
        this.noTeacherTv=this.viewTeachersMain.findViewById(R.id.noTeacherTv);
        this.viewTeacherSearchEd=this.viewTeachersMain.findViewById(R.id.viewTeacherSearchEd);
        this.viewTeachersGoBackBtn=this.viewTeachersMain.findViewById(R.id.viewTeacherGoBackBtn);
        this.viewTeachersSearchByBtn=this.viewTeachersMain.findViewById(R.id.viewTeacherSearchByBtn);
    }
    private void setEventHandlers(){
        this.viewTeachersGoBackBtn.setOnClickListener(e->{
            this.viewTeachersMain.onBackPressed();
        });
    }
}