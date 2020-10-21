package ru.kpfu.sem1.studclinic.dao.daoImpl;

import ru.kpfu.sem1.studclinic.dao.Dao;
import ru.kpfu.sem1.studclinic.helpers.PostgresConnectionHelper;
import ru.kpfu.sem1.studclinic.models.aboutUser.Drag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DragDaoImpl implements Dao<Drag> {
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public Drag get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Drags WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            return new Drag(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("mode_of_application"),
                    resultSet.getString("other"),
                    resultSet.getString("path_of_img"),
                    findListOfIllId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Integer> findListOfIllId(int id) {
        try {
            List<Integer> illnesses_id = new ArrayList<>();
            Statement statementIll = connection.createStatement();
            String sqlIll = "SELECT * FROM Drags_Illnesses WHERE drag_id = " + id;
            ResultSet resultSetIll = statementIll.executeQuery(sqlIll);
            while (resultSetIll.next()) {
                illnesses_id.add(resultSetIll.getInt("illness_id"));
            }
            return illnesses_id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Drag> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Drags";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Drag> drags = new ArrayList<>();

            while (resultSet.next()) {
                drags.add(new Drag(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("mode_of_application"),
                        resultSet.getString("other"),
                        resultSet.getString("path_of_img"),
                        findListOfIllId(resultSet.getInt("id"))));
            }
            return drags;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Drag drag) {
        String sql = "INSERT INTO Drags(name, mode_of_application, other, path_of_img) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, drag.getName());
            preparedStatement.setString(2, drag.getMode_of_application());
            preparedStatement.setString(3, drag.getOther());
            preparedStatement.setString(4, drag.getPath_of_img());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlForManyToMany = "INSERT INTO Drags_Illnesses(drag_id, illness_id) VALUES (?, ?);";
        for (Integer illnessId : drag.getIllnesses_id()) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlForManyToMany);
                preparedStatement.setInt(1, drag.getId());
                preparedStatement.setInt(2, illnessId);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
