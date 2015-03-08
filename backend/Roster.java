package backend;

import java.util.ArrayList;
import java.util.List;

import tests.*;

public class Roster {
	private List<PlayerInterface> goalkeepers;
	private List<PlayerInterface> goalkeeperOnField;
	private List<PlayerInterface> defenders;
	private List<PlayerInterface> defendersOnField;
	private List<PlayerInterface> midfielders;
	private List<PlayerInterface> midfieldersOnField;
	private List<PlayerInterface> strikers;
	private List<PlayerInterface> strikersOnField;
	private PlayerInterface captain;
	private int numberOfPlayersOnField;
	
	public Roster(){
		this.numberOfPlayersOnField = 0;
		this.goalkeepers = new ArrayList<PlayerInterface>();
		this.defenders = new ArrayList<PlayerInterface>();
		this.midfielders = new ArrayList<PlayerInterface>();
		this.strikers = new ArrayList<PlayerInterface>();
	}
	
	public void removePlayerFromList(PlayerInterface player,List<PlayerInterface> list){
		for(int i = 0 ; i < list.size() ; i++){
			if(list.get(i).equals(player)){
				list.remove(i);
			}
		}
	}
	
	public void removePlayerFromTeam(PlayerInterface player){
		String posName = player.getPositionName();
		if (posName.equals("Goalkeeper")){
			removePlayerFromList(player,goalkeepers);
			removePlayerFromList(player,goalkeeperOnField);
		} else if (posName.equals("Defender")){
			removePlayerFromList(player,defenders);
			removePlayerFromList(player,defendersOnField);
		} else if (posName.equals("Midfielder")){
			removePlayerFromList(player,midfielders);
			removePlayerFromList(player,midfieldersOnField);
		} else if (posName.equals("Striker")){
			removePlayerFromList(player,strikers);
			removePlayerFromList(player,strikersOnField);
		}
	}
}
