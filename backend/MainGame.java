package backend;

import java.util.ArrayList;
import java.util.List;

import tests.InvalidPlayer;

import tests.InvalidPosition;
import tests.InvalidUser;

import frontend.Main;

public class MainGame {

	private static final MainGame game = new MainGame();
	private StatsHistory stats;
	private List<User> users;
	private int round = 0;
	private int currentUser = 0;
	
	private MainGame() {
		stats = new StatsHistory();
	}
	
	public static MainGame getInstance() {
		return game;
	}
	
	public void setNumUsers(List<String> names) throws InvalidPlayer {
		users = new ArrayList<User>();
		for(int i=0; i<names.size(); ++i) {
			users.add(new User(names.get(i),i));
			stats.createUserScoreObject(users.get(i));
		}
	}
	
	public void nextUser() throws InvalidUser {
		int numUsers = users.size();
		if(currentUser<numUsers && round<10) currentUser++;
		if(currentUser==numUsers && round<10) {
			currentUser = 0;
			//here call for simulation of a round
			try {
				tests.RoundMock.SimRound();
			} catch (InvalidUser e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			round++;
		}
		Main.getInstance().restartFrame();
	}
	
	public int getRound() {
		return round;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public StatsHistory getStatsHistory() {
		return stats;
	}
	
	public User getCurrentUser() {
		return users.get(currentUser);
	}
	
	public int getCurrendUserID() {
		return currentUser;
	}
}
