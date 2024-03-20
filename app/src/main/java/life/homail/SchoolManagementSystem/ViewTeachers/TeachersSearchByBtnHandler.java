package life.homail.SchoolManagementSystem.ViewTeachers;

import android.app.Dialog;
import android.text.InputType;
import android.widget.Button;

import life.homail.SchoolManagementSystem.R;

public class TeachersSearchByBtnHandler {

    private Button teacherSearchByIdBtn;
    private Button teacherSearchByNameBtn;
    private Button teacherSearchBySubjectBtn;
    private Button teacherSearchByPhoneNumberBtn;


    private Dialog teacherSearchByDialog;
    private ViewTeachersMain viewTeachersMain;
    protected TeachersSearchByBtnHandler(ViewTeachersMain viewTeachersMain) {
        this.viewTeachersMain = viewTeachersMain;
        this.setUpDialog();
    }
    private void setUpDialog(){
        this.initialSettings();
        this.initializeViews();
        this.handleEvents();
    }
    private void initialSettings(){
        this.teacherSearchByDialog=new Dialog(this.viewTeachersMain);
        this.teacherSearchByDialog.setContentView(R.layout.view_teacher_search_by_dialog);
        this.teacherSearchByDialog.setCancelable(false);
    }
    private void initializeViews(){
        this.teacherSearchByIdBtn=this.teacherSearchByDialog.findViewById(R.id.searchByIdBtn);
        this.teacherSearchByNameBtn=this.teacherSearchByDialog.findViewById(R.id.searchByNameBtn);
        this.teacherSearchBySubjectBtn=this.teacherSearchByDialog.findViewById(R.id.searchBySubjectBtn);
        this.teacherSearchByPhoneNumberBtn=this.teacherSearchByDialog.findViewById(R.id.searchByPhoneNumberBtn);
    }
    private void handleEvents(){
        this.teacherSearchByIdBtn.setOnClickListener(e-> this.onOptionClick("id", InputType.TYPE_CLASS_NUMBER));
        this.teacherSearchByNameBtn.setOnClickListener(e-> this.onOptionClick("name",InputType.TYPE_CLASS_TEXT));
        this.teacherSearchBySubjectBtn.setOnClickListener(e-> this.onOptionClick("subject",InputType.TYPE_CLASS_TEXT));
        this.teacherSearchByPhoneNumberBtn.setOnClickListener(e-> this.onOptionClick("phone number",InputType.TYPE_CLASS_NUMBER));
    }
    private void onOptionClick(String clickedOption,int inputType){
        this.viewTeachersMain.currentSearchSelectedOption=clickedOption;
        this.viewTeachersMain.viewTeachersMainViews.viewTeacherSearchEd.setInputType(inputType);
        this.viewTeachersMain.viewTeachersMainViews.viewTeacherSearchEd.setHint("Search by "+clickedOption);
        this.getTeacherSearchByDialog().dismiss();
    }
    public Dialog getTeacherSearchByDialog() {
        return teacherSearchByDialog;
    }
    public void setTeacherSearchByDialog(Dialog teacherSearchByDialog) {
        this.teacherSearchByDialog = teacherSearchByDialog;
    }
}