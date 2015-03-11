package tests;

import java.util.Random;

public class RoundMock {
	
	public static void SimRound(int numUsers, int round) {
		int min = 10;
		int max = 1000;
		Random rand = new Random();
		for(int i=0; i<numUsers; ++i) {
			int num = rand.nextInt((max - min) + 1) + min;
			if(round>0) num += backend.MainGame.getUser(i).getScore(round-1);
			backend.MainGame.getUser(i).addScore(round, num);
		}
	}

}
