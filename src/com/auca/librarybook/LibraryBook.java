package com.auca.librarybook;

import com.auca.interfaces.Identifiable;
import com.auca.interfaces.Registrable;
import com.auca.exceptions.ValidationException;
import java.time.LocalDate;
import java.math.BigDecimal;

public class LibraryBook  implements Identifiable, Registrable {
    private String bookId;
    private String isbn;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;

    public LibraryBook() {  }
    public LibraryBook(String bookId, String isbn, String title, String author, int totalCopies, int availableCopies) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public String getBookId() { return bookId; }
    public void setBookId(String value) { this.bookId = value; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String value) { this.isbn = value; }
    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }
    public String getAuthor() { return author; }
    public void setAuthor(String value) { this.author = value; }
    public int getTotalCopies() { return totalCopies; }
    public void setTotalCopies(int value) { this.totalCopies = value; }
    public int getAvailableCopies() { return availableCopies; }
    public void setAvailableCopies(int value) { this.availableCopies = value; }

    @Override public String getId() { return bookId; }
    @Override public String getDisplayName() { return String.valueOf(isbn); }
    @Override public boolean isActive() { return true; }
    @Override public void validate() throws ValidationException {
        if (bookId == null || bookId.toString().isBlank()) throw new ValidationException("bookId is required.");
        if (bookId == null || bookId.isBlank()) throw new ValidationException("bookId is required.");
        if (title == null || title.isBlank()) throw new ValidationException("title is required.");
        if (author == null || author.isBlank()) throw new ValidationException("author is required.");
        if (totalCopies < 1) throw new ValidationException("totalCopies has an invalid value.");
        if (availableCopies < 1) throw new ValidationException("availableCopies has an invalid value.");
        if (totalCopies < 0 || availableCopies < 0 || availableCopies > totalCopies) throw new ValidationException("Book copy counts are invalid.");
    }
    @Override public void printDetails() { System.out.println(this); }
    @Override public String getRegistrationSummary() { return "LibraryBook: " + getDisplayName() + " [" + getId() + "]"; }
    @Override public String toString() { return getRegistrationSummary(); }
}
