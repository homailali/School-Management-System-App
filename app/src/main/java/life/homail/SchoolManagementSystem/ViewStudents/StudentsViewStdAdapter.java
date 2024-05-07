package life.homail.SchoolManagementSystem.ViewStudents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
public class StudentsViewStdAdapter extends RecyclerView.Adapter<StudentsMyViewHolder> {
    private ViewStudentMain viewStudentMain;
    public StudentsViewStdAdapter(ViewStudentMain viewStudentMain) {

        this.viewStudentMain = viewStudentMain;
    }
    @Override
    public StudentsMyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.viewStudentMain).inflate(R.layout.view_std_row_design, parent, false);
        StudentsMyViewHolder studentsMyViewHolder = new StudentsMyViewHolder(view);
        return studentsMyViewHolder;
    }

    @Override
    public void onBindViewHolder(StudentsMyViewHolder studentsMyViewHolder, int position) {
        this.setEventHandlersForBtn(studentsMyViewHolder,position);
        studentsMyViewHolder.getClassTv().setText(SingleTon.getSingleTon().getStudentModelArrayList().get(position).getStudentClassName());
        studentsMyViewHolder.getRollNoTv().setText(String.valueOf(SingleTon.getSingleTon().getStudentModelArrayList().get(position).getStudentRollNumber()));
        studentsMyViewHolder.getNameTv().setText(SingleTon.getSingleTon().getStudentModelArrayList().get(position).getStudentFullName());
        studentsMyViewHolder.getContactNumberTv().setText(SingleTon.getSingleTon().getStudentModelArrayList().get(position).getStudentContactNumber());
    }



    private void setEventHandlersForBtn(StudentsMyViewHolder studentsMyViewHolder,int position){
        studentsMyViewHolder.getEditBtn().setOnClickListener(e->this.viewStudentMain.viewStdEditBtnHandler.viewStdEditBtnHandlerMain(position));
        studentsMyViewHolder.getDeleteBtn().setOnClickListener(e->this.viewStudentMain.viewStdDeleteBtnHandler.viewStdDeleteBtnHandlerMain(position));
    }
    @Override
    public int getItemCount() {

        return SingleTon.getSingleTon().getStudentModelArrayList().size();
    }
}