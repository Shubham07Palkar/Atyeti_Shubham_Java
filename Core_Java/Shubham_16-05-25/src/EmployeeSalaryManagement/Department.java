package EmployeeSalaryManagement;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }



    public void addEmployee(Employee emp){
        employees.add(emp);
    }

    public double getDepartmentPayout(){
        double total = 0;
        for (Employee emp: employees){
            total+=emp.getNetSalary();
        }
        return total;
    }

    public int getEmployeeCount(){
        return employees.size();
    }

    public void printDepartmentSummary(){
        System.out.println("-----Department: "+departmentName + "----");
        for (Employee emp: employees){
            emp.printEmployeeSalary();
        }
        System.out.println("Department Total Payout: "+getDepartmentPayout());
        System.out.println();
    }



}
