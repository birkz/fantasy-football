package backend;

import java.util.ArrayList;
import java.util.List;

//import tests.*;

public class ObjectScores {
	
	private Object object;
	private List<Integer> scores;
	private List<Integer> totalscores;
	
	public ObjectScores(Object object) {
		this.object = object;
		this.scores = new ArrayList<Integer>();
		this.totalscores = new ArrayList<Integer>();
	}
	
	public void addScore(int score) {
		int lastindex = this.scores.size();
		int lastscore;
		if(lastindex != 0) lastscore = this.totalscores.get(lastindex-1);
		else lastscore = 0;
		this.scores.add(score);
		this.totalscores.add(lastscore + score);
	}
	
	public List<Integer> getScores() {
		return this.scores;
	}
	
	public List<Integer> getTotalScores() {
		return this.totalscores;
	}
	
	public Object getObject() {
		return this.object;
	}
	
}
