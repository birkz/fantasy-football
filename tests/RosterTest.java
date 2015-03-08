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
		PlayerMock newplayer = new PlayerMock("Player 1","Goalkeeper");
		players = new ArrayList<PlayerMock>();
		players.add(newplayer);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		roster = null;
	}
	
	@Test
	public void testIfEmpty() {
		String[] names = roster.getNamesOfPlayersInRoster();
		String out = "";
		for(int i = 0 ; i < names.length ; i++){
			out += names[i]+":";
		}
		assertEquals(out,"::::");
	}
	
	@Test
	public void testIfNotEmpty() {
		roster.addPlayerToTeam(players.get(0));
		String[] names = roster.getNamesOfPlayersInRoster();
		String out = "";
		for(int i = 0 ; i < names.length ; i++){
			out += names[i]+":";
		}
		assertEquals(out,"Player 1::::");
	}
}
