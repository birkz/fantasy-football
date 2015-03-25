package backend;

import java.util.ArrayList;
import java.util.List;

import tests.InvalidUser;
import tests.InvalidPlayer;
import tests.PlayerInterface;

public class StatsHistory {
	
	List<ObjectScores> allplayerscores;
	List<ObjectScores> alluserscores;
	List<ObjectScores> allrosterscores; // Er þörf fyrir roster scores? Er það ekki sama og userscores?
	
	public StatsHistory() {
		this.allplayerscores = new ArrayList<ObjectScores>(150);
		this.alluserscores = new ArrayList<ObjectScores>();
		// this.allrosterscores = new ArrayList<ObjectScores>(); 
	}
	
	public void createPlayerScoreObject(Object player) {
		this.allplayerscores.add(new ObjectScores(player));
	}
	
	public void createUserScoreObject(Object user) {
		this.alluserscores.add(new ObjectScores(user));
	}
	
	public void createRosterScoreObject(Object roster) {
		this.allrosterscores.add(new ObjectScores(roster));
	}
	
	public List<Integer> getPlayerScores(PlayerInterface player) throws InvalidPlayer {
		for(ObjectScores temp : this.allplayerscores) {
			if(((PlayerInterface)temp.getObject()).equals(player)) {
				return temp.getScores();
			}
		}
		throw new InvalidPlayer(player.getName() + " is not a player");
	}
	
	public List<Integer> getUserScores(User user) throws InvalidUser {
		for(ObjectScores temp : this.alluserscores) {
			if(((User)temp.getObject()).equals(user)) {
				return temp.getScores();
			}
		}
		throw new InvalidUser(user.getName() + " is not a user");
	}
	
	public void addScoreToPlayer(PlayerInterface player, int score) throws InvalidPlayer{
		boolean playerfound = false;
		for(ObjectScores temp : this.allrosterscores) {
			if(((PlayerInterface)temp.getObject()).equals(player)) {
				temp.addScore(score);
				playerfound = true;
			}
		}
		if(!playerfound) throw new InvalidPlayer("Player" + player.getName() + " was not found");
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
