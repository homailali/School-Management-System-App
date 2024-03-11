package life.homail.SchoolManagementSystem.ViewStudents;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import life.homail.SchoolManagementSystem.R;

public class ViewStudentMain extends AppCompatActivity{
    private RecyclerView viewStdRcView;
    private ViewStdAdapter viewStdAdapter=new ViewStdAdapter(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.view_student_activity);
        this.atEndOfOnCreate();
    }

    private void atEndOfOnCreate(){
        this.viewStdRcView=super.findViewById(R.id.viewStdRcView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        this.viewStdRcView.setLayoutManager(linearLayoutManager);
        this.viewStdRcView.setAdapter(this.viewStdAdapter);
    }
}
