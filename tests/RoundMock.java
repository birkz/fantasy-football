package tests;

import java.util.Random;

public class RoundMock {
	
	public static void SimRound(int numUsers, int round) {
		int min = 1;
		int max = 80;
		Random rand = new Random();
		for(int i=0; i<numUsers; ++i) {
			int num = rand.nextInt((max - min) + 1) + min;
			if(round>0) num += backend.MainGame.getInstance().getUser(i).getScore()[round-1];
			backend.MainGame.getInstance().getUser(i).addScore(round, num);
		}
	}

}
