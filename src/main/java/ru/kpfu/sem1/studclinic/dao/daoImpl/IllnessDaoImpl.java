package ru.kpfu.sem1.studclinic.dao.daoImpl;

import ru.kpfu.sem1.studclinic.dao.Dao;
import ru.kpfu.sem1.studclinic.helpers.PostgresConnectionHelper;
import ru.kpfu.sem1.studclinic.models.aboutUser.Illness;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IllnessDaoImpl implements Dao<Illness> {
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public Illness get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Illnesses WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            return new Illness(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("other"),
                    resultSet.getString("path_of_img"),
                    findListOfDragId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Integer> findListOfDragId(int id) {
        try {
            List<Integer> drags_id = new ArrayList<>();
            Statement statementDrag = connection.createStatement();
            String sqlDrag = "SELECT * FROM Drags_Illnesses WHERE illness_id = " + id;
            ResultSet resultSetDrag = statementDrag.executeQuery(sqlDrag);
            while (resultSetDrag.next()) {
                drags_id.add(resultSetDrag.getInt("illness_id"));
            }
            return drags_id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Illness> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Illnesses";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Illness> illnesses = new ArrayList<>();
            while (resultSet.next()) {
                illnesses.add(new Illness(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("other"),
                        resultSet.getString("path_of_img"),
                        findListOfDragId(resultSet.getInt("id"))));
            }
            return illnesses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Illness illness) {
        String sql = "INSERT INTO Illnesses(name, other, path_of_img) VALUES (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, illness.getNameOfIll());
            preparedStatement.setString(2, illness.getOther());
            preparedStatement.setString(3, illness.getImg());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlForManyToMany = "INSERT INTO Drags_Illnesses(drag_id, illness_id) VALUES (?, ?);";
        for (Integer dragsId : illness.getDrags_id()) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlForManyToMany);
                preparedStatement.setInt(1, illness.getId());
                preparedStatement.setInt(2, dragsId);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
