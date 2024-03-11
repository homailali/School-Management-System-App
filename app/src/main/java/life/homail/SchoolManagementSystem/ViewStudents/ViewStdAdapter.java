package life.homail.SchoolManagementSystem.ViewStudents;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import life.homail.SchoolManagementSystem.R;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;

public class ViewStdAdapter extends RecyclerView.Adapter<MyViewHolder>{
    private ViewStudentMain viewStudentMain;
    public ViewStdAdapter(ViewStudentMain viewStudentMain) {
        this.viewStudentMain = viewStudentMain;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(this.viewStudentMain).inflate(R.layout.view_std_row_design,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder,int position){
        myViewHolder.classTv.setText("Class:"+SingleTon.getSingleTon().getStudentModelArrayList().get(position).getClassName());
        myViewHolder.rollNoTv.setText("Roll no:"+SingleTon.getSingleTon().getStudentModelArrayList().get(position).getRollNumber());
        myViewHolder.nameTv.setText("Name:"+SingleTon.getSingleTon().getStudentModelArrayList().get(position).getName());
        myViewHolder.contactNumberTv.setText("Contact:"+SingleTon.getSingleTon().getStudentModelArrayList().get(position).getContactNumber());
    }
    @Override
    public int getItemCount(){
        return SingleTon.getSingleTon().getStudentModelArrayList().size();
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{

    protected TextView classTv;
    protected TextView rollNoTv;
    protected TextView nameTv;
    protected TextView contactNumberTv;
    public MyViewHolder(View itemView){
        super(itemView);
        this.classTv=itemView.findViewById(R.id.classTv);
        this.rollNoTv=itemView.findViewById(R.id.rollNoTv);
        this.nameTv=itemView.findViewById(R.id.nameTv);
        this.contactNumberTv=itemView.findViewById(R.id.contactNumberTv);
    }
}