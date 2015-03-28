package backend;

//import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tests.InvalidPlayer;
import tests.InvalidPosition;
import tests.PlayerInterface;

public class User {

	private int id;
	private int money;
	//private List<Integer> score;
	private int score;
	private int roundscore;
	private String name;
	private Roster roster;
	
	public User(String name, int id) throws InvalidPlayer, InvalidPosition {
		this.id = id;
		this.name = name;
		//this.score = new ArrayList<Integer>();
		this.score = 0;
		this.roster = new Roster();
		if (res.Constants.TEST_MODE && this.id==0) addRandomPlayersToRoster();
		this.money = res.Constants.STARTING_MONEY;
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
	
	public int getRoundScore() {
		return this.roundscore;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int newscore) {
		this.roundscore = newscore;
		this.score += newscore;
		//this.score.add(newscore);
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
