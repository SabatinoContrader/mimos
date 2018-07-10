package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Utente;

import java.util.List;
import java.util.Scanner;

public class InizioView implements View {
    
	private int choice;

    public void showResults (Request request) {

    }


    public void showOptions () {
        System.out.println("-----Inizio Specchio----");
        System.out.println("Ciao Contrader");
        System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Inizia sessione");
        System.out.println("2) Registrati come utente");
        this.choice = Integer.parseInt(getInput());

       /* nomeUtente = getInput();
        System.out.println("Password:");
        password = getInput();*/
    }
    public void submit() {
    	  if (choice == 1)      	
    	  MainDispatcher.getInstance().callAction("Login", "doControl", null);
          if (choice == 2) {
          String paziente = "paziente";
          Request request = new Request();
          request.put("choice", paziente);
          MainDispatcher.getInstance().callAction("Utente", "doControl", request);
          }

    }


    public String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    protected void send () {
    }


}
