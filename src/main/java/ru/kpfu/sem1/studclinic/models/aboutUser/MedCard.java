package ru.kpfu.sem1.studclinic.models.aboutUser;

import ru.kpfu.sem1.studclinic.models.exception.NoneOfDoctorException;

import java.util.List;

public class MedCard {
    private Integer id;
    private List<Illness> illnesses;
    private Doctor doctor;

    public MedCard(List<Illness> illnesses, Doctor doctor) throws NoneOfDoctorException {
        this.illnesses = illnesses;
        this.doctor = doctor;
    }
}
