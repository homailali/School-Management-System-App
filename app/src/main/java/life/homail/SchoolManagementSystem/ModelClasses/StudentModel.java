package life.homail.SchoolManagementSystem.ModelClasses;

public class StudentModel {
    private long rollNumber;
    private String name;
    private String className;
    private String contactNumber;

    public StudentModel(long rollNumber, String name, String className, String contactNumber) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.className = className;
        this.contactNumber = contactNumber;
    }

    public long getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(long rollNumber) {
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
