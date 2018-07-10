package main.service;

import main.dao.LoginDAO;
import main.model.Utente;

public class LoginService {

    private LoginDAO loginDAO;

    public LoginService() {
        this.loginDAO = new LoginDAO();
    }

    public Utente login (String user_name, String password) {
		return this.loginDAO.login(user_name,password);
    }
}
