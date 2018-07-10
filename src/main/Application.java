package main;

public class Application {

    public static void main(String[] args) {
        MainDispatcher.getInstance().callAction("Inizio", "doControl", null);
    }

}
