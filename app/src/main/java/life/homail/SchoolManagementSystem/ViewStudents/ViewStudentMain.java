package life.homail.SchoolManagementSystem.ViewStudents;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import life.homail.SchoolManagementSystem.R;

public class ViewStudentMain extends AppCompatActivity {
    protected String currentSearchBySelection = "roll Number";
    protected SearchByBtnHandler searchByBtnHandler;
    protected ViewStudentMainViews viewStudentMainViews;
    protected ViewStdEditDialogClass viewStdEditDialogClass;
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

    private void atEndOfOnCreate() {
        this.createSomeObjects();
        this.setUpDialogsClasses();
        this.rcViewAndAdapterSettings();
    }



    private void createSomeObjects(){
        this.searchByBtnHandler=new SearchByBtnHandler(this);
        this.searchStdEdTextChangeListener =new SearchStdEdTextChangeListener(this);
        this.viewStudentMainViews=new ViewStudentMainViews(this);
    }

    private void setUpDialogsClasses() {
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
