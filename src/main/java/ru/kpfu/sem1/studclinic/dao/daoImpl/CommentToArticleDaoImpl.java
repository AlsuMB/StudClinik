package ru.kpfu.sem1.studclinic.dao.daoImpl;

import ru.kpfu.sem1.studclinic.dao.Dao;
import ru.kpfu.sem1.studclinic.helpers.PostgresConnectionHelper;
import ru.kpfu.sem1.studclinic.models.aboutUser.Status;
import ru.kpfu.sem1.studclinic.models.atricals.CommentToArticle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentToArticleDaoImpl implements Dao<CommentToArticle> {
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public CommentToArticle get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Comments_to_articles WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            ArticleDaoImpl article = new ArticleDaoImpl();
            UserDaoImpl userDao = new UserDaoImpl();
            DoctorDaoImpl doctorDao = new DoctorDaoImpl();
            if (resultSet.getInt("user_id") == 0) {
                return new CommentToArticle(
                        resultSet.getInt("id"),
                        article.get(resultSet.getInt("article_id")),
                        doctorDao.get(resultSet.getInt("doctor_id")),
                        resultSet.getString("text"));
            } else if (resultSet.getInt("doctor_id") == 0) {
                return new CommentToArticle(
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
    public List<CommentToArticle> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Comments_to_articles";
            ResultSet resultSet = statement.executeQuery(sql);
            ArticleDaoImpl article = new ArticleDaoImpl();
            UserDaoImpl userDao = new UserDaoImpl();
            DoctorDaoImpl doctorDao = new DoctorDaoImpl();
            List<CommentToArticle> commentToArticles = new ArrayList<>();
            if (resultSet.getInt("user_id") == 0) {
                commentToArticles.add(new CommentToArticle(
                        resultSet.getInt("id"),
                        article.get(resultSet.getInt("article_id")),
                        doctorDao.get(resultSet.getInt("doctor_id")),
                        resultSet.getString("text")));
            } else if (resultSet.getInt("doctor_id") == 0) {
                commentToArticles.add(new CommentToArticle(
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
    public void save(CommentToArticle commentToArticle) {
        String sql = "INSERT INTO Comments_to_articles(article_id, user_id, doctor_id, text) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if (commentToArticle.getUser().getStatus() == Status.DOCTOR) {
                preparedStatement.setInt(1, commentToArticle.getArticle().getId());
                preparedStatement.setNull(2, commentToArticle.getUser().getId());
                preparedStatement.setInt(3, commentToArticle.getUser().getId());
                preparedStatement.setString(4, commentToArticle.getText());
            } else if (commentToArticle.getUser().getStatus() != Status.DOCTOR) {
                preparedStatement.setInt(1, commentToArticle.getArticle().getId());
                preparedStatement.setInt(2, commentToArticle.getUser().getId());
                preparedStatement.setNull(3, commentToArticle.getUser().getId());
                preparedStatement.setString(4, commentToArticle.getText());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
