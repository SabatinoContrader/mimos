package controller;

import main.MainDispatcher;
import service.LoginService;

public class IndexController implements Controller {

	private Request request;
	
	public IndexController() {
		request = new Request();
	}

	public void doControl(Request request) {
		if (request != null) {
			switch (request.getString("mode")) {
			case ("1"):
				MainDispatcher.getInstance().callView("Login", null);
				break;
			case ("2"):
				this.request.put("mode", "insert");
				MainDispatcher.getInstance().callView("Login", this.request);
			}
		} else
			MainDispatcher.getInstance().callView("Index", null);
	}
}
