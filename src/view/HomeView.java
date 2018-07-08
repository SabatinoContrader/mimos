package view;

import main.DispatcherParam;
import main.MainDispatcher;
import controller.Request;
import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

	private Request request;
	private DispatcherParam dp;

	public void showResults(Request request) {
		if (request.get("mode").toString().equals("entry")) {
			System.out.println("\n" + "-----DASHBOARD MIMOS-----" + "\n");
			System.out.println("BENVENUTO " + request.getString("nomeUtente") + "\n");
			this.request = request;
		}
	}

	public void showOptions() {
		switch (request.get("mode").toString()) {
			case ("entry"):
				this.request = new Request();
				this.request.put("mode", "getrole");
				this.request.put("nick", request.get("nick"));
				dp = new DispatcherParam("User", "doControl", this.request);
				break;
			case ("select"):
				System.out.println("\n" + "Vuoi accedere come:" + "\n");
				break;
			case ("selected"):
				break;
			case ("logout"):
				break;
		}
	}

	public void submit() {
			MainDispatcher.getInstance().callAction(dp.getClassN(), dp.getMethodN(), dp.getRequest());
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
