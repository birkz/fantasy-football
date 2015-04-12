package backend;

import java.util.ArrayList;
import java.util.List;

//import tests.*;

public class ObjectScores {
	
	private Object object;
	private List<Integer> scores;
	
	public ObjectScores(Object object) {
		this.object = object;
		this.scores = new ArrayList<Integer>();
	}
	
	public void addScore(int score) {
		this.scores.add(score);
	}
	
	public List<Integer> getScores() {
		return this.scores;
	}
	
	public Object getObject() {
		return this.object;
	}
	
}
