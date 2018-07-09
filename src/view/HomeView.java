package view;

import main.DispatcherParam;
import dao.Role;
import main.MainDispatcher;
import controller.Request;
import java.util.ArrayList;
import java.util.Scanner;

public class HomeView implements View {

	private Request request;
	private DispatcherParam dp;
	private String nick, role;

	public void showResults(Request request) {
		this.request = request;
		if (request.get("mode").toString().equals("entry")) {
			System.out.println("\n" + "-----DASHBOARD MIMOS-----" + "\n");
			nick = request.getString("nomeUtente");
			System.out.println("BENVENUTO " + nick + "\n");
		}
		if (request.get("mode").toString().equals("select")) {
			System.out.println("\n" + "Vuoi accedere come:" + "\n");
			nick = request.getString("nomeUtente");
		}
		if (request.get("mode").toString().equals("selected")) {
			nick = request.getString("nomeUtente");
			System.out.println(
					"\n" + "-----OPZIONI " + request.getString("typeUser").toUpperCase() + " MIMOS-----" + "\n");
		}
		if (request.get("mode").toString().equals("option")) {
			nick = request.getString("nomeUtente");
			role = request.getString("typeUser");
			System.out.println(
					"\n" + "Dati di " + request.getString("nomeUtente").toUpperCase() + " come " + 
							request.getString("typeUser").toUpperCase() + "\n");
		}
	}

	public void showOptions() {
		int choice;
		switch (request.get("mode").toString()) {
			case ("entry"):
				this.nick = this.request.getString("nomeUtente");
				this.role = this.request.getString("typeUser");
				this.request = new Request();
				this.request.put("mode", "getrole");
				this.request.put("nomeUtente", nick);
				dp = new DispatcherParam("User", "doControl", this.request);
				break;
			case ("select"):
				@SuppressWarnings("unchecked")
				ArrayList<String> roles = (ArrayList<String>) this.request.get("role");
				this.showRole(roles);
				try {
					choice = Integer.parseInt(getInput());
					this.request = new Request();
					this.request.put("nomeUtente", this.nick);
					this.request.put("mode", "selected");
					this.request.put("typeUser", roles.get(choice));
				} catch (Exception e) {
					System.out.println("SCELTA ERRATA");
					// e.printStackTrace();
					this.request = new Request();
					this.request.put("nomeUtente", this.nick);
					this.request.put("mode", "select");
					this.request.put("typeUser", roles);
					dp = new DispatcherParam("Home", "doControl", this.request);
				}
				dp = new DispatcherParam("Home", "doControl", this.request);
				break;
			case ("selected"):
				this.showDashRole(String.valueOf(this.request.get("typeUser")));
				this.role = this.request.getString("typeUser");
				System.out.println("\n" + "Scegli operazione (numero):");
				choice = Integer.parseInt(getInput());
				this.request = new Request();
				this.request.put("nomeUtente", this.nick);
				this.request.put("typeUser", this.role);
				this.request.put("mode", "option");
				this.request.put("choice", choice);
				dp = new DispatcherParam("Home", "doControl", this.request);
				break;
			case ("option"):
				switch (request.get("choice").toString()) {
					case ("3"):
						this.showParameter((ArrayList<String>) request.get("dataUser"));
						this.request = new Request();
						this.request.put("nomeUtente", this.nick);
						this.request.put("typeUser", this.role);
						this.request.put("mode", "selected");
						dp = new DispatcherParam("Home", "doControl", this.request);
						break;
				}
				break;
			case ("logout"):
				break;
		}
	}

	private void showDashRole(String typeUser) {
		System.out.println("(1) Aggiorna Dati");
		System.out.println("(2) Aggiungi Ruolo");
		System.out.println("(3) Guarda i tuoi dati");
		for (Role role : Role.values()) {
			if (role.Doctor.toString().equals(typeUser)) {
				System.out.println("(4) Visualizza Misurazioni - ToDo");
				break;
			}
			if (role.Patient.toString().equals(typeUser)) {
				System.out.println("(4) Effettua Una Misurazione - ToDo");
				System.out.println("(5) Gaurda Tutte le Misurazioni - ToDo");
				break;
			}
			if (role.MAdmin.toString().equals(typeUser)) {
				System.out.println("(4) Gaurda Tutti gli User - ToDo");
				break;
			}
			if (role.Pharmacist.toString().equals(typeUser)) {
				System.out.println("(4) Gaurda Tutte le Ricette - ToDo");
				break;
			}
		}

	}

	private void showRole(ArrayList<String> roles) {
		int count = 0;
		for (String role : roles) {
			System.out.println(role + " (" + count + ")");
			count++;
		}
		System.out.print("\n" + "Seleziona Ruolo (numero) : ");
	}

	private void showParameter(ArrayList<String> param) {
		int count = 0;
		for (String p : param) {
			System.out.println(p + " (" + count + ")");
			count++;
		}
		System.out.print("\n" + "-----------------------------");
	}

	public void submit() {
		MainDispatcher.getInstance().callAction(dp.getClassN(), dp.getMethodN(), dp.getRequest());
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
