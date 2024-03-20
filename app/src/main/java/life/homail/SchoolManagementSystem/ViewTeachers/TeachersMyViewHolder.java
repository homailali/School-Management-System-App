package life.homail.SchoolManagementSystem.ViewTeachers;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import life.homail.SchoolManagementSystem.R;

public class TeachersMyViewHolder extends RecyclerView.ViewHolder {

    // fields
    private Button viewTeachersEditBtn;
    private Button viewTeachersDeleteBtn;
    private TextView viewTeachersNameTv;
    private TextView viewTeachersIdTv;
    private TextView viewTeachersSubjectTv;
    private TextView viewTeachersPhoneNumberTv;
    private ConstraintLayout teachersNameConstraintLayout;
    private ConstraintLayout teachersIdConstraintLayout;
    private ConstraintLayout teachersSubjectConstraintLayout;
    private ConstraintLayout teachersPhoneNumberConstraintLayout;



    // constructor
    public TeachersMyViewHolder(View view) {
        super(view);
        this.initializeViews();
    }

    private void initializeViews(){
        this.viewTeachersEditBtn=itemView.findViewById(R.id.viewTeachersEditBtn);
        this.viewTeachersDeleteBtn=itemView.findViewById(R.id.viewTeachersDeleteBtn);

        this.viewTeachersNameTv=itemView.findViewById(R.id.viewTeachersNameTv);
        this.viewTeachersIdTv=itemView.findViewById(R.id.viewTeachersIdTv);
        this.viewTeachersSubjectTv=itemView.findViewById(R.id.viewTeachersSubjectTv);
        this.viewTeachersPhoneNumberTv=itemView.findViewById(R.id.viewTeachersPhoneNumberTv);

        this.teachersNameConstraintLayout=itemView.findViewById(R.id.viewTeachersNameConstraintLayout);
        this.teachersIdConstraintLayout=itemView.findViewById(R.id.viewTeachersIdConstraintLayout);
        this.teachersSubjectConstraintLayout=itemView.findViewById(R.id.viewTeachersSubjectConstraintLayout);
        this.teachersPhoneNumberConstraintLayout=itemView.findViewById(R.id.viewTeachersPhoneNumberConstraintLayout);
    }

    public Button getViewTeachersEditBtn() {
        return viewTeachersEditBtn;
    }

    public void setViewTeachersEditBtn(Button viewTeachersEditBtn) {
        this.viewTeachersEditBtn = viewTeachersEditBtn;
    }

    public Button getViewTeachersDeleteBtn() {
        return viewTeachersDeleteBtn;
    }

    public void setViewTeachersDeleteBtn(Button viewTeachersDeleteBtn) {
        this.viewTeachersDeleteBtn = viewTeachersDeleteBtn;
    }

    public TextView getViewTeachersNameTv() {
        return viewTeachersNameTv;
    }

    public void setViewTeachersNameTv(TextView viewTeachersNameTv) {
        this.viewTeachersNameTv = viewTeachersNameTv;
    }

    public TextView getViewTeachersIdTv() {
        return viewTeachersIdTv;
    }

    public void setViewTeachersIdTv(TextView viewTeachersIdTv) {
        this.viewTeachersIdTv = viewTeachersIdTv;
    }

    public TextView getViewTeachersSubjectTv() {
        return viewTeachersSubjectTv;
    }

    public void setViewTeachersSubjectTv(TextView viewTeachersSubjectTv) {
        this.viewTeachersSubjectTv = viewTeachersSubjectTv;
    }

    public TextView getViewTeachersPhoneNumberTv() {
        return viewTeachersPhoneNumberTv;
    }

    public void setViewTeachersPhoneNumberTv(TextView viewTeachersPhoneNumberTv) {
        this.viewTeachersPhoneNumberTv = viewTeachersPhoneNumberTv;
    }

    public ConstraintLayout getTeachersNameConstraintLayout() {
        return teachersNameConstraintLayout;
    }

    public void setTeachersNameConstraintLayout(ConstraintLayout teachersNameConstraintLayout) {
        this.teachersNameConstraintLayout = teachersNameConstraintLayout;
    }

    public ConstraintLayout getTeachersIdConstraintLayout() {
        return teachersIdConstraintLayout;
    }

    public void setTeachersIdConstraintLayout(ConstraintLayout teachersIdConstraintLayout) {
        this.teachersIdConstraintLayout = teachersIdConstraintLayout;
    }

    public ConstraintLayout getTeachersSubjectConstraintLayout() {
        return teachersSubjectConstraintLayout;
    }

    public void setTeachersSubjectConstraintLayout(ConstraintLayout teachersSubjectConstraintLayout) {
        this.teachersSubjectConstraintLayout = teachersSubjectConstraintLayout;
    }

    public ConstraintLayout getTeachersPhoneNumberConstraintLayout() {
        return teachersPhoneNumberConstraintLayout;
    }

    public void setTeachersPhoneNumberConstraintLayout(ConstraintLayout teachersPhoneNumberConstraintLayout) {
        this.teachersPhoneNumberConstraintLayout = teachersPhoneNumberConstraintLayout;
    }
}
