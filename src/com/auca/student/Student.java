package com.auca.student;

import com.auca.interfaces.Identifiable;
import com.auca.interfaces.Registrable;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.AcademicMember;
import com.auca.abstracts.AcademicMember;
import java.time.LocalDate;

public class Student extends AcademicMember {
    private String studentNumber;
    private String programName;
    private LocalDate admissionDate;
    private int studyYear;
    private String guardianPhone;
    private boolean scholarshipStatus;

    public Student() { super(); }
    public Student(String studentNumber, String programName, LocalDate admissionDate, int studyYear, String guardianPhone, boolean scholarshipStatus) {
        super();
        this.studentNumber = studentNumber;
        this.programName = programName;
        this.admissionDate = admissionDate;
        this.studyYear = studyYear;
        this.guardianPhone = guardianPhone;
        this.scholarshipStatus = scholarshipStatus;
    }

    public String getStudentNumber() { return studentNumber; }
    public void setStudentNumber(String value) { this.studentNumber = value; }
    public String getProgramName() { return programName; }
    public void setProgramName(String value) { this.programName = value; }
    public LocalDate getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(LocalDate value) { this.admissionDate = value; }
    public int getStudyYear() { return studyYear; }
    public void setStudyYear(int value) { this.studyYear = value; }
    public String getGuardianPhone() { return guardianPhone; }
    public void setGuardianPhone(String value) { this.guardianPhone = value; }
    public boolean getScholarshipStatus() { return scholarshipStatus; }
    public void setScholarshipStatus(boolean value) { this.scholarshipStatus = value; }

    @Override public String getRoleDescription() { return "Student"; }
    @Override public String getAcademicCategory() { return "Learner"; }
    @Override public void validate() throws ValidationException {
        super.validate();
        if (studentNumber == null || studentNumber.isBlank()) throw new ValidationException("studentNumber is required.");
        if (programName == null || programName.isBlank()) throw new ValidationException("programName is required.");
        if (studyYear < 1) throw new ValidationException("studyYear has an invalid value.");
        if (guardianPhone == null || guardianPhone.isBlank()) throw new ValidationException("guardianPhone is required.");
    }
    @Override public void printDetails() { System.out.println(this); }
    @Override public String getRegistrationSummary() { return "Student: " + getDisplayName() + " [" + getId() + "]"; }
    @Override public String toString() { return getRegistrationSummary(); }
}
