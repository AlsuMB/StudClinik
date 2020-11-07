package ru.kpfu.sem1.studclinic.models.atricals;

import ru.kpfu.sem1.studclinic.models.aboutUser.User;

public class CommentToArticle {
    private Integer id;
    private Article article;
    private User user;
    private String text;

    public CommentToArticle(Article article, User user, String text) {
        this.article = article;
        this.user = user;
        this.text = text;
    }

    public CommentToArticle(Integer id, Article article, User user, String text) {
        this.id = id;
        this.article = article;
        this.user = user;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public Article getArticle() {
        return article;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "CommentToArticle{" +
                "id=" + id +
                ", article=" + article +
                ", user=" + user +
                ", text='" + text + '\'' +
                '}';
    }
}
