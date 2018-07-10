package main.controller;

import main.MainDispatcher;
import main.model.Utente;
import main.service.LoginService;

public class HomeController implements Controller {

    private LoginService loginService;

    public HomeController() {
        loginService = new LoginService();
    }

    public void doControl(Request request) {
    	System.out.println();
    	if (request != null) {
            String user_name = request.get("user_name").toString();
            String password = request.get("password").toString();
            Utente utente=loginService.login(user_name, password);
            if (utente!=null) {
            	request.put("utente", utente);
                MainDispatcher.getInstance().callView("Home", request);
                }
            else
                MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
       
        else MainDispatcher.getInstance().callView("Home", null);
    }
}
