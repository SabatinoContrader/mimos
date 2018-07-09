package controller;

import java.util.ArrayList;
import java.util.List;

import main.DispatcherParam;
import main.MainDispatcher;
import service.HomeService;
import service.LoginService;

public class HomeController implements Controller {


    private DispatcherParam dp;
	private Request request;
	private HomeService homeService;
	private List<String> gArray;

	public HomeController() {
		homeService = new HomeService();
		gArray = new ArrayList<>();
    }

    public void doControl(Request request) {
        if (request != null) {
        	switch (String.valueOf(request.get("mode"))) {
        	case ("select"):
        		this.request = request;
				dp = new DispatcherParam("Home", this.request);
        		break;
        	case ("selected"):
        		this.request = request;
				dp = new DispatcherParam("Home", this.request);
        		break;
        	case ("option"):
        		this.request = new Request();
        		this.internalDP(request.get("choice").toString(),
        				request.get("nomeUtente").toString(),
        				request.get("typeUser").toString());
        		this.request.put("dataUser", gArray);
        		this.request.put("choice", request.get("choice").toString());
        		this.request.put("nomeUtente", request.get("nomeUtente").toString());
        		this.request.put("typeUser", request.get("typeUser").toString());
        		this.request.put("mode", "option");
				dp = new DispatcherParam("Home", this.request);
        		break;
        	case ("logout"):
        		
        	}
        }
        MainDispatcher.getInstance().callView(dp.getClassN(), dp.getRequest());

    }

	private void internalDP(String choice, String nick, String typeUser) {
		switch (choice) {
		case ("3"):
			gArray = homeService.getDataUser(nick, typeUser);
			break;
		}
		
	}
}
