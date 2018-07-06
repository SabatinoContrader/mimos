package controller;

import main.MainDispatcher;
import service.LoginService;

public class LoginController implements Controller {

	private LoginService loginService;
    public LoginController() {
    }

    public void doControl (Request request) {
    	String username = request.get("nomeUtente").toString();
    	String password = request.get("password").toString();
    	if(loginService.login(username, password)) {
        MainDispatcher.getInstance().callView("Login", request);
    	}
    	else MainDispatcher.getInstance().callView("Login", request);
    }
}
