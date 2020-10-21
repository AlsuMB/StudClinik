package ru.kpfu.sem1.studclinic.dao.daoImpl;

import ru.kpfu.sem1.studclinic.dao.Dao;
import ru.kpfu.sem1.studclinic.helpers.PostgresConnectionHelper;
import ru.kpfu.sem1.studclinic.models.aboutUser.MedCard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedCardDaoImpl implements Dao<MedCard> {
    private final Connection connection = PostgresConnectionHelper.getConnection();

    public MedCard get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Med_cards WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            return new MedCard(
                    resultSet.getInt("id"),
                    resultSet.getInt("illness_id"),
                    resultSet.getInt("doctor_id"),
                    resultSet.getInt("patient_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Integer> findListOfIllId(int id) {
        try {
            List<Integer> illnesses_id = new ArrayList<>();
            Statement statementIll = connection.createStatement();
            String sqlIll = "SELECT * FROM MedCards_Illnesses WHERE med_card_id = " + id;
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
    public List<MedCard> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Drags";
            ResultSet resultSet = statement.executeQuery(sql);
            List<MedCard> medCards = new ArrayList<>();
            while (resultSet.next()) {
                medCards.add(new MedCard(
                        resultSet.getInt("id"),
                        resultSet.getInt("illness_id"),
                        resultSet.getInt("doctor_id"),
                        resultSet.getInt("patient_id")));
            }
            return medCards;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(MedCard medCard) {
        String sql = "INSERT INTO MedCards(illness_id, doctor_id, patient_id) VALUES (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, medCard.getIllnesses_id());
            preparedStatement.setInt(2, medCard.getDoctor_id());
            preparedStatement.setInt(3, medCard.getPatient_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
