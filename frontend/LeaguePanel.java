package is.hi.f2a.frontend;

import is.hi.f1a.FantasyFootballBackend;
import is.hi.f1a.Game;
import is.hi.f1a.GameEvent;
import is.hi.f1a.League;
import is.hi.f1a.Team;
import is.hi.f2a.backend.FontUtil;
import is.hi.f2a.backend.MainGame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
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
	private JScrollPane eventScroll;

	/**
	 * Create the panel.
	 */
	public LeaguePanel(boolean isEnd) {
		MainGame mainGame = MainGame.getInstance();
		
		setLayout(new GridLayout(3, 1, 0, 0));
		
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
		add(new JScrollPane(table));
		
		int showPlan = 1; // how long a plan do you want to see 1 round or more
		final ArrayList<Game> games = league.getGames();
		String[] columnNames2 = {"HomeTeam", "AwayTeam", "Score", "Round","Status"};
		final int numGames;
		if(isEnd) numGames = 50;
		else numGames = (mainGame.getRound()+showPlan)*5;
		data = new Object[numGames][];
		int round = mainGame.getRound()+1;
		if(isEnd) round = 18;
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
		
		final JTable tableGames = new JTable(data, columnNames2){
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
		tableGames.setEnabled(true);
		tableGames.addMouseListener(new MouseAdapter(){
			@Override
		      public void mouseClicked(MouseEvent e) {
		            int row = tableGames.rowAtPoint(e.getPoint());//get mouse-selected row
		            System.out.println(row);
		            addGameEvents(games.get(numGames-row-1));
		      }
		});
		tableGames.getColumn("Score").setMaxWidth(60);
		tableGames.getColumn("Round").setMaxWidth(60);
		tableGames.setShowGrid(false);
		tableGames.setFont(FontUtil.getFont("kalinga", Font.PLAIN, fontsize));
		add(new JScrollPane(tableGames));
		
		eventScroll = new JScrollPane();
		JLabel label = new JLabel("Game Events!");
		label.setFont(FontUtil.getFont("kalinga", Font.BOLD, 20));
	    label.setHorizontalAlignment(JLabel.CENTER);
	    label.setVerticalAlignment(JLabel.CENTER);
	    eventScroll.setColumnHeaderView(label);
	    eventScroll.setViewportView(new JLabel("Click a finished game to see events!"));
		add(eventScroll);
	}
	
	private void addGameEvents(Game game) {	    
		JPanel wrapper = new JPanel(new GridBagLayout());
		ArrayList<GameEvent> events = game.getGameEvents();
		if(events.size()>0) {
			JPanel gameEvents = new JPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 0;
			JLabel team =new JLabel(game.getHomeTeam().getName()+ 
					" vs " + game.getAwayTeam().getName());
			team.setFont(FontUtil.getFont("kalinga", Font.BOLD, 15));
			gameEvents.add(team , c);
			for(int k=0; k<events.size(); ++k) {
				GameEvent event = events.get(k);
				if(!event.getEvent().equals(GameEvent.Event.SUBSTITUTION_OFF) && !event.getEvent().equals(GameEvent.Event.SUBSTITUTION_ON) && 
						!event.getEvent().equals(GameEvent.Event.ASSIST)) {
					c.gridy++;
					JLabel currentEvent;
					if(event.getEvent().equals(GameEvent.Event.GOAL)){
						currentEvent = new JLabel(event.getPlayer() +" scored a goal on "+ event.getMinute() + " minute.");
					}
					else if(event.getEvent().equals(GameEvent.Event.YELLOW_CARD)){
						currentEvent = new JLabel(event.getPlayer() +" got a yellow card on " + event.getMinute() + " minute.");
					}
					else if(event.getEvent().equals(GameEvent.Event.RED_CARD)){
						currentEvent = new JLabel(event.getPlayer() +" got a red card on " + event.getMinute() + " minute.");
					}
					else if(event.getEvent().equals(GameEvent.Event.OWN_GOAL)){
						currentEvent = new JLabel(event.getPlayer() +" scored a own goal on "+ event.getMinute() + " minute.");
					}
					else {
						currentEvent = new JLabel("Player named "+event.getPlayer() +" on "+ event.getMinute() + " minute: " + event.getEvent());
					}
					gameEvents.setFont(FontUtil.getFont("kalinga", Font.BOLD, 12));
					gameEvents.add(currentEvent, c);
				}
			}
			c.gridy = c.gridy + 1;
			gameEvents.add(new JLabel("-----------------------------"), c);
			wrapper.add(gameEvents);
			eventScroll.setViewportView(wrapper);
		}
		else eventScroll.setViewportView(new JLabel("Click a finished game to see events!"));
		eventScroll.repaint();
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
