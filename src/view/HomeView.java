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
	boolean succ;

	public void showResults(Request request) {
		this.request = request;
		if (request.get("mode").toString().equals("entry")) {
			System.out.println("\n" + "-----DASHBOARD MIMOS-----" + "\n");
			nick = request.getString("nomeUtente");
			System.out.println("BENVENUTO " + nick + "\n");
		} else
		if (request.get("mode").toString().equals("select")) {
			System.out.println("\n" + "Vuoi accedere come:" + "\n");
			nick = request.getString("nomeUtente");
		} else
		if (request.get("mode").toString().equals("selected")) {
			nick = request.getString("nomeUtente");
			role = request.getString("typeUser");
			try {
				succ = Boolean.valueOf(request.getString("success"));
			} catch (Exception e) {
				return;
				//e.printStackTrace();
			}
			if (!succ)
				System.out.println("OPERAZIONE NON RISUCITA");
			System.out.println(
					"\n" + "-----OPZIONI " + request.getString("typeUser").toUpperCase() + " MIMOS-----" + "\n");
		} else
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
					this.request.put("roles", roles);
					this.request.put("nomeUtente", this.nick);
					this.request.put("mode", "selected");
					this.request.put("typeUser", roles.get(choice));
				} catch (Exception e) {
					System.out.println("SCELTA ERRATA");
					// e.printStackTrace();
					this.request = new Request();
					this.request.put("roles", roles);
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
					case ("1"):
						this.showParameter((ArrayList<String>) request.get("dataUser"));
						System.out.println("\n" + "Scegli dato (numero):");
						choice = Integer.parseInt(getInput());
						System.out.println("\n" + "Scrivi dato:");
						String newdata = getInput();
						this.chooseParameter(choice);
						this.request = new Request();
						this.request.put("nomeUtente", this.nick);
						this.request.put("typeUser", this.role);
						this.request.put("newData", newdata);
						this.request.put("field", choice);
						this.request.put("mode", "updateData");
						dp = new DispatcherParam("User", "doControl", this.request);
						break;
					case ("2"):
						ArrayList<String> othrole = this.showOtherRole(this.role);
						choice = Integer.parseInt(getInput());
						System.out.println("\n" + "Scrivi dato aggiuntivo (può essere vuoto):");
						String optional = getInput();
						this.chooseParameter(choice);
						this.request = new Request();
						this.request.put("nomeUtente", this.nick);
						this.request.put("typeUser", othrole.get(choice));
						this.request.put("newData", optional);
						this.request.put("field", 4);
						this.request.put("mode", "addRole");
						dp = new DispatcherParam("User", "doControl", this.request);
						break;
					case ("3"):
						this.showParameter((ArrayList<String>) request.get("dataUser"));
						this.request = new Request();
						this.request.put("nomeUtente", this.nick);
						this.request.put("typeUser", this.role);
						this.request.put("mode", "selected");
						dp = new DispatcherParam("Home", "doControl", this.request);
						break;
					case ("4"):
						dp = new DispatcherParam("Index", "doControl", null);
				}
				break;
			case ("logout"):
				break;
		}
	}

	private void showDashRole(String typeUser) {
		System.out.println("(1) Aggiorna Dati");
		System.out.println("(2) Aggiungi Ruolo - ToDo");
		System.out.println("(3) Guarda i tuoi dati");
		System.out.println("(4) Logout");
		for (Role role : Role.values()) {
			if (role.Doctor.toString().equals(typeUser)) {
				System.out.println("(5) Visualizza Misurazioni - ToDo");
				break;
			}
			if (role.Patient.toString().equals(typeUser)) {
				System.out.println("(5) Effettua Una Misurazione - ToDo");
				System.out.println("(6) Gaurda Tutte le Misurazioni - ToDo");
				break;
			}
			if (role.MAdmin.toString().equals(typeUser)) {
				System.out.println("(5) Gaurda Tutti gli User - ToDo");
				break;
			}
			if (role.Pharmacist.toString().equals(typeUser)) {
				System.out.println("(5) Gaurda Tutte le Ricette - ToDo");
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

	private ArrayList<String> showOtherRole(String actrole) {
		ArrayList<String> othRole = new ArrayList<>();
		int count = 0;
		for (Role role : Role.values()) {
			if (!actrole.equals(role.toString())) {
				System.out.println(role + " (" + count + ")");
				othRole.add(role.toString());
				count++;
			}
		}
		System.out.print("\n" + "Seleziona Ruolo (numero) : ");
		return othRole;
	}

	private void showParameter(ArrayList<String> param) {
		int count = 0;
		for (String p : param) {
			System.out.println(p + " (" + count + ")");
			count++;
		}
		System.out.print("\n" + "-----------------------------");
	}

	private String chooseParameter(int choose) {
		
		System.out.print("\n" + "-----------------------------");
		return null;
	}

	public void submit() {
		MainDispatcher.getInstance().callAction(dp.getClassN(), dp.getMethodN(), dp.getRequest());
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
