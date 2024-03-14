package life.homail.SchoolManagementSystem.ModelClasses;

public class StudentModel {
    private long rollNumber;
    private String firstName;
    private String lastName;
    private String fullName;


    private String className;
    private String contactNumber;

    public StudentModel(long rollNumber, String fullName,String firstName,String lastName, String className, String contactNumber) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.className = className;
        this.contactNumber = contactNumber;
        this.firstName=firstName;
        this.lastName=lastName;
    }



    @Override
    public boolean equals(Object object){
        StudentModel newStudentModel=(StudentModel) object;
        boolean bool=
                this.fullName.equals(newStudentModel.fullName) &&
                this.firstName.equals(newStudentModel.firstName)  &&
                this.lastName.equals(newStudentModel.lastName) &&
                this.rollNumber== newStudentModel.rollNumber &&
                this.className.equals(newStudentModel.className) &&
                this.contactNumber.equals(newStudentModel.contactNumber);
        return bool;
    }


    public long getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(long rollNumber) {
        this.rollNumber = rollNumber;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}