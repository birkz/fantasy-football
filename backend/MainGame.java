package backend;

public class MainGame {

	private static User[] users;
	private static int round = 0;
	private static int numUsers = 0;
	
	public static void createUser(String name) {
		users[numUsers] = new User(name);
		numUsers++;
	}
	
	public static void setNumUsers(int num) {
		users = new User[num];
	}
	
	public static void nextUser() {
		
	}
	
	public static int[] getScore() {
		int[] a = new int[1];
		return a;
	}
	
	public static User getUser(int i) {
		return users[i];
	}
}
