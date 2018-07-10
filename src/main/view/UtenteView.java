package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Utente;
import main.dao.UtenteDAO;
import main.service.UtenteService;

import java.util.List;
import java.util.Scanner;

public class UtenteView implements View {
	private Request request;
   	private UtenteService utenteService;
    private String mode;
    private Utente utente;
    private Utente utente_;
    String view;

  public UtenteView() {
     this.utenteService = new UtenteService();
      //this.mode = "paziente";
     // this.utente = (Utente) request.get("utente");
  }

    @Override
    public void showResults(Request request) {
       this.mode  = (String) request.get("mode");
       this.utente = (Utente) request.get("utente");  
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
                utenteService.insertUtente(new Utente(0, 1, nome, cognome, user_name, password, email));
                this.view = "Inizio";
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
                utenteService.insertUtente(new Utente(0, 2, nome_, cognome_, user_name_, password_, email_));
                System.out.println("----Inserito con successo----");
                this.view = "Home";
                break;
            case "dottore_all":
            	List<Utente> dottori = utenteService.getAllDottore();
                System.out.println("-----Dottori-----");
                System.out.println(" >>> Id  |  Nome  |  Cognome  |  Username <<<");
                dottori.forEach(dottore->System.out.println(dottore.getId_utente()+") | "+dottore.getNome()+" | "+dottore.getCognome()+" | "+dottore.getUser_name()));
                System.out.println("------------------");
                this.view = "Home";
                // utenteService.insertUtente(new Utente(0, 2, nome_, cognome_, user_name_, password_, email_));
                //this.view = "Home";
                break;
            case "paziente_all":
            	List<Utente> pazienti = utenteService.getAllPaziente();
                System.out.println("-----Paziente-----");
                System.out.println(" >>> Id  |  Nome  |  Cognome  |  Username <<<");
                pazienti.forEach(paziente->System.out.println(paziente.getId_utente()+") | "+paziente.getNome()+" | "+paziente.getCognome()+" | "+paziente.getUser_name()));
                System.out.println("------------------");
                this.view = "Home";
                // utenteService.insertUtente(new Utente(0, 2, nome_, cognome_, user_name_, password_, email_));
                //this.view = "Home";
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
                utente_ = new Utente(utente.getId_utente(), utente.getId_ruolo(), nome1, cognome1, user_name1, password1, email1);
                utenteService.setUtente(utente_);
                System.out.println("----Aggiornato con successo----");
                request.put("user_name", utente_.getUser_name());
                request.put("password", utente_.getPassword());
                request.put("utente", utente_);
                this.view = "Home";
                break;
            case "delete_utente":
            	System.out.println("-----Delete utente-----");
                System.out.println("Sicuro di voler cancellare il tuo utente?");
                System.out.println(">>Escrive (1)=SI  (2)=NO");
                int delete = Integer.parseInt(getInput());;
                if(delete == 1) {
                System.out.println("----Cancellato con successo----");
                utente_ = new Utente(utente.getId_utente(), utente.getId_ruolo(), "", "", "", "", "");
                utenteService.deleteUtente(utente_);
                this.view = "Inizio";
                }
                else {
                	this.view = "Home";
                }  
                break;
            case "set_utente_admin":
                System.out.println("-----Aggiorna utente-----");
                System.out.println("-----Delete utente-----");
            	List<Utente> dottoriE = utenteService.getAllDottore();
                System.out.println("-----Dottori-----");
                System.out.println(" >>> Id  |  Nome  |  Cognome  |  Username <<<");
                dottoriE.forEach(dottore->System.out.println(dottore.getId_utente()+") | "+dottore.getNome()+" | "+dottore.getCognome()+" | "+dottore.getUser_name()));
                System.out.println("------------------");
            	List<Utente> pazientiE = utenteService.getAllPaziente();
                System.out.println("-----Paziente-----");
                System.out.println(" >>> Id  |  Nome  |  Cognome  |  Username <<<");
                pazientiE.forEach(paziente->System.out.println(paziente.getId_utente()+") "+paziente.getNome()+" "+paziente.getCognome()+" | "+paziente.getUser_name()));
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
                    utente_ = new Utente(id_utente, 0, nome2, cognome2, user_name2, password2, email2);
                    utenteService.setUtente(utente_);
                    System.out.println("----Aggiornato con successo----");
                }
                this.view = "Home";
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
                utente_ = new Utente(id_utente_, 0, "", "", "", "", "");
                utenteService.deleteUtente(utente_);
                System.out.println("----Cancellato con successo----");
                }
                this.view = "Home";
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
        MainDispatcher.getInstance().callAction("Inizio", "doControl", null);
    }
    if(view == "Home") {
		MainDispatcher.getInstance().callAction("Home", "doControl", request);
    }

    }

}
