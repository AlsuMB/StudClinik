package ru.kpfu.sem1.studclinic.models.aboutUser;

import ru.kpfu.sem1.studclinic.models.exception.NoneOfDoctorException;

public class Doctor extends User {
    private Integer id;
    private String name;
    private String login;
    private String password;
    private Status status;
    private String statusOfDoctor;
    private Integer departmentID;
    private String img;

    public Doctor(Integer id, String name, String login, String password, String img, String statusOfDoctor, Integer departmentID) throws NoneOfDoctorException {
        super(id, name, login, password, "doctor", img);
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.status = Status.DOCTOR;
        this.statusOfDoctor = statusOfDoctor;
        this.departmentID = departmentID;
        this.img = img;
    }

    public Doctor( String name, String login, String password, String img, String statusOfDoctor, Integer departmentID) throws NoneOfDoctorException {
        super(name, login, password, "doctor", img);
        this.name = name;
        this.login = login;
        this.password = password;
        this.status = Status.DOCTOR;
        this.statusOfDoctor = statusOfDoctor;
        this.departmentID = departmentID;
        this.img = img;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    public String getStatusOfDoctor() {
        return statusOfDoctor;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    @Override
    public String getImg() {
        return img;
    }
}
