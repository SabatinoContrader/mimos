package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Gomma;
import main.model.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private final String QUERY_LOGIN = "select * from utente where user_name = ? and password = ?";

    public Utente login (String user_name1, String password1) {

        Connection connection = ConnectionSingleton.getInstance();
        Utente utente=null;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
            statement.setString(1, user_name1);
            statement.setString(2, password1);
            ResultSet resultSet =statement.executeQuery();
            if(resultSet.next()) {
            	int id_utente = resultSet.getInt("id_utente");
            	int id_ruolo = resultSet.getInt("id_ruolo");
            	String nome = resultSet.getString("nome");
            	String cognome = resultSet.getString("cognome");
            	String user_name = resultSet.getString("user_name");
            	String password = resultSet.getString("password");
            	String email = resultSet.getString("email");
            	utente=new Utente(id_utente,id_ruolo, nome, cognome, user_name, password,email);
            }
            return utente;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return utente;
        }
    }
}

