package tests;

import java.util.List;
import java.util.Random;

import backend.MainGame;
import backend.User;

public class RoundMock {
	
	public static void SimRound(int numUsers) {
		List<User> users = MainGame.getInstance().getUsers();
		int min = 1;
		int max = 80;
		Random rand = new Random();
		for(int i=0; i<numUsers; ++i) {
			int num = rand.nextInt((max - min) + 1) + min;
			List<Integer> score = users.get(i).getScore();
			if(score.size()>0) num += users.get(i).getScore().get(score.size()-1);
			users.get(i).addScore(num);
		}
	}

}
