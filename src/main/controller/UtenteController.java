package main.controller;

import main.MainDispatcher;
import main.model.Utente;

public class UtenteController implements Controller {

    @Override
    public void doControl(Request request) {
        String choice = (String) request.get("choice");
        //Utente utente = (Utente) request.get("utente");
        switch (choice) {
            case "paziente":              
            	request.put("mode", "paziente");
                break;
            case "dottore":
                request.put("mode", "dottore");
                break;
            case "dottore_all":
                request.put("mode", "dottore_all");
                break;
            case "paziente_all":
                request.put("mode", "paziente_all");
                break;
            case "set_utente":
                request.put("mode", "set_utente");
                break;
            case "delete_utente":
                request.put("mode", "delete_utente");
                break;
            case "delete_utente_admin":
                request.put("mode", "delete_utente_admin");
                break;
            case "set_utente_admin":
                request.put("mode", "set_utente_admin");
                break;
        }
        MainDispatcher.getInstance().callView("Utente", request);

    }
}
