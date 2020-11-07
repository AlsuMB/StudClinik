package ru.kpfu.sem1.studclinic.dao.daoImpl;

import ru.kpfu.sem1.studclinic.dao.Dao;
import ru.kpfu.sem1.studclinic.helpers.PostgresConnectionHelper;
import ru.kpfu.sem1.studclinic.models.aboutUser.Status;
import ru.kpfu.sem1.studclinic.models.atricals.CommentToArticle;
import ru.kpfu.sem1.studclinic.models.forum.AnswerInForum;

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
        String sql = "INSERT INTO Comments_to_articles(article_id, user_id, text) VALUES (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, commentToArticle.getArticle().getId());
            preparedStatement.setInt(2, commentToArticle.getUser().getId());
            preparedStatement.setString(3, commentToArticle.getText());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CommentToArticle> getAllCommentsInArticle(int articleId) {
        try {
            ArticleDaoImpl articleDao = new ArticleDaoImpl();
            UserDaoImpl userDao = new UserDaoImpl();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM comments_to_articles WHERE article_id = \'" + articleId + "\';";
            ResultSet resultSet = statement.executeQuery(sql);

            List<CommentToArticle> answers = new ArrayList<>();
            while (resultSet.next()) {
                CommentToArticle answer = new CommentToArticle(resultSet.getInt("id"),
                        articleDao.get(resultSet.getInt("article_id")),
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
}
