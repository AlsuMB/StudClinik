package ru.kpfu.sem1.studclinic.models.forum;

import ru.kpfu.sem1.studclinic.models.aboutUser.User;
import ru.kpfu.sem1.studclinic.models.atricals.Article;

public class AnswerInForum {
    private Integer id;
    private Forum forum;
    private User user;
    private String text;

    public AnswerInForum(Integer id, Forum article, User user, String text) {
        this.id = id;
        this.forum = article;
        this.user = user;
        this.text = text;
    }

    public AnswerInForum(Forum article, User user, String text) {
        this.forum = article;
        this.user = user;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public Forum getForum() {
        return forum;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "AnswerInForum{" +
                "id=" + id +
                ", forum=" + forum +
                ", user=" + user +
                ", text='" + text + '\'' +
                '}';
    }
}
