package ru.kpfu.sem1.studclinic.models.aboutUser;

public class Department {
    private Integer id;
    private String img;
    private String name;

    public Department(Integer id, String img, String name) {
        this.id = id;
        this.img = img;
        this.name = name;
    }

    public Department(String img, String name) {
        this.img = img;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }
}
