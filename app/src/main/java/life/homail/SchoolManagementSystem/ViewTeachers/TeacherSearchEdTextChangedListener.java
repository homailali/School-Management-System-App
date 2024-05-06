package life.homail.SchoolManagementSystem.ViewTeachers;
import android.text.Editable;
import android.text.TextWatcher;
import java.util.ArrayList;
import life.homail.SchoolManagementSystem.ModelClasses.TeacherModel;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
public class TeacherSearchEdTextChangedListener implements TextWatcher {
    private ViewTeachersMain viewTeachersMain;
    private ArrayList<TeacherModel> teacherArrTemp;
    protected TeacherSearchEdTextChangedListener(ViewTeachersMain viewTeachersMain) {

        this.viewTeachersMain = viewTeachersMain;
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}
    @Override
    public void afterTextChanged(Editable editable) {
        String editableStr=String.valueOf(editable);
        this.setAllStudents();
        if (!editableStr.isBlank()) this.searchBasedOnSelectedOption(editableStr);
        this.viewTeachersMain.setNoTeacherTvVisibility("No teacher founded");
        this.viewTeachersMain.viewTeachersAdapter.notifyDataSetChanged();
    }
    private void searchBasedOnSelectedOption(String editableStr){
        switch (this.viewTeachersMain.currentSearchSelectedOption){
            case "id"-> this.searchById(editableStr);
            case "name"-> this.searchByName(editableStr);
            case "subject"->this.searchBySubject(editableStr);
            case "phone number"->this.searchByPhoneNumber(editableStr);
        }
    }
    private void searchById(String editableStr){
        ArrayList<TeacherModel> searchedArrList=new ArrayList<>();
        for (TeacherModel teacherModel : this.teacherArrTemp){
            if (String.valueOf(teacherModel.getTeacherId()).contains(editableStr)){
                searchedArrList.add(teacherModel);
            }
        }
        SingleTon.getSingleTon().setTeacherModelArrayList(searchedArrList);
    }
    private void searchByName(String editableStr){
        editableStr=editableStr.toLowerCase();
        ArrayList<TeacherModel> searchedArrList=new ArrayList<>();
        for (TeacherModel teacherModel : this.teacherArrTemp){
             if (teacherModel.getTeacherFullName().toLowerCase().contains(editableStr)){
                 searchedArrList.add(teacherModel);
             }
        }
        SingleTon.getSingleTon().setTeacherModelArrayList(searchedArrList);
    }
    private void searchBySubject(String editableStr){
        editableStr=editableStr.toLowerCase();
        ArrayList<TeacherModel> searchedArrList=new ArrayList<>();
        for (TeacherModel teacherModel : this.teacherArrTemp){
            if (teacherModel.getTeacherSubject().toLowerCase().contains(editableStr)){
                searchedArrList.add(teacherModel);
            }
        }
        SingleTon.getSingleTon().setTeacherModelArrayList(searchedArrList);
    }
    private void searchByPhoneNumber(String editableStr){
        ArrayList<TeacherModel> searchedArrList=new ArrayList<>();
        for (TeacherModel teacherModel : this.teacherArrTemp){
            if (teacherModel.getTeacherPhoneNumber().contains(editableStr)){
                searchedArrList.add(teacherModel);
            }
        }
        SingleTon.getSingleTon().setTeacherModelArrayList(searchedArrList);
    }

    private void setAllStudents(){
        SingleTon.getSingleTon().setTeacherModelArrayList(this.teacherArrTemp);
    }

    public ArrayList<TeacherModel> getTeacherArrTemp() {
        return teacherArrTemp;
    }

    public void setTeacherArrTemp(ArrayList<TeacherModel> teacherArrTemp) {
        this.teacherArrTemp = teacherArrTemp;
    }
}