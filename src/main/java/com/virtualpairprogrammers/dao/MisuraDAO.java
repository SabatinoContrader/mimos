package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.*;
import com.virtualpairprogrammers.model.Misura;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MisuraDAO {

    private final String QUERY_ALL = "select * from misure WHERE id_paziente = ?";
    private final String QUERY_INSERT = "insert into misure (id_paziente, pressione, battiti, temperatura, glicemia) values (?,?,?,?,?)";
    private final String QUERY_GET_MISURA = "SELECT * FROM misure WHERE id_misura = ?";
   
    public MisuraDAO() {}
    
    public boolean insertMisura(Misura misura) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, misura.getId_paziente());
            preparedStatement.setFloat(2, misura.getPressione());
            preparedStatement.setInt(3, misura.getBattiti());
            preparedStatement.setFloat(4, misura.getTemperatura());
            preparedStatement.setFloat(5, misura.getGlicemia());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
           /* ((Object) GestoreEccezioni.getInstance()).gestisciEccezione(e);*/
        	return false;
        }
    }

    public List<Misura> getAllMisura (int id_paziente_) {
        List<Misura> misura = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
            preparedStatement.setInt(1, id_paziente_);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
       	    int id_misura = resultSet.getInt("id_misura");
       	    int id_paziente = resultSet.getInt("id_paziente");
       	    float pressione = resultSet.getFloat("pressione");
       	    int battiti = resultSet.getInt("battiti");
       	    float temperatura = resultSet.getFloat("temperatura");
       	    float glicemia = resultSet.getFloat("glicemia");;
       	    Date data = resultSet.getDate("data");
       	    misura.add(new Misura(id_misura, id_paziente, pressione, battiti, temperatura, glicemia, data));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return misura;
    }
    
    public Misura getMisura(int id_misura) {
    	 Connection connection = ConnectionSingleton.getInstance();
         try{
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_MISURA);
             preparedStatement.setInt(1, id_misura);
             ResultSet resultSet = preparedStatement.executeQuery();
             Misura misura = new Misura();
             if (resultSet.next()) {
            	 misura.setId_misura(resultSet.getInt("id_misura"));
            	 misura.setId_paziente(resultSet.getInt("id_paziente"));
            	 misura.setPressione(resultSet.getFloat("pressione"));
             	 misura.setBattiti(resultSet.getInt("battiti"));
            	 misura.setTemperatura(resultSet.getFloat("temperatura"));
            	 misura.setGlicemia(resultSet.getFloat("temperatura"));
            	 misura.setData(resultSet.getDate("data"));
                 preparedStatement.close();
                 return misura;
             }
         }catch (Exception e){
             /*GestoreEccezioni.getInstance().gestisciEccezione(e);
             System.out.println("Errore nella ricerca dell' utente");*/
             return null;
         }
         return null;
    }
    
}
