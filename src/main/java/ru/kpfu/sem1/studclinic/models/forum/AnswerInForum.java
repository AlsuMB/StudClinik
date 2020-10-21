package ru.kpfu.sem1.studclinic.models.forum;

import ru.kpfu.sem1.studclinic.models.aboutUser.User;
import ru.kpfu.sem1.studclinic.models.atricals.Article;

public class AnswerInForum {
    private Integer id;
    private Article article;
    private User user;
    private String text;

    public AnswerInForum(Integer id, Article article, User user, String text) {
        this.id = id;
        this.article = article;
        this.user = user;
        this.text = text;
    }

    public AnswerInForum(Article article, User user, String text) {
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
}
