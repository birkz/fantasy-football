package is.hi.f2a.backend;

<<<<<<< HEAD
import java.util.List;

import is.hi.f1a.Player;
import is.hi.f2a.tests.InvalidPlayer;

=======
>>>>>>> parent of 74cfc3e... push to pull
public class User {

	private int money;
	private int[] score;
	private String name;
	private Roster roster;
	
	public User(String name) {
		this.name = name;
		this.score = new int[10];
		this.roster = new Roster();
<<<<<<< HEAD
		if (is.hi.f2a.res.Constants.TEST_MODE && this.id==0) addRandomPlayersToRoster();
		this.money = is.hi.f2a.res.Constants.STARTING_MONEY;
	}
	
	/*
	 * Money related stuff
	 */
	public int getMoney(){
		return this.money;
=======
		this.money = 0;
>>>>>>> parent of 74cfc3e... push to pull
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
	
<<<<<<< HEAD
	/*
	 * Test function
	 */
	private void addRandomPlayersToRoster() throws InvalidPlayer {
		
		List<Player> players = is.hi.f1a.FantasyFootballBackend.getInstance().getLeague().getTeams().get(0).getPlayers();
		int j = 0;
		
		for(Player player : players){
			this.roster.addPlayerToRoster(player);
			if (j++ < 12) this.roster.addPlayerToField(player);
		}
		
=======
	public String getName() {
		return name;
>>>>>>> parent of 74cfc3e... push to pull
	}
}
