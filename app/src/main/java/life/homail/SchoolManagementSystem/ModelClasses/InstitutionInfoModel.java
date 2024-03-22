package life.homail.SchoolManagementSystem.ModelClasses;

public class InstitutionInfoModel {
    private String principalName;
    private String contactNumber;
    private String institutionName;
    private String institutionLocation;

    public InstitutionInfoModel(String principalName, String contactNumber, String institutionName, String institutionLocation) {
        this.principalName = principalName;
        this.contactNumber = contactNumber;
        this.institutionName = institutionName;
        this.institutionLocation = institutionLocation;
    }

    public boolean equals(InstitutionInfoModel institutionInfoModel){
        return
               this.institutionName.equals(institutionInfoModel.getInstitutionName()) &&
               this.institutionLocation.equals(institutionInfoModel.getInstitutionLocation()) &&
               this.principalName.equals(institutionInfoModel.getPrincipalName()) &&
               this.contactNumber.equals(institutionInfoModel.getContactNumber());
    }


    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionLocation() {
        return institutionLocation;
    }

    public void setInstitutionLocation(String institutionLocation) {
        this.institutionLocation = institutionLocation;
    }
}