public class Employee {
    private String name;
    private float salary;

    public Employee(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void displayDetails(){
        System.out.println("Employee :"+name);
        System.out.println("Salary :"+salary);
    }

    public static void main(String[] args){
        Employee employee = new Employee("Geek", 10000.0f);
        employee.displayDetails();
    }
}
