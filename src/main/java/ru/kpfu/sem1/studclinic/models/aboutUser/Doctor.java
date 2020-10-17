package ru.kpfu.sem1.studclinic.models.aboutUser;

public class Doctor extends User {
    private Integer id;
    private String name;
    private Status status = Status.DOCTOR;
    private String statusOfDoctor;
    private Department department;
    private String img;
}
