package com.auca.abstracts;

import com.auca.department.Department;
import com.auca.exceptions.ValidationException;
import java.time.LocalDate;

public abstract class AcademicMember extends Person {
    private String memberNumber;
    private Department department;
    private LocalDate joinDate;
    private String academicStatus;
    private String institutionalEmail;
    private String advisorName;

    protected AcademicMember() { super(); }

    protected AcademicMember(String personId, String firstName, String lastName,
            String email, String phoneNumber, LocalDate dateOfBirth,
            String memberNumber, Department department, LocalDate joinDate,
            String academicStatus, String institutionalEmail, String advisorName) {
        super(personId, firstName, lastName, email, phoneNumber, dateOfBirth);
        this.memberNumber = memberNumber;
        this.department = department;
        this.joinDate = joinDate;
        this.academicStatus = academicStatus;
        this.institutionalEmail = institutionalEmail;
        this.advisorName = advisorName;
    }

    public abstract String getAcademicCategory();

    @Override public void validate() throws ValidationException {
        super.validate();
        if (memberNumber == null || memberNumber.isBlank()) throw new ValidationException("Member number is required.");
        if (department == null) throw new ValidationException("Select an existing department.");
        if (joinDate == null) throw new ValidationException("Join date is required.");
        if (!"ACTIVE".equalsIgnoreCase(academicStatus) && !"INACTIVE".equalsIgnoreCase(academicStatus))
            throw new ValidationException("Academic status must be ACTIVE or INACTIVE.");
        if (institutionalEmail == null || !institutionalEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new ValidationException("Enter a valid institutional email.");
        if (advisorName == null || advisorName.isBlank()) throw new ValidationException("Advisor name is required.");
    }

    public String getMemberNumber() { return memberNumber; }
    public void setMemberNumber(String v) { memberNumber = v; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department v) { department = v; }
    public LocalDate getJoinDate() { return joinDate; }
    public void setJoinDate(LocalDate v) { joinDate = v; }
    public String getAcademicStatus() { return academicStatus; }
    public void setAcademicStatus(String v) { academicStatus = v; }
    public String getInstitutionalEmail() { return institutionalEmail; }
    public void setInstitutionalEmail(String v) { institutionalEmail = v; }
    public String getAdvisorName() { return advisorName; }
    public void setAdvisorName(String v) { advisorName = v; }
}
