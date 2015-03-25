package tests;

import java.util.ArrayList;
import java.util.List;

public class TeamMock {
	/*
	 * Constants
	 */
	private final int MAX_GOALKEEPERS = 4;
	private final int MAX_DEFENDERS = 10;
	private final int MAX_MIDFIELDERS = 10;
	private final int MAX_STRIKERS = 6;
	
	/*
	 * Instance variables
	 */
	private List<PlayerInterface> goalkeepers;
	private List<PlayerInterface> defenders;
	private List<PlayerInterface> midfielders;
	private List<PlayerInterface> strikers;
	private String name;
	
	/*
	 * Constructor
	 */
	public TeamMock(Integer i) {
		this.name = "Team "+i.toString();
		
		this.goalkeepers = new ArrayList<PlayerInterface>(MAX_GOALKEEPERS);
		this.defenders = new ArrayList<PlayerInterface>(MAX_DEFENDERS);
		this.midfielders = new ArrayList<PlayerInterface>(MAX_MIDFIELDERS);
		this.strikers = new ArrayList<PlayerInterface>(MAX_STRIKERS);
		
		// Create some i players
		this.goalkeepers.add(new PlayerMock("Goalkeeper "+i.toString(),"Goalkeeper")); i+=10;
		this.goalkeepers.add(new PlayerMock("Goalkeeper "+i.toString(),"Goalkeeper")); i+=10;
		this.goalkeepers.add(new PlayerMock("Goalkeeper "+i.toString(),"Goalkeeper")); i+=10;
		
		this.defenders.add(new PlayerMock("Defender "+i.toString(),"Defender")); i+=10;
		this.defenders.add(new PlayerMock("Defender "+i.toString(),"Defender")); i+=10;
		this.defenders.add(new PlayerMock("Defender "+i.toString(),"Defender")); i+=10;
		this.defenders.add(new PlayerMock("Defender "+i.toString(),"Defender")); i+=10;
		this.defenders.add(new PlayerMock("Defender "+i.toString(),"Defender")); i+=10;
		
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(),"Midfielder")); i+=10;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(),"Midfielder")); i+=10;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(),"Midfielder")); i+=10;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(),"Midfielder")); i+=10;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(),"Midfielder")); i+=10;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(),"Midfielder")); i+=10;
		
		this.strikers.add(new PlayerMock("Striker "+i.toString(),"Striker")); i+=10;
		this.strikers.add(new PlayerMock("Striker "+i.toString(),"Striker")); i+=10;
		this.strikers.add(new PlayerMock("Striker "+i.toString(),"Striker")); i+=10;
		this.strikers.add(new PlayerMock("Striker "+i.toString(),"Striker")); i+=10;
		
	}
	
	/*
	 * Returns a single list with all the players in the team.
	 */
	public List<PlayerInterface> getPlayers(){
		List<PlayerInterface> player_list = new ArrayList<PlayerInterface>();
		player_list.addAll(this.goalkeepers);
		player_list.addAll(this.defenders);
		player_list.addAll(this.midfielders);
		player_list.addAll(this.strikers);
		return player_list;
	}
	
	/*
	 * Returns 4 lists, each with players in the team in the 4 different positions.
	 */
	public List<List<PlayerInterface>> getPlayersByPosition(){
		List<List<PlayerInterface>> player_list = new ArrayList<List<PlayerInterface>>(4);
		player_list.add(goalkeepers);
		player_list.add(defenders);
		player_list.add(midfielders);
		player_list.add(strikers);
		return player_list;
	}
	
	/*
	 * Returns the name of the team.
	 */
	public String getName(){
		return this.name;
	}
	
}
