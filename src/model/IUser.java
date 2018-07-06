package model;

public interface IUser {

	public void addNick(String nick);
	public String getNick();
	public void addPassword(String password);
	public String getPassword();
	public void addName(String lastname, String surname);
	public String getSurname();
	public String getLastname();
	
}
