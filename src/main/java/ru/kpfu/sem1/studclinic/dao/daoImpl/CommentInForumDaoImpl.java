package ru.kpfu.sem1.studclinic.dao.daoImpl;

import ru.kpfu.sem1.studclinic.dao.Dao;
import ru.kpfu.sem1.studclinic.helpers.PostgresConnectionHelper;
import ru.kpfu.sem1.studclinic.models.aboutUser.Status;
import ru.kpfu.sem1.studclinic.models.forum.AnswerInForum;
import ru.kpfu.sem1.studclinic.models.forum.Forum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentInForumDaoImpl implements Dao<AnswerInForum> {
    private final Connection connection = PostgresConnectionHelper.getConnection();

    public List<AnswerInForum> getAllCommentsInForum(int id_forum) {
        try {
            ForumDaoImpl forumDao = new ForumDaoImpl();
            UserDaoImpl userDao = new UserDaoImpl();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM comments_in_forum WHERE forum_id = \'" + id_forum + "\';";
            ResultSet resultSet = statement.executeQuery(sql);

            List<AnswerInForum> answers = new ArrayList<>();
            while (resultSet.next()) {
                AnswerInForum answer = new AnswerInForum(resultSet.getInt("id"),
                        forumDao.get(resultSet.getInt("forum_id")),
                        userDao.get(resultSet.getInt("user_id")),
                        resultSet.getString("text"));
                answers.add(answer);
            }
            return answers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public AnswerInForum get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM comments_in_forum WHERE id = \'" + id + "\';";
            ResultSet resultSet = statement.executeQuery(sql);
            ForumDaoImpl forumDao = new ForumDaoImpl();
            UserDaoImpl userDao = new UserDaoImpl();
            DoctorDaoImpl doctorDao = new DoctorDaoImpl();
            if (resultSet.getInt("user_id") == 0) {
                return new AnswerInForum(
                        resultSet.getInt("id"),
                        forumDao.get(resultSet.getInt("forum_id")),
                        doctorDao.get(resultSet.getInt("doctor_id")),
                        resultSet.getString("text"));
            } else if (resultSet.getInt("doctor_id") == 0) {
                return new AnswerInForum(
                        resultSet.getInt("id"),
                        forumDao.get(resultSet.getInt("forum_id")),
                        userDao.get(resultSet.getInt("user_id")),
                        resultSet.getString("text"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AnswerInForum> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM comments_in_forum";
            ResultSet resultSet = statement.executeQuery(sql);
            ForumDaoImpl forum = new ForumDaoImpl();
            UserDaoImpl userDao = new UserDaoImpl();
            DoctorDaoImpl doctorDao = new DoctorDaoImpl();
            List<AnswerInForum> commentToArticles = new ArrayList<>();
            if (resultSet.getInt("user_id") == 0) {
                commentToArticles.add(new AnswerInForum(
                        resultSet.getInt("id"),
                        forum.get(resultSet.getInt("article_id")),
                        doctorDao.get(resultSet.getInt("doctor_id")),
                        resultSet.getString("text")));
            } else if (resultSet.getInt("doctor_id") == 0) {
                commentToArticles.add(new AnswerInForum(
                        resultSet.getInt("id"),
                        forum.get(resultSet.getInt("article_id")),
                        userDao.get(resultSet.getInt("user_id")),
                        resultSet.getString("text")));
            }
            return commentToArticles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(AnswerInForum answerInForum) {
        String sql = "INSERT INTO comments_in_forum(forum_id, user_id, text) VALUES (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, answerInForum.getForum().getId());
            preparedStatement.setInt(2, answerInForum.getUser().getId());
            preparedStatement.setString(3, answerInForum.getText());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
