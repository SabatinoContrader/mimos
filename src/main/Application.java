package main;

import controller.Request;

public class Application {

    public static void main(String[] args) {
        //MainDispatcher.getInstance().callAction("Login", "doControl", null);
    	// 0 scelta - 1 login - 2 register
    	Request request = new Request();
    	request.put("mode", "0");
    	MainDispatcher.getInstance().callView("Login", request);
    }

}
