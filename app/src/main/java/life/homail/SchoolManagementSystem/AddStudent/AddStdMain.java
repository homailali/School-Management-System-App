package life.homail.SchoolManagementSystem.AddStudent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import life.homail.SchoolManagementSystem.R;
public class AddStdMain extends AppCompatActivity{
    protected AddStdViews addStdViews;
    protected AddStdSaveStdBtnHandler addStdSaveStdBtnHandler = new AddStdSaveStdBtnHandler(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.add_std_activity);
        this.addStdViewsClassSettings();
    }

    private void addStdViewsClassSettings(){
        this.addStdViews=new AddStdViews(this);
    }
}
