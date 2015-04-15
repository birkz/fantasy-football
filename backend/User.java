package is.hi.f2a.backend;

import java.util.List;

import is.hi.f1a.Player;
import is.hi.f2a.res.Constants;
import is.hi.f2a.tests.InvalidPlayer;

public class User {

	private int id;
	private int money;
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
		if (Constants.TEST_MODE && this.id==0) addRandomPlayersToRoster();
		this.money = Constants.STARTING_MONEY;
	}
	
	/*
	 * Money related stuff
	 */
	public int getMoney(){
		return this.money;
	}
	
	public boolean isAffordable(int price){
		return this.money >= price;
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
		
		List<Player> players = is.hi.f1a.FantasyFootballBackend.getInstance().getLeague().getTeams().get(0).getPlayers();
		int j = 0;
		
		for(Player player : players){
			j++;
			if(j % 2 == 0){
				if(this.roster.addPlayerToRoster(player)){
					this.roster.addPlayerToField(player);
				}
			}
		}
	}
}
