package is.hi.f2a.tests;

import is.hi.f1a.Player;
import is.hi.f1a.Player.Position;

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
	private List<Player> goalkeepers = new ArrayList<Player>(MAX_GOALKEEPERS);
	private List<Player> defenders = new ArrayList<Player>(MAX_DEFENDERS);
	private List<Player> midfielders = new ArrayList<Player>(MAX_MIDFIELDERS);
	private List<Player> strikers = new ArrayList<Player>(MAX_STRIKERS);
	private String name;
	
	/*
	 * Constructor
	 */
	public TeamMock(Integer i) {
		this.name = "Team "+i.toString();
		
		this.goalkeepers = new ArrayList<Player>(MAX_GOALKEEPERS);
		this.defenders = new ArrayList<Player>(MAX_DEFENDERS);
		this.midfielders = new ArrayList<Player>(MAX_MIDFIELDERS);
		this.strikers = new ArrayList<Player>(MAX_STRIKERS);
		
		// Create some i players
		this.goalkeepers.add(new Player("Goalkeeper "+i.toString(), Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.goalkeepers.add(new Player("Goalkeeper "+i.toString(), Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.goalkeepers.add(new Player("Goalkeeper "+i.toString(), Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		
		this.defenders.add(new Player("Defender "+i.toString(), Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.defenders.add(new Player("Defender "+i.toString(), Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.defenders.add(new Player("Defender "+i.toString(), Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.defenders.add(new Player("Defender "+i.toString(), Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.defenders.add(new Player("Defender "+i.toString(), Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		
		this.midfielders.add(new Player("Midfielder "+i.toString(), Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.midfielders.add(new Player("Midfielder "+i.toString(), Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.midfielders.add(new Player("Midfielder "+i.toString(), Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.midfielders.add(new Player("Midfielder "+i.toString(), Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.midfielders.add(new Player("Midfielder "+i.toString(), Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.midfielders.add(new Player("Midfielder "+i.toString(), Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		
		this.strikers.add(new Player("Forward "+i.toString(), Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.strikers.add(new Player("Forward "+i.toString(), Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.strikers.add(new Player("Forward "+i.toString(), Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.strikers.add(new Player("Forward "+i.toString(), Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
	}
	
	public TeamMock() {
		this.name = "Team Awesome";
		
		Player player1 = new Player("Svampur Sveinsson", Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Player player2 = new Player("Pétur", Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Player player3 = new Player("Sigmar", Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Player player4 = new Player("Harpa", Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Player player5 = new Player("Klemmi", Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Player player6 = new Player("Mikki Mús", Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Player player7 = new Player("Andrés Önd", Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Player player8 = new Player("Guffi", Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Player player9 = new Player("Amma Önd", Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Player player10 = new Player("Ripp", Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Player player11 = new Player("Rapp", Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Player player12 = new Player("Rupp", Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Player player13 = new Player("Jóakim Aðalönd", Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Player player14 = new Player("Hábeinn Heppni", Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
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
	public List<Player> getPlayers(){
		List<Player> player_list = new ArrayList<Player>();
		player_list.addAll(this.goalkeepers);
		player_list.addAll(this.defenders);
		player_list.addAll(this.midfielders);
		player_list.addAll(this.strikers);
		return player_list;
	}
	
	/*
	 * Returns 4 lists, each with players in the team in the 4 different positions.
	 */
	public List<List<Player>> getPlayersByPosition(){
		List<List<Player>> player_list = new ArrayList<List<Player>>(4);
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
