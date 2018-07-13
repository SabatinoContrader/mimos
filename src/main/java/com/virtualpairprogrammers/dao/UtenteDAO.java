package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class UtenteDAO {

	private final String QUERY_ALL = "select * from mimosJSP.$tableName";
	private final String QUERY_DELETE = "delete from mimosJSP.$tableName where $columnName = ?";
	private final String QUERY_INSERT_GENERIC = "insert into mimosJSP.$tableName "
			+ "(id_ruolo, nome, cognome, codice_fiscale, data_nascita, username, password, citta) "
			+ "values (?,?,?,?,?,?,?,?)";
	private final String QUERY_VERIFY_ID = "SELECT $columnName_1 FROM mimosJSP.$tableName "
			+ "WHERE $columnName_2 = ?";
	private final String QUERY_VERIFY_UP = "SELECT $columnName_1 FROM mimosJSP.$tableName "
			+ "WHERE $tableName.$columnName_1 = ? and $tableName.$columnName_2 = ?";
	private final String QUERY_UPDATE = "UPDATE mimosJSP.$tableName " + "SET $columnName_1 = ? " + "WHERE $columnName_2 = ?";

	public UtenteDAO() {

	}

	public boolean updateData(String username, String field, String newdata) {
		int id = this.getIdByNick(username);
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement;
			ResultSet res = null;
			String query_added_table = QUERY_UPDATE.replace("$tableName", "utenti");
			String query_added_c1 = query_added_table.replace("$columnName", field);
			String query_added_c2 = query_added_c1.replace("$columnName", "id_utente");
			preparedStatement = connection.prepareStatement(query_added_c2);
			preparedStatement.setString(1, newdata);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		} catch (InsertUserException e1) {
			GestoreEccezioni.getInstance().gestisciEccezione(e1);
			return false;
		}
	}
	
	public int getUserRole(String username) {
		int id = this.getIdByNick(username);
		Connection connection = ConnectionSingleton.getInstance();
		PreparedStatement preparedStatement;
		ResultSet res = null;
		try {
			String query_added_table = QUERY_VERIFY_ID.replace("$tableName", "utenti");
			String query_added_column = query_added_table.replace("$columnName", "id_utente");
			preparedStatement = connection.prepareStatement(query_added_column);
			preparedStatement.setInt(1, id);
			res = preparedStatement.executeQuery();
			res.next();
			id = res.getInt("id_ruolo");
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			id = 0;
		} catch (InsertUserException e1) {
			GestoreEccezioni.getInstance().gestisciEccezione(e1);
			id = 0;
		}
		return id;
	}
	
	public boolean verifyEntry(String username, String password) throws RuntimeException {
		int id = this.getIdByNick(username);
		Connection connection = ConnectionSingleton.getInstance();
		PreparedStatement preparedStatement;
		ResultSet res = null;
		try {
			String query_added_table = QUERY_VERIFY_UP.replace("$tableName", "utenti");
			String query_added_c1 = query_added_table.replace("$columnName_1", "username");
			String query_added_c2 = query_added_c1.replace("$columnName_2", "password");
			preparedStatement = connection.prepareStatement(query_added_c2);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			res = preparedStatement.executeQuery();
			res.next();
			if (res.getString("username") == null) throw new RuntimeException();
			//sono rimbambito è ovvio che non c'è il campo password dalla query...
			//if (res.getString("password") == null) throw new RuntimeException();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		} catch (InsertUserException e1) {
			GestoreEccezioni.getInstance().gestisciEccezione(e1);
			System.out.println("ok login di " + username);
			return false;
		}
		System.out.println("ok login di " + username);
		return true;
	}
/*
	public List<String> getUserRole(String username) {
		int id = this.getIdByNick(username);
		List<String> data = new ArrayList<>();

		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement;
			// uso un foreach per i valor del Role enum
			ResultSet res = null;
			for (Role r : Role.values()) {
				// creo il MUser
				String query_added_table = QUERY_VERIFY_ID.replace("$tableName", "utenti");
				String query_added_column = query_added_table.replace("$columnName", "id_utente");
				// System.out.println(query);
				preparedStatement = connection.prepareStatement(query_added_column);
				// non si può passare il nome della tabella in string
				preparedStatement.setInt(1, id);
				// boolean result = preparedStatement.execute();
				// System.out.println(preparedStatement);
				res = preparedStatement.executeQuery();
				// System.out.println(res);
				while (res.next())
					if (!res.wasNull())
						data.add(r.toString());
			}
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
		} catch (InsertUserException e1) {
			GestoreEccezioni.getInstance().gestisciEccezione(e1);
		}
		return data;
	}
*/
	public ArrayList<Utente> getAllUsers() {
		ArrayList<Utente> users = new ArrayList<>();
		Utente user;
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			String query_added_table = QUERY_ALL.replace("$tableName", "utenti");
			ResultSet resultSet = statement.executeQuery(query_added_table);
			while (resultSet.next()) {
				user = new Utente();
				user.setCitta(resultSet.getString("citta"));
				user.setCodice_fiscale(resultSet.getString("codice_fiscale"));
				user.setCognome(resultSet.getString("cognome"));
				user.setData_nascita(resultSet.getDate("data_nascita"));
				user.setId_ruolo(resultSet.getInt("id_ruolo"));
				user.setNome(resultSet.getString("nome"));
				user.setPassword(resultSet.getString("password"));
				user.setUsername(resultSet.getString("username"));
				user.setId_utente(resultSet.getInt("id_utente"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public int getIdByNick(String username) {
		Connection connection = ConnectionSingleton.getInstance();
		int id = 0;
		PreparedStatement preparedStatement;
		try {
			String query_added_table = QUERY_VERIFY_ID.replace("$tableName", "utenti");
			String query_added_c1 = query_added_table.replace("$columnName_1", "id_utente");
			String query_added_c2 = query_added_c1.replace("$columnName_2", "username");
			preparedStatement = connection.prepareStatement(query_added_c2);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			id = resultSet.getInt("id_utente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public boolean insertUser(Utente utente) {
		Connection connection = ConnectionSingleton.getInstance();
		int id = 0;
		try {
			PreparedStatement preparedStatement;
			// verifico se l'utente già c'è mediante nick
			if (this.getIdByNick(utente.getUsername()) != 0)
				throw new InsertUserException();
			// creo il MUser
			preparedStatement = connection.prepareStatement(QUERY_INSERT_GENERIC);
			preparedStatement.setInt(1, utente.getId_ruolo());
			preparedStatement.setString(2, utente.getNome());
			preparedStatement.setString(3, utente.getCognome());
			preparedStatement.setString(4, utente.getCodice_fiscale());
			preparedStatement.setDate(5, (Date) utente.getData_nascita());
			preparedStatement.setString(6, utente.getPassword());
			preparedStatement.setString(7, utente.getUsername());
			preparedStatement.setString(8, utente.getCitta());
			preparedStatement.execute();
			id = this.getIdByNick(utente.getUsername());
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		} catch (InsertUserException e1) {
			GestoreEccezioni.getInstance().gestisciEccezione(e1);
			return false;
		}
		return true;

	}

	public boolean deleteUser(String username) {
		int id = this.getIdByNick(username);
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement;
			String query_added_table = QUERY_DELETE.replace("$tableName", "utenti");
			String query_added_column = query_added_table.replace("$tableColumn", "id_utente");
			preparedStatement = connection.prepareStatement(query_added_column);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		} catch (InsertUserException e1) {
			GestoreEccezioni.getInstance().gestisciEccezione(e1);
			return false;
		}
		return true;
	}
}
