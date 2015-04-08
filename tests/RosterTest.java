package is.hi.f2a.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import is.hi.f1a.Player;
import is.hi.f1a.Player.Position;
import is.hi.f2a.backend.Roster;
import is.hi.f2a.res.Constants;

public class RosterTest {
	/*
	 * Instance variables
	 */
	private static Roster roster;
	public static Map<String, Player> players;
	private static List<String> goalkeepers;
	private static List<String> defenders;
	private static List<String> midfielders;
	private static List<String> strikers;
	
	private static Player goalkeeper1;
	private static Player goalkeeper2;
	private static Player goalkeeper3;
	private static Player goalkeeper4;
	
	private static Player defender1;
	private static Player defender2;
	private static Player defender3;
	private static Player defender4;
	private static Player defender5;
	
	private static Player midfielder1;
	private static Player midfielder2;
	private static Player midfielder3;
	private static Player midfielder4;
	private static Player midfielder5;
	
	private static Player striker1;
	private static Player striker2;
	private static Player striker3;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		goalkeeper1 = new Player("Goalkeeper 1",Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		goalkeeper2 = new Player("Goalkeeper 2",Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		goalkeeper3 = new Player("Goalkeeper 3",Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		goalkeeper4 = new Player("Goalkeeper 4",Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		defender1 = new Player("Defender 1",Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		defender2 = new Player("Defender 2",Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		defender3 = new Player("Defender 3",Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		defender4 = new Player("Defender 4",Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		defender5 = new Player("Defender 5",Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		midfielder1 = new Player("Midfielder 1",Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		midfielder2 = new Player("Midfielder 2",Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		midfielder3 = new Player("Midfielder 3",Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		midfielder4 = new Player("Midfielder 4",Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		midfielder5 = new Player("Midfielder 5",Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		striker1 = new Player("Forward 1",Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		striker2 = new Player("Forward 2",Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		striker3 = new Player("Forward 3",Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		players = new HashMap<String, Player>();
		players.put(goalkeeper1.getName(),goalkeeper1);
		players.put(goalkeeper2.getName(),goalkeeper2);
		players.put(goalkeeper3.getName(),goalkeeper3);
		players.put(goalkeeper4.getName(),goalkeeper4);
		
		players.put(defender1.getName(),defender1);
		players.put(defender2.getName(),defender2);
		players.put(defender3.getName(),defender3);
		players.put(defender4.getName(),defender4);
		players.put(defender5.getName(),defender5);
		
		players.put(midfielder1.getName(),midfielder1);
		players.put(midfielder2.getName(),midfielder2);
		players.put(midfielder3.getName(),midfielder3);
		players.put(midfielder4.getName(),midfielder4);
		players.put(midfielder5.getName(),midfielder5);
		
		players.put(striker1.getName(), striker1);
		players.put(striker2.getName(), striker2);
		players.put(striker3.getName(), striker3);
	}
	
	@Before
	public void setUp() throws Exception {
		roster = new Roster();
		goalkeepers = new ArrayList<String>(Constants.MAX_GOALKEEPERS);
		defenders = new ArrayList<String>(Constants.MAX_DEFENDERS);
		midfielders = new ArrayList<String>(Constants.MAX_MIDFIELDERS);
		strikers = new ArrayList<String>(Constants.MAX_FORWARDS);
	}
	
	@After
	public void tearDown() throws Exception {
		roster = null;
		goalkeepers = null;
		defenders = null;
		midfielders = null;
		strikers = null;
	}
	
	// Usage: compareListsOfLists(expected,actual)
	// Before: expected is a list containing lists of strings, the strings are the expected names of the football players
	//         in the roster.
	public int compareListsOfLists(List<List<String>> expected, List<List<Player>> actual) throws IllegalStateException{
		// Count the number of matches
		int matches = 0;
		
		// If the two lists (of lists) have different number of elements, throw exception.
		if (actual.size() != expected.size()){
			throw new IllegalStateException("Sizes of lists containing lists not the same: "+expected.size()+" and "+actual.size());
		}
		
		// Create an iterator for both lists (of lists)
		Iterator<List<Player>> playerlist_iterator = actual.iterator();
		Iterator<List<String>> expected_playerlist_iterator = expected.iterator();
		
		// Loop through the lists
		while(playerlist_iterator.hasNext()){
			List<Player> playerlist = playerlist_iterator.next();
			List<String> expected_playerlist = expected_playerlist_iterator.next();
			
			if (playerlist.size() != expected_playerlist.size()){
				throw new IllegalStateException("Sizes of lists not the same: "+expected_playerlist.size()+" and "+playerlist.size());
			}
			
			Iterator<Player> player_iterator = playerlist.iterator();
			Iterator<String> expected_player_iterator = expected_playerlist.iterator();
			
			while(player_iterator.hasNext()){
				String expected_player = expected_player_iterator.next();
				Player player = player_iterator.next();
				if(!player.getName().equals(expected_player)){
					throw new IllegalStateException("Player: "+player.getName()+" not the same as "+expected_player);
				}
				else{
					matches++;
				}
			}
		}
		return matches;
	}
	
	// This test will check if a new roster is empty.
	@SuppressWarnings("serial")
	@Test
	public void testIfEmpty() throws IllegalStateException, InvalidPosition {
		List<List<Player>> actual = roster.getPlayersInRoster();
		List<List<String>> excepted = new ArrayList<List<String>>(4) {{add(goalkeepers);add(defenders);add(midfielders);add(strikers);}};
		assertEquals(0,compareListsOfLists(excepted, actual));
	}
	
	// This test will check if we can successfully add a single player to the roster.
	@SuppressWarnings("serial")
	@Test
	public void testIfOnePlayer() throws IllegalStateException, InvalidPosition {
		// Add the player "Goalkeeper 1" to the roster
		boolean add = roster.addPlayerToRoster(players.get("Goalkeeper 1"));
		assertTrue(add);
		
		// Get the roster players
		List<List<Player>> actual = roster.getPlayersInRoster();
		
		// Create the expected outcome of the test
		goalkeepers.add("Goalkeeper 1");
		List<List<String>> excepted = new ArrayList<List<String>>(4) {{add(goalkeepers);add(defenders);add(midfielders);add(strikers);}};
		
		assertEquals(1,compareListsOfLists(excepted, actual));
	}
	
	// This test will check if we will receive "false" from the addPlayerToRoster() method if we try
	// to add too many players to the same position.
	@SuppressWarnings("serial")
	@Test
	public void testIfThreePlayers() throws InvalidPosition {
		// Add the player "Goalkeeper 1" to the roster
		Integer i;
		for(i = 1 ; i<Constants.MAX_GOALKEEPERS+1 ; i++){
			System.out.println("Goalkeeper "+i);
			boolean add = roster.addPlayerToRoster(players.get("Goalkeeper "+i));
			assertTrue(add);
		}
		boolean add = roster.addPlayerToRoster(players.get("Goalkeeper "+i));
		assertFalse(add);
		
		// Get the roster players
		List<List<Player>> actual = roster.getPlayersInRoster();
		
		// Create the expected outcome of the test
		for(int j = 1 ; j<Constants.MAX_GOALKEEPERS+1 ; j++){
			goalkeepers.add("Goalkeeper "+j);
		}
		
		List<List<String>> excepted = new ArrayList<List<String>>(4) {{add(goalkeepers);add(defenders);add(midfielders);add(strikers);}};
		
		assertEquals(3,compareListsOfLists(excepted, actual));
	}
	
	// This test will check if we can successfully add 15 players (maximum allowed roster size) to the roster.
	@SuppressWarnings("serial")
	@Test
	public void testIfFullRoster() throws InvalidPosition {
		// Add the player "Goalkeeper 1" to the roster
		roster.addPlayerToRoster(players.get("Goalkeeper 1"));
		roster.addPlayerToRoster(players.get("Goalkeeper 2"));
		boolean add;
		add = roster.addPlayerToRoster(players.get("Defender 1"));	assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Defender 2"));	assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Defender 3"));	assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Defender 4"));	assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Defender 5"));	assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Midfielder 1"));	assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Midfielder 2"));	assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Midfielder 3"));	assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Midfielder 4"));	assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Midfielder 5"));	assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Forward 1"));		assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Forward 2"));		assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Forward 3"));		assertTrue(add);
		
		// Get the roster players
		List<List<Player>> actual = roster.getPlayersInRoster();
		
		// Create the expected outcome of the test
		goalkeepers.add("Goalkeeper 1");
		goalkeepers.add("Goalkeeper 2");
		defenders.add("Defender 1");
		defenders.add("Defender 2");
		defenders.add("Defender 3");
		defenders.add("Defender 4");
		defenders.add("Defender 5");
		midfielders.add("Midfielder 1");
		midfielders.add("Midfielder 2");
		midfielders.add("Midfielder 3");
		midfielders.add("Midfielder 4");
		midfielders.add("Midfielder 5");
		strikers.add("Forward 1");
		strikers.add("Forward 2");
		strikers.add("Forward 3");
		List<List<String>> excepted = new ArrayList<List<String>>(4) {{add(goalkeepers);add(defenders);add(midfielders);add(strikers);}};
		
		assertEquals(15,compareListsOfLists(excepted, actual));
	}
	
	// This test will check if we can add two players to the same position
	@Test
	public void testIfAddGoalkeepers() throws InvalidPlayer, InvalidPosition {
		roster.addPlayerToRoster(players.get("Goalkeeper 1"));
		roster.addPlayerToRoster(players.get("Goalkeeper 2"));
		boolean b = roster.addPlayerToField(players.get("Goalkeeper 1"));
		assertTrue(b);
		b = roster.addPlayerToField(players.get("Goalkeeper 2"));
		assertFalse(b);
	}
	
	// This test will check if we can successfully add eleven players to the field and can't add the twelfth
	@Test
	public void testIfAddElevenAndTwelveToField() throws InvalidPlayer, InvalidPosition {
		// All 15 test players available in roster
		roster.addPlayerToRoster(players.get("Goalkeeper 1"));
		roster.addPlayerToRoster(players.get("Goalkeeper 2"));
		roster.addPlayerToRoster(players.get("Defender 1"));
		roster.addPlayerToRoster(players.get("Defender 2"));
		roster.addPlayerToRoster(players.get("Defender 3"));
		roster.addPlayerToRoster(players.get("Defender 4"));
		roster.addPlayerToRoster(players.get("Defender 5"));
		roster.addPlayerToRoster(players.get("Midfielder 1"));
		roster.addPlayerToRoster(players.get("Midfielder 2"));
		roster.addPlayerToRoster(players.get("Midfielder 3"));
		roster.addPlayerToRoster(players.get("Midfielder 4"));
		roster.addPlayerToRoster(players.get("Midfielder 5"));
		roster.addPlayerToRoster(players.get("Forward 1"));
		roster.addPlayerToRoster(players.get("Forward 2"));
		roster.addPlayerToRoster(players.get("Forward 3"));
		
		boolean b;
		roster.addPlayerToField(players.get("Goalkeeper 1"));	
		b = roster.addPlayerToField(players.get("Defender 1"));		assertTrue(b);
		b = roster.addPlayerToField(players.get("Defender 2"));		assertTrue(b);
		b = roster.addPlayerToField(players.get("Midfielder 1"));	assertTrue(b);
		b = roster.addPlayerToField(players.get("Midfielder 2"));	assertTrue(b);
		b = roster.addPlayerToField(players.get("Midfielder 3"));	assertTrue(b);
		b = roster.addPlayerToField(players.get("Midfielder 4"));	assertTrue(b);
		b = roster.addPlayerToField(players.get("Midfielder 5"));	assertTrue(b);
		b = roster.addPlayerToField(players.get("Forward 1"));		assertTrue(b);
		b = roster.addPlayerToField(players.get("Forward 2"));		assertTrue(b);
		b = roster.addPlayerToField(players.get("Forward 3"));		assertTrue(b);
		
		// Test if we're not able to add the 12th player to the field
		b = roster.addPlayerToField(players.get("Defender 3"));
		assertFalse(b);
	}
	
	// Test if we remove a player that's in the roster.
	@SuppressWarnings("serial")
	@Test
	public void testRemoveFromRoster() throws InvalidPosition, InvalidPlayer{
		roster.addPlayerToRoster(players.get("Goalkeeper 1"));
		roster.removePlayerFromRoster(players.get("Goalkeeper 1"));
		
		// Check if the roster is empty
		List<List<Player>> actual = roster.getPlayersInRoster();
		List<List<String>> excepted = new ArrayList<List<String>>(4) {{add(goalkeepers);add(defenders);add(midfielders);add(strikers);}};
		assertEquals(0,compareListsOfLists(excepted, actual));
	}
	
	// This test if check if the variable NumberOfPlayersOfField is accurate.
	@Test
	public void testNumberOfPlayersOnField() throws InvalidPosition, InvalidPlayer {
		assertEquals(0,roster.getNumberOfPlayersOnField());
		roster.addPlayerToRoster(players.get("Goalkeeper 1"));
		roster.addPlayerToRoster(players.get("Defender 2"));
		assertEquals(0,roster.getNumberOfPlayersOnField());
		roster.addPlayerToField(players.get("Goalkeeper 1"));
		assertEquals(1,roster.getNumberOfPlayersOnField());
		roster.addPlayerToField(players.get("Defender 2"));
		assertEquals(2,roster.getNumberOfPlayersOnField());
		roster.removePlayerFromField(players.get("Goalkeeper 1"));
		assertEquals(1,roster.getNumberOfPlayersOnField());
		roster.removePlayerFromField(players.get("Defender 2"));
		assertEquals(0,roster.getNumberOfPlayersOnField());
	}
	
	// This test will test the isInRoster function.
	@Test
	public void testIsInRoster() throws InvalidPosition, InvalidPlayer{
		roster.addPlayerToRoster(players.get("Goalkeeper 1"));
		roster.addPlayerToRoster(players.get("Defender 2"));
		assertTrue(roster.isInRoster(players.get("Goalkeeper 1")));
		assertFalse(roster.isInRoster(players.get("Goalkeeper 2")));
		assertTrue(roster.isInRoster(players.get("Defender 2")));
		
	}
}