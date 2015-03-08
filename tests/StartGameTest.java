package tests;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import frontend.Main;

public class StartGameTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Main.createAndShowGUI();
		Main.startGame(2);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void leftRighttest() {
		//assertNotSame(Main.left, Main.right);
	}

}
