package is.hi.f2a.tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import is.hi.f2a.backend.User;

public class UserTest {
	
	private static User user;

	// This test, tests the class that holds onto the users of the game.
	// We setup the test with one new user which takes in "user1" as its name.
	
	@BeforeClass
	public static void setUp() throws Exception {
		user = new User("user1", 0);
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
		user.setName("user2");
		assertEquals("user2", user.getName());
	}
	
	// This test checks if the score from round 0 goes to index 0
	@Test
	public void scoreTest() {
		user.setScore(100);
		int score = user.getScore();
		assertEquals(100, score);
	}
	
	// This test checks if the changes to the money of the user behave as intended
	// where the user can't have negative money and no money is subtracted if that subtraction 
	// would set the users money below zero
	@Test
	public void testChangingMoney() throws Exception {
		
		// Money is 0
		user.changeMoney(1000);
		assertEquals(3000, user.getMoney());
		
		// Money is 3000
		int curr = user.getMoney();
		user.changeMoney(-2900);
		assertEquals(curr-2900, user.getMoney());
		
		// Money is 100
		curr = user.getMoney();
		if(user.isAffordable(curr))
			user.changeMoney(-200);
		assertEquals(curr, user.getMoney());
		// Money is still 100 cause you can't get negative money
	}
}
