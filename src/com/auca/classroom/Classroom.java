package com.auca.classroom;

import com.auca.interfaces.Identifiable;
import com.auca.interfaces.Registrable;
import com.auca.exceptions.ValidationException;
import java.time.LocalDate;
import java.math.BigDecimal;

public class Classroom  implements Identifiable, Registrable {
    private String classroomId;
    private String buildingName;
    private String roomNumber;
    private int capacity;
    private int floorNumber;
    private boolean available;

    public Classroom() {  }
    public Classroom(String classroomId, String buildingName, String roomNumber, int capacity, int floorNumber, boolean available) {
        this.classroomId = classroomId;
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.floorNumber = floorNumber;
        this.available = available;
    }

    public String getClassroomId() { return classroomId; }
    public void setClassroomId(String value) { this.classroomId = value; }
    public String getBuildingName() { return buildingName; }
    public void setBuildingName(String value) { this.buildingName = value; }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String value) { this.roomNumber = value; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int value) { this.capacity = value; }
    public int getFloorNumber() { return floorNumber; }
    public void setFloorNumber(int value) { this.floorNumber = value; }
    public boolean getAvailable() { return available; }
    public void setAvailable(boolean value) { this.available = value; }

    @Override public String getId() { return classroomId; }
    @Override public String getDisplayName() { return String.valueOf(buildingName); }
    @Override public boolean isActive() { return available; }
    @Override public void validate() throws ValidationException {
        if (classroomId == null || classroomId.toString().isBlank()) throw new ValidationException("classroomId is required.");
        if (classroomId == null || classroomId.isBlank()) throw new ValidationException("classroomId is required.");
        if (buildingName == null || buildingName.isBlank()) throw new ValidationException("buildingName is required.");
        if (capacity < 1) throw new ValidationException("capacity has an invalid value.");
        if (floorNumber < 0) throw new ValidationException("floorNumber has an invalid value.");
    }
    @Override public void printDetails() { System.out.println(this); }
    @Override public String getRegistrationSummary() { return "Classroom: " + getDisplayName() + " [" + getId() + "]"; }
    @Override public String toString() { return getRegistrationSummary(); }
}
