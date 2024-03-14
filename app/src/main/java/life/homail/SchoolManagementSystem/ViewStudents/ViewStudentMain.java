package life.homail.SchoolManagementSystem.ViewStudents;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import life.homail.SchoolManagementSystem.R;

public class ViewStudentMain extends AppCompatActivity{
    protected RecyclerView viewStdRcView;
    protected ViewStdEditDialogClass viewStdEditDialogClass;
    protected ViewStdAdapter viewStdAdapter=new ViewStdAdapter(this);
    protected ViewStdEditBtnHandler viewStdEditBtnHandler=new ViewStdEditBtnHandler(this);
    protected ViewStdDeleteBtnHandler viewStdDeleteBtnHandler = new ViewStdDeleteBtnHandler(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.view_student_activity);
        this.atEndOfOnCreate();
    }

    private void atEndOfOnCreate(){
        this.viewStdEditDialogClass =new ViewStdEditDialogClass(this);
        this.rcViewAndAdapterSettings();
    }
    private void rcViewAndAdapterSettings(){
        this.viewStdRcView=super.findViewById(R.id.viewStdRcView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        this.viewStdRcView.setLayoutManager(linearLayoutManager);
        this.viewStdRcView.setAdapter(this.viewStdAdapter);
    }
}
