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
	
	/*
	 * Constructor
	 */
	public TeamMock(Integer i) {
		
		this.goalkeepers = new ArrayList<PlayerInterface>(MAX_GOALKEEPERS);
		this.defenders = new ArrayList<PlayerInterface>(MAX_DEFENDERS);
		this.midfielders = new ArrayList<PlayerInterface>(MAX_MIDFIELDERS);
		this.strikers = new ArrayList<PlayerInterface>(MAX_STRIKERS);
		
		// Create some i players
		this.goalkeepers.add(new PlayerMock("Goalkeeper "+i.toString(),"Goalkeeper")); i+=100;
		this.goalkeepers.add(new PlayerMock("Goalkeeper "+i.toString(),"Goalkeeper")); i+=100;
		this.goalkeepers.add(new PlayerMock("Goalkeeper "+i.toString(),"Goalkeeper")); i+=100;
		
		this.defenders.add(new PlayerMock("Defender "+i.toString(),"Defender")); i+=100;
		this.defenders.add(new PlayerMock("Defender "+i.toString(),"Defender")); i+=100;
		this.defenders.add(new PlayerMock("Defender "+i.toString(),"Defender")); i+=100;
		this.defenders.add(new PlayerMock("Defender "+i.toString(),"Defender")); i+=100;
		this.defenders.add(new PlayerMock("Defender "+i.toString(),"Defender")); i+=100;
		
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(),"Midfielder")); i+=100;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(),"Midfielder")); i+=100;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(),"Midfielder")); i+=100;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(),"Midfielder")); i+=100;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(),"Midfielder")); i+=100;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(),"Midfielder")); i+=100;
		
		this.strikers.add(new PlayerMock("Striker "+i.toString(),"Striker")); i+=100;
		this.strikers.add(new PlayerMock("Striker "+i.toString(),"Striker")); i+=100;
		this.strikers.add(new PlayerMock("Striker "+i.toString(),"Striker")); i+=100;
		this.strikers.add(new PlayerMock("Striker "+i.toString(),"Striker")); i+=100;
		
	}
	
}
