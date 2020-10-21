package ru.kpfu.sem1.studclinic.dao.daoImpl;

import ru.kpfu.sem1.studclinic.dao.Dao;
import ru.kpfu.sem1.studclinic.helpers.PostgresConnectionHelper;
import ru.kpfu.sem1.studclinic.models.aboutUser.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements Dao<Department> {
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public Department get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Departments WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            return new Department(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("path_of_img"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Department> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Departments";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Department> departments = new ArrayList<>();
            while (resultSet.next()) {
                departments.add(new Department(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("path_of_img")));
            }
            return departments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Department department) {
        String sql = "INSERT INTO Departments(name, path_of_img) VALUES (?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, department.getName());
            preparedStatement.setString(2, department.getImg());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
