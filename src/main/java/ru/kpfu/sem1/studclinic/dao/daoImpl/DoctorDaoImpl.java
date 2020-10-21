package ru.kpfu.sem1.studclinic.dao.daoImpl;

import ru.kpfu.sem1.studclinic.dao.Dao;
import ru.kpfu.sem1.studclinic.helpers.PostgresConnectionHelper;
import ru.kpfu.sem1.studclinic.models.aboutUser.Department;
import ru.kpfu.sem1.studclinic.models.aboutUser.Doctor;
import ru.kpfu.sem1.studclinic.models.exception.NoneOfDoctorException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements Dao<Doctor> {
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public Doctor get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Departments WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            return new Doctor(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    null,
                    resultSet.getString("path_of_img"),
                    resultSet.getString("status_of_doctor"),
                    resultSet.getInt("department_id"));
        } catch (SQLException | NoneOfDoctorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Doctor> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Doctors";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Doctor> doctors = new ArrayList<>();
            while (resultSet.next()) {
                doctors.add(new Doctor(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        null,
                        resultSet.getString("path_of_img"),
                        resultSet.getString("status_of_doctor"),
                        resultSet.getInt("department_id")));
            }
            return doctors;
        } catch (SQLException | NoneOfDoctorException e) {
            e.printStackTrace();
        }
        return null;    }

    @Override
    public void save(Doctor doctor) {
        String sql = "INSERT INTO Doctors(name, login, password, status_of_doctor, department_id, path_of_img) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, doctor.getName());
            preparedStatement.setString(2, doctor.getLogin());
            preparedStatement.setString(3, doctor.getPassword());
            preparedStatement.setString(4, doctor.getStatusOfDoctor());
            preparedStatement.setInt(5, doctor.getDepartmentID());
            preparedStatement.setString(6, doctor.getImg());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
