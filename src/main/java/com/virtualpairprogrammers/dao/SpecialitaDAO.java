package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.virtualpairprogrammers.model.Specialita;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class SpecialitaDAO {

	private final String QUERY_ALL_SKILLS = "select * from mimosJSP.$tableName";
	private final String QUERY_DELETE_SKILL = "delete from mimosJSP.$tableName " 
			+ "where $columnName = ?";
	private final String QUERY_INSERT_SKILL = "insert into mimosJSP.$tableName "
			+ "($columnName_1, $columnName_2) "
			+ "values (?, ?, ?)";
	private final String QUERY_VERIFY_ID = "SELECT $columnName_1 FROM $tableName " 
			+ "WHERE $columnName_2 = ?";
	
	public SpecialitaDAO() {

	}

	public ArrayList<Specialita> getAllSkills() {
		ArrayList<Specialita> skills = new ArrayList<>();
		Specialita skill;
		Connection connection = ConnectionSingleton.getInstance();
		try {
			//Statement statement = connection.createStatement();
			String query_added_t1 = QUERY_ALL_SKILLS.replace("$tableName_1", "specialita");
			PreparedStatement preparedStatement = connection.prepareStatement(query_added_t1);
			ResultSet resultSet = preparedStatement.executeQuery(query_added_t1);
			while (resultSet.next()) {
				skill = new Specialita();
				skill.setNome(resultSet.getString("nome"));
				skill.setDescrizione(resultSet.getString("descrizione"));
				skill.setId_specialita(resultSet.getInt("id_specialita"));
				skills.add(skill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return skills;
	}

	public boolean insertSkill(Specialita specialita) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement;
			String query_added_table = QUERY_INSERT_SKILL.replace("$tableName", "specialita");
			String query_added_c1 = query_added_table.replace("$tableColumn_1", "nome");
			String query_added_c2 = query_added_c1.replace("$tableColumn_2", "descrizione");
			preparedStatement = connection.prepareStatement(query_added_c2);
			preparedStatement.setString(1, specialita.getNome());
			preparedStatement.setString(2, specialita.getDescrizione());
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

	public boolean deleteSkill(String nome) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement;
			String query_added_table = QUERY_DELETE_SKILL.replace("$tableName", "dottore_specialita");
			String query_added_c1 = query_added_table.replace("$tableColumn", "nome");
			preparedStatement = connection.prepareStatement(query_added_c1);
			preparedStatement.setString(1, nome);
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

	public int getIdSkill(String nome) {
		Connection connection = ConnectionSingleton.getInstance();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		int rs;
		try {
			String query_added_table = QUERY_VERIFY_ID.replace("$tableName", "dottore_specialita");
			String query_added_c1 = query_added_table.replace("$tableColumn", "id_specialita");
			String query_added_c2 = query_added_c1.replace("$tableColumn", "nome");
			preparedStatement = connection.prepareStatement(query_added_c2);
			preparedStatement.setString(1, nome);
			preparedStatement.execute();
			resultSet.next();
			rs = resultSet.getInt("id_specialista");
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return 0;
		} catch (InsertUserException e1) {
			GestoreEccezioni.getInstance().gestisciEccezione(e1);
			return 0;
		}
		return rs;
	}
}
