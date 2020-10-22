package ru.kpfu.sem1.studclinic.dto;

import java.util.List;

public class DragDto {
    private String name;
    private String mode_of_application;
    private String other;
    private String path_of_img;
    private List<Integer> illnesses_id;

    public void setName(String name) {
        this.name = name;
    }

    public void setMode_of_application(String mode_of_application) {
        this.mode_of_application = mode_of_application;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public void setPath_of_img(String path_of_img) {
        this.path_of_img = path_of_img;
    }

    public void setIllnesses_id(List<Integer> illnesses_id) {
        this.illnesses_id = illnesses_id;
    }

    public DragDto(String name, String mode_of_application, String other, String path_of_img, List<Integer> illnesses_id) {
        this.name = name;
        this.mode_of_application = mode_of_application;
        this.other = other;
        this.path_of_img = path_of_img;
        this.illnesses_id = illnesses_id;
    }

    public String getName() {
        return name;
    }

    public String getMode_of_application() {
        return mode_of_application;
    }

    public String getOther() {
        return other;
    }

    public String getPath_of_img() {
        return path_of_img;
    }

    public List<Integer> getIllnesses_id() {
        return illnesses_id;
    }
}
