package main.view;

import java.util.List;
import java.util.Scanner;
import java.util.Date;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Misura;
import main.model.Utente;
import main.service.MisuraService;

public class MisuraView implements View {

	private static final Date NULL = null;
	private MisuraService misuraService;
    private Utente utente;
    private String mode;
    private Request request;
    
    public void showResults(Request request) {
       this.misuraService = new MisuraService();
       this.mode  = (String) request.get("mode");
       this.utente = (Utente) request.get("utente");
       this.request = request;
    }

    public void showOptions() {
        switch (mode) {
            case "all":
                List<Misura> misure = misuraService.getAllMisura();
                System.out.println("----- Misure disponibili -----");
                System.out.println();
                System.out.println(" >>> Data  |  Pressione  |  Temperatura  |  Glicemia <<<");
                misure.forEach(misura -> System.out.println(">>"+misura.getData()+" | "+ misura.getPressione()+" | "+misura.getTemperatura()+" | "+ misura.getGlicemia()));
                break;
            case "insert":  
            	//misuraService.insertMisura(new Misura(2, 1, 12, 12, 12, NULL));
                System.out.println("------- Nuova misura --------");
                System.out.println("Inserisci pressione");
                float pressione = Float.parseFloat(getInput());
                System.out.println("Inserisci temperatura:");
                float temperatura = Float.parseFloat(getInput());
                System.out.println("Inserisci glicemia:");
                float glicemia = Float.parseFloat(getInput());
                System.out.println("----Inserito con successo----");
                misuraService.insertMisura(new Misura(0, utente.getId_utente(), pressione, temperatura, glicemia, NULL));
                break;
        }
    }


	public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
  }

    public void submit() {
    	 MainDispatcher.getInstance().callAction("Home", "doControl", request);
    }


}
