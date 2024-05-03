package life.homail.SchoolManagementSystem.ViewTeachers;

import life.homail.SchoolManagementSystem.ModelClasses.TeacherModel;
import life.homail.SchoolManagementSystem.SingleTon.SingleTon;
import life.homail.SchoolManagementSystem.Toast.MyToast;

public class ViewTeacherDeleteBtnHandler {
    private int position;
    private ViewTeachersMain viewTeachersMain;
    public ViewTeacherDeleteBtnHandler(ViewTeachersMain viewTeachersMain) {

        this.viewTeachersMain = viewTeachersMain;
    }
    protected void teacherDeleteBtnHandlerMain(int position){
        this.position=position;
        this.viewTeachersMain.viewTeachersDeleteDialogClass.getTeacherDeleteDialog().show();
    }
    protected void deleteTeacher(){
        TeacherModel teacherModel= SingleTon.getSingleTon().getTeacherModelArrayList().get(position);
        boolean bool=SingleTon.getSingleTon().getHomeMain().homeTeachersDb.deleteTeacher(teacherModel);
        if (bool){
            MyToast.makeToast("Teacher deleted successfully",this.viewTeachersMain);
            SingleTon.getSingleTon().getTeacherModelArrayList().remove(position);
            this.viewTeachersMain.viewTeachersAdapter.notifyItemRemoved(position);
            this.viewTeachersMain.viewTeachersAdapter.notifyItemRangeChanged(position,SingleTon.getSingleTon().getTeacherModelArrayList().size());
            this.viewTeachersMain.setNoTeacherTvVisibility("No teacher added");
            this.viewTeachersMain.viewTeachersDeleteDialogClass.getTeacherDeleteDialog().dismiss();
        } else MyToast.makeToast("Could not delete teacher",this.viewTeachersMain);
    }


}
