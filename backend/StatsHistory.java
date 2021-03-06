package is.hi.f2a.backend;

import java.util.ArrayList;
import java.util.List;

import is.hi.f1a.Player;
import is.hi.f2a.tests.InvalidUser;
import is.hi.f2a.tests.InvalidPlayer;

public class StatsHistory {
	
	List<ObjectScores> allplayerscores;
	List<ObjectScores> alluserscores;
	List<ObjectScores> allrosterscores; // Er þörf fyrir roster scores? Er það ekki sama og userscores?
	
	public StatsHistory() {
		this.allplayerscores = new ArrayList<ObjectScores>(150);
		this.alluserscores = new ArrayList<ObjectScores>();
		// this.allrosterscores = new ArrayList<ObjectScores>(); 
	}
	
	// CREATE OBJECTS
	public void createPlayerScoreObject(Object player) {
		this.allplayerscores.add(new ObjectScores(player));
	}
	
	public void createUserScoreObject(Object user) {
		this.alluserscores.add(new ObjectScores(user));
	}
	
	/*
	public void createRosterScoreObject(Object roster) {
		this.allrosterscores.add(new ObjectScores(roster));
	}
	*/
	
	/////////////////
	// PLAYER STUFF
	/////////////////
	public List<Integer> getPlayerScores(Player player) throws InvalidPlayer {
		return getPlayerScores(player, false);
	}
	
	public List<Integer> getTotalPlayerScores(Player player) throws InvalidPlayer {
		return getPlayerScores(player, true);
	}
	
	private List<Integer> getPlayerScores(Player player, boolean total) throws InvalidPlayer {
		for(ObjectScores temp : this.allplayerscores) {
			if(((Player)temp.getObject()).equals(player)) {
				if(total) return temp.getTotalScores();
				return temp.getScores();
			}
		}
		throw new InvalidPlayer(player.getName() + " is not a player");
	}
	
	public void addScoreToPlayer(Player player, int score) throws InvalidPlayer{
		boolean playerfound = false;
		for(ObjectScores temp : this.allrosterscores) {
			if(((Player)temp.getObject()).equals(player)) {
				temp.addScore(score);
				playerfound = true;
			}
		}
		if(!playerfound) throw new InvalidPlayer("Player" + player.getName() + " was not found");
	}
	
	///////////////
	// USER STUFF
	///////////////
	public List<Integer> getUserScores(User user) throws InvalidUser {
		return getUserScores(user, false);
	}
	
	public List<Integer> getTotalUserScores(User user) throws InvalidUser {
		return getUserScores(user, true);
	}
	
	private List<Integer> getUserScores(User user, boolean total) throws InvalidUser {
		for(ObjectScores temp : this.alluserscores) {
			if(((User)temp.getObject()).equals(user)) {
				if(total) return temp.getTotalScores();
				else return temp.getScores();
			}
		}
		throw new InvalidUser(user.getName() + " is not a user");
	}
	
	public void addScoreToUser(User user, int score) throws InvalidUser {
		boolean userfound = false;
		for(ObjectScores temp : this.alluserscores) {
			if(((User)temp.getObject()).equals(user)) {
				temp.addScore(score);
				userfound = true;
			}
		}
		if(!userfound) throw new InvalidUser("User " + user.getName() + " was not found");
	}

}
