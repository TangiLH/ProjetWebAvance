package model;

public class Partie {
	private int id;
	private String date;
	public Partie(int id, String date) {
		super();
		this.id = id;
		this.date = date;
	}
	public Partie() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
