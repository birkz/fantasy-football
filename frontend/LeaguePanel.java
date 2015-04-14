package is.hi.f2a.frontend;

import is.hi.f1a.FantasyFootballBackend;
import is.hi.f1a.Game;
import is.hi.f1a.League;
import is.hi.f1a.Team;
import is.hi.f2a.backend.MainGame;

import java.awt.BorderLayout;
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
		MainGame mainGame = MainGame.getInstance();
		
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
		table.setEnabled(false);
		table.getColumn("CLUB").setPreferredWidth(300);
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		int showPlan = 1; // how long a plan do you want to see 1 round or more
		if(mainGame.getRound()==10) showPlan = 0;
		ArrayList<Game> games = league.getGames();
		String[] columnNames2 = {"HomeTeam", "AwayTeam", "Score", "Round","Status"};
		int numGames = (mainGame.getRound()+showPlan)*5;
		data = new Object[numGames][];
		int round = mainGame.getRound()+1;
		String status = "Planned";
		int k = 0;
		for(int i=numGames-1; i>=0; --i) {
			Game current = games.get(i);
			if(mainGame.getRound()==round) status = "Finished";
			Object[] game = new Object[]{current.getHomeTeam().getName(), current.getAwayTeam().getName(), 
					current.getHomeScore()+" - "+current.getAwayScore(), round, status};
			data[k] = game;
			if((k+1)%5 == 0) round--;
			k++;
		}
		JTable tableGames = new JTable(data, columnNames2);
		tableGames.setEnabled(false);
		tableGames.getColumn("Score").setMaxWidth(60);
		tableGames.getColumn("Round").setMaxWidth(60);
		add(new JScrollPane(tableGames), BorderLayout.SOUTH);
	}
}
