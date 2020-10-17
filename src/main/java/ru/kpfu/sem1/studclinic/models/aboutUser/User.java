package ru.kpfu.sem1.studclinic.models.aboutUser;

public class User {
    private Integer id;
    private String name;
    private Status status;
    private MedCard medCard;
    private String img;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public MedCard getMedCard() {
        return medCard;
    }
}

