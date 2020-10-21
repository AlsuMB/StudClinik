package ru.kpfu.sem1.studclinic.models.aboutUser;

import java.util.List;

public class MedCard {
    private Integer id;
    private Integer illnesses_id;
    private Integer patient_id;
    private Integer doctor_id;

    public MedCard(Integer id, Integer illnesses_id, Integer patient_id, Integer doctor_id) {
        this.id = id;
        this.illnesses_id = illnesses_id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
    }

    public MedCard(Integer illnesses_id, Integer patient_id, Integer doctor_id) {
        this.illnesses_id = illnesses_id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIllnesses_id() {
        return illnesses_id;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }
}
