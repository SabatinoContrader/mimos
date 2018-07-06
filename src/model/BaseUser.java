package model;

public class BaseUser extends AUser {

	public BaseUser(String nick ,String psw ,String ln ,String sn) {
		this.addName(ln, sn);
		this.addNick(nick);
		this.addPassword(psw);
	}

}
