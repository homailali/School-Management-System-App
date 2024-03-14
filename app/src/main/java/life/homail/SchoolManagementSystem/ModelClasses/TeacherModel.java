package life.homail.SchoolManagementSystem.ModelClasses;

public class TeacherModel {

    private String teacherFirstName;
    private String teacherLastName;
    private String teacherFullName;
    private long teacherId;
    private String teacherSubject;
    private String teacherPhoneNumber;

    public TeacherModel(long teacherId,String teacherFullName,String teacherFirstName,String teacherLastName, String teacherSubject, String teacherPhoneNumber) {
        this.teacherId = teacherId;
        this.teacherFullName = teacherFullName;
        this.teacherFirstName=teacherFirstName;
        this.teacherLastName=teacherLastName;
        this.teacherSubject = teacherSubject;
        this.teacherPhoneNumber = teacherPhoneNumber;
    }

    public String getTeacherFullName() {
        return teacherFullName;
    }

    public void setTeacherFullName(String teacherFullName) {
        this.teacherFullName = teacherFullName;
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

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public void setTeacherPhoneNumber(String teacherPhoneNumber) {
        this.teacherPhoneNumber = teacherPhoneNumber;
    }
}
