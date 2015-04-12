package backend;

import java.util.List;

import tests.InvalidPlayer;
import tests.PlayerInterface;

public class User {

	private int id;
	private int money;
	//private List<Integer> score;
	private int score;
	private int roundscore;
	private String name;
	private Roster roster;
	
	public User(String name, int id) throws InvalidPlayer {
		this.id = id;
		this.name = name;
		//this.score = new ArrayList<Integer>();
		this.score = 0;
		this.roster = new Roster();
		if (res.Constants.TEST_MODE && this.id==0) addRandomPlayersToRoster();
		this.money = res.Constants.STARTING_MONEY;
	}
	
	/*
	 * Money related stuff
	 */
	public int getMoney(){
		return this.money;
	}
	
	public boolean isAffordable(int price){
		return this.money > price;
	}
	
	public void changeMoney(int dMoney) throws Exception {
		if(!isAffordable(-dMoney))
			throw new Exception("Insufficient cash!");
		this.money += dMoney;
	}
	
	
	/*
	 * getRoster
	 */
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
	
	/*
	 * Name related stuff
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String newname) {
		this.name = newname;
	}
	
	/*
	 * Test function
	 */
	private void addRandomPlayersToRoster() throws InvalidPlayer {
		
		List<PlayerInterface> players = frontend.MarketPanel.getLeague().getTeams().get(0).getPlayers();
		int j = 0;
		
		for(PlayerInterface player : players){
			this.roster.addPlayerToRoster(player);
			if (j++ < 12) this.roster.addPlayerToField(player);
		}
		
	}
}
