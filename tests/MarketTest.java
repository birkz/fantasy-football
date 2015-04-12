package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
//import java.util.List;

import backend.Market;

public class MarketTest {
	
	private static Market market;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		market = new Market();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		market = null;
	}
	
	@Test
	public void testIfEmpty() {
		assertNotNull(market.getAllPlayers());
	}

	@Test
	public void testName() {
		assertEquals("Einar", market.getPlayerByName("Einar").getName());
	}
	
	/*
	@Test
	public void testFindingRightTeam() {
		List<PlayerInterface> teamtest = market.getPlayersByTeam("Fylkir");
		for(PlayerInterface temp : teamtest) {
			//assertEquals("Fylkir", temp.getTeam());
		}
	}
	*/

}
