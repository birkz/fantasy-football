package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.User;

public class UserTest {
	
	private static User user;

	// This test, tests the class that holds onto the users of the game.
	// We setup the test with one new user which takes in "user1" as its name.
	
	@BeforeClass
	public static void setUp() throws Exception {
		user = new User("user1");
	}

	@AfterClass
	public static void tearDown() throws Exception {
		user = null;
	}
	
	// This test checks if the user has a Roster
	@Test
	public void checkRoster() {
		assertNotNull(user.getRoster());
	}
	
	// This test checks if a name change goes though
	@Test 
	public void nameChange() {
		user.changeName("user2");
		assertEquals("user2", user.getName());
	}
	
	// This test checks if the score from round 0 goes to index 0
	@Test
	public void scoreTest() {
		user.addScore(0, 100);
		assertEquals(100, user.getScore()[0]);
	}
	
	// This test checks if the changes to the money of the user behave as intended
	// where the user can't have negative money and no money is subtracted if that subtraction 
	// would set the users money below zero
	@Test
	public void testChangingMoney() {
		
		// Money is 0
		assertTrue(user.changeMoney(1000));
		assertEquals(1000, user.getMoney());
		
		// Money is 1000
		int curr = user.getMoney();
		assertTrue(user.changeMoney(-900));
		assertEquals(curr-900, user.getMoney());
		
		// Money is 100
		curr = user.getMoney();
		assertFalse(user.changeMoney(-200));
		assertEquals(curr, user.getMoney());
		// Money is still 100 cause you can't get negative money
	}
}
