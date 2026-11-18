package com.auca.abstracts;

import com.auca.interfaces.Identifiable;
import com.auca.interfaces.Registrable;
import com.auca.exceptions.ValidationException;
import java.time.LocalDate;

public abstract class Person implements Identifiable, Registrable {
    private String personId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    protected Person() { }

    protected Person(String personId, String firstName, String lastName,
                     String email, String phoneNumber, LocalDate dateOfBirth) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public abstract String getRoleDescription();

    @Override public String getId() { return personId; }
    @Override public String getDisplayName() { return firstName + " " + lastName; }
    @Override public boolean isActive() { return true; }

    @Override public void validate() throws ValidationException {
        if (personId == null || personId.isBlank()) throw new ValidationException("Person ID is required.");
        if (firstName == null || firstName.trim().length() < 2 || firstName.trim().length() > 60)
            throw new ValidationException("First name must contain 2-60 characters.");
        if (lastName == null || lastName.trim().length() < 2 || lastName.trim().length() > 60)
            throw new ValidationException("Last name must contain 2-60 characters.");
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new ValidationException("Enter a valid email address.");
        if (phoneNumber == null || !phoneNumber.matches("^\\+?[0-9]{10,15}$"))
            throw new ValidationException("Phone must contain 10-15 digits, optionally starting with +.");
        if (dateOfBirth == null || !dateOfBirth.isBefore(LocalDate.now()))
            throw new ValidationException("Date of birth must be in the past.");
    }

    @Override public void printDetails() { System.out.println(this); }
    @Override public String getRegistrationSummary() { return getRoleDescription() + ": " + getDisplayName() + " [" + personId + "]"; }

    public String getPersonId() { return personId; }
    public void setPersonId(String v) { personId = v; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String v) { firstName = v; }
    public String getLastName() { return lastName; }
    public void setLastName(String v) { lastName = v; }
    public String getEmail() { return email; }
    public void setEmail(String v) { email = v; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String v) { phoneNumber = v; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate v) { dateOfBirth = v; }

    @Override public String toString() {
        return getRegistrationSummary() + ", email=" + email + ", phone=" + phoneNumber
                + ", dateOfBirth=" + dateOfBirth;
    }
}
