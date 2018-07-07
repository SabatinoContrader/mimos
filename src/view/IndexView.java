package view;

import main.DispatcherParam;
import main.MainDispatcher;
import controller.Request;

import java.util.Scanner;

public class IndexView implements View {

	private Request request;
	private DispatcherParam dp;

	public void showResults(Request request) {
		this.request = new Request();
		System.out.println("\n" + "-----WELCOME TO MIMOS----" + "\n");
	}

	public void showOptions() {
		System.out.println("(1) LogIn");
		System.out.println("(2) SignUp" + "\n");
		System.out.print("Inserisci il numero corrispondente: ");
		String tmp = getInput();
		// mode sarà per tutti i controlli
		dp = new DispatcherParam("Index", "doControl", null);
		switch (tmp) {
			case ("1"):
				this.request.put("mode", tmp);
				dp = new DispatcherParam("Login", "doControl", null);
				break;
			case ("2"):
				this.request.put("mode", tmp);
				dp = new DispatcherParam("User", "doControl", request);
		}
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
