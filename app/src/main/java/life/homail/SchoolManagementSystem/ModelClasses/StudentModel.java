package life.homail.SchoolManagementSystem.ModelClasses;

public class StudentModel {
    private int rollNumber;
    private String name;
    private String className;
    private String phoneNumber;

    public StudentModel(int rollNumber, String name, String className, String phoneNumber) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.className = className;
        this.phoneNumber = phoneNumber;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
