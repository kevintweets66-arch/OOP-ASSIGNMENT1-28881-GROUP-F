package com.auca.teacher;

import com.auca.interfaces.Identifiable;
import com.auca.interfaces.Registrable;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.AcademicMember;
import com.auca.abstracts.AcademicMember;
import java.time.LocalDate;
import java.math.BigDecimal;

public class Teacher extends AcademicMember {
    private String employeeNumber;
    private String specialization;
    private LocalDate hireDate;
    private BigDecimal salary;
    private String officeNumber;
    private String employmentType;

    public Teacher() { super(); }
    public Teacher(String employeeNumber, String specialization, LocalDate hireDate, BigDecimal salary, String officeNumber, String employmentType) {
        super();
        this.employeeNumber = employeeNumber;
        this.specialization = specialization;
        this.hireDate = hireDate;
        this.salary = salary;
        this.officeNumber = officeNumber;
        this.employmentType = employmentType;
    }

    public String getEmployeeNumber() { return employeeNumber; }
    public void setEmployeeNumber(String value) { this.employeeNumber = value; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String value) { this.specialization = value; }
    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate value) { this.hireDate = value; }
    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal value) { this.salary = value; }
    public String getOfficeNumber() { return officeNumber; }
    public void setOfficeNumber(String value) { this.officeNumber = value; }
    public String getEmploymentType() { return employmentType; }
    public void setEmploymentType(String value) { this.employmentType = value; }

    @Override public String getRoleDescription() { return "Teacher"; }
    @Override public String getAcademicCategory() { return "Teaching staff"; }
    @Override public void validate() throws ValidationException {
        super.validate();
        if (employeeNumber == null || employeeNumber.isBlank()) throw new ValidationException("employeeNumber is required.");
        if (specialization == null || specialization.isBlank()) throw new ValidationException("specialization is required.");
        if (salary == null || salary.compareTo(BigDecimal.ZERO) <= 0) throw new ValidationException("salary must be positive.");
        if (employmentType == null || employmentType.isBlank()) throw new ValidationException("employmentType is required.");
    }
    @Override public void printDetails() { System.out.println(this); }
    @Override public String getRegistrationSummary() { return "Teacher: " + getDisplayName() + " [" + getId() + "]"; }
    @Override public String toString() { return getRegistrationSummary(); }
}
