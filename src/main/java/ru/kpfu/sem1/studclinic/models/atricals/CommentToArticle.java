package ru.kpfu.sem1.studclinic.models.atricals;

import ru.kpfu.sem1.studclinic.models.aboutUser.User;

public class CommentToArticle {
    private Integer id;
    private Article article;
    private User user;
    private String text;
}
