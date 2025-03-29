package model;

public class Utilisateur {
	private String pseudo;
	private int id;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Utilisateur(String username, int id,String mdp) {
		super();
		this.pseudo = username;
		this.id = id;
		this.password=mdp;
	}
	public Utilisateur() {
		
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
