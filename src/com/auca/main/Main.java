package com.auca.main;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import com.auca.interfaces.Identifiable;
import com.auca.abstracts.Person;
import com.auca.student.Student;
import com.auca.teacher.Teacher;
import com.auca.administrator.Administrator;
import com.auca.department.Department;
import com.auca.course.Course;
import com.auca.classroom.Classroom;
import com.auca.enrollment.Enrollment;
import com.auca.assessment.Assessment;
import com.auca.feepayment.FeePayment;
import com.auca.librarybook.LibraryBook;
import com.auca.bookloan.BookLoan;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    private static final List<Person> people = new ArrayList<>();
    private static final List<Identifiable> records = new ArrayList<>();
    private static final List<Department> departments = new ArrayList<>();
    private static final List<Student> students = new ArrayList<>();
    private static final List<Teacher> teachers = new ArrayList<>();
    private static final List<Administrator> administrators = new ArrayList<>();
    private static final List<Course> courses = new ArrayList<>();
    private static final List<Classroom> classrooms = new ArrayList<>();
    private static final List<Enrollment> enrollments = new ArrayList<>();
    private static final List<Assessment> assessments = new ArrayList<>();
    private static final List<FeePayment> payments = new ArrayList<>();
    private static final List<LibraryBook> books = new ArrayList<>();
    private static final List<BookLoan> loans = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            String choice = input.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> registerDepartment();
                    case "2" -> listRecords();
                    case "3" -> searchById();
                    case "4" -> demonstratePolymorphism();
                    case "0" -> running = false;
                    default -> System.out.println("Invalid option. Please choose 0-4.");
                }
            } catch (Exception ex) {
                System.out.println("Operation could not be completed: " + ex.getMessage());
            }
            System.out.println();
        }
        System.out.println("Thank you for using AUCA_ID.");
    }

    private static void showMenu() {
        System.out.println("========== AUCA_ID SCHOOL MANAGEMENT ==========");
        System.out.println("1. Register Department");
        System.out.println("2. View All Records");
        System.out.println("3. Search Record by ID");
        System.out.println("4. Demonstrate Polymorphism");
        System.out.println("0. Exit");
        System.out.print("Select: ");
    }

    private static void registerDepartment() {
        Department d = new Department();
        System.out.print("Department ID: "); d.setDepartmentId(input.nextLine().trim());
        System.out.print("Department name: "); d.setDepartmentName(input.nextLine().trim());
        System.out.print("Department code: "); d.setDepartmentCode(input.nextLine().trim());
        System.out.print("Office location: "); d.setOfficeLocation(input.nextLine().trim());
        System.out.print("Contact email: "); d.setContactEmail(input.nextLine().trim());
        System.out.println("Head teacher can be assigned after a teacher has been registered.");
        try {
            d.validate();
            if (findById(d.getId()) != null) {
                System.out.println("Duplicate ID. Department was not saved.");
                return;
            }
            departments.add(d);
            records.add(d);
            System.out.println("Department saved: " + d.getRegistrationSummary());
        } catch (Exception e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }

    private static Identifiable findById(String id) {
        for (Identifiable item : records) if (item.getId() != null && item.getId().equalsIgnoreCase(id)) return item;
        return null;
    }

    private static void listRecords() {
        if (records.isEmpty()) { System.out.println("No records have been registered."); return; }
        for (Identifiable item : records) System.out.println(item.getDisplayName() + " [" + item.getId() + "]");
    }

    private static void searchById() {
        System.out.print("Enter record ID: ");
        String id = input.nextLine().trim();
        Identifiable item = findById(id);
        if (item == null) System.out.println("No record found with ID " + id);
        else System.out.println(item.getDisplayName() + " [" + item.getId() + "]");
    }

    private static void demonstratePolymorphism() {
        System.out.println("Person references demonstrate superclass polymorphism:");
        for (Person person : people) System.out.println(person.getRegistrationSummary());
        System.out.println("Identifiable references demonstrate interface polymorphism:");
        for (Identifiable item : records) System.out.println(item.getDisplayName() + " | " + item.getId());
        System.out.println("Registering Student, Teacher and Administrator will populate the Person list.");
    }
}
