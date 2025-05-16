package EmployeeSalaryManagement;

import java.util.List;

public class Company {
    public static void main(String[] args) {
        Department it = new Department("IT");
        it.addEmployee(new Employee("Software Developer",101,"Shubham",
                new SalaryDetails(60000,5000, 4000, 5000,6000,3000)));
        it.addEmployee(new Employee("Dev Ops Engineer",102,"Bob",
                new SalaryDetails(65000, 8500, 7500, 3500, 5200, 2400)));

        Department hr = new Department("HR");
        hr.addEmployee(new Employee("HR Manager", 201, "Carol",
                new SalaryDetails(50000, 7000, 6000, 2500, 4000, 2000)));

        List<Department> department = List.of(it, hr);

        int totalEmployees = 0;
        double totalPayout = 0;

        for(Department dept:department){
            dept.printDepartmentSummary();
            totalEmployees+=dept.getEmployeeCount();
            totalPayout+= dept.getDepartmentPayout();
        }

        System.out.println("---Company Summary---");
        System.out.println("Total Employees: "+totalEmployees);
        System.out.println("Total Salary Payout: "+totalPayout);

    }
}
