package controller;

import java.util.ArrayList;
import java.util.List;

import main.DispatcherParam;
import main.MainDispatcher;
import model.Administrator;
import model.BaseUser;
import model.Doctor;
import model.Measurements;
import model.Patient;
import model.Pharmacist;
import service.UserService;

public class UserController implements Controller {


    private UserService userService;
    private DispatcherParam dp;
    private Request request;
    
    public UserController() {
    	
    }
    
    @Override
    public void doControl(Request request) {
        this.userService = new UserService();
        this.request = new Request();
        
        String choice = (String) request.get("choice");
        switch (choice) {
            case "insert":
            	this.request.put("mode", "insert");
            	dp =  new DispatcherParam("User", this.request);
            	break;
            case "newuser":
            	this.newUser(request);
            	this.request.put("mode", "0");
            	dp =  new DispatcherParam("Login", this.request);
            	break;
            case "getall":
                List<BaseUser> users = userService.getAllUsers();
                request.put("mode", "all");
            	this.request.put("users", users);
                break;
        }
        MainDispatcher.getInstance().callView(dp.getClassN(), dp.getRequest());

    }
    
    @SuppressWarnings("unchecked")
	private void newUser(Request request) {
    	List<String> attributi = new ArrayList<>();
    	attributi = (List<String>) request.get("data");
    	String type = attributi.get(4);
    	switch (type) {
	    	case "A":
	    		Administrator au = new Administrator(attributi.get(0), 
	    				attributi.get(1), 
	    				attributi.get(2), 
	    				attributi.get(3), 
	    				Boolean.parseBoolean(attributi.get(5)));
	    		userService.insertAdministrator(au);
	    		break;
	    	case "D":
	    		Doctor du = new Doctor(attributi.get(0), 
	    				attributi.get(1), 
	    				attributi.get(2), 
	    				attributi.get(3), 
	    				Measurements.valueOf(attributi.get(5)));
	    		userService.insertDoctor(du);
	    		break;
	    	case "F":
	    		Pharmacist phu = new Pharmacist(attributi.get(0), 
	    				attributi.get(1), 
	    				attributi.get(2), 
	    				attributi.get(3), 
	    				Integer.parseInt(attributi.get(5)));
	    		userService.insertPharmacist(phu);
	    		break;
	    	case "P":
	    		Patient pu = new Patient(attributi.get(0), 
	    				attributi.get(1), 
	    				attributi.get(2), 
	    				attributi.get(3), 
	    				attributi.get(5));
	    		userService.insertPatient(pu);
	    		break;
    	}
    }
}
