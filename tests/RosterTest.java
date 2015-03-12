package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import backend.Roster;
import tests.PlayerInterface;

public class RosterTest {
	private static Roster roster;
	private static List<PlayerMock> players;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		roster = new Roster();
		PlayerMock newplayer1 = new PlayerMock("Player 1","Goalkeeper");
		PlayerMock newplayer2 = new PlayerMock("Player 2","Goalkeeper");
		PlayerMock newplayer3 = new PlayerMock("Player 3","Goalkeeper");
		players = new ArrayList<PlayerMock>();
		players.add(newplayer1);
		players.add(newplayer2);
		players.add(newplayer3);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		roster = null;
		players = null;
	}
	
	@Test
	public void testIfEmpty() {
		List<List<PlayerInterface>> players_in_roster = roster.getPlayersInRoster();
		Iterator<List<PlayerInterface>> playerlist_iterator = players_in_roster.iterator();
		while(playerlist_iterator.hasNext()){
			List<PlayerInterface> playerlist = playerlist_iterator.next();
			Iterator<PlayerInterface> player_iterator = playerlist.iterator();
			while(player_iterator.hasNext()){
				System.out.println(player_iterator.next().getName());
				assertEquals(player_iterator.next().getName(),"");
			}
		}
	}
	
	/*@Test
	public void testIfOnePlayer() {
		System.out.println("testIfOnePlayer");
		boolean add1Goalkeeper = roster.addPlayerToTeam(players.get(0));
		// assertTrue(add1Goalkeeper);
		String[] names = roster.getNamesOfPlayersInRoster();
		valid = new String[]{"Player 1", "", "", ""};
		for(int i = 0 ; i < names.length ; i++){
			System.out.println(names[i]);
			System.out.println(valid[i]);
		}
		assertArrayEquals(names,valid);
	}

	@Test
	public void testIfTwoPlayer() {
		System.out.println("testIfTwoPlayer");
		roster.addPlayerToTeam(players.get(0));
		boolean add2Goalkeeper = roster.addPlayerToTeam(players.get(1));
		// assertTrue(add2Goalkeeper);
		String[] names = roster.getNamesOfPlayersInRoster();
		valid = new String[]{"Player 1, Player 2", "", "", ""};
		for(int i = 0 ; i < names.length ; i++){
			System.out.println(names[i]);
			System.out.println(valid[i]);
			assertEquals(names[i],valid[i]);
		}
		// assertArrayEquals(names,valid);
	}

	@Test
	public void testIfThreePlayer() {
		System.out.println("testIfThreePlayer");
		roster.addPlayerToTeam(players.get(0));
		roster.addPlayerToTeam(players.get(1));
		roster.addPlayerToTeam(players.get(2));
		String[] names = roster.getNamesOfPlayersInRoster();
		valid = new String[]{"Player 1, Player 2", "", "", ""};
		for(int i = 0 ; i < names.length ; i++){
			System.out.println(names[i]);
			System.out.println(valid[i]);
			assertEquals(names[i],valid[i]);
		}
		// assertArrayEquals(names,valid);
	}*/
}
