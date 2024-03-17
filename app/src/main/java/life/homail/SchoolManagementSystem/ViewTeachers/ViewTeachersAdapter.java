package life.homail.SchoolManagementSystem.ViewTeachers;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;

public class ViewTeachersAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private ViewTeachersMain viewTeachersMain;
    protected ViewTeachersAdapter (ViewTeachersMain viewTeachersMain){
        this.viewTeachersMain=viewTeachersMain;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(viewTeachersMain).inflate(R.layout.view_teacher_row_design,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder,int position){

    }
    @Override
    public int getItemCount(){
        return SingleTon.getSingleTon().getTeacherModelArrayList().size();
    }

}
class MyViewHolder extends RecyclerView.ViewHolder{
    public MyViewHolder (View itemView){
        super(itemView);
    }
}