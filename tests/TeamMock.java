package tests;

import java.util.ArrayList;
import java.util.List;

import tests.PlayerInterface.Position;

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
	private List<PlayerInterface> goalkeepers = new ArrayList<PlayerInterface>(MAX_GOALKEEPERS);
	private List<PlayerInterface> defenders = new ArrayList<PlayerInterface>(MAX_DEFENDERS);
	private List<PlayerInterface> midfielders = new ArrayList<PlayerInterface>(MAX_MIDFIELDERS);
	private List<PlayerInterface> strikers = new ArrayList<PlayerInterface>(MAX_STRIKERS);
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
		this.goalkeepers.add(new PlayerMock("Goalkeeper "+i.toString(), Position.GOALKEEPER)); i+=10;
		this.goalkeepers.add(new PlayerMock("Goalkeeper "+i.toString(), Position.GOALKEEPER)); i+=10;
		this.goalkeepers.add(new PlayerMock("Goalkeeper "+i.toString(), Position.GOALKEEPER)); i+=10;
		
		this.defenders.add(new PlayerMock("Defender "+i.toString(), Position.DEFENDER)); i+=10;
		this.defenders.add(new PlayerMock("Defender "+i.toString(), Position.DEFENDER)); i+=10;
		this.defenders.add(new PlayerMock("Defender "+i.toString(), Position.DEFENDER)); i+=10;
		this.defenders.add(new PlayerMock("Defender "+i.toString(), Position.DEFENDER)); i+=10;
		this.defenders.add(new PlayerMock("Defender "+i.toString(), Position.DEFENDER)); i+=10;
		
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(), Position.MIDFIELDER)); i+=10;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(), Position.MIDFIELDER)); i+=10;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(), Position.MIDFIELDER)); i+=10;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(), Position.MIDFIELDER)); i+=10;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(), Position.MIDFIELDER)); i+=10;
		this.midfielders.add(new PlayerMock("Midfielder "+i.toString(), Position.MIDFIELDER)); i+=10;
		
		this.strikers.add(new PlayerMock("Forward "+i.toString(), Position.FORWARD)); i+=10;
		this.strikers.add(new PlayerMock("Forward "+i.toString(), Position.FORWARD)); i+=10;
		this.strikers.add(new PlayerMock("Forward "+i.toString(), Position.FORWARD)); i+=10;
		this.strikers.add(new PlayerMock("Forward "+i.toString(), Position.FORWARD)); i+=10;
		
	}
	
	public TeamMock() {
		this.name = "Team Awesome";
		
		PlayerInterface player1 = new PlayerMock("Svampur Sveinsson", Position.GOALKEEPER);
		PlayerInterface player2 = new PlayerMock("Pétur", Position.GOALKEEPER);
		PlayerInterface player3 = new PlayerMock("Sigmar", Position.DEFENDER);
		PlayerInterface player4 = new PlayerMock("Harpa", Position.MIDFIELDER);
		PlayerInterface player5 = new PlayerMock("Klemmi", Position.MIDFIELDER);
		PlayerInterface player6 = new PlayerMock("Mikki Mús", Position.FORWARD);
		PlayerInterface player7 = new PlayerMock("Andrés Önd", Position.FORWARD);
		PlayerInterface player8 = new PlayerMock("Guffi", Position.FORWARD);
		PlayerInterface player9 = new PlayerMock("Amma Önd", Position.MIDFIELDER);
		PlayerInterface player10 = new PlayerMock("Ripp", Position.MIDFIELDER);
		PlayerInterface player11 = new PlayerMock("Rapp", Position.MIDFIELDER);
		PlayerInterface player12 = new PlayerMock("Rupp", Position.DEFENDER);
		PlayerInterface player13 = new PlayerMock("Jóakim Aðalönd", Position.DEFENDER);
		PlayerInterface player14 = new PlayerMock("Hábeinn Heppni", Position.DEFENDER);
		
		this.goalkeepers.add(player1);
		this.goalkeepers.add(player2);
		this.defenders.add(player3);
		this.midfielders.add(player4);
		this.midfielders.add(player5);
		this.strikers.add(player6);
		this.strikers.add(player7);
		this.strikers.add(player8);
		this.midfielders.add(player9);
		this.midfielders.add(player10);
		this.midfielders.add(player11);
		this.defenders.add(player12);
		this.defenders.add(player13);
		this.defenders.add(player14);
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
