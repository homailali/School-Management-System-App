package life.homail.SchoolManagementSystem.ModelClasses;

public class TeacherModel {
    private String teacherName;
    private long teacherId;
    private String teacherSubject;
    private String teacherPhoneNumber;

    public TeacherModel(String teacherName, long teacherId, String teacherSubject, String teacherPhoneNumber) {
        this.teacherName = teacherName;
        this.teacherId = teacherId;
        this.teacherSubject = teacherSubject;
        this.teacherPhoneNumber = teacherPhoneNumber;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(String teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    public String getTeacherPhoneNumber() {
        return teacherPhoneNumber;
    }

    public void setTeacherPhoneNumber(String teacherPhoneNumber) {
        this.teacherPhoneNumber = teacherPhoneNumber;
    }
}
