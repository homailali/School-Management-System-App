package life.homail.SchoolManagementSystem.ViewStudents;
import android.text.Editable;
import android.text.TextWatcher;
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

    }
}
