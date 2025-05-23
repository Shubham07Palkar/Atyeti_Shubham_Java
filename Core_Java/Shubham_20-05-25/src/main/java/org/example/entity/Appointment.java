package org.example.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private LocalDateTime appointmentDate;
    private String diagnosis;
    private List<Service> serviceUsed;
    private boolean isCompleted;

    public void completeAppointment(String diagnosis, List<Service> services){
       this.diagnosis=diagnosis;
       this.serviceUsed = services;
       this.isCompleted=true;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Service> getServiceUsed() {
        return serviceUsed;
    }

    public void setServiceUsed(List<Service> serviceUsed) {
        this.serviceUsed = serviceUsed;
    }
}
