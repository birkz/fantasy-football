package backend;

import tests.*;

public class Roster {
	private PlayerInterface[] goalkeepers;
	private PlayerInterface goalkeeperOnField;
	private PlayerInterface[] defenders;
	private PlayerInterface[] defendersOnField;
	private PlayerInterface[] midfielders;
	private PlayerInterface[] midfieldersOnField;
	private PlayerInterface[] strikers;
	private PlayerInterface[] strikersOnField;
	private PlayerInterface captain;
	private int numberOfPlayersOnField;
	
	public Roster(){
		this.numberOfPlayersOnField = 0;
		this.goalkeepers = new PlayerMock[2];
		this.defenders = new PlayerMock[5];
		this.midfielders = new PlayerMock[5];
		this.strikers = new PlayerMock[3];
	}
	
	public void removePlayerFromTeam(PlayerInterface player){
		String posName = player.getPositionName();
		if (posName.equals("Goalkeeper")){
			for(int i = 0 ; i < goalkeepers.length ; i++){
				if(goalkeepers[i] == player){
					System.out.println("Jebb");
					goalkeepers[i] = null;
				}
			}
		} else if (posName.equals("Defender")){
			
		} else if (posName.equals("Midfielder")){
			
		} else if (posName.equals("Striker")){
			
		}
	}
	
}
