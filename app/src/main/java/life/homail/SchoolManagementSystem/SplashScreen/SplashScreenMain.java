package life.homail.SchoolManagementSystem.SplashScreen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import life.homail.SchoolManagementSystem.HomePage.HomeMain;
import life.homail.SchoolManagementSystem.R;

public class SplashScreenMain extends AppCompatActivity{
    private Handler handler = new Handler();
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.splash_screen_activity);
        this.changeStatusBarColor();
        this.handler.postDelayed(this::changeActivity,2000);
    }
    private void changeActivity(){
        Intent intent=new Intent(this, HomeMain.class);
        super.startActivity(intent);
        super.finish();
    }
    private void changeStatusBarColor(){
        Window window=getWindow();
        window.setStatusBarColor(Color.parseColor("#e74c3c"));
    }
}
