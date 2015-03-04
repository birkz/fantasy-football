package backend;

public class User {

	private int money;
	private int score;
	private String name;
	private Roster roster;
	
	public User(String name) {
		this.name = name;
		this.roster = new Roster();
	}
	
	public boolean changeMoney(int dMoney) {
		return false;
	}
	
	public Roster getRoster() {
		
		return new Roster();
	}
	
	public void addScoreToStats() {
		
	}
	
	public void changeName(String newname) {
		this.name = newname;
	}
	
	public String getName() {
		return name;
	}
}
