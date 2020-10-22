package ru.kpfu.sem1.studclinic.dto;

import ru.kpfu.sem1.studclinic.models.aboutUser.User;
import ru.kpfu.sem1.studclinic.models.atricals.Article;

public class CommentToArticleDto {
    private Article article;
    private User user;
    private String text;

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CommentToArticleDto(Article article, User user, String text) {
        this.article = article;
        this.user = user;
        this.text = text;
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
}
