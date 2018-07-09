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
    private boolean succ;
    
    public UserController() {
    	
    }
    
    @Override
    public void doControl(Request request) {
        this.userService = new UserService();
        this.request = new Request();
        String mode = (String) request.get("mode");
        switch (mode) {
            case "insert":
            	this.request.put("mode", "insert");
            	dp =  new DispatcherParam("User", this.request);
            	break;
            case "newuser":
            	this.request.put("result", newUser(request));
            	dp =  new DispatcherParam("Index", this.request);
            	break;
            case "getall":
                List<BaseUser> user;
                user = userService.getAllUsers();
                request.put("mode", "all");
            	this.request.put("users", user);
                break;
            case "getrole":
            	List<String> role;
                role = userService.getUserRole(request.getString("nomeUtente"));
                this.request.put("mode", "select");
            	this.request.put("role", role);
            	this.request.put("nomeUtente", request.getString("nomeUtente"));
            	dp =  new DispatcherParam("Home", this.request);
                break;
            case "updateData":
            	succ = userService.updateData(request.getString("nomeUtente"),
            			request.getString("typeUser"),
            			request.getString("field"),
            			request.getString("newData"));
                this.request.put("mode", "selected");
            	this.request.put("typeUser", request.getString("typeUser"));
            	this.request.put("nomeUtente", request.getString("nomeUtente"));
        		this.request.put("success", succ);
            	dp =  new DispatcherParam("Home", this.request);
            	break;
            case "addRole":
            	succ = userService.addRole(request.getString("nomeUtente"),
            			request.getString("typeUser"),
            			request.getString("field"),
            			request.getString("newData"));
                this.request.put("mode", "selected");
            	this.request.put("typeUser", request.getString("typeUser"));
            	this.request.put("nomeUtente", request.getString("nomeUtente"));
        		this.request.put("success", succ);
            	dp =  new DispatcherParam("Home", this.request);
            	break;
        }
        MainDispatcher.getInstance().callView(dp.getClassN(), dp.getRequest());

    }
    
    @SuppressWarnings("unchecked")
	private boolean newUser(Request request) {
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
	    		return userService.insertAdministrator(au);
	    	case "D":
	    		Doctor du = new Doctor(attributi.get(0), 
	    				attributi.get(1), 
	    				attributi.get(2), 
	    				attributi.get(3), 
	    				Measurements.valueOf(attributi.get(5)));
	    		return userService.insertDoctor(du);
	    	case "F":
	    		Pharmacist phu = new Pharmacist(attributi.get(0), 
	    				attributi.get(1), 
	    				attributi.get(2), 
	    				attributi.get(3), 
	    				Integer.parseInt(attributi.get(5)));
	    		return userService.insertPharmacist(phu);
	    	case "P":
	    		Patient pu = new Patient(attributi.get(0), 
	    				attributi.get(1), 
	    				attributi.get(2), 
	    				attributi.get(3), 
	    				attributi.get(5));
	    		return userService.insertPatient(pu);
    	}
		return false;
    }
}
