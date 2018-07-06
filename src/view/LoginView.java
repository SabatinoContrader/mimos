package view;

import main.DispatcherParam;
import main.MainDispatcher;
import controller.Request;

import java.util.Scanner;

public class LoginView implements View {

    private String nomeUtente;
    private String password;
    private Request request;
    private DispatcherParam dp;

    public void showResults (Request request) {
    	this.request = request;
    }


    public void showOptions () {
        switch (request.getString("mode")) {
	        case "1":
	        	request = new Request();
		        System.out.println("-----LOGIN----");
		        System.out.println("Nome utente:");
		        nomeUtente = getInput();
		        System.out.println("Password:");
		        password = getInput();
		        this.request.put("login", "log");
		        this.request.put("nomeUtente", nomeUtente);
		        this.request.put("password", password);
		        dp = new DispatcherParam("Home", "doControl", request);
		        break;
	        case "0":
	        	request = new Request();
		        System.out.println("-----BENVENUTO----");
		        System.out.println("(1) LogIn");
		        System.out.println("(2) SignUp");
		        System.out.println("Inserisci il numero corrispondente:");
		        String tmp = getInput();
		        this.request.put("mode", tmp);
		        dp = new DispatcherParam("Login", "doControl", request);
		        break;
	        case "2":
	        	request = new Request();
		        System.out.println("-----REGISTER----");
		        this.request.put("choice", "insert");
		        dp = new DispatcherParam("User", "doControl", request);
		        break;
        }
    }

    public void submit() {
        MainDispatcher.getInstance().callAction(dp.getClassN(), dp.getMethodN(), dp.getRequest());
    }


    public String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    protected void send () {
    }


}
