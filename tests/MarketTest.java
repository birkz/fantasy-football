package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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
	public void testName() {
		assertEquals("Einar", market.getPlayerByName("Einar").getName());
	}
	
	@Test
	public void testTeam() {
		assertEquals("Fylkir", market.getPlayersByTeam("Fylkir").get(0).getTeam());
	}

}
