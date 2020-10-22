package ru.kpfu.sem1.studclinic.dto;

import java.util.List;

public class IllnessDto {
    private String nameOfIll;
    private String other;
    private String img;
    private List<Integer> drags_id;


    public IllnessDto(String nameOfIll, String other, String img, List<Integer> drags_id) {
        this.nameOfIll = nameOfIll;
        this.other = other;
        this.img = img;
        this.drags_id = drags_id;
    }

    public void setNameOfIll(String nameOfIll) {
        this.nameOfIll = nameOfIll;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDrags_id(List<Integer> drags_id) {
        this.drags_id = drags_id;
    }

    public String getNameOfIll() {
        return nameOfIll;
    }

    public String getOther() {
        return other;
    }

    public String getImg() {
        return img;
    }

    public List<Integer> getDrags_id() {
        return drags_id;
    }
}
