package life.homail.SchoolManagementSystem.ViewStudents;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import life.homail.SchoolManagementSystem.R;

public class ViewStudentMainViews {
    private ViewStudentMain viewStudentMain;
    protected Button searchByBtn;
    protected Button goBackBtn;
    protected EditText searchStdEd;
    protected TextView noStudentsTv;
    protected RecyclerView viewStdRcView;


    protected ViewStudentMainViews(ViewStudentMain viewStudentMain){
        this.viewStudentMain=viewStudentMain;
        this.initializeViews();
        this.setEventHandlers();
    }

    private void initializeViews(){
        this.searchByBtn=this.viewStudentMain.findViewById(R.id.searchByBtn);
        this.viewStdRcView=this.viewStudentMain.findViewById(R.id.viewStdRcView);
        this.searchStdEd=this.viewStudentMain.findViewById(R.id.viewStudentSearchStdEd);
        this.noStudentsTv=this.viewStudentMain.findViewById(R.id.noStudentsTv);
        this.goBackBtn=this.viewStudentMain.findViewById(R.id.viewStudentGoBackBtn);
    }
    private void setEventHandlers(){
        this.searchByBtn.setOnClickListener(this.viewStudentMain.searchByBtnHandler);
        this.searchStdEd.addTextChangedListener(this.viewStudentMain.searchStdEdTextChangeListener);
        this.goBackBtn.setOnClickListener(e->{
            this.viewStudentMain.onBackPressed();
        });
    }
}
