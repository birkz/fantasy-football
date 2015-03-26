package backend;

public class User {

	private int id;
	private int money;
	private int[] score;
	private String name;
	private Roster roster;
	private final MainGame game;
	
	public User(String name, MainGame game, int id) {
		this.id = id;
		this.name = name;
		this.score = new int[10];
		this.roster = new Roster(game);
		this.money = 0;
		this.game = game;
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
