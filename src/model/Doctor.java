package model;

public class Doctor extends AUser {

	private Measurements mainSkill;
	
	public Doctor(String nick ,String psw ,String ln ,String sn) {
		this.addNick(nick);
		this.addPassword(psw);
		this.addName(ln, sn);
	}
	
	public Doctor(String nick ,String psw ,String ln ,String sn, Measurements mainSkill) {
		this.addNick(nick);
		this.addPassword(psw);
		this.addName(ln, sn);
		this.mainSkill = mainSkill;
	}
	
	public void addMainSkill(Measurements mainSkill) {
		this.mainSkill = mainSkill;
	}
	
	public Measurements getMainSkill() {
		return mainSkill;
		
	}
	
	@Override
	public String toString() {
	    return "Nick: " + this.getNick() 
	    		+ "\nSurnamer: " + this.getSurname() 
	    		+ "\nLastnamer: " + this.getLastname()
	    		+ "\nMain Skill: " + this.mainSkill;
	
	}
}
