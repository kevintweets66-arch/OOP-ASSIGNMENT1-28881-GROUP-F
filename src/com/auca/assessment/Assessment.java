package com.auca.assessment;

import com.auca.interfaces.Identifiable;
import com.auca.interfaces.Registrable;
import com.auca.exceptions.ValidationException;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.enrollment.Enrollment;

public class Assessment  implements Identifiable, Registrable {
    private String assessmentId;
    private Enrollment enrollment;
    private String assessmentType;
    private double maximumScore;
    private double obtainedScore;
    private LocalDate assessmentDate;

    public Assessment() {  }
    public Assessment(String assessmentId, Enrollment enrollment, String assessmentType, double maximumScore, double obtainedScore, LocalDate assessmentDate) {
        this.assessmentId = assessmentId;
        this.enrollment = enrollment;
        this.assessmentType = assessmentType;
        this.maximumScore = maximumScore;
        this.obtainedScore = obtainedScore;
        this.assessmentDate = assessmentDate;
    }

    public String getAssessmentId() { return assessmentId; }
    public void setAssessmentId(String value) { this.assessmentId = value; }
    public Enrollment getEnrollment() { return enrollment; }
    public void setEnrollment(Enrollment value) { this.enrollment = value; }
    public String getAssessmentType() { return assessmentType; }
    public void setAssessmentType(String value) { this.assessmentType = value; }
    public double getMaximumScore() { return maximumScore; }
    public void setMaximumScore(double value) { this.maximumScore = value; }
    public double getObtainedScore() { return obtainedScore; }
    public void setObtainedScore(double value) { this.obtainedScore = value; }
    public LocalDate getAssessmentDate() { return assessmentDate; }
    public void setAssessmentDate(LocalDate value) { this.assessmentDate = value; }

    @Override public String getId() { return assessmentId; }
    @Override public String getDisplayName() { return String.valueOf(enrollment); }
    @Override public boolean isActive() { return true; }
    @Override public void validate() throws ValidationException {
        if (assessmentId == null || assessmentId.toString().isBlank()) throw new ValidationException("assessmentId is required.");
        if (assessmentId == null || assessmentId.isBlank()) throw new ValidationException("assessmentId is required.");
        if (enrollment == null) throw new ValidationException("Select a valid enrollment.");
        if (assessmentType == null || assessmentType.isBlank()) throw new ValidationException("assessmentType is required.");
        if (maximumScore <= 0 || obtainedScore < 0 || obtainedScore > maximumScore) throw new ValidationException("Assessment score is outside the allowed range.");
    }
    @Override public void printDetails() { System.out.println(this); }
    @Override public String getRegistrationSummary() { return "Assessment: " + getDisplayName() + " [" + getId() + "]"; }
    @Override public String toString() { return getRegistrationSummary(); }
}
