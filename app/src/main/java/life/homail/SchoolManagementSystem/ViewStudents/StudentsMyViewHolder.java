package life.homail.SchoolManagementSystem.ViewStudents;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import life.homail.SchoolManagementSystem.R;

public class StudentsMyViewHolder extends RecyclerView.ViewHolder {

    private Button editBtn;
    private TextView nameTv;
    private TextView classTv;
    private TextView rollNoTv;
    private Button deleteBtn;
    private TextView contactNumberTv;
    private ConstraintLayout nameConstraintLayout;
    private ConstraintLayout rollNoConstraintLayout;
    private ConstraintLayout classConstraintLayout;
    private ConstraintLayout contactNumberConstraintLayout;

    public StudentsMyViewHolder(View itemView) {
        super(itemView);
        this.initializeViews();
    }
    private void initializeViews(){
        this.editBtn = itemView.findViewById(R.id.editBtn);
        this.deleteBtn = itemView.findViewById(R.id.deleteBtn);

        this.classTv = itemView.findViewById(R.id.classTv);
        this.rollNoTv = itemView.findViewById(R.id.rollNoTv);
        this.nameTv = itemView.findViewById(R.id.nameTv);
        this.contactNumberTv = itemView.findViewById(R.id.contactNumberTv);

        this.nameConstraintLayout = itemView.findViewById(R.id.nameConstraintLayout);
        this.rollNoConstraintLayout = itemView.findViewById(R.id.rollNoConstraintLayout);
        this.classConstraintLayout = itemView.findViewById(R.id.classConstraintLayout);
        this.contactNumberConstraintLayout = itemView.findViewById(R.id.contactNumberConstraintLayout);
    }


    public Button getEditBtn() {
        return editBtn;
    }

    public void setEditBtn(Button editBtn) {
        this.editBtn = editBtn;
    }

    public TextView getNameTv() {
        return nameTv;
    }

    public void setNameTv(TextView nameTv) {
        this.nameTv = nameTv;
    }

    public TextView getClassTv() {
        return classTv;
    }

    public void setClassTv(TextView classTv) {
        this.classTv = classTv;
    }

    public TextView getRollNoTv() {
        return rollNoTv;
    }

    public void setRollNoTv(TextView rollNoTv) {
        this.rollNoTv = rollNoTv;
    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(Button deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    public TextView getContactNumberTv() {
        return contactNumberTv;
    }

    public void setContactNumberTv(TextView contactNumberTv) {
        this.contactNumberTv = contactNumberTv;
    }

    public ConstraintLayout getNameConstraintLayout() {
        return nameConstraintLayout;
    }

    public void setNameConstraintLayout(ConstraintLayout nameConstraintLayout) {
        this.nameConstraintLayout = nameConstraintLayout;
    }

    public ConstraintLayout getRollNoConstraintLayout() {
        return rollNoConstraintLayout;
    }

    public void setRollNoConstraintLayout(ConstraintLayout rollNoConstraintLayout) {
        this.rollNoConstraintLayout = rollNoConstraintLayout;
    }

    public ConstraintLayout getClassConstraintLayout() {
        return classConstraintLayout;
    }

    public void setClassConstraintLayout(ConstraintLayout classConstraintLayout) {
        this.classConstraintLayout = classConstraintLayout;
    }

    public ConstraintLayout getContactNumberConstraintLayout() {
        return contactNumberConstraintLayout;
    }

    public void setContactNumberConstraintLayout(ConstraintLayout contactNumberConstraintLayout) {
        this.contactNumberConstraintLayout = contactNumberConstraintLayout;
    }
}
