package backend;

import java.util.ArrayList;
import java.util.List;

import tests.InvalidUser;

public class StatsHistory {
	
	List<ObjectScores> allplayerscores;
	List<ObjectScores> allrosterscores;
	List<ObjectScores> alluserscores;
	
	public StatsHistory() {
		this.allplayerscores = new ArrayList<ObjectScores>(150);
		this.allrosterscores = new ArrayList<ObjectScores>(MainGame.getInstance().getNumUsers());
		this.alluserscores = new ArrayList<ObjectScores>(MainGame.getInstance().getNumUsers());
	}
	
	public void createUserScoreObject(Object user) {
		this.alluserscores.add(new ObjectScores(user));
	}
	
	public List<Integer> getUserScores(User user) throws InvalidUser {
		for(ObjectScores temp : this.allrosterscores) {
			if(((User)temp.getObject()).equals(user)) {
				return temp.getScores();
			}
		}
		throw new InvalidUser(user.getName() + " is not a user");
	}
	
	public void addScoreToUser(User user, int score) throws InvalidUser {
		boolean userfound = false;
		for(ObjectScores temp : this.allrosterscores) {
			if(((User)temp.getObject()).equals(user)) {
				temp.addScore(score);
				userfound = true;
			}
		}
		if(!userfound) throw new InvalidUser("User " + user.getName() + " was not found");
	}

}
