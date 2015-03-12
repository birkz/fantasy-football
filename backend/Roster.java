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
	// private PlayerInterface captain;
	private int numberOfPlayersOnField = 0;
	
	public Roster(){
//		this.numberOfPlayersOnTeam = 0;
//		this.numberOfPlayersOnField = 0;
		this.goalkeepers = new ArrayList<PlayerInterface>(2);
		this.goalkeeperOnField = new ArrayList<PlayerInterface>(1);
		this.defenders = new ArrayList<PlayerInterface>(5);
		this.defendersOnField = new ArrayList<PlayerInterface>(5);
		this.midfielders = new ArrayList<PlayerInterface>(5);
		this.midfieldersOnField = new ArrayList<PlayerInterface>(5);
		this.strikers = new ArrayList<PlayerInterface>(3);
		this.strikersOnField = new ArrayList<PlayerInterface>(3);
	}
	
	public int getNumberOfPlayersOnField(){
		return this.numberOfPlayersOnField;
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
		if (posName.toLowerCase().equals("goalkeeper")){
			if (removeFromTeam) removePlayerFromList(player,goalkeepers);
			removePlayerFromList(player,goalkeeperOnField);
		} else if (posName.toLowerCase().equals("defender")){
			if (removeFromTeam) removePlayerFromList(player,defenders);
			removePlayerFromList(player,defendersOnField);
		} else if (posName.toLowerCase().equals("midfielder")){
			if (removeFromTeam) removePlayerFromList(player,midfielders);
			removePlayerFromList(player,midfieldersOnField);
		} else if (posName.toLowerCase().equals("striker")){
			if (removeFromTeam) removePlayerFromList(player,strikers);
			removePlayerFromList(player,strikersOnField);
		}
	}
	
	// Usage: b = addPlayerToTeam(player)
	// Before:player is of type PlayerInferface and is not null
	// After: If there is room for the player in team in the position that he plays then he's
	//        added to the team and b is returned as true. If there is no room him in his
	//        position then b is returned as false. If the player's position is not "Goalkeeper",
	//        "Defender", "Midfielder", or "Striker" then InvalidPosition exception is thrown.
	public boolean addPlayerToTeam(PlayerInterface player) throws InvalidPosition{
		String posName = player.getPositionName();
		if (posName.toLowerCase().equals("goalkeeper")){
			if (this.goalkeepers.size() == 2) return false;
			this.goalkeepers.add(player);
			return true;
		} else if (posName.toLowerCase().equals("defender")){
			if (this.defenders.size() == 5) return false;
			this.defenders.add(player);
			return true;
		} else if (posName.toLowerCase().equals("midfielder")){
			if (midfielders.size() == 5) return false;
			this.midfielders.add(player);
			return true;
		} else if (posName.toLowerCase().equals("striker")){
			if (strikers.size() == 3) return false;
			this.strikers.add(player);
			return true;
		} else {
			throw new InvalidPosition(posName+" is not a valid position. Only Goalkeeper, Defender, Midfielder, and Striker are valid.");
		}
	}
	
	// Usage: b = addPlayerToField(player)
	// Before:player is of type PlayerInterface
	// After: If the player isn't in the roster then an InvalidPlayer exception is thrown. Otherwise, and
	//        if the player's position and team on field are not full, the player will be added to the field
	//        and b will be returned as true. Otherwise b will be returned as false.
	public boolean addPlayerToField(PlayerInterface player) throws InvalidPlayer{
		if (this.goalkeepers.contains(player)){
			if (this.goalkeeperOnField.size() >= 1 || this.numberOfPlayersOnField >= 11){
				return false;
			}
			this.goalkeeperOnField.add(player);
			this.numberOfPlayersOnField++;
			return true;
		} else if (this.defenders.contains(player)){
			if (this.defendersOnField.contains(player) || this.numberOfPlayersOnField >= 11){
				return false;
			}
			this.defendersOnField.add(player);
			this.numberOfPlayersOnField++;
			return true;
		} else if (this.midfielders.contains(player)){
			if (this.midfieldersOnField.contains(player) || this.numberOfPlayersOnField >= 11){
				return false;
			}
			this.midfieldersOnField.add(player);
			this.numberOfPlayersOnField++;
			return true;
		} else if (this.strikers.contains(player)){
			if (this.strikersOnField.contains(player) || this.numberOfPlayersOnField >= 11){
				return false;
			}
			this.strikersOnField.add(player);
			this.numberOfPlayersOnField++;
			return true;
		} else {
			throw new tests.InvalidPlayer(player.getName()+" is currently not in the team.");
		}
	}
	
	public List<List<PlayerInterface>> getPlayersInRoster(){
		List<List<PlayerInterface>> names = new ArrayList<List<PlayerInterface>>(4);
		names.add(goalkeepers);
		names.add(defenders);
		names.add(midfielders);
		names.add(strikers);
		return names;
	}
}
