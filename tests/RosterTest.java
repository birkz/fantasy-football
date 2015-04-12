package tests;

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

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import is.hi.f1a.Player;
import is.hi.f1a.Player.Position;
import is.hi.f2a.backend.Roster;
import is.hi.f2a.res.Constants;
=======
import backend.Roster;
import tests.PlayerInterface;
>>>>>>> parent of 74cfc3e... push to pull
=======
import backend.Roster;
import tests.PlayerInterface.*;
import res.Constants;
>>>>>>> parent of 64162c5... more changes for the integration
=======
import backend.Roster;
import tests.PlayerInterface.*;
import res.Constants;
>>>>>>> parent of 64162c5... more changes for the integration

public class RosterTest {
	private static Roster roster;
	public static Map<String, PlayerMock> players;
	private static List<String> goalkeepers;
	private static List<String> defenders;
	private static List<String> midfielders;
	private static List<String> strikers;
	
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	private static Player goalkeeper1;
	private static Player goalkeeper2;
	private static Player goalkeeper3;
	private static Player goalkeeper4;
=======
	private static PlayerMock goalkeeper1;
	private static PlayerMock goalkeeper2;
	private static PlayerMock goalkeeper3;
	
	private static PlayerMock invalid_pos1;
>>>>>>> parent of 74cfc3e... push to pull
=======
	private static PlayerMock goalkeeper1;
	private static PlayerMock goalkeeper2;
	private static PlayerMock goalkeeper3;
	private static PlayerMock goalkeeper4;
>>>>>>> parent of 64162c5... more changes for the integration
	
	private static PlayerMock defender1;
	private static PlayerMock defender2;
	private static PlayerMock defender3;
	private static PlayerMock defender4;
	private static PlayerMock defender5;
	
	private static PlayerMock midfielder1;
	private static PlayerMock midfielder2;
	private static PlayerMock midfielder3;
	private static PlayerMock midfielder4;
	private static PlayerMock midfielder5;
	
=======
	private static PlayerMock goalkeeper1;
	private static PlayerMock goalkeeper2;
	private static PlayerMock goalkeeper3;
	private static PlayerMock goalkeeper4;
	
	private static PlayerMock defender1;
	private static PlayerMock defender2;
	private static PlayerMock defender3;
	private static PlayerMock defender4;
	private static PlayerMock defender5;
	
	private static PlayerMock midfielder1;
	private static PlayerMock midfielder2;
	private static PlayerMock midfielder3;
	private static PlayerMock midfielder4;
	private static PlayerMock midfielder5;
	
>>>>>>> parent of 64162c5... more changes for the integration
	private static PlayerMock striker1;
	private static PlayerMock striker2;
	private static PlayerMock striker3;
	
	@BeforeClass
	public static void setUpBeforeClass() {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		goalkeeper1 = new Player("Goalkeeper 1",Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		goalkeeper2 = new Player("Goalkeeper 2",Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		goalkeeper3 = new Player("Goalkeeper 3",Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		goalkeeper4 = new Player("Goalkeeper 4",Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
=======
=======
>>>>>>> parent of 64162c5... more changes for the integration
		goalkeeper1 = new PlayerMock("Goalkeeper 1",Position.GOALKEEPER);
		goalkeeper2 = new PlayerMock("Goalkeeper 2",Position.GOALKEEPER);
		goalkeeper3 = new PlayerMock("Goalkeeper 3",Position.GOALKEEPER);
		goalkeeper4 = new PlayerMock("Goalkeeper 4",Position.GOALKEEPER);
<<<<<<< HEAD
>>>>>>> parent of 64162c5... more changes for the integration
=======
>>>>>>> parent of 64162c5... more changes for the integration
		
		defender1 = new PlayerMock("Defender 1",Position.DEFENDER);
		defender2 = new PlayerMock("Defender 2",Position.DEFENDER);
		defender3 = new PlayerMock("Defender 3",Position.DEFENDER);
		defender4 = new PlayerMock("Defender 4",Position.DEFENDER);
		defender5 = new PlayerMock("Defender 5",Position.DEFENDER);
		
		midfielder1 = new PlayerMock("Midfielder 1",Position.MIDFIELDER);
		midfielder2 = new PlayerMock("Midfielder 2",Position.MIDFIELDER);
		midfielder3 = new PlayerMock("Midfielder 3",Position.MIDFIELDER);
		midfielder4 = new PlayerMock("Midfielder 4",Position.MIDFIELDER);
		midfielder5 = new PlayerMock("Midfielder 5",Position.MIDFIELDER);
		
<<<<<<< HEAD
<<<<<<< HEAD
		striker1 = new Player("Forward 1",Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		striker2 = new Player("Forward 2",Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		striker3 = new Player("Forward 3",Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
=======
		goalkeeper1 = new PlayerMock("Goalkeeper 1","Goalkeeper");
		goalkeeper2 = new PlayerMock("Goalkeeper 2","Goalkeeper");
		goalkeeper3 = new PlayerMock("Goalkeeper 3","Goalkeeper");
		
		invalid_pos1 = new PlayerMock("Football fan","Couch potato");
		
		defender1 = new PlayerMock("Defender 1","Defender");
		defender2 = new PlayerMock("Defender 2","Defender");
		defender3 = new PlayerMock("Defender 3","Defender");
		defender4 = new PlayerMock("Defender 4","Defender");
		defender5 = new PlayerMock("Defender 5","Defender");
		
		midfielder1 = new PlayerMock("Midfielder 1","Midfielder");
		midfielder2 = new PlayerMock("Midfielder 2","Midfielder");
		midfielder3 = new PlayerMock("Midfielder 3","Midfielder");
		midfielder4 = new PlayerMock("Midfielder 4","Midfielder");
		midfielder5 = new PlayerMock("Midfielder 5","Midfielder");
		
		striker1 = new PlayerMock("Striker 1","Striker");
		striker2 = new PlayerMock("Striker 2","Striker");
		striker3 = new PlayerMock("Striker 3","Striker");
>>>>>>> parent of 74cfc3e... push to pull
=======
		striker1 = new PlayerMock("Forward 1",Position.FORWARD);
		striker2 = new PlayerMock("Forward 2",Position.FORWARD);
		striker3 = new PlayerMock("Forward 3",Position.FORWARD);
>>>>>>> parent of 64162c5... more changes for the integration
		
=======
		striker1 = new PlayerMock("Forward 1",Position.FORWARD);
		striker2 = new PlayerMock("Forward 2",Position.FORWARD);
		striker3 = new PlayerMock("Forward 3",Position.FORWARD);
		
>>>>>>> parent of 64162c5... more changes for the integration
		players = new HashMap<String, PlayerMock>();
		players.put(goalkeeper1.getName(),goalkeeper1);
		players.put(goalkeeper2.getName(),goalkeeper2);
		players.put(goalkeeper3.getName(),goalkeeper3);
		
		players.put(invalid_pos1.getName(),invalid_pos1);
		
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
		goalkeepers = new ArrayList<String>(2);
		defenders = new ArrayList<String>(5);
		midfielders = new ArrayList<String>(5);
		strikers = new ArrayList<String>(3);
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
	public int compareListsOfLists(List<List<String>> expected, List<List<PlayerInterface>> actual) throws IllegalStateException{
		// Count the number of matches
		int matches = 0;
		
		// If the two lists (of lists) have different number of elements, throw exception.
		if (actual.size() != expected.size()){
			throw new IllegalStateException("Sizes of lists containing lists not the same: "+expected.size()+" and "+actual.size());
		}
		
		// Create an iterator for both lists (of lists)
		Iterator<List<PlayerInterface>> playerlist_iterator = actual.iterator();
		Iterator<List<String>> expected_playerlist_iterator = expected.iterator();
		
		// Loop through the lists
		while(playerlist_iterator.hasNext()){
			List<PlayerInterface> playerlist = playerlist_iterator.next();
			List<String> expected_playerlist = expected_playerlist_iterator.next();
			
			if (playerlist.size() != expected_playerlist.size()){
				throw new IllegalStateException("Sizes of lists not the same: "+expected_playerlist.size()+" and "+playerlist.size());
			}
			
			Iterator<PlayerInterface> player_iterator = playerlist.iterator();
			Iterator<String> expected_player_iterator = expected_playerlist.iterator();
			
			while(player_iterator.hasNext()){
				String expected_player = expected_player_iterator.next();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
				Player player = player_iterator.next();
=======
				PlayerInterface player = player_iterator.next();
>>>>>>> parent of 64162c5... more changes for the integration
=======
				PlayerInterface player = player_iterator.next();
>>>>>>> parent of 64162c5... more changes for the integration
				if(!player.getName().equals(expected_player)){
					throw new IllegalStateException("Player: "+player.getName()+" not the same as "+expected_player);
=======
				if(player_iterator.next().getName() != expected_player){
					return -1;
>>>>>>> parent of 74cfc3e... push to pull
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
		List<List<PlayerInterface>> actual = roster.getPlayersInRoster();
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
		List<List<PlayerInterface>> actual = roster.getPlayersInRoster();
		
		// Create the expected outcome of the test
		goalkeepers.add("Goalkeeper 1");
		List<List<String>> excepted = new ArrayList<List<String>>(4) {{add(goalkeepers);add(defenders);add(midfielders);add(strikers);}};
		
		assertEquals(1,compareListsOfLists(excepted, actual));
	}
	
	// This test will check if we get an exception when adding a player with a different position
	@Test
	public void testIfInvalidPlayer() throws InvalidPosition {
		Throwable exception = null;
		// Add the player "Football fan" to the roster
		try{
			roster.addPlayerToRoster(players.get("Football fan"));
		} catch (Throwable e) {
			exception = e;
		}
		assertNotNull(exception);
		assertSame(InvalidPosition.class,exception.getClass());
	}
	
	// This test will check if we will receive "false" from the addPlayerToRoster() method if we try
	// to add too many players to the same position.
	@SuppressWarnings("serial")
	@Test
	public void testIfThreePlayers() throws InvalidPosition {
		// Add the player "Goalkeeper 1" to the roster
		roster.addPlayerToRoster(players.get("Goalkeeper 1"));
		boolean add = roster.addPlayerToRoster(players.get("Goalkeeper 2"));
		assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Goalkeeper 3"));
		assertFalse(add);
		
		// Get the roster players
		List<List<PlayerInterface>> actual = roster.getPlayersInRoster();
		
		// Create the expected outcome of the test
		goalkeepers.add("Goalkeeper 1");
		goalkeepers.add("Goalkeeper 2");
		List<List<String>> excepted = new ArrayList<List<String>>(4) {{add(goalkeepers);add(defenders);add(midfielders);add(strikers);}};
		
		assertEquals(2,compareListsOfLists(excepted, actual));
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
		add = roster.addPlayerToRoster(players.get("Striker 1"));		assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Striker 2"));		assertTrue(add);
		add = roster.addPlayerToRoster(players.get("Striker 3"));		assertTrue(add);
		
		// Get the roster players
		List<List<PlayerInterface>> actual = roster.getPlayersInRoster();
		
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
		strikers.add("Striker 1");
		strikers.add("Striker 2");
		strikers.add("Striker 3");
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
		roster.addPlayerToRoster(players.get("Striker 1"));
		roster.addPlayerToRoster(players.get("Striker 2"));
		roster.addPlayerToRoster(players.get("Striker 3"));
		
		boolean b;
		roster.addPlayerToField(players.get("Goalkeeper 1"));	
		b = roster.addPlayerToField(players.get("Defender 1"));		assertTrue(b);
		b = roster.addPlayerToField(players.get("Defender 2"));		assertTrue(b);
		b = roster.addPlayerToField(players.get("Midfielder 1"));	assertTrue(b);
		b = roster.addPlayerToField(players.get("Midfielder 2"));	assertTrue(b);
		b = roster.addPlayerToField(players.get("Midfielder 3"));	assertTrue(b);
		b = roster.addPlayerToField(players.get("Midfielder 4"));	assertTrue(b);
		b = roster.addPlayerToField(players.get("Midfielder 5"));	assertTrue(b);
		b = roster.addPlayerToField(players.get("Striker 1"));		assertTrue(b);
		b = roster.addPlayerToField(players.get("Striker 2"));		assertTrue(b);
		b = roster.addPlayerToField(players.get("Striker 3"));		assertTrue(b);
		
		// Test if adding a player that is not in the roster will throw the InvalidPlayer exception
		Throwable exception = null;
		try{
			roster.addPlayerToField(players.get("Football fan"));
		} catch (Throwable e) {
			exception = e;
		}
		assertNotNull(exception);
		assertSame(InvalidPlayer.class,exception.getClass());
		
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
		List<List<PlayerInterface>> actual = roster.getPlayersInRoster();
		List<List<String>> excepted = new ArrayList<List<String>>(4) {{add(goalkeepers);add(defenders);add(midfielders);add(strikers);}};
		assertEquals(0,compareListsOfLists(excepted, actual));
	}
	
	// Test if we remove a player that's NOT in the roster.
	@Test
	public void testRemoveInvalidPlayer() {
		Throwable exception = null;
		try{
			roster.removePlayerFromRoster(players.get("Goalkeeper 1"));
		} catch (Throwable e) {
			exception = e;
		}
		assertNotNull(exception);
		assertSame(InvalidPlayer.class,exception.getClass());
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
}