package backend;

import tests.InvalidPlayer;
import tests.InvalidPosition;
import tests.PlayerInterface;
import tests.PlayerMock;

public class User {

	private int id;
	private int money;
	private int[] score;
	private String name;
	private Roster roster;
	private final Boolean TEST = true;
	
	public User(String name, MainGame game, int id) throws InvalidPlayer, InvalidPosition {
		this.id = id;
		this.name = name;
		this.score = new int[10];
		this.roster = new Roster(game);
		if (this.TEST && this.id==0) addRandomPlayersToRoster();
		this.money = 10000;
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
	// After: i is an array of scores of this user
	public int[] getScore() {
		return this.score;
	}
	
	public int getTotalScore(){
		int sum = 0;
		for(int i = 0 ; i<10 ; i++){
			sum += score[i];
		}
		return sum;
	}
	
	public void addScore(int round, int score) {
		this.score[round] += score;
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
		PlayerInterface player1 = new PlayerMock("Svampur Sveinsson", "Goalkeeper");
		PlayerInterface player2 = new PlayerMock("Pétur", "Goalkeeper");
		PlayerInterface player3 = new PlayerMock("Sigmar", "Defender");
		PlayerInterface player4 = new PlayerMock("Harpa", "Midfielder");
		PlayerInterface player5 = new PlayerMock("Klemmi", "Midfielder");
		PlayerInterface player6 = new PlayerMock("Mikki Mús", "Striker");
		PlayerInterface player7 = new PlayerMock("Andrés Önd", "Striker");
		PlayerInterface player8 = new PlayerMock("Guffi", "Striker");
		PlayerInterface player9 = new PlayerMock("Amma Önd", "Midfielder");
		PlayerInterface player10 = new PlayerMock("Ripp", "Midfielder");
		PlayerInterface player11 = new PlayerMock("Rapp", "Midfielder");
		PlayerInterface player12 = new PlayerMock("Rupp", "Defender");
		PlayerInterface player13 = new PlayerMock("Jóakim Aðalönd", "Defender");
		PlayerInterface player14 = new PlayerMock("Hábeinn Heppni", "Defender");
		
		this.roster.addPlayerToRoster(player1);
		this.roster.addPlayerToRoster(player2);
		this.roster.addPlayerToRoster(player3);
		this.roster.addPlayerToRoster(player4);
		this.roster.addPlayerToRoster(player5);
		this.roster.addPlayerToRoster(player6);
		this.roster.addPlayerToRoster(player7);
		this.roster.addPlayerToRoster(player8);
		this.roster.addPlayerToRoster(player9);
		this.roster.addPlayerToRoster(player10);
		this.roster.addPlayerToRoster(player11);
		this.roster.addPlayerToRoster(player12);
		this.roster.addPlayerToRoster(player13);
		this.roster.addPlayerToRoster(player14);
		
		this.roster.addPlayerToField(player1);
		this.roster.addPlayerToField(player3);
		this.roster.addPlayerToField(player4);
		this.roster.addPlayerToField(player5);
		this.roster.addPlayerToField(player6);
		this.roster.addPlayerToField(player7);
		this.roster.addPlayerToField(player8);
		this.roster.addPlayerToField(player9);
		this.roster.addPlayerToField(player10);
		this.roster.addPlayerToField(player11);
	}
}
