package ru.kpfu.sem1.studclinic.models.aboutUser;

import java.util.List;

public class Illness {
    private Integer id;
    private String nameOfIll;
    private String other;
    private String img;
    private List<Integer> drags_id;

    public Illness(Integer id, String nameOfIll, String other, String img, List<Integer> drags_id) {
        this.id = id;
        this.nameOfIll = nameOfIll;
        this.other = other;
        this.img = img;
        this.drags_id = drags_id;
    }

    public Illness(String nameOfIll, String other, String img, List<Integer> drags_id) {
        this.nameOfIll = nameOfIll;
        this.other = other;
        this.img = img;
        this.drags_id = drags_id;
    }

    public Integer getId() {
        return id;
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
