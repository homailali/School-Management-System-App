package life.homail.SchoolManagementSystem.ModelClasses;

public class StudentModel {
    private long studentRollNumber;
    private String studentFirstName;
    private String studentLastName;
    private String studentFullName;


    private String studentClassName;
    private String studentContactNumber;

    public StudentModel(long studentRollNumber, String studentFullName,String studentFirstName,String studentLastName, String studentClassName, String studentContactNumber) {
        this.studentRollNumber = studentRollNumber;
        this.studentFullName = studentFullName;
        this.studentClassName = studentClassName;
        this.studentContactNumber = studentContactNumber;
        this.studentFirstName=studentFirstName;
        this.studentLastName=studentLastName;
    }



    @Override
    public boolean equals(Object object){
        StudentModel newStudentModel=(StudentModel) object;
        boolean bool=
                this.studentFullName.equals(newStudentModel.studentFullName) &&
                this.studentFirstName.equals(newStudentModel.studentFirstName)  &&
                this.studentLastName.equals(newStudentModel.studentLastName) &&
                this.studentRollNumber== newStudentModel.studentRollNumber &&
                this.studentClassName.equals(newStudentModel.studentClassName) &&
                this.studentContactNumber.equals(newStudentModel.studentContactNumber);
        return bool;
    }

    public long getStudentRollNumber() {
        return studentRollNumber;
    }

    public void setStudentRollNumber(long studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public String getStudentClassName() {
        return studentClassName;
    }

    public void setStudentClassName(String studentClassName) {
        this.studentClassName = studentClassName;
    }

    public String getStudentContactNumber() {
        return studentContactNumber;
    }

    public void setStudentContactNumber(String studentContactNumber) {
        this.studentContactNumber = studentContactNumber;
    }
}