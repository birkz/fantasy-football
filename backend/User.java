package backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tests.InvalidPlayer;
import tests.InvalidPosition;
import tests.PlayerInterface;

public class User {

	private int id;
	private int money;
	private List<Integer> score;
	private String name;
	private Roster roster;
	private final Boolean TEST = true;
	
	public User(String name, int id) throws InvalidPlayer, InvalidPosition {
		this.id = id;
		this.name = name;
		this.score = new ArrayList<Integer>();
		this.roster = new Roster();
		if (this.TEST && this.id==0) addRandomPlayersToRoster();
		this.money = 2000;
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
	// After: i is an List of scores of this user
	public List<Integer> getScore() {
		return this.score;
	}
	
	public int getTotalScore(){
		int size = this.score.size();
		if(size == 0) return 0;
		return this.score.get(size-1);
	}
	
	public void addScore(int newscore) {
		this.score.add(newscore);
	}
	
	public void changeName(String newname) {
		this.name = newname;
	}
	
	public String getName() {
		return name;
	}
	
	/*
	 * Test function
	 */
	private void addRandomPlayersToRoster() throws InvalidPlayer, InvalidPosition{
		
		List<PlayerInterface> players = frontend.MarketPanel.getLeague().getTeams().get(0).getPlayers();
		Iterator<PlayerInterface> players_it = players.iterator();
		int j = 0;
		while(players_it.hasNext()){
			PlayerInterface player = players_it.next();
			this.roster.addPlayerToRoster(player);
			if (j < 12){
				this.roster.addPlayerToField(player);
				j++;
			}
		}
		
	}
}
