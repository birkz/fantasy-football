package backend;

public class MainGame {

	private static User[] users;
	private static int round = 0;
	private static int numUsers = 0;
	private static int currentUser = 0;
	
	public static void createUser(String name) {
		users[numUsers] = new User(name);
		numUsers++;
	}
	
	public static void setNumUsers(int num) {
		users = new User[num];
		for(int i=0; i<num; ++i) {
			createUser("Player" + (i+1));
		}
	}
	
	public static int getNumUsers() {
		return numUsers;
	}
	
	public static void nextUser() {
		if(currentUser<numUsers && round<10)currentUser++;
		if(currentUser==numUsers && round<10) {
			currentUser = 0;
			//here call for simulation of a round
			tests.RoundMock.SimRound(numUsers, round);
			round++;
		}
		frontend.Main.restartFrame();
	}
	
	public static int getRound() {
		return round;
	}
	
	public static int[] getScore() {
		int[] a = new int[1];//just a placeholder
		return a;
	}
	
	public static User getUser(int i) {
		return users[i];
	}
	
	public static User getCurrentUser() {
		return users[currentUser];
	}
}
