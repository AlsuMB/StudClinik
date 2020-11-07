package ru.kpfu.sem1.studclinic;

import ru.kpfu.sem1.studclinic.dao.daoImpl.*;
import ru.kpfu.sem1.studclinic.helpers.PasswordHelper;
import ru.kpfu.sem1.studclinic.models.aboutUser.User;
import ru.kpfu.sem1.studclinic.models.atricals.Article;
import ru.kpfu.sem1.studclinic.models.exception.NoneOfDoctorException;


public class Main {
    public static void main(String[] args) throws NoneOfDoctorException {
//        String str = "salsu";
        CommentInForumDaoImpl commentInForumDao = new CommentInForumDaoImpl();
        ForumDaoImpl forumDao = new ForumDaoImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        // What I must to do
        // search
        // update user

        ArticleDaoImpl articleDao = new ArticleDaoImpl();
//        System.out.println(articleDao.get(1));
        CommentToArticleDaoImpl commentToArticleDao = new CommentToArticleDaoImpl();
//        ArrayList<CommentToArticle> comments = (ArrayList<CommentToArticle>) commentToArticleDao.getAllCommentsInArticle(1);
//        System.out.println(comments);
        Article article = new Article("text", "title", null);
        articleDao.save(article);
        User user = new User(15, "Alsu", "alsu", PasswordHelper.encrypt("DoL8a9T6"), "patient", null);
        userDao.update(user);
        System.out.println(userDao.get(15));
    }
}
