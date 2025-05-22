package org.example.entity;

public class Bill{
    private Appointment appointment;
    private double totalAmount;
    private static final double GST = 0.18;

    public double calculateTotal(){
        double base = 500;
        double total = 0;
        for (Service s:appointment.getServiceUsed()){
           base +=s.getCost();
        }
        total = base + (base*GST);
        return total;
    }
}
