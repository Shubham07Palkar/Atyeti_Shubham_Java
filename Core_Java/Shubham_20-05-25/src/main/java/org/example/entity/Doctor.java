package org.example.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Doctor {
    private String doctorId;
    private String name;
    private String speciality;
    private List<LocalDateTime> availableSlots;

    public Doctor(String doctorId, String name, String speciality) {
        this.availableSlots = availableSlots;
        this.doctorId = doctorId;
        this.name = name;
        this.speciality = speciality;
    }

    public boolean isAvailable(LocalDateTime slot){
        return availableSlots.contains(slot);
    }

    public void bookSlot(LocalDateTime slot){
        availableSlots.add(slot);
    }

}
