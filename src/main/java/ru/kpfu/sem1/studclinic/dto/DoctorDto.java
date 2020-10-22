package ru.kpfu.sem1.studclinic.dto;

import ru.kpfu.sem1.studclinic.models.aboutUser.Status;
import ru.kpfu.sem1.studclinic.models.exception.NoneOfDoctorException;

public class DoctorDto {
    private String name;
    private String login;
    private String password;
    private Status status;
    private String statusOfDoctor;
    private Integer departmentID;
    private String img;


    public DoctorDto( String name, String login, String password, Integer medCard, String img, String statusOfDoctor, Integer departmentID) throws NoneOfDoctorException {
        this.name = name;
        this.login = login;
        this.password = password;
        this.status = Status.DOCTOR;
        this.statusOfDoctor = statusOfDoctor;
        this.departmentID = departmentID;
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setStatusOfDoctor(String statusOfDoctor) {
        this.statusOfDoctor = statusOfDoctor;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Status getStatus() {
        return status;
    }

    public String getStatusOfDoctor() {
        return statusOfDoctor;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public String getImg() {
        return img;
    }
}
