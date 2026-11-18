package com.auca.enrollment;

import com.auca.interfaces.Identifiable;
import com.auca.interfaces.Registrable;
import com.auca.exceptions.ValidationException;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.student.Student;
import com.auca.course.Course;

public class Enrollment  implements Identifiable, Registrable {
    private String enrollmentId;
    private Student student;
    private Course course;
    private LocalDate enrollmentDate;
    private String semester;
    private String enrollmentStatus;

    public Enrollment() {  }
    public Enrollment(String enrollmentId, Student student, Course course, LocalDate enrollmentDate, String semester, String enrollmentStatus) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.semester = semester;
        this.enrollmentStatus = enrollmentStatus;
    }

    public String getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(String value) { this.enrollmentId = value; }
    public Student getStudent() { return student; }
    public void setStudent(Student value) { this.student = value; }
    public Course getCourse() { return course; }
    public void setCourse(Course value) { this.course = value; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate value) { this.enrollmentDate = value; }
    public String getSemester() { return semester; }
    public void setSemester(String value) { this.semester = value; }
    public String getEnrollmentStatus() { return enrollmentStatus; }
    public void setEnrollmentStatus(String value) { this.enrollmentStatus = value; }

    @Override public String getId() { return enrollmentId; }
    @Override public String getDisplayName() { return String.valueOf(student); }
    @Override public boolean isActive() { return true; }
    @Override public void validate() throws ValidationException {
        if (enrollmentId == null || enrollmentId.toString().isBlank()) throw new ValidationException("enrollmentId is required.");
        if (enrollmentId == null || enrollmentId.isBlank()) throw new ValidationException("enrollmentId is required.");
        if (student == null) throw new ValidationException("Select a valid student.");
        if (course == null) throw new ValidationException("Select a valid course.");
        if (semester == null || semester.isBlank()) throw new ValidationException("semester is required.");
        if (enrollmentStatus == null || enrollmentStatus.isBlank()) throw new ValidationException("enrollmentStatus is required.");
    }
    @Override public void printDetails() { System.out.println(this); }
    @Override public String getRegistrationSummary() { return "Enrollment: " + getDisplayName() + " [" + getId() + "]"; }
    @Override public String toString() { return getRegistrationSummary(); }
}
