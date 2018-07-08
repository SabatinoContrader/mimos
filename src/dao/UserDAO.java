package dao;

import main.ConnectionSingleton;
import controller.GestoreEccezioni;
import model.AUser;
import model.Administrator;
import model.BaseUser;
import model.Doctor;
import model.Patient;
import model.Pharmacist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	private final String QUERY_ALL = "select * from MUser";
	private final String QUERY_INSERT_GENERIC = "insert into MUser (nick, psw, sName, lName) values (?,?,?,?)";
	private String QUERY_INSERT_SPEC;
	private final String QUERY_GETID = "select MUser.idUnique, MUser.nick from MUser";
	private final String QUERY_VERIFY_NICK = "SELECT MUser.nick FROM $tableName "
			+ "LEFT OUTER JOIN MUser ON MUser.idUnique = ?.IdUnique"
			+ "WHERE muser.nick = '?'";
	private final String QUERY_VERIFY_ID = "SELECT idUnique FROM $tableName "
			+ "WHERE idUnique = ?";

	public UserDAO() {

	}

	public List<String> getUserRole(String nick) {
		int id = this.getIdUniqueByNick(nick);
		List<String> data = new ArrayList<>();

		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement;
			//uso un foreach per i valor del Role enum
			ResultSet res = null;
			for (Role r: Role.values()) {
				// creo il MUser
				String query = QUERY_VERIFY_ID.replace("$tableName",r.name());
				//System.out.println(query);
				preparedStatement = connection.prepareStatement(query);
				//non si può passare il nome della tabella in string
				preparedStatement.setInt(1, id);
				//boolean result = preparedStatement.execute();
				//System.out.println(preparedStatement);
				res = preparedStatement.executeQuery();
				//System.out.println(res);
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

	public List<BaseUser> getAllUsers() {
		List<BaseUser> users = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				int id = resultSet.getInt("idUnique");
				String nickName = resultSet.getString("nick");
				String password = resultSet.getString("psw");
				String surName = resultSet.getString("sName");
				String lastName = resultSet.getString("lName");
				users.add(new BaseUser(nickName, password, surName, lastName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	private int getIdUniqueByNick(String nick) {
		Connection connection = ConnectionSingleton.getInstance();
		int id;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_GETID);
			while (resultSet.next()) {
				id = resultSet.getInt("idUnique");
				String nickname = resultSet.getString("nick");
				if (nickname.equals(nick)) {
					return id;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private int insertBaseUser(BaseUser user) {
		Connection connection = ConnectionSingleton.getInstance();
		int id = 0;
		try {
			PreparedStatement preparedStatement;
			// verifico se l'utente già c'è mediante nick
			if (this.getIdUniqueByNick(user.getNick()) != 0)
				throw new InsertUserException();
			// creo il MUser
			preparedStatement = connection.prepareStatement(QUERY_INSERT_GENERIC);
			preparedStatement.setString(1, user.getNick());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getSurname());
			preparedStatement.setString(4, user.getLastname());
			preparedStatement.execute();
			id = this.getIdUniqueByNick(user.getNick());
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return 0;
		} catch (InsertUserException e1) {
			GestoreEccezioni.getInstance().gestisciEccezione(e1);
			return 0;
		}
		return id;

	}

	public boolean insertPatient(Patient user) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement;
			BaseUser bu = new BaseUser(user.getNick(), user.getPassword(), user.getLastname(), user.getSurname());
			// creo il Patient
			QUERY_INSERT_SPEC = "insert into Patient (idUnique, healthInsuranceCard) values (?,?)";
			preparedStatement = connection.prepareStatement(QUERY_INSERT_SPEC);
			preparedStatement.setInt(1, this.insertBaseUser(bu));
			preparedStatement.setString(2, user.getHealthAC());
			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public boolean insertDoctor(Doctor user) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement;
			BaseUser bu = new BaseUser(user.getNick(), user.getPassword(), user.getLastname(), user.getSurname());
			// creo il Doctor
			QUERY_INSERT_SPEC = "insert into Doctor (idUnique, mainSkill) values (?,?)";
			preparedStatement = connection.prepareStatement(QUERY_INSERT_SPEC);
			preparedStatement.setInt(1, this.insertBaseUser(bu));
			preparedStatement.setString(2, user.getMainSkill().name());
			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public boolean insertAdmin(Administrator user) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement;
			BaseUser bu = new BaseUser(user.getNick(), user.getPassword(), user.getLastname(), user.getSurname());
			// creo l'Admin
			QUERY_INSERT_SPEC = "insert into MAdmin (idUnique, isRoot) values (?,?)";
			preparedStatement = connection.prepareStatement(QUERY_INSERT_SPEC);
			preparedStatement.setInt(1, this.insertBaseUser(bu));
			preparedStatement.setBoolean(2, user.getIsRoot());
			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public boolean insertPharmacist(Pharmacist user) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement;
			BaseUser bu = new BaseUser(user.getNick(), user.getPassword(), user.getLastname(), user.getSurname());
			// creo il Pharmacist
			QUERY_INSERT_SPEC = "insert into Pharmacist (idUnique, idPharmacy) values (?,?)";
			preparedStatement = connection.prepareStatement(QUERY_INSERT_SPEC);
			preparedStatement.setInt(1, this.insertBaseUser(bu));
			preparedStatement.setInt(2, user.getPharmacy());
			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
}
