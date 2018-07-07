package view;
import main.DispatcherParam;
import main.MainDispatcher;
import controller.Request;
import model.*;
import dao.UserDAO;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserView implements View {

    private Request request;
    private DispatcherParam dp;

  public UserView () {
	  
  }

    @Override
    public void showResults(Request request) {
    	//qui non ho compreso bene ma ci carico la request in entrata
    	//predo il mode e lo memorizzo?
    	this.request = request;
        System.out.println("----- USER TAB -----");
    }

    @Override
    public void showOptions() {
        switch (request.getString("mode")) {
            case "all":
                System.out.println("----- UTENTI -----");
                System.out.println();
                @SuppressWarnings
                ("unchecked") List<BaseUser> bus = (List<BaseUser>) request.get("users");
                for (BaseUser bu : bus) {
                	System.out.println(bu.toString());
                }
                break;
            case "insert":
                System.out.println("----- REGISTRAZIONE -----");
            	List<String> attributi = new ArrayList<>();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci i dati del nuovo utente o aggiungi ruolo:");
                System.out.println("Nick Name:");
                attributi.add(getInput());
                System.out.println("Password:");
                attributi.add(getInput());
                System.out.println("Nome:");
                attributi.add(getInput());
                System.out.println("Cognome:");
                attributi.add(getInput());
                System.out.println("Ruolo:");
                System.out.println("(P) Paziente");
                System.out.println("(D) Dottore");
                System.out.println("(F) Farmacista");
                System.out.println("(A) Admin");
                attributi.add(getInput());
                System.out.println("Attributo:");
                System.out.println("(P) Tessera Sanitaria");
                System.out.println("(D) Competenza");
                System.out.println("(F) Codice Farmacia");
                System.out.println("(A) E' root");
                attributi.add(getInput());
                request = new Request();
                request.put("choice", "newuser");
                request.put("data", attributi);
                dp = new DispatcherParam("User", "doControl", this.request);
        }
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
  }

    @Override
    public void submit() {
        MainDispatcher.getInstance().callAction(dp.getClassN(), dp.getMethodN(), dp.getRequest());
    }



}
