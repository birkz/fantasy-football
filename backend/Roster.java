package backend;

import java.util.ArrayList;
import java.util.List;

import tests.*;

public class Roster {
	private List<PlayerInterface> goalkeepers;
	private List<PlayerInterface> goalkeeperOnField;
	private List<PlayerInterface> defenders;
	private List<PlayerInterface> defendersOnField;
	private List<PlayerInterface> midfielders;
	private List<PlayerInterface> midfieldersOnField;
	private List<PlayerInterface> strikers;
	private List<PlayerInterface> strikersOnField;
	// private PlayerInterface captain;
	private int numberOfPlayersOnField;
	
	public Roster(){
		this.numberOfPlayersOnField = 0;
		this.goalkeepers = new ArrayList<PlayerInterface>(2);
		this.goalkeeperOnField = new ArrayList<PlayerInterface>(1);
		this.defenders = new ArrayList<PlayerInterface>(5);
		this.defendersOnField = new ArrayList<PlayerInterface>(5);
		this.midfielders = new ArrayList<PlayerInterface>(5);
		this.midfieldersOnField = new ArrayList<PlayerInterface>(5);
		this.strikers = new ArrayList<PlayerInterface>(3);
		this.strikersOnField = new ArrayList<PlayerInterface>(3);
	}
	
	public int getNumberOfPlayersOnField(){
		return this.numberOfPlayersOnField;
	}
	
	public void removePlayerFromList(PlayerInterface player,List<PlayerInterface> list){
		for(int i = 0 ; i < list.size() ; i++){
			if(list.get(i).equals(player)){
				list.remove(i);
				return;
			}
		}
	}
	
	public void removePlayer(PlayerInterface player, boolean removeFromTeam){
		String posName = player.getPositionName();
		if (posName.equals("Goalkeeper")){
			if (removeFromTeam) removePlayerFromList(player,goalkeepers);
			removePlayerFromList(player,goalkeeperOnField);
		} else if (posName.equals("Defender")){
			if (removeFromTeam) removePlayerFromList(player,defenders);
			removePlayerFromList(player,defendersOnField);
		} else if (posName.equals("Midfielder")){
			if (removeFromTeam) removePlayerFromList(player,midfielders);
			removePlayerFromList(player,midfieldersOnField);
		} else if (posName.equals("Striker")){
			if (removeFromTeam) removePlayerFromList(player,strikers);
			removePlayerFromList(player,strikersOnField);
		}
	}
	
	// Notkun: addPlayerToTeam(player)
	// Fyrir: player er af tagi PlayerInferface, má ekki vera null
	// Eftir: Ef pláss er fyrir leikmanninn í liði í þeirri stöðu sem hann er skráður á
	//        þá er honum bætt við liðið og skilað er true. Ef ekki er pláss fyrir leik-
	//        manninn er skilað false.
	public boolean addPlayerToTeam(PlayerInterface player) throws InvalidPosition{
		String posName = player.getPositionName();
		if (posName.equals("Goalkeeper")){
			if (goalkeepers.size() == 2) return false;
			this.goalkeepers.add(player);
			this.numberOfPlayersOnField++;
			return true;
		} else if (posName.equals("Defender")){
			if (this.defenders.size() == 5) return false;
			this.defenders.add(player);
			this.numberOfPlayersOnField++;
			return true;
		} else if (posName.equals("Midfielder")){
			if (midfielders.size() == 5) return false;
			this.midfielders.add(player);
			this.numberOfPlayersOnField++;
			return true;
		} else if (posName.equals("Striker")){
			if (strikers.size() == 3) return false;
			this.strikers.add(player);
			this.numberOfPlayersOnField++;
			return true;
		} else {
			throw new InvalidPosition(posName+" is not a valid position. Only Goalkeeper, Defender, Midfielder, and Striker are valid.");
		}
	}
	
	public List<List<PlayerInterface>> getPlayersInRoster(){
		List<List<PlayerInterface>> names = new ArrayList<List<PlayerInterface>>(4);
		names.add(goalkeepers);
		names.add(defenders);
		names.add(midfielders);
		names.add(strikers);
		return names;
	}
}
