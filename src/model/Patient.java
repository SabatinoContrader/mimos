package model;

public class Patient extends AUser {

	private String healthAC;
	
	public Patient(String nick ,String psw ,String ln ,String sn) {
		this.addNick(nick);
		this.addPassword(psw);
		this.addName(ln, sn);
	}
	
	public Patient(String nick ,String psw ,String ln ,String sn, String healthAC) {
		this.addNick(nick);
		this.addPassword(psw);
		this.addName(ln, sn);
		this.healthAC = healthAC;
	}

	public void addHealthAC(String healthAC) {
		this.healthAC = healthAC;
	}

	public String getHealthAC() {
		return healthAC;
		
	}

    @Override
    public String toString() {
        return "Nick: " + this.getNick() 
        		+ "\nSurnamer: " + this.getSurname() 
        		+ "\nLastnamer: " + this.getLastname()
        		+ "\nHealth Card: " + this.healthAC;

    }
}
