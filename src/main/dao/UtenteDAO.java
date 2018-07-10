package main.dao;
import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Utente;

import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO {
	
	    private final String QUERY_INSERT = "insert into utente (id_ruolo, nome, cognome, user_name, password, email) values (?,?,?,?,?,?)";
	  //  private final String QUERY_GET = "SELECT * FROM utente WHERE last_name = 'Anderson'";
	    private final String QUERY_All_DOTTORE = "SELECT * FROM utente WHERE id_ruolo = 2";
	    private final String QUERY_All_PAZIENTE = "SELECT * FROM utente WHERE id_ruolo = 1";
	    private final String QUERY_SET_UTENTE = "UPDATE utente SET nome = ?, cognome = ?, user_name = ?, password =?, email =? WHERE id_utente=?; ";
	    private final String QUERY_DELETE = "DELETE FROM utente WHERE id_utente=?";
	    
	    public boolean insertUtente(Utente utente) {
	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
	            preparedStatement.setInt(1, utente.getId_ruolo());
	            preparedStatement.setString(2, utente.getNome());
	            preparedStatement.setString(3, utente.getCognome());
	            preparedStatement.setString(4, utente.getUser_name());
	            preparedStatement.setString(5, utente.getPassword());
	            preparedStatement.setString(6, utente.getEmail());
	            return preparedStatement.execute();
	        }
	        catch (SQLException e) {
	            GestoreEccezioni.getInstance().gestisciEccezione(e);
	            return false;
	        }

	    }
	    
	    public boolean setUtente(Utente utente) {
	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SET_UTENTE);
	            preparedStatement.setString(1, utente.getNome());
	            preparedStatement.setString(2, utente.getCognome());
	            preparedStatement.setString(3, utente.getUser_name());
	            preparedStatement.setString(4, utente.getPassword());
	            preparedStatement.setString(5, utente.getEmail());
	            preparedStatement.setInt(6, utente.getId_utente());
	            return preparedStatement.execute();
	        }
	        catch (SQLException e) {
	            GestoreEccezioni.getInstance().gestisciEccezione(e);
	            return false;
	        }

	    }
	    
	    public boolean deleteUtente(Utente utente) {
	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
	            preparedStatement.setInt(1, utente.getId_utente());
	            return preparedStatement.execute();
	        }
	        catch (SQLException e) {
	            GestoreEccezioni.getInstance().gestisciEccezione(e);
	            return false;
	        }

	    }
	    
	    public List<Utente> getAllDottore () {
	        List<Utente> dottori = new ArrayList<>();
	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	           Statement statement = connection.createStatement();
	           ResultSet resultSet = statement.executeQuery(QUERY_All_DOTTORE);
	           while (resultSet.next()) {
	               int id_utente = resultSet.getInt("id_utente");
	               String nome = resultSet.getString("nome");
	               String cognome = resultSet.getString("cognome");
	               String user_name = resultSet.getString("user_name");
	               String password = resultSet.getString("password");
	               String email = resultSet.getString("email");
	               dottori.add(new Utente(id_utente, 2, nome, cognome, user_name, password, email));
	           }
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return dottori;
	    }
	    
	    public List<Utente> getAllPaziente () {
	        List<Utente> pazienti = new ArrayList<>();
	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	           Statement statement = connection.createStatement();
	           ResultSet resultSet = statement.executeQuery(QUERY_All_PAZIENTE);
	           while (resultSet.next()) {
	               int id_utente = resultSet.getInt("id_utente");
	               String nome = resultSet.getString("nome");
	               String cognome = resultSet.getString("cognome");
	               String user_name = resultSet.getString("user_name");
	               String password = resultSet.getString("password");
	               String email = resultSet.getString("email");
	               pazienti.add(new Utente(id_utente, 1, nome, cognome, user_name, password, email));
	           }
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return pazienti;
	    }
	    

	    }

