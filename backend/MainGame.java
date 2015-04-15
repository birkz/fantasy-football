package is.hi.f2a.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import is.hi.f1a.FantasyFootballBackend;
import is.hi.f1a.Player;
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
		FantasyFootballBackend.getInstance().restart();
	}
	
	public void setNumUsers(List<String> names) throws InvalidPlayer {
		users = new ArrayList<User>();
		for(int i=0; i<names.size(); ++i) {
			users.add(new User(names.get(i),i));
			stats.createUserScoreObject(users.get(i));
		}
	}
	
	public void nextUser() throws InvalidUser, IOException, InvalidPlayer {
		int numUsers = users.size();
		if(round<10) {
			if(currentUser<numUsers) currentUser++;
			if(currentUser==numUsers) {
				currentUser = 0;
				FantasyFootballBackend.getInstance().getLeague().playNextRound();
				//is.hi.f2a.tests.RoundMock.SimRound();
				round++;
				updateUserScore();
				sendPlayersBoughtAndSold();
				Main.getInstance().restartFrame();
			}
			//Hérna var restartFrame, ég færði það fimmm línur upp
			//Svo er ég að reyna að fá vinstra panel til að uppfærast með refreshFrame 
			//en það er bara ekki að ganga
			Main.getInstance().refreshFrame();
		}
		if(round == 10) {
			Main.getInstance().setEndgamePanel(true);
		}
	}
	
	public int getRound() {
		return round;
	}
	
	public void updateUserScore() throws InvalidUser {
		for(User temp : users) {
			int num = temp.getRoster().getRecentRosterScore();
			temp.setScore(num);
			stats.addScoreToUser(temp, num);
		}
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
	
	/*
	 * Get the current user's placement (1st, 2nd, 3rd, ...)
	 */
	public int getCurrentUserPlacement() {
		int currentUserScore = this.getCurrentUser().getScore();
		int placement = 1;
		for (User user : this.users){
			if(user.getScore() > currentUserScore) placement++;
		}
		return placement;
	}
	
	private void sendPlayersBoughtAndSold(){
		for(User user : users){
			List<Player> playersBought = user.getRoster().getNewlyBought();
			for(Player player : playersBought){
				player.playerBought();
			}
			
			List<Player> playersSold = user.getRoster().getNewlySold();
			for(Player player : playersSold){
				player.playerSold();
			}
		}
		return;
	}
}
