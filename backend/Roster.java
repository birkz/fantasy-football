package backend;

import java.util.ArrayList;
import java.util.List;

import tests.*;

public class Roster {
	private List<PlayerInterface> goalkeepers;
	private List<PlayerInterface> goalkeepersOnField;
	private List<PlayerInterface> defenders;
	private List<PlayerInterface> defendersOnField;
	private List<PlayerInterface> midfielders;
	private List<PlayerInterface> midfieldersOnField;
	private List<PlayerInterface> strikers;
	private List<PlayerInterface> strikersOnField;
	// private PlayerInterface captain;
	private int numberOfPlayersOnField;
	
	/*
	 * Constants
	 */
	private final int MAX_GOALKEEPERS = res.Contants.MAX_GOALKEEPERS;
	private final int MAX_GOALKEEPERS_ON_FIELD = res.Contants.MAX_GOALKEEPERS_ON_FIELD;
	
	private final int MAX_DEFENDERS = res.Contants.MAX_DEFENDERS;
	private final int MAX_DEFENDERS_ON_FIELD = res.Contants.MAX_DEFENDERS_ON_FIELD;
	
	private final int MAX_MIDFIELDERS = res.Contants.MAX_MIDFIELDERS;
	private final int MAX_MIDFIELDERS_ON_FIELD = res.Contants.MAX_MIDFIELDERS_ON_FIELD;
	
	private final int MAX_STRIKERS = res.Contants.MAX_STRIKERS;
	private final int MAX_STRIKERS_ON_FIELD = res.Contants.MAX_STRIKERS_ON_FIELD;
	
	public Roster(){
		this.numberOfPlayersOnField = 0;
		this.goalkeepers = new ArrayList<PlayerInterface>(2);
		this.goalkeepersOnField = new ArrayList<PlayerInterface>(1);
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
			goalkeepersOnField.remove(player);
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
			if (this.goalkeepers.size() == MAX_GOALKEEPERS) return false;
			this.goalkeepers.add(player);
			return true;
			
		} else if (posName.toLowerCase().equals("defender")){
			if (this.defenders.size() == MAX_DEFENDERS) return false;
			this.defenders.add(player);
			return true;
			
		} else if (posName.toLowerCase().equals("midfielder")){
			if (midfielders.size() == MAX_MIDFIELDERS) return false;
			this.midfielders.add(player);
			return true;
			
		} else if (posName.toLowerCase().equals("striker")){
			if (strikers.size() == MAX_STRIKERS) return false;
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
			if (this.goalkeepersOnField.size() >= MAX_GOALKEEPERS_ON_FIELD || this.goalkeepersOnField.contains(player)
					|| this.numberOfPlayersOnField >= 11){
				return false;
			}
			this.goalkeepersOnField.add(player);
			this.numberOfPlayersOnField++;
			return true;
			
		} else if (this.defenders.contains(player)){
			if (this.defendersOnField.size() >= MAX_DEFENDERS_ON_FIELD || this.defendersOnField.contains(player)
					|| this.numberOfPlayersOnField >= 11){
				return false;
			}
			this.defendersOnField.add(player);
			this.numberOfPlayersOnField++;
			return true;
			
		} else if (this.midfielders.contains(player)){
			if (this.midfieldersOnField.size() >= MAX_MIDFIELDERS_ON_FIELD || this.midfieldersOnField.contains(player) || this.numberOfPlayersOnField >= 11){
				return false;
			}
			this.midfieldersOnField.add(player);
			this.numberOfPlayersOnField++;
			return true;
			
		} else if (this.strikers.contains(player)){
			if (this.strikersOnField.size() >= MAX_STRIKERS_ON_FIELD || this.strikersOnField.contains(player) || this.numberOfPlayersOnField >= 11){
				return false;
			}
			this.strikersOnField.add(player);
			this.numberOfPlayersOnField++;
			return true;
			
		}
		throw new tests.InvalidPlayer(player.getName()+" is currently not in the roster.");
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
		names.add(goalkeepersOnField);
		names.add(defendersOnField);
		names.add(midfieldersOnField);
		names.add(strikersOnField);
		return names;
	}
	
	/*
	 * Is this player in roster?
	 */
	public boolean isInRoster(PlayerInterface player) throws InvalidPlayer{
		String pos = player.getPositionName();
		
		if (pos.toLowerCase().equals("goalkeeper")){
			return goalkeepers.contains(player);
		} else if (pos.toLowerCase().equals("defender")){
			return defenders.contains(player);
		} else if (pos.toLowerCase().equals("midfielder")){
			return midfielders.contains(player);
		} else if (pos.toLowerCase().equals("striker")){
			return strikers.contains(player);
		}
		throw new tests.InvalidPlayer(pos+" is a invalid position for a player.");
	}
	
	/*
	 * Is this player on the field?
	 */
	public boolean isOnField(PlayerInterface player) throws InvalidPlayer{
		String pos = player.getPositionName();
		
		if (pos.toLowerCase().equals("goalkeeper")){
			return goalkeepersOnField.contains(player);
		} else if (pos.toLowerCase().equals("defender")){
			return defendersOnField.contains(player);
		} else if (pos.toLowerCase().equals("midfielder")){
			return midfieldersOnField.contains(player);
		} else if (pos.toLowerCase().equals("striker")){
			return strikersOnField.contains(player);
		}
		throw new tests.InvalidPlayer(pos+" is a invalid position for a player.");
	}
}
