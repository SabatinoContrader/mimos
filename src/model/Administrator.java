package model;

public class Administrator extends AUser {

	private boolean isRoot;
	
	public Administrator(String nick ,String psw ,String ln ,String sn) {
		this.addNick(nick);
		this.addPassword(psw);
		this.addName(ln, sn);
		isRoot = false;
	}
	
	public Administrator(String nick ,String psw ,String ln ,String sn, boolean isRoot) {
		this.addNick(nick);
		this.addPassword(psw);
		this.addName(ln, sn);
		this.isRoot = isRoot;
	}
	
	public void addIsRoot(Boolean isRoot) {
		this.isRoot = isRoot;
	}
	
	public boolean getIsRoot() {
		return isRoot;
		
	}
	
	@Override
	public String toString() {
	    return "Nick: " + this.getNick() 
	    		+ "\nSurnamer: " + this.getSurname() 
	    		+ "\nLastnamer: " + this.getLastname()
	    		+ "\nRoot: " + this.isRoot;
	
	}
}
