package main.controller;
import main.MainDispatcher;
import main.model.Utente;
import main.service.UtenteService;

public class UtenteController implements Controller {
	
	private UtenteService utenteService = new UtenteService();
	
    @Override
    public void doControl(Request request) {
        String choice = (String) request.get("choice");
        switch (choice) {
        	case "home":              
        		request.put("mode", "home");
        		MainDispatcher.getInstance().callView("Utente", request);
            break;
            case "paziente":              
            	request.put("mode", "paziente");
                MainDispatcher.getInstance().callView("Utente", request);
                break;
            case "dottore":
                request.put("mode", "dottore");
                MainDispatcher.getInstance().callView("Utente", request);
                break;
            case "dottore_all":
                request.put("mode", "dottore_all");
                request.put("dottori", utenteService.getAllDottore());
                MainDispatcher.getInstance().callView("Utente", request);
                break;
            case "paziente_all":
                request.put("mode", "paziente_all");
                request.put("pazienti", utenteService.getAllPaziente());
                MainDispatcher.getInstance().callView("Utente", request);
                break;
            case "set_utente":
                request.put("mode", "set_utente");
                MainDispatcher.getInstance().callView("Utente", request);
                break;
            case "delete_utente":
                request.put("mode", "delete_utente");
                MainDispatcher.getInstance().callView("Utente", request);
                break;
            case "delete_utente_admin":
                request.put("mode", "delete_utente_admin");
                MainDispatcher.getInstance().callView("Utente", request);
                break;
            case "set_utente_admin":
                request.put("mode", "set_utente_admin");
	          	request.put("dottori", utenteService.getAllDottore());
	            request.put("pazienti", utenteService.getAllPaziente());
	            MainDispatcher.getInstance().callView("Utente", request);
                break;
            case "service_insert_paziente":
            	utenteService.insertUtente((Utente) request.get("utente_service"));
                MainDispatcher.getInstance().callView("Inizio", null);
                break;
            case "service_insert_dottore":
            	utenteService.insertUtente((Utente) request.get("utente_service"));
                MainDispatcher.getInstance().callView("Home", request);
                break;
            case "service_dottore_all":
            	utenteService.insertUtente((Utente) request.get("utente_service"));
                break;
            case "service_set_utente":     
            	utenteService.setUtente((Utente) request.get("utente_service"));
            	request.put("mode", "home");
            	MainDispatcher.getInstance().callView("Home", request);
                break;  
            case "service_delete_utente":     
            	utenteService.deleteUtente((Utente) request.get("utente_service"));
                MainDispatcher.getInstance().callView("Inizio", request);
                break;  
            case "service_delete_utente_admin":     
            	utenteService.deleteUtente((Utente) request.get("utente_service"));
            	request.put("mode", "home");
            	MainDispatcher.getInstance().callView("Home", request);
                break;
            case "service_set_utente_admin":     
            	utenteService.setUtente((Utente) request.get("utente_service"));
            	MainDispatcher.getInstance().callView("Home", request);
                break;  
        }

    }
}
