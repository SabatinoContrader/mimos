package dao;

import main.ConnectionSingleton;
import controller.GestoreEccezioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HomeDAO {

	private final String QUERY_DATA_OBTAIN = "SELECT nick, psw, sName, lName, $columnName " + "FROM MUser "
			+ "LEFT OUTER JOIN $tableName ON MUser.idUnique = $tableName.IdUnique " + "WHERE MUser.nick = ?";

	public ArrayList<String> getDataUser(String username, String role) {
		ArrayList<String> data = new ArrayList<>();
		String s = null;
		Connection connection = ConnectionSingleton.getInstance();
		try {
			String query_added_table = QUERY_DATA_OBTAIN.replace("$tableName", role);
			switch (role) {
				case ("Patient"):
					s = "healthInsuranceCard";
					break;
				case ("MAdmin"):
					s = "isRoot";
					break;
				case ("Doctor"):
					s = "mainSkill";
					break;
				case ("Pharmacist"):
					s = "idPharmacy";
			}
			String query_added_column = query_added_table.replace("$columnName", s);
			PreparedStatement statement = connection.prepareStatement(query_added_column);
			statement.setString(1, s);
			statement.setString(1, username);
			System.out.println(statement);
			ResultSet rs = statement.executeQuery();
			rs.next();
			data.add(rs.getString("nick"));
			data.add(rs.getString("psw"));
			data.add(rs.getString("sName"));
			data.add(rs.getString("lName"));
			data.add(rs.getString(s));
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
		return data;
	}
}
