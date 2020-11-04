package ru.kpfu.sem1.studclinic;

import ru.kpfu.sem1.studclinic.dao.daoImpl.DragDaoImpl;
import ru.kpfu.sem1.studclinic.dao.daoImpl.ForumDaoImpl;
import ru.kpfu.sem1.studclinic.models.aboutUser.Drag;
import ru.kpfu.sem1.studclinic.models.forum.Forum;

public class Main {
    public static void main(String[] args) {
        String str = "salsu";
        DragDaoImpl forumDao = new DragDaoImpl();
        System.out.println(forumDao.get(1));
    }
}
