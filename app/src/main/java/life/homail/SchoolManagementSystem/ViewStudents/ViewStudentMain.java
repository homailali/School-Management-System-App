package life.homail.SchoolManagementSystem.ViewStudents;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
public class ViewStudentMain extends AppCompatActivity {
    protected SearchByBtnHandler searchByBtnHandler;
    protected ViewStudentMainViews viewStudentMainViews;
    protected ViewStdEditDialogClass viewStdEditDialogClass;
    protected String currentSearchBySelection = "roll Number";
    protected ViewStdDeleteDialogClass viewStdDeleteDialogClass;
    protected SearchStdEdTextChangeListener searchStdEdTextChangeListener;
    protected ViewStdAdapter viewStdAdapter = new ViewStdAdapter(this);
    protected ViewStdEditBtnHandler viewStdEditBtnHandler = new ViewStdEditBtnHandler(this);
    protected ViewStdDeleteBtnHandler viewStdDeleteBtnHandler = new ViewStdDeleteBtnHandler(this);
    @Override
    public void onCreate(Bundle getCodeFromParent) {
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.view_student_activity);
        this.atEndOfOnCreate();
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        SingleTon.getSingleTon().setStudentModelArrayList(SingleTon.getSingleTon().getHomeMain().homeStudentsDb.getAllStudentsData());
    }

    private void atEndOfOnCreate() {
        this.createSomeObjects();
        this.rcViewAndAdapterSettings();
        this.setNoStdTvVisibility("No students added");
    }
    protected void setNoStdTvVisibility(String tvText){
        this.viewStudentMainViews.noStudentsTv.setText(tvText);
        // approach 1 works
        boolean bool=SingleTon.getSingleTon().getStudentModelArrayList().size()==0;
        this.viewStudentMainViews.noStudentsTv.setVisibility(bool?View.VISIBLE:View.INVISIBLE);
        // approach 2  does not works (gives error:not a statement)
//        SingleTon.getSingleTon().getStudentModelArrayList().size() == 0 ? this.viewStudentMainViews.noStudentsTv.setVisibility(View.VISIBLE) : this.viewStudentMainViews.noStudentsTv.setVisibility(View.INVISIBLE);
    }
    private void createSomeObjects(){
        this.searchByBtnHandler=new SearchByBtnHandler(this);
        this.searchStdEdTextChangeListener =new SearchStdEdTextChangeListener(this);
        this.viewStudentMainViews=new ViewStudentMainViews(this);
        this.viewStdEditDialogClass = new ViewStdEditDialogClass(this);
        this.viewStdDeleteDialogClass = new ViewStdDeleteDialogClass(this);
    }
    private void rcViewAndAdapterSettings() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        this.viewStudentMainViews.viewStdRcView.setLayoutManager(linearLayoutManager);
        this.viewStudentMainViews.viewStdRcView.setAdapter(this.viewStdAdapter);
    }
}