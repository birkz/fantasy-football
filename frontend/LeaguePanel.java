package is.hi.f2a.frontend;

import is.hi.f1a.FantasyFootballBackend;
import is.hi.f1a.Game;
import is.hi.f1a.League;
import is.hi.f1a.Team;
import is.hi.f2a.backend.FontUtil;
import is.hi.f2a.backend.MainGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class LeaguePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int fontsize = 13;

	/**
	 * Create the panel.
	 */
	public LeaguePanel(boolean isEnd) {
		MainGame mainGame = MainGame.getInstance();
		
		setLayout(new BorderLayout(0, 0)); 
		String[] columnNames = {"POS", "CLUB", "P", "W", "D", "L", "GF", "GA", "GD", "PTS"};
		League league = FantasyFootballBackend.getInstance().getLeague();

		ArrayList<Team> teams = new ArrayList<Team>(league.getTeams());
		getOrderedTeams(teams);

		Object[][] data = new Object[teams.size()][];
		for(int i=0; i<teams.size(); ++i) {
			Team current = teams.get(i);
			Object[] team = new Object[]{new Integer(i+1), current.getName(), MainGame.getInstance().getRound(), 
					current.getWins(), current.getDraws(), current.getLosses(), current.getGoalsScored(), 
					current.getGoalsConceded(), current.getGoalsScored()- current.getGoalsConceded(), current.getPoints()};
			data[i] = team;
		}
		
		JTable table = new JTable(data, columnNames){
			private static final long serialVersionUID = 1L;
			
			public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int vColIndex) {
		        Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
		        if (rowIndex % 2 == 0) {
		          c.setBackground(new Color(0,0,255,42));
		        } else {
		          c.setBackground(getBackground());
		        }
		        return c;
		    }
		};
		
		table.setEnabled(false);
		table.getColumn("CLUB").setPreferredWidth(300);
		table.setShowGrid(false);
		table.setBackground(Color.WHITE);
		table.setFont(FontUtil.getFont("kalinga", Font.PLAIN, fontsize));
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		int showPlan = 1; // how long a plan do you want to see 1 round or more
		ArrayList<Game> games = league.getGames();
		String[] columnNames2 = {"HomeTeam", "AwayTeam", "Score", "Round","Status"};
		int numGames = (mainGame.getRound()+showPlan)*5;
		if(isEnd) numGames = 50;
		data = new Object[numGames][];
		int round = mainGame.getRound()+1;
		if(isEnd) round = 10;
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
		
		JTable tableGames = new JTable(data, columnNames2){
			private static final long serialVersionUID = 1L;
			
			public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int vColIndex) {
		        Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
		        if (rowIndex % 2 == 0) {
		          c.setBackground(new Color(0,0,255,42));
		        } else {
		          c.setBackground(getBackground());
		        }
		        return c;
		    }
		};
		tableGames.setEnabled(false);
		tableGames.getColumn("Score").setMaxWidth(60);
		tableGames.getColumn("Round").setMaxWidth(60);
		tableGames.setShowGrid(false);
		tableGames.setFont(FontUtil.getFont("kalinga", Font.PLAIN, fontsize));
		add(new JScrollPane(tableGames), BorderLayout.SOUTH);
	}
	
	private void getOrderedTeams(ArrayList<Team> teams) {
		for (int i=0; i<teams.size(); ++i) {
			int j = i;
			while(j>0) {
				if(teams.get(j-1).getPoints() < teams.get(j).getPoints()
						||
						(teams.get(j-1).getPoints() == teams.get(j).getPoints() &&
						teams.get(j-1).getGoalsScored()-teams.get(j-1).getGoalsConceded() < 
						teams.get(j).getGoalsScored()-teams.get(j).getGoalsConceded()
						) || (
						teams.get(j-1).getPoints() == teams.get(j).getPoints() &&
						teams.get(j-1).getGoalsScored()-teams.get(j-1).getGoalsConceded() == 
						teams.get(j).getGoalsScored()-teams.get(j).getGoalsConceded() &&
						teams.get(j-1).getGoalsScored() < teams.get(j).getGoalsScored()
						) || (
						teams.get(j-1).getPoints() == teams.get(j).getPoints() &&
						teams.get(j-1).getGoalsScored()-teams.get(j-1).getGoalsConceded() == 
						teams.get(j).getGoalsScored()-teams.get(j).getGoalsConceded() &&
						teams.get(j-1).getGoalsScored() == teams.get(j).getGoalsScored() &&
						teams.get(j-1).getWins() < teams.get(j).getWins()
						)
						) {
					Team tmp = teams.get(j-1);
					teams.set(j-1, teams.get(j));
					teams.set(j, tmp);
				}
				--j;
			}
		}
	}

}
