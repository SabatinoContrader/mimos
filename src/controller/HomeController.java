package controller;

import main.DispatcherParam;
import main.MainDispatcher;
import service.LoginService;

public class HomeController implements Controller {


    private DispatcherParam dp;
	private Request request;

	public HomeController() {
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
        	case ("logout"):
        		
        	}
        }
        MainDispatcher.getInstance().callView(dp.getClassN(), dp.getRequest());

    }
}
