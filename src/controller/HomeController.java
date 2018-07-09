package controller;

import main.DispatcherParam;
import main.MainDispatcher;
import service.HomeService;
import service.LoginService;

public class HomeController implements Controller {


    private DispatcherParam dp;
	private Request request;
	private HomeService homeService;

	public HomeController() {
		homeService = new HomeService();
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
        		this.internalDP(request.get("choice").toString(),
        				request.get("nomeUtente").toString());
        		break;
        	case ("logout"):
        		
        	}
        }
        MainDispatcher.getInstance().callView(dp.getClassN(), dp.getRequest());

    }

	private void internalDP(String choice, String string) {
		switch (choice) {
		case ("3"):
			break;
		}
		
	}
}
