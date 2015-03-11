package backend;

public class User {

	private int money;
	private int[] score;
	private String name;
	private Roster roster;
	
	public User(String name) {
		this.name = name;
		this.score = new int[10];
		this.roster = new Roster();
	}
	
	public boolean changeMoney(int dMoney) {
		return false;
	}
	
	public Roster getRoster() {
		return this.roster;
	}
	
	public void addScoreToStats() {
		
	}
	
	public void addScore(int i, int score) {
		this.score[i] += score;
	}
	
	public void changeName(String newname) {
		this.name = newname;
	}
	
	public String getName() {
		return name;
	}
}
