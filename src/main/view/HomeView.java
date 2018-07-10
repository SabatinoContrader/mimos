package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Misura;
//import sun.applet.Main;
import main.model.Utente;
import main.service.MisuraService;

import java.util.Date;
import java.util.Scanner;

public class HomeView implements View {

    private static final Date NULL = null;
	private int choice;
    private int opzione_ruolo;
    private Utente utente;

    public void showResults(Request request) {
        Utente utente = (Utente) request.get("utente");
    	this.utente=(Utente) request.get("utente");
        this.opzione_ruolo = utente.getId_ruolo();
    	if (utente.getId_ruolo()==1) {
            System.out.println("-------SPECCHIO-------");
            System.out.println("-------PAZIENTE-------");
       	 	System.out.println("Paziente: "+utente.getNome()+" "+utente.getCognome());
            System.out.println("---------MENU---------");
            System.out.println("");
            System.out.println("1) Inserisci misura Personale");
            System.out.println("2) Visualizza misure disponibili");
            System.out.println("3) Aggiorna i tuoi dati");
            System.out.println("4) Rimuovere questo utente");
            System.out.println("6) Logout");
            String tmp = getInput();
            this.choice = Integer.parseInt(tmp);

    	}
    	if (utente.getId_ruolo()==2){
            System.out.println("-------SPECCHIO-------");
            System.out.println("-------DOTTORE--------");
       	 	System.out.println("Dottore "+utente.getNome()+" "+utente.getCognome());
            System.out.println("---------MENU---------");
            System.out.println("");
            System.out.println("1) Aggiorna i tuoi dati");
            System.out.println("2) Rimuovere questo utente");
            System.out.println("3) Logout");
            System.out.println("----------------------");
            this.choice = Integer.parseInt(getInput());
       	}
   
    	if (utente.getId_ruolo()==3){
            System.out.println("-------SPECCHIO-------");
            System.out.println("--------ADMIN---------");
       	 	System.out.println("Admin: "+utente.getNome()+" "+utente.getCognome());
            System.out.println("---------MENU---------");
            System.out.println("1) Inserisci nuovo dottore");
            System.out.println("2) Visualizza dottori");
            System.out.println("3) Visualizza pazienti");
            System.out.println("4) Aggiorna i dati di un utente");
            System.out.println("5) Rimuovere un utente");
            System.out.println("6) Logout");
            System.out.println("----------------------");
            this.choice = Integer.parseInt(getInput());
       	}
   
    }

    public void showOptions() {

    }

    public void submit() { 		  
    	  Request request = new Request();
          request.put("user_name", utente.getUser_name());
          request.put("password", utente.getPassword());
          request.put("utente", utente);
    	  switch (opzione_ruolo) {
          case 1:
        	  if (choice == 1) {
        		  String misura = "misura";
              	  request.put("choice", misura);
              	  request.put("utente", utente);
                  MainDispatcher.getInstance().callAction("Misura", "doControl", request);
        	  }       	  
        	  if (choice == 2) {
        		  String misura_all = "misura_all";
              	  request.put("choice", misura_all);
        		  request.put("utente", utente);
        		  MainDispatcher.getInstance().callAction("Misura", "doControl", request);
        	  }
        	  if (choice == 3) {
        		  String set_paziente = "set_utente";
              	  request.put("choice", set_paziente);
        		  request.put("utente", utente);
        		  MainDispatcher.getInstance().callAction("Utente", "doControl", request);
        	  }
        	  if (choice == 4) {
        		  String delete = "delete_utente";
              	  request.put("choice", delete);
        		  request.put("utente", utente);
        		  MainDispatcher.getInstance().callAction("Utente", "doControl", request);
        	  }
        	  if (choice == 5) {
        		  System.out.println("-----CIAO-----");
        		  MainDispatcher.getInstance().callAction("Inizio", "doControl", null);
        	  }
             break;
          case 2:
        	  if (choice == 1) {
        		  String set_utente = "set_utente";
              	  request.put("choice", set_utente);
        		  request.put("utente", utente);
        		  MainDispatcher.getInstance().callAction("Utente", "doControl", request);
        	  }
        	  if (choice == 2) {
        		  String delete = "delete_utente";
              	  request.put("choice", delete);
        		  request.put("utente", utente);
        		  MainDispatcher.getInstance().callAction("Utente", "doControl", request);
        	  }
        	  if (choice == 3) {
        		  System.out.println("-----CIAO-----");
        		  MainDispatcher.getInstance().callAction("Inizio", "doControl", null);
        	  }
             break;
             
          case 3:
        	  if (choice == 1) {
        		  String dottore = "dottore";
                  request.put("choice", dottore);
                  MainDispatcher.getInstance().callAction("Utente", "doControl", request);
        	  }
        	  if (choice == 2) {
        		  String dottore = "dottore_all";
                  request.put("choice", dottore);
                  MainDispatcher.getInstance().callAction("Utente", "doControl", request);
        	  }
        	  if (choice == 3) {
        		  String dottore = "paziente_all";
                  request.put("choice", dottore);
                  MainDispatcher.getInstance().callAction("Utente", "doControl", request);
        	  }
        	  if (choice == 4) {
        		  String delete_utente_admin = "set_utente_admin";
                  request.put("choice", delete_utente_admin);
                  MainDispatcher.getInstance().callAction("Utente", "doControl", request);
        	  }
        	  if (choice == 5) {
        		  String delete_utente_admin = "delete_utente_admin";
                  request.put("choice", delete_utente_admin);
                  MainDispatcher.getInstance().callAction("Utente", "doControl", request);
        	  }
        	  if (choice == 6) {
        		  System.out.println("-----CIAO-----");
        		  MainDispatcher.getInstance().callAction("Inizio", "doControl", null);
        	  }  
             break;
    	  }	
    		
    		
    		
    		

    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }




}
