package EmploeeSalaryManagement;

public class Employee {
    private int id;
    private String name;
    private String designation;
    private SalaryDetails salaryDetails;

    public Employee(String designation, int id, String name, SalaryDetails salaryDetails) {
        this.designation = designation;
        this.id = id;
        this.name = name;
        this.salaryDetails = salaryDetails;
    }

    public double getNetSalary(){
        return salaryDetails.calculateNetSalary();
    }

    public double getBaseSalary(){
        return salaryDetails.getBasesalary();
    }

    public void printEmployeeSalary(){
        System.out.println("Employee: "+name);
        System.out.println("Designation: "+designation);
        System.out.println("Base Salary: "+getBaseSalary());
        System.out.println("Net Salary: "+getNetSalary());
        System.out.println();
    }
}
