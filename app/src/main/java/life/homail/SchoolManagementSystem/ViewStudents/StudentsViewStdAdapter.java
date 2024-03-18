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
        this.setLayoutsHeight(studentsMyViewHolder);
        return studentsMyViewHolder;
    }
    private void setLayoutsHeight(StudentsMyViewHolder studentsMyViewHolder){
        // Add an OnPreDrawListener to ensure accurate height measurements
        studentsMyViewHolder.itemView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                studentsMyViewHolder.itemView.getViewTreeObserver().removeOnPreDrawListener(this);
                getAndSetValueOfLayoutsHeight(studentsMyViewHolder);
                return true;
            }
        });

    }
    @Override
    public void onBindViewHolder(StudentsMyViewHolder studentsMyViewHolder, int position) {
        this.setEventHandlersForBtn(studentsMyViewHolder,position);
        studentsMyViewHolder.getClassTv().setText(SingleTon.getSingleTon().getStudentModelArrayList().get(position).getStudentClassName());
        studentsMyViewHolder.getRollNoTv().setText(String.valueOf(SingleTon.getSingleTon().getStudentModelArrayList().get(position).getStudentRollNumber()));
        studentsMyViewHolder.getNameTv().setText(SingleTon.getSingleTon().getStudentModelArrayList().get(position).getStudentFullName());
        studentsMyViewHolder.getContactNumberTv().setText(SingleTon.getSingleTon().getStudentModelArrayList().get(position).getStudentContactNumber());
    }
    protected void getAndSetValueOfLayoutsHeight(StudentsMyViewHolder studentsMyViewHolder) {
        int maxHeight;
        int nameLayoutHeight = studentsMyViewHolder.getNameConstraintLayout().getHeight();
        int rollNoLayoutHeight = studentsMyViewHolder.getRollNoConstraintLayout().getHeight();
        int classLayoutHeight = studentsMyViewHolder.getClassConstraintLayout().getHeight();
        int contactNumberLayoutHeight = studentsMyViewHolder.getContactNumberConstraintLayout().getHeight();
        maxHeight = Math.max(Math.max(nameLayoutHeight, rollNoLayoutHeight), Math.max(classLayoutHeight, contactNumberLayoutHeight));

        studentsMyViewHolder.getNameConstraintLayout().setMinHeight(maxHeight);
        studentsMyViewHolder.getRollNoConstraintLayout().setMinHeight(maxHeight);
        studentsMyViewHolder.getClassConstraintLayout().setMinHeight(maxHeight);
        studentsMyViewHolder.getContactNumberConstraintLayout().setMinHeight(maxHeight);
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