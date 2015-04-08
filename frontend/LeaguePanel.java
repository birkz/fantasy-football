package is.hi.f2a.frontend;

import is.hi.f1a.FantasyFootballBackend;
import is.hi.f1a.Game;
import is.hi.f1a.League;
import is.hi.f1a.Team;
import is.hi.f2a.backend.MainGame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class LeaguePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public LeaguePanel() {
		setLayout(new BorderLayout(0, 0)); 
		String[] columnNames = {"POS", "CLUB", "P", "W", "D", "L", "GF", "GA", "GD", "PTS"};
		League league = FantasyFootballBackend.getInstance().getLeague();
		ArrayList<Team> teams = league.getTeams();
		Object[][] data = new Object[teams.size()][];
		for(int i=0; i<teams.size(); ++i) {
			Team current = teams.get(i);
			Object[] team = new Object[]{new Integer(i+1), current.getName(), MainGame.getInstance().getRound(), 
					current.getWins(), current.getDraws(), current.getLosses(), current.getGoalsScored(), 
					current.getGoalsConceded(), current.getGoalsScored()- current.getGoalsConceded(), current.getPoints()};
			data[i] = team;
		}
		JTable table = new JTable(data, columnNames);
		table.setEnabled(true);
		table.getColumn("CLUB").setPreferredWidth(300);
		JScrollPane scroll = new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
		
		ArrayList<Game> games = league.getGames();
		String[] columnNames2 = {"HomeTeam", "AwayTeam", "HomeScore", "AwayScore"};
		data = new Object[games.size()][];
		for(int i=0; i<games.size(); ++i) {
			Game current = games.get(i);
			Object[] game = new Object[]{current.getHomeTeam().getName(), current.getAwayTeam().getName(), 
					current.getHomeScore(), current.getAwayScore()};
			System.out.print(games.get(i).getHomeTeam().getName());
			System.out.println(" - "+games.get(i).getAwayTeam().getName());
			data[i] = game;
		}
		JTable tableGames = new JTable(data, columnNames2);
		tableGames.setEnabled(true);
		JScrollPane scroll2 = new JScrollPane(tableGames);
		add(scroll2, BorderLayout.SOUTH);
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }

}
