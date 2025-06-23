package com.Collections.BehavioralQuestions.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    Employee withRaisedSalary(int percent){
        return new Employee(this.name, this.salary + (this.salary * percent / 100));
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}


public class ImutabilityInStreams {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("A", 1000),
                new Employee("B", 1000),
                new Employee("C", 1000)
        );

        List<Employee> updated = employees.stream()
                .map(emp -> emp.withRaisedSalary(1000))
                .collect(Collectors.toList());

        updated.forEach(System.out::println);
        System.out.println("\n"+employees);

//        employees still has original values: no mutation occurred.

    }

}
