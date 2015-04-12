package tests;

import java.util.Random;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import is.hi.f2a.backend.MainGame;
import is.hi.f2a.backend.StatsHistory;
import is.hi.f2a.backend.User;
=======
import backend.MainGame;
import backend.StatsHistory;
import backend.User;
>>>>>>> parent of 64162c5... more changes for the integration
=======
import backend.MainGame;
import backend.StatsHistory;
import backend.User;
>>>>>>> parent of 64162c5... more changes for the integration

=======
>>>>>>> parent of 74cfc3e... push to pull
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
