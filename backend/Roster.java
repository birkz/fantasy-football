package is.hi.f2a.backend;

import java.util.ArrayList;
import java.util.List;

import is.hi.f1a.Player;
import is.hi.f1a.Player.Position;
import is.hi.f2a.tests.*;
import is.hi.f2a.res.Constants;

public class Roster {
	private List<Player> goalkeepers;
	private List<Player> goalkeepersOnField;
	private List<Player> defenders;
	private List<Player> defendersOnField;
	private List<Player> midfielders;
	private List<Player> midfieldersOnField;
	private List<Player> forwards;
	private List<Player> forwardsOnField;
	// private Player captain;
	private int numberOfPlayersOnField;
	
	/*
	 * Constants
	 */
	private final int MAX_GOALKEEPERS = Constants.MAX_GOALKEEPERS;
	private final int MAX_GOALKEEPERS_ON_FIELD = Constants.MAX_GOALKEEPERS_ON_FIELD;
	
	private final int MAX_DEFENDERS = Constants.MAX_DEFENDERS;
	private final int MAX_DEFENDERS_ON_FIELD = Constants.MAX_DEFENDERS_ON_FIELD;
	
	private final int MAX_MIDFIELDERS = Constants.MAX_MIDFIELDERS;
	private final int MAX_MIDFIELDERS_ON_FIELD = Constants.MAX_MIDFIELDERS_ON_FIELD;
	
	private final int MAX_FORWARDS = Constants.MAX_FORWARDS;
	private final int MAX_FORWARDS_ON_FIELD = Constants.MAX_FORWARDS_ON_FIELD;
	
	public Roster(){
		this.numberOfPlayersOnField = 0;
		this.goalkeepers = new ArrayList<Player>(MAX_GOALKEEPERS);
		this.goalkeepersOnField = new ArrayList<Player>(MAX_GOALKEEPERS_ON_FIELD);
		this.defenders = new ArrayList<Player>(MAX_DEFENDERS);
		this.defendersOnField = new ArrayList<Player>(MAX_DEFENDERS_ON_FIELD);
		this.midfielders = new ArrayList<Player>(MAX_MIDFIELDERS);
		this.midfieldersOnField = new ArrayList<Player>(MAX_MIDFIELDERS_ON_FIELD);
		this.forwards = new ArrayList<Player>(MAX_FORWARDS);
		this.forwardsOnField = new ArrayList<Player>(MAX_FORWARDS_ON_FIELD);
	}
	
	// Usage: i = getNumberOfPlayersOnField()
	// Before:Nothing.
	// After: i is the number of players currently on the field.
	public int getNumberOfPlayersOnField(){
		return this.numberOfPlayersOnField;
	}
	
	// Usage: removePlayerFromField(player)
	// Before: player is of type Player
	// After: player has been taken of the field
	public boolean removePlayerFromField(Player player) throws InvalidPlayer{
		return removePlayer(player, false);
	}
	
	// Usage: removePlayerFromRoster(player)
	// Before: player is of type Player
	// After: player has been removed from the roster
	public boolean removePlayerFromRoster(Player player) throws InvalidPlayer{
		return removePlayer(player, true);
	}
	
	// Usage: removePlayer(player,b)
	// Before:player is of type Player and b is a boolean variable (true or false)
	// After: If b is true then player will be removed both from the field and the roster. If
	//        b is false then the player will only be removed from the field. If the player
	//        provided is not in the roster then a InvalidPlayer exception will be thrown.
	private boolean removePlayer(Player player, boolean removeFromRoster){
		Position pos = player.getPosition();
		boolean b = true;
		if (pos.equals(Position.GOALKEEPER)){
			if (removeFromRoster)
				b = goalkeepers.remove(player);
			if(b){
				b = goalkeepersOnField.remove(player);
				if(b) numberOfPlayersOnField--;
				return true;
			}
			return b;
			
		} else if (pos.equals(Position.DEFENDER)){
			if (removeFromRoster)
				b = defenders.remove(player);
			if(b){
				b = defendersOnField.remove(player);
				if(b) numberOfPlayersOnField--;
				return true;
			}
			return b;
			
		} else if (pos.equals(Position.MIDFIELDER)){
			if (removeFromRoster)
				b = midfielders.remove(player);
			if(b){
				b = midfieldersOnField.remove(player);
				if(b == true) numberOfPlayersOnField--;
				return true;
			}
			return b;
			
		} else if (pos.equals(Position.FORWARD)){
			if (removeFromRoster)
				b = forwards.remove(player);
			if(b){
				b = forwardsOnField.remove(player);
				if(b) numberOfPlayersOnField--;
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
	public boolean addPlayerToRoster(Player player) {
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
			if (forwards.size() == MAX_FORWARDS) return false;
			this.forwards.add(player);
			return true;
		}
		return false;
	}
	
	// Usage: b = addPlayerToField(player)
	// Before:player is of type Player
	// After: If the player isn't in the roster then an InvalidPlayer exception is thrown. Otherwise, and
	//        if the player's position and roster on field are not full, the player will be added to the field
	//        and b will be returned as true. Otherwise b will be returned as false.
	public boolean addPlayerToField(Player player) throws InvalidPlayer{
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
			
		} else if (this.forwards.contains(player)){
			if (this.forwardsOnField.size() >= MAX_FORWARDS_ON_FIELD || this.forwardsOnField.contains(player) || this.numberOfPlayersOnField >= 11){
				return false;
			}
			this.forwardsOnField.add(player);
			this.numberOfPlayersOnField++;
			return true;
			
		}
		throw new is.hi.f2a.tests.InvalidPlayer(player.getName()+" is currently not in the roster.");
	}
	
	// Usage: getPlayersInRoster()
	// Before:Nothing
	// After: List containing a list of all players in the current roster. There will always be 4 inner
	//        lists, the first for goalkeepers, second for defenders, third for midfielders, and the
	//        4th for strikers.
	public List<List<Player>> getPlayersInRoster(){
		List<List<Player>> names = new ArrayList<List<Player>>(4);
		names.add(goalkeepers);
		names.add(defenders);
		names.add(midfielders);
		names.add(forwards);
		return names;
	}
	
	/*
	 * Get on players on the field
	 */
	public List<List<Player>> getPlayersOnField(){
		List<List<Player>> names = new ArrayList<List<Player>>(4);
		names.add(goalkeepersOnField);
		names.add(defendersOnField);
		names.add(midfieldersOnField);
		names.add(forwardsOnField);
		return names;
	}
	
	/*
	 * Is this player in roster?
	 */
	public boolean isInRoster(Player player) throws InvalidPlayer{
		Position pos = player.getPosition();
		
		if (pos.equals(Position.GOALKEEPER)){
			return goalkeepers.contains(player);
		} else if (pos.equals(Position.DEFENDER)){
			return defenders.contains(player);
		} else if (pos.equals(Position.MIDFIELDER)){
			return midfielders.contains(player);
		} else if (pos.equals(Position.FORWARD)){
			return forwards.contains(player);
		}
		return false;
	}
	
	/*
	 * Is this player on the field?
	 */
	public boolean isOnField(Player player) throws InvalidPlayer{
		Position pos = player.getPosition();
		
		if (pos.equals(Position.GOALKEEPER)){
			return goalkeepersOnField.contains(player);
		} else if (pos.equals(Position.DEFENDER)){
			return defendersOnField.contains(player);
		} else if (pos.equals(Position.MIDFIELDER)){
			return midfieldersOnField.contains(player);
		} else if (pos.equals(Position.FORWARD)){
			return forwardsOnField.contains(player);
		}
		return false;
	}
	
	/*
	 * Function that sells a player. Returns false if the player wasn't found.
	 */
	public boolean sellPlayer(Player player) throws InvalidPlayer{
		if(removePlayerFromRoster(player)){
			try {
				is.hi.f2a.backend.MainGame.getInstance().getCurrentUser().changeMoney(player.getPrice());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(is.hi.f2a.res.Constants.VERBOSE)
				System.out.println("This player was sold! You made "+player.getPrice());
			return true;
		}
		return false;
	}
	
	/*
	 * Function that buys a player.
	 */
	public boolean buyPlayer(Player player) throws InvalidPosition, InvalidPlayer{
		if(!is.hi.f2a.backend.MainGame.getInstance().getCurrentUser().isAffordable(player.getPrice())){
			if(is.hi.f2a.res.Constants.VERBOSE)
				System.out.println("This player is too expensive!");
			return false;
		}
		if(addPlayerToRoster(player)){
			try {
				is.hi.f2a.backend.MainGame.getInstance().getCurrentUser().changeMoney(-player.getPrice());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(is.hi.f2a.res.Constants.VERBOSE)
				System.out.println("This player was bought! You lost "+(-player.getPrice()));
			addPlayerToField(player);
			return true;
		} else {
			if(is.hi.f2a.res.Constants.VERBOSE)
				System.out.println("You can't have more players in that position!");
		}
		return false;
	}
}
