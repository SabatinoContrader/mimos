package com.virtualpairprogrammers.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.Dottore;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class DottoreDAO {

	private final String QUERY_DELETE_SKILL = "delete from mimosJSP.$tableName " 
			+ "where $columnName_1 = ? and $columnName_2 = ?";
	private final String QUERY_INSERT_SKILL = "insert into mimosJSP.$tableName "
			+ "($columnName_1, $columnName_2) "
			+ "values (?, ?)";
	private final String QUERY_ALL_SKILLS_UNIQUE = "select mimosJSP.$tableName_1.$tableColumn_1 "
			+ "from mimosJSP.$tableName_1 "
			+ "LEFT OUTER JOIN mimosJSP.$tableName_2 ON mimosJSP.$tableName_1.$tableColumn_1 = mimosJSP.$tableName_2.$tableColumn_1 "
			+ "WHERE mimosJSP.$tableName_2.$tableColumn_2 = ?";

	public DottoreDAO() {

	}

	public ArrayList<Dottore> getAllSkills(int id_dottore) {
		ArrayList<Dottore> doctors = new ArrayList<>();
		Dottore doctor;
		Connection connection = ConnectionSingleton.getInstance();
		try {
			//Statement statement = connection.createStatement();
			String query_added_t1 = QUERY_ALL_SKILLS_UNIQUE.replace("$tableName_1", "specialita");
			String query_added_t2 = query_added_t1.replace("$tableName_2", "dottore_specialita");
			String query_added_c1 = query_added_t2.replace("$tableColumn_1", "id_specialita");
			String query_added_c2 = query_added_c1.replace("$tableColumn_2", "id_dottore");;
			PreparedStatement preparedStatement = connection.prepareStatement(query_added_c2);
			preparedStatement.setInt(1, id_dottore);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				doctor = new Dottore();
				doctor.setId_specialita(resultSet.getInt("id_specialita"));
				doctor.setId_utente(id_dottore);
				doctors.add(doctor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctors;
	}

	public boolean insertSkill(int id_dottore, int id_specialita) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement;
			String query_added_table = QUERY_INSERT_SKILL.replace("$tableName", "dottore_specialita");
			String query_added_c1 = query_added_table.replace("$tableColumn_1", "id_dottore");
			String query_added_c2 = query_added_c1.replace("$tableColumn_2", "id_specialita");
			preparedStatement = connection.prepareStatement(query_added_c2);
			preparedStatement.setInt(1, id_dottore);
			preparedStatement.setInt(2, id_specialita);
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

	public boolean deleteSkill(int id_dottore, int id_specialita) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement;
			String query_added_table = QUERY_DELETE_SKILL.replace("$tableName", "dottore_specialita");
			String query_added_c1 = query_added_table.replace("$tableColumn", "id_dottore");
			String query_added_c2 = query_added_c1.replace("$tableColumn", "id_specialita");
			preparedStatement = connection.prepareStatement(query_added_c2);
			preparedStatement.setInt(1, id_dottore);
			preparedStatement.setInt(2, id_specialita);
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
