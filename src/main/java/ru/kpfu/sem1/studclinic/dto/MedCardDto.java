package ru.kpfu.sem1.studclinic.dto;

public class MedCardDto {
    private Integer illnesses_id;
    private Integer patient_id;
    private Integer doctor_id;

    public MedCardDto(Integer illnesses_id, Integer patient_id, Integer doctor_id) {
        this.illnesses_id = illnesses_id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
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

    public void setIllnesses_id(Integer illnesses_id) {
        this.illnesses_id = illnesses_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }
}
