package life.homail.SchoolManagementSystem.HomePage;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;

import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
public class HomeMain extends AppCompatActivity {
    protected HomePageViews homePageViews;
    public HomeStudentsDb homeStudentsDb=new HomeStudentsDb(this);
    public HomeTeachersDb homeTeachersDb=new HomeTeachersDb(this);
    protected HomeDialogClass homeDialogClass=new HomeDialogClass(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.home_activity);
        this.changeStatusBarColor();
        this.homePageViewsSetting();
        this.manageDialog();
        SingleTon.getSingleTon().setHomeMain(this);
    }
    private void homePageViewsSetting(){
        this.homePageViews=new HomePageViews(this);
    }
    private void manageDialog(){
        this.homeDialogClass.decideShowOrNotShowDialog();
    }
    private void changeStatusBarColor(){
        Window window=getWindow();
        window.setStatusBarColor(Color.parseColor("#e74c3c"));
    }
}