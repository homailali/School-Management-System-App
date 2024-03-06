package life.homail.SchoolManagementSystem.AddStudent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import life.homail.SchoolManagementSystem.R;
public class AddStdMain extends AppCompatActivity{
    protected AddStdViews addStdViews;
    protected AddStdSaveStdBtnHandler addStdSaveStdBtnHandler = new AddStdSaveStdBtnHandler(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.add_std_activity);
        this.changeStatusBarColor();
        this.addStdViewsClassSettings();
    }

    private void addStdViewsClassSettings(){
        this.addStdViews=new AddStdViews(this);
    }
    private void changeStatusBarColor(){
        Window window=getWindow();
        window.setStatusBarColor(Color.parseColor("#e74c3c"));
    }
}
