package backend;

import java.util.ArrayList;
import java.util.List;

public class Market {
	
	private static List<Player> players;
	
	public Market() {
		fillWithAllPlayers();
	}
	
	public static void fillWithAllPlayers() {
		players = new ArrayList<Player>();
		for(int i = 0; i < Player.count(); i++){
			players.add(new Player(i));
		}
	}
	
	public List<Player> getAllPlayers() {
		return players;
	}
	
	public Player getPlayerByName(String name){
		for(Player temp : players) {
			if(name.equals(temp.getName())) {
				return temp;
			}
		}
		return null;
	}
	
	public List<Player> getPlayersByTeam(String team) {
		List<Player> allteam = new ArrayList<Player>();
		for(Player temp : players) {
			if(team.equals(temp.getTeam())) {
				allteam.add(temp);
			}
		}
		return allteam;
	}

}
