# AUCA_ID – School Management System

Java console application model for the OOP practical assignment.

## Requirements
- JDK 17 or later (the Main menu uses Java switch-arrow syntax).
- Any Java IDE, such as IntelliJ IDEA, Eclipse, or NetBeans.

## Open and run
1. Extract `AUCA_ID.zip`.
2. Open the `AUCA_ID` folder in your IDE as a Java project.
3. Ensure `src` is marked as the source folder.
4. Run `com.auca.main.Main`.

From a terminal in the project folder:
```bash
javac -d out $(find src -name "*.java")
java -cp out com.auca.main.Main
```

## Package design
- `interfaces`: Identifiable and Registrable contracts.
- `abstracts`: Person and AcademicMember.
- Each concrete entity has its own package.
- `exceptions`: the five required custom checked exceptions.
- `main`: application entry point.

## Important assignment notes
- The lecturer's PDF contains a conflict for Student.studyYear: Section 8 says 1–6, while the later sample smart form says 1–8. This starter follows the validation section (1–6); confirm with your lecturer if the later 1–8 instruction is intended to override it.
- This delivery establishes the complete domain-type/package foundation and a runnable starter menu. It is not yet the finished examination application: the remaining registration forms, full 19-option workflow, edit/report operations, and stock-safe book-loan workflow must be implemented and tested before submission. Do not present this starter as satisfying the entire practical assessment.
