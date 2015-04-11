package is.hi.f2a.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import is.hi.f1a.FantasyFootballBackend;
import is.hi.f2a.tests.InvalidPlayer;
import is.hi.f2a.tests.InvalidUser;
import is.hi.f2a.backend.User;
import is.hi.f2a.frontend.Main;

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
	
	public void resetGame() {
		this.stats = new StatsHistory();
		this.users = null;
		this.round = 0;
		this.currentUser = 0;
	}
	
	public void setNumUsers(List<String> names) throws InvalidPlayer {
		users = new ArrayList<User>();
		for(int i=0; i<names.size(); ++i) {
			users.add(new User(names.get(i),i));
			stats.createUserScoreObject(users.get(i));
		}
	}
	
	public void nextUser() throws InvalidUser, IOException {
		int numUsers = users.size();
		if(round<10) {
			if(currentUser<numUsers) currentUser++;
			if(currentUser==numUsers) {
				currentUser = 0;
				//here call for simulation of a round
				try {
					//FantasyFootballBackend.getInstance().getLeague().playNextRound();
					is.hi.f2a.tests.RoundMock.SimRound();
				} catch (InvalidUser e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				round++;
			}
			Main.getInstance().restartFrame();
		}
		if(round == 10) {
			Main.getInstance().setEndgamePanel();
		}
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
