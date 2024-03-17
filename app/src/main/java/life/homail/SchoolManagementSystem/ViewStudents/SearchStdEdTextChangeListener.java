package life.homail.SchoolManagementSystem.ViewStudents;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import java.util.ArrayList;

import life.homail.SchoolManagementSystem.ModelClasses.StudentModel;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;

public class SearchStdEdTextChangeListener implements TextWatcher {
    // Fields
    private ViewStudentMain viewStudentMain;
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
        ArrayList<StudentModel> searchedArrayList=new ArrayList<>();
        ArrayList<StudentModel> studentModelsArr=new ArrayList<>(SingleTon.getSingleTon().getStudentModelArrayList());
        for (StudentModel stdModel : studentModelsArr) {
            if (stdModel.getStudentClassName().contains(classEnteredInEd)) {
                searchedArrayList.add(stdModel);
            }
        }
        SingleTon.getSingleTon().setStudentModelArrayList(searchedArrayList);
        this.viewStudentMain.viewStdAdapter.notifyDataSetChanged();
    }
    private void searchByName(String nameEnteredInEd){
        nameEnteredInEd=nameEnteredInEd.toLowerCase();
        ArrayList<StudentModel> searchedArrayList=new ArrayList<>();
        ArrayList<StudentModel> studentModelsArr=new ArrayList<>(SingleTon.getSingleTon().getStudentModelArrayList());
        for (StudentModel stdModel : studentModelsArr){
            if (stdModel.getStudentFullName().toLowerCase().contains(nameEnteredInEd)){
                searchedArrayList.add(stdModel);
            }
        }
        SingleTon.getSingleTon().setStudentModelArrayList(searchedArrayList);
        this.viewStudentMain.viewStdAdapter.notifyDataSetChanged();
    }
    private void searchByRollNumber(String rollNoEnteredInEd){
        ArrayList<StudentModel> searchedArrList=new ArrayList<>();
        ArrayList<StudentModel> studentModelsArrList=new ArrayList<>(SingleTon.getSingleTon().getStudentModelArrayList());
        for (StudentModel stdModel : studentModelsArrList){
            if (String.valueOf(stdModel.getStudentRollNumber()).contains(rollNoEnteredInEd)){
                searchedArrList.add(stdModel);
            }
        }
        SingleTon.getSingleTon().setStudentModelArrayList(searchedArrList);
        this.viewStudentMain.viewStdAdapter.notifyDataSetChanged();
    }
    private void searchByContactNumber(String contactNumberEnteredInEd){
        ArrayList<StudentModel> searchedArrList=new ArrayList<>();
        ArrayList<StudentModel> studentModelsArrList=new ArrayList<>(SingleTon.getSingleTon().getStudentModelArrayList());
        for (StudentModel stdModel : studentModelsArrList){
            if (stdModel.getStudentContactNumber().contains(contactNumberEnteredInEd)){
                searchedArrList.add(stdModel);
            }
        }
        SingleTon.getSingleTon().setStudentModelArrayList(searchedArrList);
        this.viewStudentMain.viewStdAdapter.notifyDataSetChanged();
    }
    private void setAllStudents(){
        SingleTon.getSingleTon().setStudentModelArrayList(SingleTon.getSingleTon().getHomeMain().homeStudentsDb.getAllStudentsData());
        this.viewStudentMain.viewStdAdapter.notifyDataSetChanged();
    }
}
