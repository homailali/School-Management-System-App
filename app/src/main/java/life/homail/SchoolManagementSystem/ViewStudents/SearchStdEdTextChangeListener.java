package life.homail.SchoolManagementSystem.ViewStudents;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import java.util.Locale;

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
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }
    @Override
    public void afterTextChanged(Editable editable) {
        if (String.valueOf(editable).isEmpty()) {
            this.whenSearchStdEdIsEmpty();
            return;
        }
        switch (this.viewStudentMain.currentSearchBySelection.toLowerCase()){
            case "class" -> Log.d("searchType","class");
            case "name"-> Log.d("searchType","name");
            case "roll number"-> Log.d("searchType","roll number");
            case "contact number"-> Log.d("searchType","contact number");
        }
    }


    private void searchByClass(){}
    private void searchByName(){}
    private void searchByRollNumber(){}
    private void searchByContactNumber(){}



    private void whenSearchStdEdIsEmpty(){
        SingleTon.getSingleTon().setStudentModelArrayList(SingleTon.getSingleTon().getHomeMain().homeStudentsDb.getAllStudentsData());
        this.viewStudentMain.viewStdAdapter.notifyDataSetChanged();
    }
}
