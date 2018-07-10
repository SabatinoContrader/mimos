package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Misura;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MisuraDAO {

    private final String QUERY_ALL = "select * from misura";
    private final String QUERY_INSERT = "insert into misura (id_paziente, pressione, temperatura, glicemia) values (?,?,?,?)";

    public MisuraDAO() {

    }

    public List<Misura> getAllMisura () {
        List<Misura> misura = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
       	    int id_misura = resultSet.getInt("id_misura");
       	    int id_paziente = resultSet.getInt("id_paziente");
       	    float pressione = resultSet.getFloat("pressione");
       	    float temperatura = resultSet.getFloat("temperatura");
       	    float glicemia = resultSet.getFloat("glicemia");;
       	    Date data = resultSet.getDate("data");
               misura.add(new Misura(id_misura, id_paziente, pressione, temperatura, glicemia, data));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return misura;
    }

    public boolean insertMisura(Misura misura) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, misura.getId_paziente());
            preparedStatement.setFloat(2, misura.getPressione());
            preparedStatement.setFloat(3, misura.getTemperatura());
            preparedStatement.setFloat(4, misura.getGlicemia());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
}
