package life.homail.SchoolManagementSystem.ViewStudents;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
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
        this.getAndSetValueOfLayoutsHeight(myViewHolder);
        myViewHolder.classTv.setText(SingleTon.getSingleTon().getStudentModelArrayList().get(position).getClassName());
        myViewHolder.rollNoTv.setText(String.valueOf(SingleTon.getSingleTon().getStudentModelArrayList().get(position).getRollNumber()));
        myViewHolder.nameTv.setText(SingleTon.getSingleTon().getStudentModelArrayList().get(position).getName());
        myViewHolder.contactNumberTv.setText(SingleTon.getSingleTon().getStudentModelArrayList().get(position).getContactNumber());
    }

    private void getAndSetValueOfLayoutsHeight(MyViewHolder myViewHolder){
        int maxHeight;
        int nameLayoutHeight=myViewHolder.nameConstraintLayout.getHeight();
        int rollNoLayoutHeight=myViewHolder.rollNoConstraintLayout.getHeight();
        int classLayoutHeight=myViewHolder.classConstraintLayout.getHeight();
        int contactNumberLayoutHeight=myViewHolder.contactNumberConstraintLayout.getHeight();
        maxHeight = Math.max(Math.max(nameLayoutHeight,rollNoLayoutHeight),Math.max(classLayoutHeight,contactNumberLayoutHeight));

        myViewHolder.nameConstraintLayout.setMinHeight(maxHeight);
        myViewHolder.rollNoConstraintLayout.setMinHeight(maxHeight);
        myViewHolder.classConstraintLayout.setMinHeight(maxHeight);
        myViewHolder.contactNumberConstraintLayout.setMinHeight(maxHeight);



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

    protected ConstraintLayout nameConstraintLayout;
    protected ConstraintLayout rollNoConstraintLayout;
    protected ConstraintLayout classConstraintLayout;
    protected ConstraintLayout contactNumberConstraintLayout;
    public MyViewHolder(View itemView){
        super(itemView);
        this.classTv=itemView.findViewById(R.id.classTv);
        this.rollNoTv=itemView.findViewById(R.id.rollNoTv);
        this.nameTv=itemView.findViewById(R.id.nameTv);
        this.contactNumberTv=itemView.findViewById(R.id.contactNumberTv);

        this.nameConstraintLayout=itemView.findViewById(R.id.nameConstraintLayout);
        this.rollNoConstraintLayout=itemView.findViewById(R.id.rollNoConstraintLayout);
        this.classConstraintLayout=itemView.findViewById(R.id.classConstraintLayout);
        this.contactNumberConstraintLayout=itemView.findViewById(R.id.contactNumberConstraintLayout);
    }
}