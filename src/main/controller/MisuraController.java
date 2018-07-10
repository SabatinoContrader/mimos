package main.controller;

import main.MainDispatcher;
import main.model.Utente;

public class MisuraController implements Controller {


    @Override
    public void doControl(Request request) {
        String choice = (String) request.get("choice");
        Utente utente = (Utente) request.get("utente");
        switch (choice) {
            case "misura":
               request.put("mode", "insert");
               break;
            case "misura_all":
               request.put("mode", "all");
               break;
        }
        MainDispatcher.getInstance().callView("Misura", request);

    }
}
