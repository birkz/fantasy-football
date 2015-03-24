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
		this.money = 0;
	}
	
	public boolean changeMoney(int dMoney) {
		if(this.money + dMoney <0) return false;
		this.money += dMoney;
		return true;
	}
	
	public int getMoney(){
		return this.money;
	}
	
	public Roster getRoster() {
		return this.roster;
	}

	// Usage: i = getScore()
	// Before:Nothing.
	// After: i is an array of scores of this user
	public int[] getScore() {
		return this.score;
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
