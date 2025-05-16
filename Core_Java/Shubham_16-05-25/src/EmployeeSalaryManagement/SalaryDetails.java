package EmployeeSalaryManagement;

public class SalaryDetails {
    private double basesalary;
    private double hra;
    private double da;
    private double bonus;
    private double tax;
    private double pf;

    public SalaryDetails(double basesalary, double bonus, double da, double hra, double pf, double tax) {
        this.basesalary = basesalary;
        this.bonus = bonus;
        this.da = da;
        this.hra = hra;
        this.pf = pf;
        this.tax = tax;
    }

    public double calculateNetSalary(){
        return basesalary+hra+da+bonus-(tax+pf);
    }


    public double getBasesalary() {
        return basesalary;
    }

    public void setBasesalary(double basesalary) {
        this.basesalary = basesalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getDa() {
        return da;
    }

    public void setDa(double da) {
        this.da = da;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public double getPf() {
        return pf;
    }

    public void setPf(double pf) {
        this.pf = pf;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
