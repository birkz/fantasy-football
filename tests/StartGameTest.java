package is.hi.f2a.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

<<<<<<< HEAD
import is.hi.f2a.backend.MainGame;
import is.hi.f2a.backend.User;
import is.hi.f2a.frontend.Main;
=======
import frontend.Main;
>>>>>>> parent of 74cfc3e... push to pull

public class StartGameTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Main.getInstance().createAndShowGUI();
		List<String> names = new ArrayList<String>();
		names.add("Jón");
		names.add("Pétur");
		Main.getInstance().startGame(names);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreatedUsers() {
		assertNotSame(backend.MainGame.getInstance().getUser(0).getName(), "Pétur");
		assertSame(backend.MainGame.getInstance().getUser(1).getName(), "Pétur");
	}

}
