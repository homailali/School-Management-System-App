package life.homail.SchoolManagementSystem.HomePage;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
public class HomeMain extends AppCompatActivity {
    protected HomePageViews homePageViews;
    protected HomeDialogClass homeDialogClass=new HomeDialogClass(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.home_activity);
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
}