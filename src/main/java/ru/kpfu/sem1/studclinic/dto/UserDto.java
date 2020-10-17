package ru.kpfu.sem1.studclinic.dto;

public class UserDto {
    private String login;
    private String name;
    private String age;
    private String status;
    private String lastName;

    public UserDto(String login, String name, String age, String status, String lastName) {
        this.login = login;
        this.name = name;
        this.age = age;
        this.status = status;
        this.lastName = lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getStatus() {
        return status;
    }

    public String getLastName() {
        return lastName;
    }
}
