package model;

public class Utilisateur {
	private String username;
	private int id;
	private String motdepasse;
	
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	public Utilisateur(String username, int id,String mdp) {
		super();
		this.username = username;
		this.id = id;
		this.motdepasse=mdp;
	}
	public Utilisateur() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
