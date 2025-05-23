package org.example;

import java.time.LocalDate;

public class Employee {
    private int employeeId;
    private String Name;
    private LocalDate date;
    private int hoursWorked;

    public Employee(LocalDate date, int employeeId, int hoursWorked, String name) {
        this.date = date;
        this.employeeId = employeeId;
        this.hoursWorked = hoursWorked;
        Name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Emp :" +
                "date=" + date +
                ", employeeId=" + employeeId +
                ", Name='" + Name + '\'' +
                ", hoursWorked=" + hoursWorked +
                '}';
    }
}
