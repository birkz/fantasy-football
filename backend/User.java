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
	
	public int getScore(int round) {
		return this.score[round];
	}
	
	public void addScore(int round, int score) {
		this.score[round] += score;
	}
	
	public void changeName(String newname) {
		this.name = newname;
	}
	
	public String getName() {
		return name;
	}
}
