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
		this.goalkeeperOnField = new ArrayList<PlayerInterface>();
		this.defenders = new ArrayList<PlayerInterface>();
		this.defendersOnField = new ArrayList<PlayerInterface>();
		this.midfielders = new ArrayList<PlayerInterface>();
		this.midfieldersOnField = new ArrayList<PlayerInterface>();
		this.strikers = new ArrayList<PlayerInterface>();
		this.strikersOnField = new ArrayList<PlayerInterface>();
	}
	
	public void removePlayerFromList(PlayerInterface player,List<PlayerInterface> list){
		for(int i = 0 ; i < list.size() ; i++){
			if(list.get(i).equals(player)){
				list.remove(i);
				return;
			}
		}
	}
	
	public void removePlayer(PlayerInterface player, boolean removeFromTeam){
		String posName = player.getPositionName();
		if (posName.equals("Goalkeeper")){
			if (removeFromTeam) removePlayerFromList(player,goalkeepers);
			removePlayerFromList(player,goalkeeperOnField);
		} else if (posName.equals("Defender")){
			if (removeFromTeam) removePlayerFromList(player,defenders);
			removePlayerFromList(player,defendersOnField);
		} else if (posName.equals("Midfielder")){
			if (removeFromTeam) removePlayerFromList(player,midfielders);
			removePlayerFromList(player,midfieldersOnField);
		} else if (posName.equals("Striker")){
			if (removeFromTeam) removePlayerFromList(player,strikers);
			removePlayerFromList(player,strikersOnField);
		}
	}
	
	public boolean addPlayerToTeam(PlayerInterface player){
		String posName = player.getPositionName();
		if (posName.equals("Goalkeeper")){
			if (goalkeepers.size() == 2) return false;
			goalkeepers.add(player);
			return true;
		} else if (posName.equals("Defender")){
			if (defenders.size() == 5) return false;
			defenders.add(player);
			return true;
		} else if (posName.equals("Midfielder")){
			if (midfielders.size() == 5) return false;
			midfielders.add(player);
			return true;
		} else if (posName.equals("Striker")){
			if (strikers.size() == 3) return false;
			strikers.add(player);
			return true;
		}
		return false;
	}
	
	public String getNamesOfPlayersInList(List<PlayerInterface> list){
		String names = "";
		for(int i = 0 ; i < list.size() ; i++){
			names += list.get(i).getName();
		}
		return names;
	}
	
	public String[] getNamesOfPlayersInRoster(){
		String[] names = new String[4];
		names[0] = getNamesOfPlayersInList(goalkeepers);
		names[1] = getNamesOfPlayersInList(defenders);
		names[2] = getNamesOfPlayersInList(midfielders);
		names[3] = getNamesOfPlayersInList(strikers);
		return names;
	}
}
