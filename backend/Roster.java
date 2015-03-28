package backend;

import java.util.ArrayList;
import java.util.List;

import tests.*;
import tests.PlayerInterface.Position;

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
	private final int MAX_GOALKEEPERS = res.Constants.MAX_GOALKEEPERS;
	private final int MAX_GOALKEEPERS_ON_FIELD = res.Constants.MAX_GOALKEEPERS_ON_FIELD;
	
	private final int MAX_DEFENDERS = res.Constants.MAX_DEFENDERS;
	private final int MAX_DEFENDERS_ON_FIELD = res.Constants.MAX_DEFENDERS_ON_FIELD;
	
	private final int MAX_MIDFIELDERS = res.Constants.MAX_MIDFIELDERS;
	private final int MAX_MIDFIELDERS_ON_FIELD = res.Constants.MAX_MIDFIELDERS_ON_FIELD;
	
	private final int MAX_STRIKERS = res.Constants.MAX_STRIKERS;
	private final int MAX_STRIKERS_ON_FIELD = res.Constants.MAX_STRIKERS_ON_FIELD;
	
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
	public boolean removePlayerFromField(PlayerInterface player) throws InvalidPlayer{
		return removePlayer(player, false);
	}
	
	// Usage: removePlayerFromRoster(player)
	// Before: player is of type PlayerInterface
	// After: player has been removed from the roster
	public boolean removePlayerFromRoster(PlayerInterface player) throws InvalidPlayer{
		return removePlayer(player, true);
	}
	
	// Usage: removePlayer(player,b)
	// Before:player is of type PlayerInterface and b is a boolean variable (true or false)
	// After: If b is true then player will be removed both from the field and the roster. If
	//        b is false then the player will only be removed from the field. If the player
	//        provided is not in the roster then a InvalidPlayer exception will be thrown.
	private boolean removePlayer(PlayerInterface player, boolean removeFromRoster){
		Position pos = player.getPosition();
		boolean b = true;
		if (pos.equals(Position.GOALKEEPER)){
			if (removeFromRoster)
				b = goalkeepers.remove(player);
			if(b == true){
				b = goalkeepersOnField.remove(player);
				if(b == true) numberOfPlayersOnField--;
				return true;
			}
			return b;
			
		} else if (pos.equals(Position.DEFENDER)){
			if (removeFromRoster)
				b = defenders.remove(player);
			if(b == true){
				b = defendersOnField.remove(player);
				if(b == true) numberOfPlayersOnField--;
				return true;
			}
			return b;
			
		} else if (pos.equals(Position.MIDFIELDER)){
			if (removeFromRoster)
				b = midfielders.remove(player);
			if(b == true){
				b = midfieldersOnField.remove(player);
				if(b == true) numberOfPlayersOnField--;
				return true;
			}
			return b;
			
		} else if (pos.equals(Position.FORWARD)){
			if (removeFromRoster)
				b = strikers.remove(player);
			if(b == true){
				b = strikersOnField.remove(player);
				if(b == true) numberOfPlayersOnField--;
				return true;
			}
			return b;
			
		}
		return false;
	}
	
	// Usage: b = addPlayerToRoster(player)
	// Before:player is of type PlayerInferface and is not null
	// After: If there is room for the player in roster in the position that he plays then he's
	//        added to the roster and b is returned as true. If there is no room him in his
	//        position then b is returned as false. If the player's position is not "Goalkeeper",
	//        "Defender", "Midfielder", or "Striker" then InvalidPosition exception is thrown.
	public boolean addPlayerToRoster(PlayerInterface player) {
		Position pos = player.getPosition();
		
		if (pos.equals(Position.GOALKEEPER)){
			if (this.goalkeepers.size() == MAX_GOALKEEPERS) return false;
			this.goalkeepers.add(player);
			return true;
			
		} else if (pos.equals(Position.DEFENDER)){
			if (this.defenders.size() == MAX_DEFENDERS) return false;
			this.defenders.add(player);
			return true;
			
		} else if (pos.equals(Position.MIDFIELDER)){
			if (midfielders.size() == MAX_MIDFIELDERS) return false;
			this.midfielders.add(player);
			return true;
			
		} else if (pos.equals(Position.FORWARD)){
			if (strikers.size() == MAX_STRIKERS) return false;
			this.strikers.add(player);
			return true;
		}
		return false;
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
		Position pos = player.getPosition();
		
		if (pos.equals(Position.GOALKEEPER)){
			return goalkeepers.contains(player);
		} else if (pos.equals(Position.DEFENDER)){
			return defenders.contains(player);
		} else if (pos.equals(Position.MIDFIELDER)){
			return midfielders.contains(player);
		} else if (pos.equals(Position.FORWARD)){
			return strikers.contains(player);
		}
		return false;
	}
	
	/*
	 * Is this player on the field?
	 */
	public boolean isOnField(PlayerInterface player) throws InvalidPlayer{
		Position pos = player.getPosition();
		
		if (pos.equals(Position.GOALKEEPER)){
			return goalkeepersOnField.contains(player);
		} else if (pos.equals(Position.DEFENDER)){
			return defendersOnField.contains(player);
		} else if (pos.equals(Position.MIDFIELDER)){
			return midfieldersOnField.contains(player);
		} else if (pos.equals(Position.FORWARD)){
			return strikersOnField.contains(player);
		}
		return false;
	}
	
	/*
	 * Function that sells a player. Returns false if the player wasn't found.
	 */
	public boolean sellPlayer(PlayerInterface player) throws InvalidPlayer{
		if(removePlayerFromRoster(player)){
			backend.MainGame.getInstance().getCurrentUser().changeMoney(player.getPrice());
			if(res.Constants.VERBOSE)
				System.out.println("This player was sold! You made "+player.getPrice());
			return true;
		}
		return false;
	}
	
	/*
	 * Function that buys a player.
	 */
	public boolean buyPlayer(PlayerInterface player) throws InvalidPosition, InvalidPlayer{
		if(player.getPrice() > backend.MainGame.getInstance().getCurrentUser().getMoney()){
			if(res.Constants.VERBOSE)
				System.out.println("This player is too expensive!");
			return false;
		}
		if(addPlayerToRoster(player)){
			backend.MainGame.getInstance().getCurrentUser().changeMoney(-player.getPrice());
			if(res.Constants.VERBOSE)
				System.out.println("This player was bought! You lost "+(-player.getPrice()));
			addPlayerToField(player);
			return true;
		} else {
			if(res.Constants.VERBOSE)
				System.out.println("You can't have more players in that position!");
		}
		return false;
	}
}
