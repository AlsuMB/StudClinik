package ru.kpfu.sem1.studclinic.models.forum;

public class Forum {
    private Integer id;
    private String text;
    private String title;
    private String img;

    public Forum(Integer id, String text, String title, String img) {
        this.id = id;
        this.text = text;
        this.title = title;
        this.img = img;
    }

    public Forum(String text, String title, String img) {
        this.text = text;
        this.title = title;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public String getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
