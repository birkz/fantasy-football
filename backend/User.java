package backend;

import java.util.ArrayList;
import java.util.List;

import tests.InvalidPlayer;
import tests.PlayerInterface;

public class User {

	private int id;
	private int money;
	private List<Integer> score;
	private String name;
	private Roster roster;
	
	public User(String name, int id) throws InvalidPlayer {
		this.id = id;
		this.name = name;
		this.score = new ArrayList<Integer>();
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
		if(!isAffordable(dMoney))
			throw new Exception("Insufficient cash!");
		this.money += dMoney;
	}
	
	
	/*
	 * getRoster
	 */
	public Roster getRoster() {
		return this.roster;
	}

	/*
	 * Score related stuff
	 */
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
