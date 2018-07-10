package main.controller;

import main.MainDispatcher;

public class InizioController implements Controller {

    public InizioController() {
    }

    public void doControl (Request request) {
        MainDispatcher.getInstance().callView("Inizio", request);
    }
}
