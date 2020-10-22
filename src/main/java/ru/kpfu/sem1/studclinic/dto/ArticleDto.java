package ru.kpfu.sem1.studclinic.dto;

public class ArticleDto {
    private String text;
    private String title;
    private String img;


    public ArticleDto(String text, String title, String img) {
        this.text = text;
        this.title = title;
        this.img = img;
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

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
