package model;

public class Item {
	private int id;
	private int prix;
	private String nom;
	public Item() {
		super();
	}
	public Item(int id, int prix, String nom) {
		super();
		this.id = id;
		this.prix = prix;
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
