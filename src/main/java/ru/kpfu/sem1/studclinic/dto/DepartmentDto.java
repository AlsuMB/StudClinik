package ru.kpfu.sem1.studclinic.dto;

public class DepartmentDto {
    private String img;
    private String name;

    public DepartmentDto(String img, String name) {
        this.img = img;
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }
}
