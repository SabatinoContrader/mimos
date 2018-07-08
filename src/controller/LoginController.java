package controller;

import main.MainDispatcher;
import service.LoginService;

public class LoginController implements Controller {

	private Request request;
	private LoginService loginService;

	public LoginController() {
		request = new Request();
		loginService = new LoginService();
	}

	public void doControl(Request request) {
		if (request != null) {
			String nomeUtente = request.get("nomeUtente").toString();
			String password = request.get("password").toString();
			
			boolean tmp = loginService.login(nomeUtente, password);
			if (tmp) {
				this.request = new Request();
				this.request.put("mode", "entry");
				this.request.put("nomeUtente", nomeUtente);
				this.request.put("password", password);
				MainDispatcher.getInstance().callView("Home", this.request);
			}
			else {
				this.request.put("result", tmp);
				MainDispatcher.getInstance().callView("Login", this.request);
			}
		} else
			MainDispatcher.getInstance().callView("Login", null);
	}
}
