package tests;

import java.util.ArrayList;
import java.util.List;

public class LeagueMock {

	private List<TeamMock> teams;
	
	/*
	 * Constructor
	 */
	public LeagueMock(){
		
		this.teams = new ArrayList<TeamMock>(10);
		this.teams.add(new TeamMock());
		this.teams.add(new TeamMock(0));
		this.teams.add(new TeamMock(1));
		this.teams.add(new TeamMock(2));
		this.teams.add(new TeamMock(3));
		this.teams.add(new TeamMock(4));
		this.teams.add(new TeamMock(5));
		this.teams.add(new TeamMock(6));
		this.teams.add(new TeamMock(7));
		this.teams.add(new TeamMock(8));
	}
	
	/*
	 * Returns all teams in a list.
	 */
	public List<TeamMock> getTeams(){
		return this.teams;
	}
	
}
