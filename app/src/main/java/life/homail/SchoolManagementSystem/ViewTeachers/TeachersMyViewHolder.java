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
    private ConstraintLayout viewTeachersNameConstraintLayout;
    private ConstraintLayout viewTeachersIdConstraintLayout;
    private ConstraintLayout viewTeachersSubjectConstraintLayout;
    private ConstraintLayout viewTeachersPhoneNumberConstraintLayout;



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

        this.viewTeachersNameConstraintLayout=itemView.findViewById(R.id.nameConstraintLayout);
        this.viewTeachersIdConstraintLayout=itemView.findViewById(R.id.viewTeachersIdConstraintLayout);
        this.viewTeachersSubjectConstraintLayout=itemView.findViewById(R.id.viewTeachersSubjectConstraintLayout);
        this.viewTeachersPhoneNumberConstraintLayout=itemView.findViewById(R.id.viewTeachersPhoneNumberConstraintLayout);
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

    public ConstraintLayout getViewTeachersNameConstraintLayout() {
        return viewTeachersNameConstraintLayout;
    }

    public void setViewTeachersNameConstraintLayout(ConstraintLayout viewTeachersNameConstraintLayout) {
        this.viewTeachersNameConstraintLayout = viewTeachersNameConstraintLayout;
    }

    public ConstraintLayout getViewTeachersIdConstraintLayout() {
        return viewTeachersIdConstraintLayout;
    }

    public void setViewTeachersIdConstraintLayout(ConstraintLayout viewTeachersIdConstraintLayout) {
        this.viewTeachersIdConstraintLayout = viewTeachersIdConstraintLayout;
    }

    public ConstraintLayout getViewTeachersSubjectConstraintLayout() {
        return viewTeachersSubjectConstraintLayout;
    }

    public void setViewTeachersSubjectConstraintLayout(ConstraintLayout viewTeachersSubjectConstraintLayout) {
        this.viewTeachersSubjectConstraintLayout = viewTeachersSubjectConstraintLayout;
    }

    public ConstraintLayout getViewTeachersPhoneNumberConstraintLayout() {
        return viewTeachersPhoneNumberConstraintLayout;
    }

    public void setViewTeachersPhoneNumberConstraintLayout(ConstraintLayout viewTeachersPhoneNumberConstraintLayout) {
        this.viewTeachersPhoneNumberConstraintLayout = viewTeachersPhoneNumberConstraintLayout;
    }
}
