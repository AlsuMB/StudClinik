package ru.kpfu.sem1.studclinic.dao.daoImpl;

import ru.kpfu.sem1.studclinic.dao.Dao;
import ru.kpfu.sem1.studclinic.helpers.PostgresConnectionHelper;
import ru.kpfu.sem1.studclinic.models.atricals.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl implements Dao<Article> {
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public Article get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Articles WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            return new Article(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("text"),
                    resultSet.getString("path_of_img"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Article> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Articles";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Article> articles = new ArrayList<>();
            while (resultSet.next()) {
                articles.add(new Article(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("text"),
                        resultSet.getString("path_of_img")));
            }
            return articles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Article article) {
        String sql = "INSERT INTO Articles(title, text, path_of_img) VALUES (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, article.getText());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setString(3, article.getImg());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
