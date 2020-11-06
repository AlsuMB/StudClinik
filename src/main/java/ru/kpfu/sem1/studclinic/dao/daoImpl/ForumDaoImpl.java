package ru.kpfu.sem1.studclinic.dao.daoImpl;

import ru.kpfu.sem1.studclinic.dao.Dao;
import ru.kpfu.sem1.studclinic.helpers.PostgresConnectionHelper;
import ru.kpfu.sem1.studclinic.models.atricals.Article;
import ru.kpfu.sem1.studclinic.models.forum.Forum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ForumDaoImpl implements Dao<Forum> {
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public Forum get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Forums WHERE id = \'" + id + "\';";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                return new Forum(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("text"),
                        resultSet.getString("path_of_img"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Forum> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Forums";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Forum> forums = new ArrayList<>();
            while (resultSet.next()) {
                forums.add(new Forum(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("text"),
                        resultSet.getString("path_of_img")));
            }
            return forums;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Forum forum) {
        String sql = "INSERT INTO Forums(title, text, path_of_img) VALUES (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, forum.getText());
            preparedStatement.setString(2, forum.getTitle());
            preparedStatement.setString(3, forum.getImg());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Forum> getAll(int page, int pageSize) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Forums limit" + pageSize + " OFFSET " + (page - 1) * pageSize;
            ResultSet resultSet = statement.executeQuery(sql);

            List<Forum> forums = new ArrayList<>();
            while (resultSet.next()) {
                forums.add(new Forum(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("text"),
                        resultSet.getString("path_of_img")));
            }
            return forums;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
