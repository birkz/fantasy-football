package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import frontend.Main;

public class StartGameTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Main.createAndShowGUI();
		List<String> names = new ArrayList<String>();
		names.add("J�n");
		names.add("P�tur");
		Main.startGame(names);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreatedUsers() {
		assertNotSame(backend.MainGame.getUser(0).getName(), "P�tur");
		assertSame(backend.MainGame.getUser(1).getName(), "P�tur");
	}

}
