package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.User;

public class UserTest {
	
	private static User user;

	@BeforeClass
	public static void setUp() throws Exception {
		user = new User("user1");
	}

	@AfterClass
	public static void tearDown() throws Exception {
		user = null;
	}
	
	@Test
	public void checkRoster() {
		assertNotNull(user.getRoster());
	}
	
	@Test 
	public void nameChange() {
		user.changeName("user2");
		assertEquals("user2", user.getName());
	}
	
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
