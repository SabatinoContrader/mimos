package model;

public abstract class AUser implements IUser {

	private String nick,psw,ln,sn;
	private int id;
	
	public AUser() {
		id = 0;
	}

	@Override
	public void addNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String getNick() {
		// TODO Auto-generated method stub
		return nick;
	}

	@Override
	public void addPassword(String password) {
		this.psw = password;

	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return psw;
	}

	@Override
	public void addName(String lastname, String surname) {
		ln = lastname;
		sn = surname;

	}

	@Override
	public String getSurname() {
		// TODO Auto-generated method stub
		return sn;
	}

	@Override
	public String getLastname() {
		// TODO Auto-generated method stub
		return ln;
	}

	public int getId() {

		return id;
	}

	public int compareTo(AUser user) {
		if (user.id == 0) return -1;
		
		return (user.id == this.id) ? -1 : 0;
	}

	public int compareTo(Patient user) {
		if (user.getId() == 0) return -1;
		
		return (user.getId() == this.id) ? -1 : 0;
	}

	public int compareTo(Doctor user) {
		if (user.getId() == 0) return -1;
		
		return (user.getId() == this.id) ? -1 : 0;
	}

	public int compareTo(Pharmacist user) {
		if (user.getId() == 0) return -1;
		
		return (user.getId() == this.id) ? -1 : 0;
	}

	public int compareTo(Administrator user) {
		if (user.getId() == 0) return -1;
		
		return (user.getId() == this.id) ? -1 : 0;
	}

	public int compareTo(BaseUser user) {
		if (user.getId() == 0) return -1;
		
		return (user.getId() == this.id) ? -1 : 0;
	}

}
