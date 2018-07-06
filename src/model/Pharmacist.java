package model;

public class Pharmacist extends AUser {

	private int idP;
	
	public Pharmacist(String nick ,String psw ,String ln ,String sn) {
		this.addNick(nick);
		this.addPassword(psw);
		this.addName(ln, sn);
	}
	
	public Pharmacist(String nick ,String psw ,String ln ,String sn, int idPharmacy) {
		this.addNick(nick);
		this.addPassword(psw);
		this.addName(ln, sn);
		this.idP = idPharmacy;
	}
	
	public void addPharmacy(int idPharmacy) {
		this.idP = idPharmacy;
	}
	
	public int getPharmacy() {
		return idP;
		
	}
	
	@Override
	public String toString() {
	    return "Nick: " + this.getNick() 
	    		+ "\nSurnamer: " + this.getSurname() 
	    		+ "\nLastnamer: " + this.getLastname()
	    		+ "\nPharmacy: " + this.idP;
	
	}

}
