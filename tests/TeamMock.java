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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	private List<Player> goalkeepers = new ArrayList<Player>(MAX_GOALKEEPERS);
	private List<Player> defenders = new ArrayList<Player>(MAX_DEFENDERS);
	private List<Player> midfielders = new ArrayList<Player>(MAX_MIDFIELDERS);
	private List<Player> strikers = new ArrayList<Player>(MAX_STRIKERS);
=======
	private List<PlayerInterface> goalkeepers;
	private List<PlayerInterface> defenders;
	private List<PlayerInterface> midfielders;
	private List<PlayerInterface> strikers;
>>>>>>> parent of 74cfc3e... push to pull
=======
=======
>>>>>>> parent of 64162c5... more changes for the integration
	private List<PlayerInterface> goalkeepers = new ArrayList<PlayerInterface>(MAX_GOALKEEPERS);
	private List<PlayerInterface> defenders = new ArrayList<PlayerInterface>(MAX_DEFENDERS);
	private List<PlayerInterface> midfielders = new ArrayList<PlayerInterface>(MAX_MIDFIELDERS);
	private List<PlayerInterface> strikers = new ArrayList<PlayerInterface>(MAX_STRIKERS);
<<<<<<< HEAD
>>>>>>> parent of 64162c5... more changes for the integration
=======
>>>>>>> parent of 64162c5... more changes for the integration
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		this.goalkeepers.add(new Player("Goalkeeper "+i.toString(), Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.goalkeepers.add(new Player("Goalkeeper "+i.toString(), Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
		this.goalkeepers.add(new Player("Goalkeeper "+i.toString(), Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)); i+=10;
=======
=======
>>>>>>> parent of 64162c5... more changes for the integration
		this.goalkeepers.add(new PlayerMock("Goalkeeper "+i.toString(), Position.GOALKEEPER)); i+=10;
		this.goalkeepers.add(new PlayerMock("Goalkeeper "+i.toString(), Position.GOALKEEPER)); i+=10;
		this.goalkeepers.add(new PlayerMock("Goalkeeper "+i.toString(), Position.GOALKEEPER)); i+=10;
		
		this.defenders.add(new PlayerMock("Defender "+i.toString(), Position.DEFENDER)); i+=10;
		this.defenders.add(new PlayerMock("Defender "+i.toString(), Position.DEFENDER)); i+=10;
		this.defenders.add(new PlayerMock("Defender "+i.toString(), Position.DEFENDER)); i+=10;
		this.defenders.add(new PlayerMock("Defender "+i.toString(), Position.DEFENDER)); i+=10;
		this.defenders.add(new PlayerMock("Defender "+i.toString(), Position.DEFENDER)); i+=10;
<<<<<<< HEAD
>>>>>>> parent of 64162c5... more changes for the integration
=======
>>>>>>> parent of 64162c5... more changes for the integration
		
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
		
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
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
>>>>>>> parent of 74cfc3e... push to pull
=======
=======
>>>>>>> parent of 64162c5... more changes for the integration
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
<<<<<<< HEAD
>>>>>>> parent of 64162c5... more changes for the integration
=======
>>>>>>> parent of 64162c5... more changes for the integration
		
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
