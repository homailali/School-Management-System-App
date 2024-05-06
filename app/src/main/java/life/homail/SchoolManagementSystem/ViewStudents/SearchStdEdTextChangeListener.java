package life.homail.SchoolManagementSystem.ViewStudents;
import android.text.Editable;
import android.text.TextWatcher;
import java.util.ArrayList;
import life.homail.SchoolManagementSystem.ModelClasses.StudentModel;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
public class SearchStdEdTextChangeListener implements TextWatcher {
    // Fields
    private ViewStudentMain viewStudentMain;
    private ArrayList<StudentModel> studentArrTemp;
    // Constructor
    protected SearchStdEdTextChangeListener(ViewStudentMain viewStudentMain){
        this.viewStudentMain=viewStudentMain;
    }
    // Methods
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}
    @Override
    public void afterTextChanged(Editable editable) {
        String editableStr=String.valueOf(editable);
        this.setAllStudents();
        if (!String.valueOf(editable).isBlank()) this.searchStudents(editableStr);
        this.viewStudentMain.setNoStdTvVisibility("No student found");
        this.viewStudentMain.studentsViewStdAdapter.notifyDataSetChanged();
    }
    private void searchStudents(String editableStr){
        switch (this.viewStudentMain.currentSearchBySelection.toLowerCase()) {
            case "class" -> this.searchByClass(editableStr);
            case "name" -> this.searchByName(editableStr);
            case "roll number" -> this.searchByRollNumber(editableStr);
            case "contact number" -> this.searchByContactNumber(editableStr);
        }
    }
    private void searchByClass(String classEnteredInEd){
        classEnteredInEd=classEnteredInEd.toLowerCase();
        ArrayList<StudentModel> searchedArrayList=new ArrayList<>();
        for (StudentModel stdModel :this.studentArrTemp) {
            if (stdModel.getStudentClassName().toLowerCase().contains(classEnteredInEd)) {
                searchedArrayList.add(stdModel);
            }
        }
        SingleTon.getSingleTon().setStudentModelArrayList(searchedArrayList);
    }
    private void searchByName(String nameEnteredInEd){
        nameEnteredInEd=nameEnteredInEd.toLowerCase();
        ArrayList<StudentModel> searchedArrayList=new ArrayList<>();
        for (StudentModel stdModel :this.studentArrTemp){
            if (stdModel.getStudentFullName().toLowerCase().contains(nameEnteredInEd)){
                searchedArrayList.add(stdModel);
            }
        }
        SingleTon.getSingleTon().setStudentModelArrayList(searchedArrayList);
    }
    private void searchByRollNumber(String rollNoEnteredInEd){
        ArrayList<StudentModel> searchedArrList=new ArrayList<>();
        for (StudentModel stdModel :this.studentArrTemp){
            if (String.valueOf(stdModel.getStudentRollNumber()).contains(rollNoEnteredInEd)){
                searchedArrList.add(stdModel);
            }
        }
        SingleTon.getSingleTon().setStudentModelArrayList(searchedArrList);
    }
    private void searchByContactNumber(String contactNumberEnteredInEd){
        ArrayList<StudentModel> searchedArrList=new ArrayList<>();
        for (StudentModel stdModel :this.studentArrTemp){
            if (stdModel.getStudentContactNumber().contains(contactNumberEnteredInEd)){
                searchedArrList.add(stdModel);
            }
        }
        SingleTon.getSingleTon().setStudentModelArrayList(searchedArrList);
    }
    private void setAllStudents(){
        SingleTon.getSingleTon().setStudentModelArrayList(this.studentArrTemp);
    }

    public ArrayList<StudentModel> getStudentArrTemp() {
        return studentArrTemp;
    }

    public void setStudentArrTemp(ArrayList<StudentModel> studentArrTemp) {
        this.studentArrTemp = studentArrTemp;
    }
}