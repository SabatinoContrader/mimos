package dao;

import main.ConnectionSingleton;
import controller.GestoreEccezioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDAO {

    private final String QUERY_LOGIN = "select * from mimos.muser where nick = ? and psw = ?";

    public boolean login (String username, String password) {

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
            statement.setString(1, username);
            statement.setString(2, password);
            return statement.executeQuery().next();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
}
