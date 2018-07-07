package view;

import main.DispatcherParam;
import main.MainDispatcher;
import controller.Request;

import java.util.Scanner;

public class LoginView implements View {

	private String nomeUtente;
	private String password;
	private Request request;
	private DispatcherParam dp;

	public void showResults(Request request) {
		System.out.println( "\n" + "-----LOGIN----" + "\n");
		if (request != null) {
			boolean result = (boolean) request.get("result");
			if (!result) {
				System.out.println("NON ESISTE L'UTENTE" + "\n");
			}
		}
		this.request = new Request();
	}

	public void showOptions() {
		System.out.println("Nome utente:");
		nomeUtente = getInput();
		System.out.println("Password:");
		password = getInput();
		this.request.put("login", "log");
		this.request.put("nomeUtente", nomeUtente);
		this.request.put("password", password);
		dp = new DispatcherParam("Login", "doControl", request);
	}

	public void submit() {
		MainDispatcher.getInstance().callAction(dp.getClassN(), dp.getMethodN(), dp.getRequest());
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	protected void send() {
	}

}
