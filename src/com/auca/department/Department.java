package com.auca.department;

import com.auca.interfaces.Identifiable;
import com.auca.interfaces.Registrable;
import com.auca.exceptions.ValidationException;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.teacher.Teacher;

public class Department  implements Identifiable, Registrable {
    private String departmentId;
    private String departmentName;
    private String departmentCode;
    private String officeLocation;
    private String contactEmail;
    private Teacher headTeacher;

    public Department() {  }
    public Department(String departmentId, String departmentName, String departmentCode, String officeLocation, String contactEmail, Teacher headTeacher) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.officeLocation = officeLocation;
        this.contactEmail = contactEmail;
        this.headTeacher = headTeacher;
    }

    public String getDepartmentId() { return departmentId; }
    public void setDepartmentId(String value) { this.departmentId = value; }
    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String value) { this.departmentName = value; }
    public String getDepartmentCode() { return departmentCode; }
    public void setDepartmentCode(String value) { this.departmentCode = value; }
    public String getOfficeLocation() { return officeLocation; }
    public void setOfficeLocation(String value) { this.officeLocation = value; }
    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String value) { this.contactEmail = value; }
    public Teacher getHeadTeacher() { return headTeacher; }
    public void setHeadTeacher(Teacher value) { this.headTeacher = value; }

    @Override public String getId() { return departmentId; }
    @Override public String getDisplayName() { return String.valueOf(departmentName); }
    @Override public boolean isActive() { return true; }
    @Override public void validate() throws ValidationException {
        if (departmentId == null || departmentId.toString().isBlank()) throw new ValidationException("departmentId is required.");
        if (departmentId == null || departmentId.isBlank()) throw new ValidationException("departmentId is required.");
        if (departmentName == null || departmentName.isBlank()) throw new ValidationException("departmentName is required.");
        if (officeLocation == null || officeLocation.isBlank()) throw new ValidationException("officeLocation is required.");
        if (contactEmail == null || contactEmail.isBlank()) throw new ValidationException("contactEmail is required.");
    }
    @Override public void printDetails() { System.out.println(this); }
    @Override public String getRegistrationSummary() { return "Department: " + getDisplayName() + " [" + getId() + "]"; }
    @Override public String toString() { return getRegistrationSummary(); }
}
