package life.homail.SchoolManagementSystem.ViewStudents;

import android.app.Dialog;
import android.text.InputType;
import android.view.View;
import android.widget.Button;

import life.homail.SchoolManagementSystem.R;

public class SearchByBtnHandler implements View.OnClickListener{

    private ViewStudentMain viewStudentMain;
    private Dialog searchByDialog;
    private Button searchByRollNoBtn;
    private Button searchByNameBtn;
    private Button searchByClassBtn;
    private Button searchByContactNumberBtn;


    protected SearchByBtnHandler(ViewStudentMain viewStudentMain){
        this.viewStudentMain=viewStudentMain;
        this.setUpDialog();
    }




    @Override
    public void onClick(View view){
        this.searchByDialog.show();
    }





    private void setUpDialog(){
        this.searchByDialog=new Dialog(this.viewStudentMain);
        this.searchByDialog.setContentView(R.layout.view_std_search_by_dialog);
        this.searchByDialog.setCancelable(false);
        this.initializeViews();
        this.setEventHandlersForDialogViews();
    }
    private void initializeViews(){
        this.searchByNameBtn=this.searchByDialog.findViewById(R.id.searchByNameBtn);
        this.searchByClassBtn=this.searchByDialog.findViewById(R.id.searchByClassBtn);
        this.searchByRollNoBtn=this.searchByDialog.findViewById(R.id.searchByRollNoBtn);
        this.searchByContactNumberBtn=this.searchByDialog.findViewById(R.id.searchByContactNumberBtn);
    }
    private void setEventHandlersForDialogViews(){
        this.searchByNameBtn.setOnClickListener(e->{
            this.dialogViewsHandler("Search by name","name",InputType.TYPE_CLASS_TEXT);
        });
        this.searchByClassBtn.setOnClickListener(e->{
            this.dialogViewsHandler("Search by class","class",InputType.TYPE_CLASS_TEXT);
        });
        this.searchByRollNoBtn.setOnClickListener(e->{
            this.dialogViewsHandler("Search by roll no","roll number",InputType.TYPE_CLASS_NUMBER);
        });
        this.searchByContactNumberBtn.setOnClickListener(e->{
            this.dialogViewsHandler("Search by contact no","contact number",InputType.TYPE_CLASS_NUMBER);
        });
    }
    private void dialogViewsHandler(String edHintText,String currentSearchBySelection,int inputType){
        this.viewStudentMain.viewStudentMainViews.searchStdEd.setHint(edHintText);
        this.viewStudentMain.viewStudentMainViews.searchStdEd.setInputType(inputType);
        this.viewStudentMain.currentSearchBySelection=currentSearchBySelection;
        this.searchByDialog.dismiss();
    }
}
