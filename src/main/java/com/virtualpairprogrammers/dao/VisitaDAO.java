package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.*;
//import com.virtualpairprogrammers.domain.User;
import com.virtualpairprogrammers.model.Misura;
import com.virtualpairprogrammers.model.Visita;
//import com.virtualpairprogrammers.servlets.ConnectionSingleton;
//import com.virtualpairprogrammers.servlets.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VisitaDAO {
	
	//insert into mimosJSP.visite (id_paziente, id_dottore, data_visita, stato, descrizione, diagnosi) values('4','2','2012-06-18 10:34:09','0','febbre, mal di testa','tutto bene')
	private final String QUERY_INSERT = "insert into visite (id_paziente, id_dottore, data_visita, stato, descrizione, diagnosi) values('?','?','?','?','?','?')";
	private final String QUERY_GET_VISITA = "SELECT * FROM visite WHERE id_visita = ?";
	private final String QUERY_SET_VISITA = "UPDATE visite SET data_visita = ? , stato = ?, descrizione = ?, diagnosi = ? WHERE id_visita = ?;";
	private final String QUERY_ALL_VISITA = "SELECT * FROM visite;";
	private final String QUERY_ALL_DOTTORE_STATO = "SELECT * FROM visite WHERE id_dottore = ? AND id_stato = ? ORDER BY 'data_visita' ASC";
	private final String QUERY_ALL_PAZIENTE_STATO = "SELECT * FROM visite WHERE id_paziente = ? AND id_stato = ? ORDER BY 'data_visita' ASC";
	private final String QUERY_DELETE = "DELETE FROM visita WHERE id_visita=?";
	
	public VisitaDAO() {
		// TODO Auto-generated constructor stub
	}
	
    public boolean insertVisita(Visita visita) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_INSERT);
            statement.setInt(1, visita.getId_paziente());
            statement.setInt(2, visita.getId_dottore());
            statement.setDate(3, (java.sql.Date) visita.getData_visita());
            statement.setInt(4, visita.getStato());
            statement.setString(5, visita.getDescrizione());
            statement.setString(6, visita.getDiagnosi()); 
			return statement.execute();
        }
        catch (SQLException e) {
           /* ((Object) GestoreEccezioni.getInstance()).gestisciEccezione(e);*/
        	return false;
        }
    }
	
    public Visita getVisita(int id_visita) {
   	 Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_VISITA);
            preparedStatement.setInt(1, id_visita);
            ResultSet resultSet = preparedStatement.executeQuery();
            Visita visita = new Visita();
            if (resultSet.next()) {
             visita.setId_visita(resultSet.getInt("id_visita"));
           	 visita.setId_paziente(resultSet.getInt("id_paziente"));
           	 visita.setId_dottore(resultSet.getInt("id_dottore"));
           	 visita.setData_visita(resultSet.getDate("data_visita"));  	 
           	 visita.setStato(resultSet.getInt("stato"));
           	 visita.setDescrizione(resultSet.getString("descrizione"));
           	 visita.setDiagnosi(resultSet.getString("diagnosi"));
             preparedStatement.close();
                return visita;
            }
        }catch (Exception e){
            /*GestoreEccezioni.getInstance().gestisciEccezione(e);
            System.out.println("Errore nella ricerca dell' utente");*/
            return null;
        }
        return null;
   }
    
    public boolean setVisita(Visita visita) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SET_VISITA);
            preparedStatement.setDate(1, (java.sql.Date) visita.getData_visita());
            preparedStatement.setInt(2, visita.getStato());
            preparedStatement.setString(3, visita.getDescrizione());
            preparedStatement.setString(4, visita.getDiagnosi());
            preparedStatement.setInt(5, visita.getId_visita());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            //GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    

    public boolean deleteVisita(Visita visita) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, visita.getId_visita());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            //GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
   
    public List<Visita> getAllVisita () {
        List<Visita> visite = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL_VISITA);
           while (resultSet.next()) {
        	     int id_visita = resultSet.getInt("id_visita");
             	 int id_paziente = resultSet.getInt("id_paziente");
             	 int id_dottore = resultSet.getInt("id_dottore");
             	 Date data_visita = resultSet.getDate("data_visita");  	 
             	 int stato = resultSet.getInt("stato");
             	 String descrizione = resultSet.getString("descrizione");
             	 String diagnosi = resultSet.getString("diagnosi");
             	 visite.add(new Visita(id_visita, id_paziente, id_dottore, data_visita, stato, descrizione, diagnosi));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return visite;
    }
	
    public List<Visita> getAllVisitaPerDottore (int id_dottore_, int stato_) {
        List<Visita> visite = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           PreparedStatement statement = connection.prepareStatement(QUERY_ALL_DOTTORE_STATO);
           statement.setInt(1, id_dottore_);
           statement.setInt(2, stato_);
           ResultSet resultSet = statement.executeQuery();
           while (resultSet.next()) {
        	     int id_visita = resultSet.getInt("id_visita");
             	 int id_paziente = resultSet.getInt("id_paziente");
             	 int id_dottore = resultSet.getInt("id_dottore");
             	 Date data_visita = resultSet.getDate("data_visita");  	 
             	 int stato = resultSet.getInt("stato");
             	 String descrizione = resultSet.getString("descrizione");
             	 String diagnosi = resultSet.getString("diagnosi");
             	 visite.add(new Visita(id_visita, id_paziente, id_dottore, data_visita, stato, descrizione, diagnosi));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return visite;
    }
    
    public List<Visita> getAllVisitaPerPaziente (int id_paziente_, int stato_) {
        List<Visita> visite = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           PreparedStatement statement = connection.prepareStatement(QUERY_ALL_PAZIENTE_STATO);
           statement.setInt(1, id_paziente_);
           statement.setInt(2, stato_);
           ResultSet resultSet = statement.executeQuery();
           while (resultSet.next()) {
        	     int id_visita = resultSet.getInt("id_visita");
             	 int id_paziente = resultSet.getInt("id_paziente");
             	 int id_dottore = resultSet.getInt("id_dottore");
             	 Date data_visita = resultSet.getDate("data_visita");  	 
             	 int stato = resultSet.getInt("stato");
             	 String descrizione = resultSet.getString("descrizione");
             	 String diagnosi = resultSet.getString("diagnosi");
             	 visite.add(new Visita(id_visita, id_paziente, id_dottore, data_visita, stato, descrizione, diagnosi));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return visite;
    }

    
}
