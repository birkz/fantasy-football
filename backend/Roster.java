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
	private int numberOfPlayersOnField;
	public Roster(MainGame game){
		this.numberOfPlayersOnField = 0;
		this.goalkeepers = new ArrayList<PlayerInterface>(2);
		this.goalkeeperOnField = new ArrayList<PlayerInterface>(1);
		this.defenders = new ArrayList<PlayerInterface>(5);
		this.defendersOnField = new ArrayList<PlayerInterface>(5);
		this.midfielders = new ArrayList<PlayerInterface>(5);
		this.midfieldersOnField = new ArrayList<PlayerInterface>(5);
		this.strikers = new ArrayList<PlayerInterface>(3);
		this.strikersOnField = new ArrayList<PlayerInterface>(3);
	}
	
	// Usage: i = getNumberOfPlayersOnField()
	// Before:Nothing.
	// After: i is the number of players currently on the field.
	public int getNumberOfPlayersOnField(){
		return this.numberOfPlayersOnField;
	}
	
	// Usage: removePlayerFromField(player)
	// Before: player is of type PlayerInterface
	// After: player has been taken of the field
	public void removePlayerFromField(PlayerInterface player) throws InvalidPlayer{
		removePlayer(player, false);
	}
	
	// Usage: removePlayerFromRoster(player)
	// Before: player is of type PlayerInterface
	// After: player has been removed from the roster
	public void removePlayerFromRoster(PlayerInterface player) throws InvalidPlayer{
		removePlayer(player, true);
	}
	
	// Usage: removePlayer(player,b)
	// Before:player is of type PlayerInterface and b is a boolean variable (true or false)
	// After: If b is true then player will be removed both from the field and the roster. If
	//        b is false then the player will only be removed from the field. If the player
	//        provided is not in the roster then a InvalidPlayer exception will be thrown.
	private void removePlayer(PlayerInterface player, boolean removeFromRoster) throws InvalidPlayer{
		String posName = player.getPositionName();
		if (posName.toLowerCase().equals("goalkeeper")){
			if (removeFromRoster){
				boolean b = goalkeepers.remove(player);
				if (!b) throw new tests.InvalidPlayer("The player "+player.getName()+" isn't in this roster");
			}
			goalkeeperOnField.remove(player);
			numberOfPlayersOnField--;
		} else if (posName.toLowerCase().equals("defender")){
			if (removeFromRoster){
				boolean b = defenders.remove(player);
				if (!b) throw new tests.InvalidPlayer("The player "+player.getName()+" isn't in this roster");
			}
			defendersOnField.remove(player);
			numberOfPlayersOnField--;
		} else if (posName.toLowerCase().equals("midfielder")){
			if (removeFromRoster){
				boolean b = midfielders.remove(player);
				if (!b) throw new tests.InvalidPlayer("The player "+player.getName()+" isn't in this roster");
			}
			midfieldersOnField.remove(player);
			numberOfPlayersOnField--;
		} else if (posName.toLowerCase().equals("striker")){
			if (removeFromRoster){
				boolean b = strikers.remove(player);
				if (!b) throw new tests.InvalidPlayer("The player "+player.getName()+" isn't in this roster");
			}
			strikersOnField.remove(player);
			numberOfPlayersOnField--;
		}
	}
	
	// Usage: b = addPlayerToRoster(player)
	// Before:player is of type PlayerInferface and is not null
	// After: If there is room for the player in roster in the position that he plays then he's
	//        added to the roster and b is returned as true. If there is no room him in his
	//        position then b is returned as false. If the player's position is not "Goalkeeper",
	//        "Defender", "Midfielder", or "Striker" then InvalidPosition exception is thrown.
	public boolean addPlayerToRoster(PlayerInterface player) throws InvalidPosition{
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
	//        if the player's position and roster on field are not full, the player will be added to the field
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
			throw new tests.InvalidPlayer(player.getName()+" is currently not in the roster.");
		}
	}
	
	// Usage: getPlayersInRoster()
	// Before:Nothing
	// After: List containing a list of all players in the current roster. There will always be 4 inner
	//        lists, the first for goalkeepers, second for defenders, third for midfielders, and the
	//        4th for strikers.
	public List<List<PlayerInterface>> getPlayersInRoster(){
		List<List<PlayerInterface>> names = new ArrayList<List<PlayerInterface>>(4);
		names.add(goalkeepers);
		names.add(defenders);
		names.add(midfielders);
		names.add(strikers);
		return names;
	}
	
	/*
	 * Get on players on the field
	 */
	public List<List<PlayerInterface>> getPlayersOnField(){
		List<List<PlayerInterface>> names = new ArrayList<List<PlayerInterface>>(4);
		names.add(goalkeeperOnField);
		names.add(defendersOnField);
		names.add(midfieldersOnField);
		names.add(strikersOnField);
		return names;
	}
}
