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
}