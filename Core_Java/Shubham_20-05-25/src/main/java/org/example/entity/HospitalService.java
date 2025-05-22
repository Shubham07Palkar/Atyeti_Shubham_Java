package org.example.entity;

import java.util.HashMap;
import java.util.Map;

public class HospitalService {
    private Map<String, Patient> patients = new HashMap<>();
    private Map<String, Doctor> doctors = new HashMap<>();

    public void registerPatient(String patientId, String name, String contact){
    patients.put(patientId, new Patient(contact,name, patientId));
    }

    public void registerDoctor(String doctorId, String name, String speciality){
        doctors.put(doctorId, new Doctor(doctorId,name,speciality))
    }

}
