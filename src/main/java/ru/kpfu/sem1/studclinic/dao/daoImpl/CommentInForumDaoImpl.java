package ru.kpfu.sem1.studclinic.dao.daoImpl;

import ru.kpfu.sem1.studclinic.dao.Dao;
import ru.kpfu.sem1.studclinic.helpers.PostgresConnectionHelper;
import ru.kpfu.sem1.studclinic.models.aboutUser.Status;
import ru.kpfu.sem1.studclinic.models.atricals.CommentToArticle;
import ru.kpfu.sem1.studclinic.models.forum.AnswerInForum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentInForumDaoImpl implements Dao<AnswerInForum> {
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public AnswerInForum get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM comments_in_forum WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            ArticleDaoImpl article = new ArticleDaoImpl();
            UserDaoImpl userDao = new UserDaoImpl();
            DoctorDaoImpl doctorDao = new DoctorDaoImpl();
            if (resultSet.getInt("user_id") == 0) {
                return new AnswerInForum(
                        resultSet.getInt("id"),
                        article.get(resultSet.getInt("article_id")),
                        doctorDao.get(resultSet.getInt("doctor_id")),
                        resultSet.getString("text"));
            } else if (resultSet.getInt("doctor_id") == 0) {
                return new AnswerInForum(
                        resultSet.getInt("id"),
                        article.get(resultSet.getInt("article_id")),
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
            ArticleDaoImpl article = new ArticleDaoImpl();
            UserDaoImpl userDao = new UserDaoImpl();
            DoctorDaoImpl doctorDao = new DoctorDaoImpl();
            List<AnswerInForum> commentToArticles = new ArrayList<>();
            if (resultSet.getInt("user_id") == 0) {
                commentToArticles.add(new AnswerInForum(
                        resultSet.getInt("id"),
                        article.get(resultSet.getInt("article_id")),
                        doctorDao.get(resultSet.getInt("doctor_id")),
                        resultSet.getString("text")));
            } else if (resultSet.getInt("doctor_id") == 0) {
                commentToArticles.add(new AnswerInForum(
                        resultSet.getInt("id"),
                        article.get(resultSet.getInt("article_id")),
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
        String sql = "INSERT INTO comments_in_forum(article_id, user_id, doctor_id, text) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if (answerInForum.getUser().getStatus() == Status.DOCTOR) {
                preparedStatement.setInt(1, answerInForum.getArticle().getId());
                preparedStatement.setNull(2, answerInForum.getUser().getId());
                preparedStatement.setInt(3, answerInForum.getUser().getId());
                preparedStatement.setString(4, answerInForum.getText());
            } else if (answerInForum.getUser().getStatus() != Status.DOCTOR) {
                preparedStatement.setInt(1, answerInForum.getArticle().getId());
                preparedStatement.setInt(2, answerInForum.getUser().getId());
                preparedStatement.setNull(3, answerInForum.getUser().getId());
                preparedStatement.setString(4, answerInForum.getText());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
