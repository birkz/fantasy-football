package backend;

import java.util.List;

public class MainGame {

	private static final MainGame game = new MainGame();
	private StatsHistory stats;
	private User[] users;
	private int round = 0;
	private int numUsers = 0;
	private int currentUser = 0;
	
	private MainGame() {
		stats = new StatsHistory();
	}
	
	public static MainGame getInstance() {
		return game;
	}
	
	public void setNumUsers(List<String> names) {
		numUsers = names.size();
		users = new User[numUsers];
		for(int i=0; i<numUsers; ++i) {
			users[i] = new User(names.get(i));
			stats.createUserScoreObject(users[i]); // Is this nasty?
		}
	}
	
	public int getNumUsers() {
		return numUsers;
	}
	
	public void nextUser() {
		if(currentUser<numUsers && round<10) currentUser++;
		if(currentUser==numUsers && round<10) {
			currentUser = 0;
			//here call for simulation of a round
			tests.RoundMock.SimRound(numUsers, round);
			round++;
		}
		frontend.Main.getInstance().restartFrame();
	}
	
	public int getRound() {
		return round;
	}
	
	public int[] getScore() {
		int[] a = new int[1];//just a placeholder
		return a;
	}
	
	public User getUser(int i) {
		return users[i];
	}
	
	public StatsHistory getStatsHistory() {
		return stats;
	}
	
	public User getCurrentUser() {
		return users[currentUser];
	}
	
	public int getCurrendUserID() {
		return currentUser;
	}
}
