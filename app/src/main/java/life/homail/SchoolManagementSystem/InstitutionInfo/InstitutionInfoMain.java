package life.homail.SchoolManagementSystem.InstitutionInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;

public class InstitutionInfoMain extends AppCompatActivity {
    protected EditText institutionNameEd;
    protected EditText principalNameEd;
    protected EditText institutionLocationEd;
    protected EditText contactNumberEd;
    protected Button submitInfoBtn;


    public SubmitInfoBtnHandler submitInfoBtnHandler=new SubmitInfoBtnHandler(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.institution_info_activity);
        this.initializingViews();
        this.submitInfoBtn.setOnClickListener(this.submitInfoBtnHandler);
    }
    private void initializingViews(){
        this.institutionNameEd=super.findViewById(R.id.institutionNameEd);
        this.principalNameEd=super.findViewById(R.id.principalNameEd);
        this.institutionLocationEd=super.findViewById(R.id.institutionLocationEd);
        this.contactNumberEd=super.findViewById(R.id.contactNumberEd);
        this.submitInfoBtn=super.findViewById(R.id.submitInfoBtn);
    }
}
