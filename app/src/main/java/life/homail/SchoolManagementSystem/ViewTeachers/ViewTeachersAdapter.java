package life.homail.SchoolManagementSystem.ViewTeachers;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.recyclerview.widget.RecyclerView;
import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
import life.homail.SchoolManagementSystem.ViewStudents.StudentsMyViewHolder;

public class ViewTeachersAdapter extends RecyclerView.Adapter<TeachersMyViewHolder>{
    private ViewTeachersMain viewTeachersMain;
    protected ViewTeachersAdapter (ViewTeachersMain viewTeachersMain){
        this.viewTeachersMain=viewTeachersMain;
    }
    @Override
    public TeachersMyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(viewTeachersMain).inflate(R.layout.view_teacher_row_design,parent,false);
        TeachersMyViewHolder teachersMyViewHolder =new TeachersMyViewHolder(view);
        this.setLayoutsHeight(teachersMyViewHolder);
        return teachersMyViewHolder;
    }
    @Override
    public void onBindViewHolder(TeachersMyViewHolder teachersMyViewHolder, int position){
        this.setEventHandlersForBtn(teachersMyViewHolder,position);
        teachersMyViewHolder.getViewTeachersNameTv().setText(SingleTon.getSingleTon().getTeacherModelArrayList().get(position).getTeacherFullName());
        teachersMyViewHolder.getViewTeachersIdTv().setText(String.valueOf(SingleTon.getSingleTon().getTeacherModelArrayList().get(position).getTeacherId()));
        teachersMyViewHolder.getViewTeachersSubjectTv().setText(SingleTon.getSingleTon().getTeacherModelArrayList().get(position).getTeacherSubject());
        teachersMyViewHolder.getViewTeachersPhoneNumberTv().setText(SingleTon.getSingleTon().getTeacherModelArrayList().get(position).getTeacherPhoneNumber());
    }

    private void setEventHandlersForBtn(TeachersMyViewHolder teachersMyViewHolder,int position){
        teachersMyViewHolder.getViewTeachersEditBtn().setOnClickListener(e->this.viewTeachersMain.viewTeacherEditBtnHandler.teacherEditBtnHandlerMain(position));
        teachersMyViewHolder.getViewTeachersDeleteBtn().setOnClickListener(e->this.viewTeachersMain.viewTeacherDeleteBtnHandler.teacherDeleteBtnHandlerMain(position));
    }
    @Override
    public int getItemCount(){

        return SingleTon.getSingleTon().getTeacherModelArrayList().size();
    }
    private void setLayoutsHeight(TeachersMyViewHolder teacherMyViewHolder){
        // Add an OnPreDrawListener to ensure accurate height measurements
        teacherMyViewHolder.itemView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                teacherMyViewHolder.itemView.getViewTreeObserver().removeOnPreDrawListener(this);
                getAndSetLayoutHeight(teacherMyViewHolder);
                return true;
            }
        });
    }
    private void getAndSetLayoutHeight(TeachersMyViewHolder teachersMyViewHolder){
        int maxHeight;
        int nameLayoutHeight=teachersMyViewHolder.getTeachersNameConstraintLayout().getHeight();
        int idLayoutHeight=teachersMyViewHolder.getTeachersIdConstraintLayout().getHeight();
        int subjectLayoutHeight=teachersMyViewHolder.getTeachersSubjectConstraintLayout().getHeight();
        int phoneNumberLayoutHeight=teachersMyViewHolder.getTeachersPhoneNumberConstraintLayout().getHeight();
        maxHeight=Math.max(Math.max(nameLayoutHeight,idLayoutHeight),Math.max(subjectLayoutHeight,phoneNumberLayoutHeight));
        teachersMyViewHolder.getTeachersNameConstraintLayout().setMinHeight(maxHeight);
        teachersMyViewHolder.getTeachersIdConstraintLayout().setMinHeight(maxHeight);
        teachersMyViewHolder.getTeachersSubjectConstraintLayout().setMinHeight(maxHeight);
        teachersMyViewHolder.getTeachersPhoneNumberConstraintLayout().setMinHeight(maxHeight);
    }
}