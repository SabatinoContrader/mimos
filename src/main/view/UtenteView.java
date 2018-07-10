package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Utente;
import main.dao.UtenteDAO;
import main.service.UtenteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UtenteView implements View {
	private Request request;
   	private UtenteService utenteService;
    private String mode;
   	private List<Utente> dottori = new ArrayList<>();
   	private List<Utente> pazienti = new ArrayList<>();
    private Utente utente;
    private Utente utente_service;
    private final String  home = "home";
    private Utente utente_;
    String view;

  public UtenteView() {
     this.utenteService = new UtenteService();
      //this.mode = "paziente";
     // this.utente = (Utente) request.get("utente");
  }

	@SuppressWarnings("unchecked")
	@Override
    public void showResults(Request request) {
       this.mode  = (String) request.get("mode");
       this.utente = (Utente) request.get("utente"); 
       this.dottori = (List<Utente>) request.get("dottori");
       this.pazienti = (List<Utente>) request.get("pazienti");
       this.request = request;
    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "paziente":
            	System.out.println("-----REGISTRAZIONE-----");
                System.out.println("Inserisci i dati:");
                System.out.println("Nome:");
                String nome = getInput();
                System.out.println("Cognome:");
                String cognome= getInput();
                System.out.println("User Name:");
                String user_name = getInput();
                System.out.println("Password:");
                String password = getInput();
                System.out.println("email:");
                String email = getInput();
                String  service_insert_paziente = "service_insert_paziente";
                this.utente_service = new Utente(0, 1, nome, cognome, user_name, password, email);
            	request.put("choice",  service_insert_paziente);
            	request.put("utente_service", utente_service);
            	MainDispatcher.getInstance().callAction("Utente", "doControl", request);
                break;
            case "dottore":
            	System.out.println("-----REGISTRAZIONE DOTTORE-----");
                System.out.println("Inserisci i dati:");
                System.out.println("Nome:");
                String nome_ = getInput();
                System.out.println("Cognome:");
                String cognome_= getInput();
                System.out.println("User Name:");
                String user_name_ = getInput();
                System.out.println("Password:");
                String password_ = getInput();
                System.out.println("email:");
                String email_ = getInput();
                String  service_insert_dottore = "service_insert_dottore";
                this.utente_service = new Utente(0, 2, nome_, cognome_, user_name_, password_, email_);
            	request.put("choice",  service_insert_dottore);
            	request.put("utente_service", utente_service);
            	MainDispatcher.getInstance().callAction("Utente", "doControl", request);
                break;
            case "dottore_all":
                System.out.println("-----Dottori-----");
                System.out.println(" >>> Id  |  Nome  |  Cognome  |  Username <<<");
                dottori.forEach(dottore->System.out.println(dottore.getId_utente()+") | "+dottore.getNome()+" | "+dottore.getCognome()+" | "+dottore.getUser_name()));
                System.out.println("------------------");
                MainDispatcher.getInstance().callAction("Home", "doControl", request);
                // utenteService.insertUtente(new Utente(0, 2, nome_, cognome_, user_name_, password_, email_));
                //this.view = "Home";
                break;
            case "paziente_all":
                System.out.println("-----Paziente-----");
                System.out.println(" >>> Id  |  Nome  |  Cognome  |  Username <<<");
                pazienti.forEach(paziente->System.out.println(paziente.getId_utente()+") | "+paziente.getNome()+" | "+paziente.getCognome()+" | "+paziente.getUser_name()));
                System.out.println("------------------");
                MainDispatcher.getInstance().callAction("Home", "doControl", request);
                break;
            case "set_utente":
            	System.out.println("-----Aggiornamento dei dati-----");
                System.out.println("Inserisci i dati:");
                System.out.println("Nome:");
                String nome1 = getInput();
                System.out.println("Cognome:");
                String cognome1= getInput();
                System.out.println("User Name:");
                String user_name1 = getInput();
                System.out.println("Password:");
                String password1 = getInput();
                System.out.println("email:");
                String email1 = getInput();
                this.utente_service = new Utente(utente.getId_utente(), utente.getId_ruolo(), nome1, cognome1, user_name1, password1, email1);
                String  service_set_utente = "service_set_utente";
            	request.put("choice",  service_set_utente);
            	request.put("utente_service", utente_service);
            	request.put("utente", utente_service);
            	MainDispatcher.getInstance().callAction("Utente", "doControl", request);
                break;
            case "delete_utente":
            	System.out.println("-----Delete utente-----");
                System.out.println("Sicuro di voler cancellare il tuo utente?");
                System.out.println(">>Escrive (1)=SI  (2)=NO");
                int delete = Integer.parseInt(getInput());;
                if(delete == 1) {
                this.utente_service = new Utente(utente.getId_utente(), 0, "", "", "", "", "");
                String  service_delete_utente = "service_delete_utente";
             	request.put("choice",  service_delete_utente);
             	request.put("utente_service", utente_service);
             	MainDispatcher.getInstance().callAction("Utente", "doControl", request);
                }
                else {
                MainDispatcher.getInstance().callAction("Home", "doControl", request);
                }  
                break;
            case "set_utente_admin":
                System.out.println("-----Aggiorna utente-----");
                System.out.println("-----Dottori-----");
                System.out.println(" >>> Id  |  Nome  |  Cognome  |  Username <<<");
                dottori.forEach(dottore->System.out.println(dottore.getId_utente()+") | "+dottore.getNome()+" | "+dottore.getCognome()+" | "+dottore.getUser_name()));
                System.out.println("------------------");
                System.out.println("-----Paziente-----");
                System.out.println(" >>> Id  |  Nome  |  Cognome  |  Username <<<");
                pazienti.forEach(paziente->System.out.println(paziente.getId_utente()+") "+paziente.getNome()+" "+paziente.getCognome()+" | "+paziente.getUser_name()));
                System.out.println("------------------");
                System.out.println("Inserisci l'id dell'utente che desideri aggiornare:");
                int id_utente = Integer.parseInt(getInput());
                System.out.println("Sicuro di voler aggionare questa registrazione?");
                System.out.println(">>Escrive (1)=SI  (2)=NO");
                int delete_ = Integer.parseInt(getInput());;
                if(delete_ == 1) {
                	System.out.println("-----Aggiornamento dei dati-----");
                    System.out.println("Inserisci i dati:");
                    System.out.println("Nome:");
                    String nome2 = getInput();
                    System.out.println("Cognome:");
                    String cognome2= getInput();
                    System.out.println("User Name:");
                    String user_name2 = getInput();
                    System.out.println("Password:");
                    String password2 = getInput();
                    System.out.println("email:");
                    String email2 = getInput();
                    this.utente_service = new Utente(id_utente, 0, nome2, cognome2, user_name2, password2, email2);
                    String  service_set_utente_admin = "service_set_utente_admin";
                	request.put("choice",  service_set_utente_admin);
                	request.put("utente_service", utente_service);
                	MainDispatcher.getInstance().callAction("Utente", "doControl", request);
                }
                break; 
            case "delete_utente_admin":
                System.out.println("-----Delete utente-----");
            	List<Utente> dottoriA = utenteService.getAllDottore();
                System.out.println("-----Dottori-----");
                System.out.println(" >>> Id  |  Nome  |  Cognome  |  Username <<<");
                dottoriA.forEach(dottore->System.out.println(dottore.getId_utente()+") | "+dottore.getNome()+" | "+dottore.getCognome()+" | "+dottore.getUser_name()));
                System.out.println("------------------");
            	List<Utente> pazientiA = utenteService.getAllPaziente();
                System.out.println("-----Paziente-----");
                System.out.println(" >>> Id  |  Nome  |  Cognome  |  Username <<<");
                pazientiA.forEach(paziente->System.out.println(paziente.getId_utente()+") "+paziente.getNome()+" "+paziente.getCognome()+" | "+paziente.getUser_name()));
                System.out.println("------------------");
                System.out.println("Inserisci l'id dell'utente che desideri rimuovere:");
                int id_utente_ = Integer.parseInt(getInput());
                System.out.println("Sicuro di voler cancellare questa registrazione?");
                System.out.println(">>Escrive (1)=SI  (2)=NO");
                int x = Integer.parseInt(getInput());;
                if(x == 1) {
                	this.utente_service = new Utente(id_utente_, 0, "", "", "", "", "");
                    String  service_delete_utente_admin = "service_delete_utente_admin";
                 	request.put("choice",  service_delete_utente_admin);
                 	request.put("utente_service", utente_service);
                 	MainDispatcher.getInstance().callAction("Utente", "doControl", request);
                }
                else{
                	MainDispatcher.getInstance().callAction("Home", "doControl", request);
                }
                break; 
            	case "home":
                	MainDispatcher.getInstance().callAction("Home", "doControl", request);
                break; 
                
                
        }
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
  }

    @Override
    public void submit() {
    if(view == "Inizio") {
       // MainDispatcher.getInstance().callAction("Inizio", "doControl", null);
    }
    if(view == "Home") {
		// MainDispatcher.getInstance().callAction("Home", "doControl", request);
    }

    }

}
