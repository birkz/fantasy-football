package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.MainGame;

public class CreateUser{

	@BeforeClass
	public static void setUp() throws Exception {
		MainGame.setNumUsers(2);
		MainGame.createUser("player"+0);
		MainGame.createUser("player"+1);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		//Comment to push
		//Push harder
	}
	
	@Test
	public void seeIfthere1() {
		assertNotNull(MainGame.getUser(0).getName());
	}

	@Test
	public void seeIfthere2() {
		assertNotNull(MainGame.getUser(1).getName());
	}

}
