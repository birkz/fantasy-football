package backend;

import java.util.ArrayList;
import java.util.List;
import tests.PlayerInterface;

public class Market {
	
	private static List<PlayerInterface> players;
	
	public Market() {
		
	}
	
	public List<PlayerInterface> getAllPlayers() {
		return players;
	}
	
	public PlayerInterface getPlayerByName(String name){
		for(PlayerInterface temp : players) {
			if(name.equals(temp.getName())) {
				return temp;
			}
		}
		return null;
	}
	
	public List<PlayerInterface> getPlayersByTeam(String team) {
		List<PlayerInterface> allteam = new ArrayList<PlayerInterface>();
		
		return allteam;
	}

}
