package ru.kpfu.sem1.studclinic.models.aboutUser;

import ru.kpfu.sem1.studclinic.models.exception.NoneOfDoctorException;

public class User {
    private Integer id;
    private String name;
    private String login;
    private String password;
    private Status status;
    private Integer medCard_id;
    private String img;

    public User(Integer id, String name, String login, String password, String status, Integer medCard, String img) throws NoneOfDoctorException {
        if (!status.toLowerCase().equals("doctor")) {
            this.id = id;
            this.name = name;
            this.login = login;
            this.password = password;
            String str = status.toUpperCase();
            if (str.equals("PATIENT")) {
                this.status = Status.PATIENT;
            } else if (str.equals("GUEST")) {
                this.status = Status.GUEST;
            } else if (str.equals("EMPLOYEE")) {
                this.status = Status.EMPLOYEE;
            }
            this.medCard_id = medCard;
            this.img = img;
        } else {
            throw new NoneOfDoctorException();
        }
    }

    public User(String name, String login, String password, String status, Integer medCard, String img) throws NoneOfDoctorException {
        if (!status.toLowerCase().equals("doctor")) {
            this.name = name;
            this.login = login;
            this.password = password;
            String str = status.toUpperCase();
            if (str.equals("PATIENT")) {
                this.status = Status.PATIENT;
            } else if (str.equals("GUEST")) {
                this.status = Status.GUEST;
            } else if (str.equals("EMPLOYEE")) {
                this.status = Status.EMPLOYEE;
            }
            this.medCard_id = medCard;
            this.img = img;
        } else {
            throw new NoneOfDoctorException();
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getMedCard_id() {
        return medCard_id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getImg() {
        return img;
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

    public void setMedCard_id(Integer medCard_id) {
        this.medCard_id = medCard_id;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

