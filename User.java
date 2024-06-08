package model;

public class User {

	protected String login ;
	protected String mp;
	
	public User(String login, String mp) {
		super();
		this.login = login;
		this.mp = mp;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMp() {
		return mp;
	}

	public void setMp(String mp) {
		this.mp = mp;
	}
	
	
}
