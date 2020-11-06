package ru.kpfu.sem1.studclinic;

import ru.kpfu.sem1.studclinic.dao.daoImpl.ArticleDaoImpl;
import ru.kpfu.sem1.studclinic.dao.daoImpl.CommentInForumDaoImpl;
import ru.kpfu.sem1.studclinic.dao.daoImpl.ForumDaoImpl;
import ru.kpfu.sem1.studclinic.dao.daoImpl.UserDaoImpl;

public class Main {
    public static void main(String[] args) {
        String str = "salsu";
        CommentInForumDaoImpl commentInForumDao = new CommentInForumDaoImpl();
        ForumDaoImpl forumDao = new ForumDaoImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        // What I must to do
        // search
        // update user
        // add article
        // add forum

        ArticleDaoImpl articleDao = new ArticleDaoImpl();
        System.out.println(articleDao.get(1));

    }
}
