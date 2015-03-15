package backend;

import java.util.ArrayList;
import java.util.List;

public class StatsHistory {
	
	List<ObjectScores> allplayerscores;
	List<ObjectScores> allrosterscores;
	List<ObjectScores> alluserscores;
	
	public StatsHistory() {
		this.allplayerscores = new ArrayList<ObjectScores>(150);
		this.allrosterscores = new ArrayList<ObjectScores>(MainGame.getNumUsers());
		this.alluserscores = new ArrayList<ObjectScores>(MainGame.getNumUsers());	
	}
	
	

}
