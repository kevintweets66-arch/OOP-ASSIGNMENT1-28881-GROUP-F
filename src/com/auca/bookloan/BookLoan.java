package com.auca.bookloan;

import com.auca.interfaces.Identifiable;
import com.auca.interfaces.Registrable;
import com.auca.exceptions.ValidationException;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.student.Student;
import com.auca.librarybook.LibraryBook;

public class BookLoan  implements Identifiable, Registrable {
    private String loanId;
    private Student student;
    private LibraryBook book;
    private LocalDate borrowedDate;
    private LocalDate dueDate;
    private LocalDate returnedDate;

    public BookLoan() {  }
    public BookLoan(String loanId, Student student, LibraryBook book, LocalDate borrowedDate, LocalDate dueDate, LocalDate returnedDate) {
        this.loanId = loanId;
        this.student = student;
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
    }

    public String getLoanId() { return loanId; }
    public void setLoanId(String value) { this.loanId = value; }
    public Student getStudent() { return student; }
    public void setStudent(Student value) { this.student = value; }
    public LibraryBook getBook() { return book; }
    public void setBook(LibraryBook value) { this.book = value; }
    public LocalDate getBorrowedDate() { return borrowedDate; }
    public void setBorrowedDate(LocalDate value) { this.borrowedDate = value; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate value) { this.dueDate = value; }
    public LocalDate getReturnedDate() { return returnedDate; }
    public void setReturnedDate(LocalDate value) { this.returnedDate = value; }

    @Override public String getId() { return loanId; }
    @Override public String getDisplayName() { return String.valueOf(student); }
    @Override public boolean isActive() { return true; }
    @Override public void validate() throws ValidationException {
        if (loanId == null || loanId.toString().isBlank()) throw new ValidationException("loanId is required.");
        if (loanId == null || loanId.isBlank()) throw new ValidationException("loanId is required.");
        if (student == null) throw new ValidationException("Select a valid student.");
        if (book == null) throw new ValidationException("Select a valid book.");
        if (borrowedDate == null || dueDate == null || !dueDate.isAfter(borrowedDate)) throw new ValidationException("Due date must be after borrowed date.");
    }
    @Override public void printDetails() { System.out.println(this); }
    @Override public String getRegistrationSummary() { return "BookLoan: " + getDisplayName() + " [" + getId() + "]"; }
    @Override public String toString() { return getRegistrationSummary(); }
}
