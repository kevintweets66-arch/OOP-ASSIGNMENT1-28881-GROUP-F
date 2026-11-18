package com.auca.administrator;

import com.auca.interfaces.Identifiable;
import com.auca.interfaces.Registrable;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.Person;
import java.time.LocalDate;

public class Administrator extends Person {
    private String staffNumber;
    private String jobTitle;
    private String assignedOffice;
    private LocalDate employmentDate;
    private int accessLevel;
    private boolean active;

    public Administrator() { super(); }
    public Administrator(String staffNumber, String jobTitle, String assignedOffice, LocalDate employmentDate, int accessLevel, boolean active) {
        super();
        this.staffNumber = staffNumber;
        this.jobTitle = jobTitle;
        this.assignedOffice = assignedOffice;
        this.employmentDate = employmentDate;
        this.accessLevel = accessLevel;
        this.active = active;
    }

    public String getStaffNumber() { return staffNumber; }
    public void setStaffNumber(String value) { this.staffNumber = value; }
    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String value) { this.jobTitle = value; }
    public String getAssignedOffice() { return assignedOffice; }
    public void setAssignedOffice(String value) { this.assignedOffice = value; }
    public LocalDate getEmploymentDate() { return employmentDate; }
    public void setEmploymentDate(LocalDate value) { this.employmentDate = value; }
    public int getAccessLevel() { return accessLevel; }
    public void setAccessLevel(int value) { this.accessLevel = value; }
    public boolean getActive() { return active; }
    public void setActive(boolean value) { this.active = value; }

    @Override public String getRoleDescription() { return "Administrator"; }
    @Override public void validate() throws ValidationException {
        super.validate();
        if (staffNumber == null || staffNumber.isBlank()) throw new ValidationException("staffNumber is required.");
        if (jobTitle == null || jobTitle.isBlank()) throw new ValidationException("jobTitle is required.");
        if (assignedOffice == null || assignedOffice.isBlank()) throw new ValidationException("assignedOffice is required.");
        if (accessLevel < 1) throw new ValidationException("accessLevel has an invalid value.");
    }
    @Override public void printDetails() { System.out.println(this); }
    @Override public String getRegistrationSummary() { return "Administrator: " + getDisplayName() + " [" + getId() + "]"; }
    @Override public String toString() { return getRegistrationSummary(); }
}
