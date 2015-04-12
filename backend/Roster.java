package backend;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
import tests.*;

public class Roster {
	private List<PlayerInterface> goalkeepers;
	private List<PlayerInterface> goalkeeperOnField;
=======
import tests.*;
import tests.PlayerInterface.Position;
import res.Constants;

public class Roster {
	private List<PlayerInterface> goalkeepers;
	private List<PlayerInterface> goalkeepersOnField;
>>>>>>> parent of 896621e... changed package location
	private List<PlayerInterface> defenders;
	private List<PlayerInterface> defendersOnField;
	private List<PlayerInterface> midfielders;
	private List<PlayerInterface> midfieldersOnField;
<<<<<<< HEAD
	private List<PlayerInterface> strikers;
	private List<PlayerInterface> strikersOnField;
	// private PlayerInterface captain;
>>>>>>> parent of 74cfc3e... push to pull
=======
	private List<PlayerInterface> forwards;
	private List<PlayerInterface> forwardsOnField;
	// private PlayerInterface captain;
>>>>>>> parent of 896621e... changed package location
	private int numberOfPlayersOnField;
	
	public Roster(){
		this.numberOfPlayersOnField = 0;
<<<<<<< HEAD
<<<<<<< HEAD
		this.goalkeepers = new ArrayList<Player>(MAX_GOALKEEPERS);
		this.goalkeepersOnField = new ArrayList<Player>(MAX_GOALKEEPERS_ON_FIELD);
		this.defenders = new ArrayList<Player>(MAX_DEFENDERS);
		this.defendersOnField = new ArrayList<Player>(MAX_DEFENDERS_ON_FIELD);
		this.midfielders = new ArrayList<Player>(MAX_MIDFIELDERS);
		this.midfieldersOnField = new ArrayList<Player>(MAX_MIDFIELDERS_ON_FIELD);
		this.forwards = new ArrayList<Player>(MAX_FORWARDS);
		this.forwardsOnField = new ArrayList<Player>(MAX_FORWARDS_ON_FIELD);
=======
		this.goalkeepers = new ArrayList<PlayerInterface>(2);
		this.goalkeeperOnField = new ArrayList<PlayerInterface>(1);
		this.defenders = new ArrayList<PlayerInterface>(5);
		this.defendersOnField = new ArrayList<PlayerInterface>(5);
		this.midfielders = new ArrayList<PlayerInterface>(5);
		this.midfieldersOnField = new ArrayList<PlayerInterface>(5);
		this.strikers = new ArrayList<PlayerInterface>(3);
		this.strikersOnField = new ArrayList<PlayerInterface>(3);
>>>>>>> parent of 74cfc3e... push to pull
=======
		this.goalkeepers = new ArrayList<PlayerInterface>(MAX_GOALKEEPERS);
		this.goalkeepersOnField = new ArrayList<PlayerInterface>(MAX_GOALKEEPERS_ON_FIELD);
		this.defenders = new ArrayList<PlayerInterface>(MAX_DEFENDERS);
		this.defendersOnField = new ArrayList<PlayerInterface>(MAX_DEFENDERS_ON_FIELD);
		this.midfielders = new ArrayList<PlayerInterface>(MAX_MIDFIELDERS);
		this.midfieldersOnField = new ArrayList<PlayerInterface>(MAX_MIDFIELDERS_ON_FIELD);
		this.forwards = new ArrayList<PlayerInterface>(MAX_FORWARDS);
		this.forwardsOnField = new ArrayList<PlayerInterface>(MAX_FORWARDS_ON_FIELD);
>>>>>>> parent of 896621e... changed package location
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
<<<<<<< HEAD
<<<<<<< HEAD
	public boolean removePlayerFromField(Player player) throws InvalidPlayer{
=======
	public boolean removePlayerFromField(PlayerInterface player) throws InvalidPlayer{
>>>>>>> parent of 896621e... changed package location
		return removePlayer(player, false);
=======
	public void removePlayerFromField(PlayerInterface player) throws InvalidPlayer{
		removePlayer(player, false);
>>>>>>> parent of 74cfc3e... push to pull
	}
	
	// Usage: removePlayerFromRoster(player)
	// Before: player is of type PlayerInterface
	// After: player has been removed from the roster
<<<<<<< HEAD
<<<<<<< HEAD
	public boolean removePlayerFromRoster(Player player) throws InvalidPlayer{
=======
	public boolean removePlayerFromRoster(PlayerInterface player) throws InvalidPlayer{
>>>>>>> parent of 896621e... changed package location
		return removePlayer(player, true);
=======
	public void removePlayerFromRoster(PlayerInterface player) throws InvalidPlayer{
		removePlayer(player, true);
>>>>>>> parent of 74cfc3e... push to pull
	}
	
	// Usage: removePlayer(player,b)
	// Before:player is of type PlayerInterface and b is a boolean variable (true or false)
	// After: If b is true then player will be removed both from the field and the roster. If
	//        b is false then the player will only be removed from the field. If the player
	//        provided is not in the roster then a InvalidPlayer exception will be thrown.
<<<<<<< HEAD
<<<<<<< HEAD
	private boolean removePlayer(Player player, boolean removeFromRoster){
=======
	private boolean removePlayer(PlayerInterface player, boolean removeFromRoster){
>>>>>>> parent of 896621e... changed package location
		Position pos = player.getPosition();
		boolean b = true;
		if (pos.equals(Position.GOALKEEPER)){
			if (removeFromRoster)
				b = goalkeepers.remove(player);
			if(b){
				b = goalkeepersOnField.remove(player);
				if(b) numberOfPlayersOnField--;
				return true;
=======
	private void removePlayer(PlayerInterface player, boolean removeFromRoster) throws InvalidPlayer{
		String posName = player.getPositionName();
		if (posName.toLowerCase().equals("goalkeeper")){
			if (removeFromRoster){
				boolean b = goalkeepers.remove(player);
				if (!b) throw new tests.InvalidPlayer("The player "+player.getName()+" isn't in this roster");
>>>>>>> parent of 74cfc3e... push to pull
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
<<<<<<< HEAD
<<<<<<< HEAD
	public boolean addPlayerToRoster(Player player) {
=======
	public boolean addPlayerToRoster(PlayerInterface player) {
>>>>>>> parent of 896621e... changed package location
		Position pos = player.getPosition();
		
		if (pos.equals(Position.GOALKEEPER)){
			if (this.goalkeepers.size() == MAX_GOALKEEPERS) return false;
=======
	public boolean addPlayerToRoster(PlayerInterface player) throws InvalidPosition{
		String posName = player.getPositionName();
		if (posName.toLowerCase().equals("goalkeeper")){
			if (this.goalkeepers.size() == 2) return false;
>>>>>>> parent of 74cfc3e... push to pull
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
<<<<<<< HEAD
<<<<<<< HEAD
		throw new is.hi.f2a.tests.InvalidPlayer(player.getName()+" is currently not in the roster.");
=======
>>>>>>> parent of 74cfc3e... push to pull
=======
		throw new tests.InvalidPlayer(player.getName()+" is currently not in the roster.");
>>>>>>> parent of 896621e... changed package location
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
<<<<<<< HEAD
		names.add(forwards);
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
		names.add(forwardsOnField);
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
			return forwards.contains(player);
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
			return forwardsOnField.contains(player);
		}
		return false;
	}
	
	/*
	 * Function that sells a player. Returns false if the player wasn't found.
	 */
	public boolean sellPlayer(PlayerInterface player) throws InvalidPlayer{
		if(removePlayerFromRoster(player)){
			try {
				backend.MainGame.getInstance().getCurrentUser().changeMoney(player.getPrice());
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		if(!backend.MainGame.getInstance().getCurrentUser().isAffordable(player.getPrice())){
			if(res.Constants.VERBOSE)
				System.out.println("This player is too expensive!");
			return false;
		}
		if(addPlayerToRoster(player)){
			try {
				backend.MainGame.getInstance().getCurrentUser().changeMoney(-player.getPrice());
			} catch (Exception e) {
				e.printStackTrace();
			}
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
=======
		names.add(strikers);
		return names;
	}
>>>>>>> parent of 74cfc3e... push to pull
}
