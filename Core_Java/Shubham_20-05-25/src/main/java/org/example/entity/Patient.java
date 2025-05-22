package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String patientId;
    private String name;
    private String contact;
    private List<Appointment> appointments;

    public Patient(String contact, String name, String patientId) {
        this.contact = contact;
        this.name = name;
        this.patientId = patientId;
        this.appointments=new ArrayList<>();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
