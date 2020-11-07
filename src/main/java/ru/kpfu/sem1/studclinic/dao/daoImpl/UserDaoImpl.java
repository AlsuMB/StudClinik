package ru.kpfu.sem1.studclinic.dao.daoImpl;

import ru.kpfu.sem1.studclinic.dao.Dao;
import ru.kpfu.sem1.studclinic.helpers.PasswordHelper;
import ru.kpfu.sem1.studclinic.helpers.PostgresConnectionHelper;
import ru.kpfu.sem1.studclinic.models.aboutUser.User;
import ru.kpfu.sem1.studclinic.models.exception.NoneOfDoctorException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao<User> {
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public User get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Users WHERE id = '" + id + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("status"),
                        resultSet.getString("path_of_img"));
                return user;
            }
        } catch (SQLException | NoneOfDoctorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Users";
            ResultSet resultSet = statement.executeQuery(sql);

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("status"),
                        resultSet.getString("path_of_img"));
                users.add(user);
            }

            return users;
        } catch (SQLException | NoneOfDoctorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO Users(name, login, password, status, path_of_img) VALUES (?, ?, ?, ?::mood, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, PasswordHelper.encrypt(user.getPassword()));
            preparedStatement.setString(4, user.getStatus().name());
            preparedStatement.setString(5, user.getImg());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getByLogin(String login) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Users WHERE login = '" + login + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("status"),
                        resultSet.getString("path_of_img")
                );
            }
        } catch (SQLException | NoneOfDoctorException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(User user) {
        String sql = "UPDATE Users SET name = ?, path_of_img = ?, password = ?, login = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getImg());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setInt(5, new UserDaoImpl().getByLogin(user.getLogin()).getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
