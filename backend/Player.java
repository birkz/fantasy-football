package backend;

public class Player {
	
	private static String[] names = {"Einar", "Hannes", "Birkir"};
	private static String[] teams = {"KR", "FH", "Fylkir"};
	private String name;
	private String team;
	
	public Player(int index){
		this.name = names[index];
		this.team = teams[index];
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getTeam() {
		return this.team;
	}
}
