package view;

import main.DispatcherParam;
import main.MainDispatcher;
import controller.Request;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeView implements View {

	private Request request;
	private DispatcherParam dp;

	public void showResults(Request request) {
		this.request = request;
		if (request.get("mode").toString().equals("entry")) {
			System.out.println("\n" + "-----DASHBOARD MIMOS-----" + "\n");
			System.out.println("BENVENUTO " + request.getString("nomeUtente") + "\n");
		}
		if (request.get("mode").toString().equals("select")) {
			System.out.println("\n" + "Vuoi accedere come:" + "\n");
		}
		if (request.get("mode").toString().equals("selected")) {
			System.out.println("\n" + "-----OPZIONI " + request.getString("typeUser").toUpperCase() + " MIMOS-----" + "\n");
		}
	}

	public void showOptions() {
		int choice;
		switch (request.get("mode").toString()) {
			case ("entry"):
				String nick = this.request.getString("nomeUtente");
				this.request = new Request();
				this.request.put("mode", "getrole");
				this.request.put("nomeUtente", nick);
				dp = new DispatcherParam("User", "doControl", this.request);
				break;
			case ("select"):
				@SuppressWarnings("unchecked")
				ArrayList<String> roles = (ArrayList<String>) this.request.get("role");
				this.showRole(roles);
				choice = Integer.parseInt(getInput());
				this.request = new Request();
				this.request.put("mode", "selected");
			try {
				this.request.put("typeUser", roles.get(choice));
			} catch (EccezioneScelta e) {
				System.out.println("SCELTA ERRATA");

				this.request = new Request();
				this.request.put("mode", "select");
				this.request.put("role", roles);
				dp = new DispatcherParam("Home", "doControl", this.request);
			}
				dp = new DispatcherParam("Home", "doControl", this.request);
				break;
			case ("selected"):
				this.showDashRole(String.valueOf(this.request.get("typeUser")));
				choice = Integer.parseInt(getInput());
				break;
			case ("logout"):
				break;
		}
	}

	private void showDashRole(String typeUser) {
		System.out.println("(1) Aggiorna Dati");
		System.out.println("(2) Aggiungi Ruolo");
		
	}

	private void showRole(ArrayList<String> roles) {
		int count = 0;
		for (String role : roles) {
			System.out.println(role + " : " + count);
			count++;
		}
		System.out.print("\n" + "Seleziona Ruolo (numero) : ");
	}

	public void submit() {
		MainDispatcher.getInstance().callAction(dp.getClassN(), dp.getMethodN(), dp.getRequest());
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
