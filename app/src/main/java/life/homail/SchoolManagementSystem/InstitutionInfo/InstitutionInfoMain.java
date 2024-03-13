package life.homail.SchoolManagementSystem.InstitutionInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import life.homail.SchoolManagementSystem.R;

public class InstitutionInfoMain extends AppCompatActivity {
    protected EditText institutionNameEd;
    protected EditText principalNameEd;
    protected EditText institutionLocationEd;
    protected EditText contactNumberEd;
    protected Button submitInfoBtn;
    protected Button resetBtn;


    public SubmitInfoBtnHandler submitInfoBtnHandler=new SubmitInfoBtnHandler(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.institution_info_activity);
        this.initializingViews();
        this.submitInfoBtn.setOnClickListener(this.submitInfoBtnHandler);
        this.resetBtn.setOnClickListener(this::resetBtnHandler);
    }

    private void resetBtnHandler(View view){
        if (this.ifSomeFieldIsFilled()) this.submitInfoBtnHandler.makeToast("Every field cleared");
        this.institutionNameEd.setText(null);
        this.principalNameEd.setText(null);
        this.institutionLocationEd.setText(null);
        this.contactNumberEd.setText(null);
    }
    private boolean ifSomeFieldIsFilled(){
        boolean bool=
                String.valueOf(this.institutionNameEd.getText()).isEmpty() &&
                String.valueOf(this.principalNameEd.getText()).isEmpty() &&
                String.valueOf(this.institutionLocationEd.getText()).isEmpty() &&
                String.valueOf(this.contactNumberEd.getText()).isEmpty();
        return !bool;
    }
    private void initializingViews(){
        this.institutionNameEd=super.findViewById(R.id.institutionNameEd);
        this.principalNameEd=super.findViewById(R.id.instituitonPrincipalNameEd);
        this.institutionLocationEd=super.findViewById(R.id.institutionLocationEd);
        this.contactNumberEd=super.findViewById(R.id.institutionContactNumberEd);
        this.submitInfoBtn=super.findViewById(R.id.submitInfoBtn);
        this.resetBtn=super.findViewById(R.id.institutionResetBtn);
    }
}