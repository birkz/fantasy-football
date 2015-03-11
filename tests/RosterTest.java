package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import backend.Roster;

public class RosterTest {
	private static Roster roster;
	private static List<PlayerMock> players;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		roster = new Roster();
		PlayerMock newplayer1 = new PlayerMock("Player 1","Goalkeeper");
		PlayerMock newplayer2 = new PlayerMock("Player 2","Goalkeeper");
		players = new ArrayList<PlayerMock>();
		players.add(newplayer1);
		players.add(newplayer2);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		roster = null;
		players = null;
	}
	
	@Test
	public void testIfEmpty() {
		String[] names = roster.getNamesOfPlayersInRoster();
		assertEquals(names,new String[]{"", "", "", ""});
	}
	
	@Test
	public void testIfOnePlayer() {
		roster.addPlayerToTeam(players.get(0));
		String[] names = roster.getNamesOfPlayersInRoster();
		assertEquals(names,new String[]{"Player 1", "", "", ""});
	}

	@Test
	public void testIfTwoPlayer() {
		roster.addPlayerToTeam(players.get(0));
		String[] names = roster.getNamesOfPlayersInRoster();
		assertEquals(names,new String[]{"Player 1, Player 2", "", "", ""});
	}
}
