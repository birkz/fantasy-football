package is.hi.f2a.frontend;

import is.hi.f1a.League;
import is.hi.f1a.Player;
import is.hi.f1a.Player.Position;
import is.hi.f1a.Team;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

<<<<<<< HEAD
import is.hi.f2a.frontend.ButtonColumn;
import is.hi.f2a.frontend.Main;
import is.hi.f2a.tests.InvalidPlayer;
import is.hi.f2a.tests.InvalidPosition;
import is.hi.f2a.tests.InvalidUser;
=======
import tests.LeagueMock;
import tests.PlayerInterface;
import tests.PlayerMock;
import tests.TeamMock;
>>>>>>> parent of 74cfc3e... push to pull

public class MarketPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	private final JTextField field = new JTextField();
	private static League league = is.hi.f1a.FantasyFootballBackend.getInstance().getLeague();
=======
	private final JTextField field;
	private LeagueMock league;
>>>>>>> parent of 74cfc3e... push to pull
	private String player_choice;
	private String team_choice;
	private String pos_choice;
	private JTable jtable;
	private JScrollPane scroll;
	private JPanel wrapper;
<<<<<<< HEAD
	private String text;
	private List<Player> results;
=======
>>>>>>> parent of 74cfc3e... push to pull

	/**
	 * Create the panel.
	 */
<<<<<<< HEAD
	public MarketPanel(final JScrollPane scroll, final int value) {
=======
	public MarketPanel() {
		this.league = new LeagueMock();
>>>>>>> parent of 74cfc3e... push to pull
		this.player_choice = "";
		this.team_choice = "Any";
		this.pos_choice = "Any";
		this.jtable = null;
		this.scroll = null;
		this.wrapper = null;
		
		setLayout(new BorderLayout(0, 0)); 
		
		field = new JTextField();
		field.setPreferredSize(new Dimension(150, 30));
		field.addKeyListener(new KeyListener(){
			
			@Override
			public void keyReleased(KeyEvent e) {
				char ch = e.getKeyChar();
				//System.out.println("Char: "+ch);
				
				if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')){
					System.out.println(field.getText()+e.getKeyChar());
					player_choice = field.getText()+e.getKeyChar();
					refreshJTable();
				// If backspace is pressed
				} else if(e.getKeyCode() == 8) {
					if(field.getText().length() >= 1){
						System.out.println(field.getText().substring(0, field.getText().length()-1));
						player_choice = field.getText().substring(0, field.getText().length()-1);
					} else {
						player_choice = "";
					}
					
					refreshJTable();
				} else {
					System.out.println("Strange button: "+e.getKeyCode()+field.getText());
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {/* Not used*/}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}
			
		});
		
		refreshJTable();
	}
	
	public JPanel createEntry() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("hello what's up?"));
		return panel;
	}
	
	private JComboBox<String> addComboBox(List<String> choices, final String flag) {
		String[] choose = new String[choices.size()];
		for(int i=0; i<choices.size(); ++i) {
			choose[i] = choices.get(i);
		}
		final JComboBox<String> cb = new JComboBox<String>(choose);
		
		if(flag.equals("Team")){
			cb.setSelectedItem(this.team_choice);
		} else if(flag.equals("Pos")){
			cb.setSelectedItem(this.pos_choice);
        }
		
		cb.setVisible(true);
		cb.addActionListener(new ActionListener() {
            @SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e)
            {
            	JComboBox<String> cb = (JComboBox<String>) e.getSource();
                String chosen = (String)cb.getSelectedItem();

                if(flag.equals("Team") && !team_choice.equals(chosen)){
                	System.out.println("TEAM: "+chosen);
                	team_choice = chosen;
                	refreshJTable();
                	
                } else if(flag.equals("Pos") && !pos_choice.equals(chosen)){
                	System.out.println("POS: "+chosen);
                	pos_choice = chosen;
                	refreshJTable();
                }
                
            }
        }); 
		return cb;
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }
	
	/*
	 * Draw JTable
	 */
	private void refreshJTable(){
		
		if(jtable!=null){
			remove(jtable);
			remove(scroll);
			remove(wrapper);
		}
		
		jtable = getJTable(player_choice,team_choice,pos_choice);
		
		scroll = new JScrollPane(jtable);
		add(scroll);
		add(scroll, BorderLayout.CENTER);
		
		/*JButton search = new JButton("SEARCH");
		search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(e.getActionCommand() );
            }
        }); */

<<<<<<< HEAD
		List<Team> teams = MarketPanel.league.getTeams();
		Iterator<Team> teams_it = teams.iterator();
=======
		List<TeamMock> teams = this.league.getTeams();
		Iterator<TeamMock> teams_it = teams.iterator();
>>>>>>> parent of 74cfc3e... push to pull
		List<String> team_choices = new ArrayList<String>();
		team_choices.add("Any");
		
		while(teams_it.hasNext()){
			team_choices.add(teams_it.next().getName());
		}

		List<String> pos_choices = Arrays.asList("Any","Goalkeeper","Defender","Midfielder","Striker");
		wrapper = new JPanel();
		wrapper.add(field);
		wrapper.add(addComboBox(team_choices,"Team"));
		wrapper.add(addComboBox(pos_choices,"Pos"));
		//wrapper.add(search);
		
		add(wrapper, BorderLayout.NORTH);
		
		field.requestFocus();
		
		validate();
	}
	
	/*
	 * get a new JTable object
	 */
	private JTable getJTable(String player_searched, String team_searched, String pos_searched){
		String[] columnNames = {"Player","Team","Position","Price",""};
<<<<<<< HEAD
		Object[][] data = null;
		
		try {
			data = getTableData();
		} catch (InvalidPlayer e2) {
			e2.printStackTrace();
		}
		
		final JTable table = new JTable(data, columnNames){
=======
		Object[][] data = getTableData();
		JTable table = new JTable(data, columnNames){
>>>>>>> parent of 74cfc3e... push to pull
			
			private static final long serialVersionUID = 1L;
			
			@Override
		    public boolean isCellEditable(int row, int column) {
		    	//all cells false except column 4 (button)
			    return (column==4);
		    }
		};
		
		table.setEnabled(true);
		table.getColumn("Player").setPreferredWidth(220);
		
		Action buy_or_sell_action = new AbstractAction()
		{
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
		    {
<<<<<<< HEAD
				Player player = results.get(Integer.parseInt(e.getActionCommand()));
				if(is.hi.f2a.res.Constants.VERBOSE)
					System.out.println("You pressed "+table.getValueAt(Integer.parseInt(e.getActionCommand()), 4)+" on player "+player.getName());
	        	
	        	// Get the current scroll position
	        	Integer value = scroll.getVerticalScrollBar().getValue();
	        	
		        if(table.getValueAt(Integer.parseInt(e.getActionCommand()), 4) == "Buy"){
		        	// If buy is pressed
		        	try {
		        		is.hi.f2a.backend.MainGame.getInstance().getCurrentUser().getRoster().buyPlayer(player);
					} catch (InvalidPosition e1) {
						e1.printStackTrace();
					} catch (InvalidPlayer e1) {
						e1.printStackTrace();
					}
		        } else {
		        	// If sell is pressed
		        	try {
		        		is.hi.f2a.backend.MainGame.getInstance().getCurrentUser().getRoster().sellPlayer(player);
					} catch (InvalidPlayer e1) {
						e1.printStackTrace();
					}
		        }
		        
		        try {
		        	is.hi.f2a.frontend.Main.getInstance().restartFrame();
				} catch (InvalidUser e1) {
					e1.printStackTrace();
				}
		        is.hi.f2a.frontend.Main.getInstance().setPanelAsMarket(scroll,value);
		        is.hi.f2a.frontend.Main.getInstance().setPanelAsFieldViewer();
=======
		        // Buy (or sell) player 
>>>>>>> parent of 74cfc3e... push to pull
		    }
		};
		
		new ButtonColumn(table, buy_or_sell_action, 4);
		
		return table;
	}
	
	/*
	 *  get the table data given some filters
	 */
<<<<<<< HEAD
	private Object[][] getTableData() throws InvalidPlayer{
		this.results = new ArrayList<Player>(180);
		
		Object[][] data = new Object[180][5];
		
		List<Team> teams = MarketPanel.league.getTeams();
=======
	private Object[][] getTableData(){
		Object[][] data = new Object[180][5];
		
		List<TeamMock> teams = this.league.getTeams();
		Iterator<TeamMock> teams_it = teams.iterator();
>>>>>>> parent of 74cfc3e... push to pull
		
		// i is the counter for matched players
		int i = 0;
		
<<<<<<< HEAD
		for(Team team : teams){
			List<Player> players_in_team = team.getPlayers();
			
			for(Player player : players_in_team ){
				// Filter out players
				if(!player.getName().toLowerCase().contains(player_choice.toLowerCase())
						|| (!this.team_choice.equals("Any") && !team.getName().equals(this.team_choice))
						|| (!this.pos_choice.equals("Any") && !positionToString(player.getPosition()).equals(this.pos_choice)))
=======
		while(teams_it.hasNext()){
			TeamMock team = teams_it.next();
			List<PlayerInterface> players_in_team = team.getPlayers();
			Iterator<PlayerInterface> players_it = players_in_team.iterator();
			
			while(players_it.hasNext()){
				PlayerMock player = (PlayerMock) players_it.next();
				
				// Filter
				//System.out.println(team.getName()+"  "+player.getName()+"  "+player_choice+"  "+player.getPositionName()+"  "+this.pos_choice);
				if(!player.getName().toLowerCase().contains(player_choice.toLowerCase())){
					continue;
				}
				
				if(!this.team_choice.equals("Any") && !team.getName().equals(this.team_choice)){
					continue;
				}
				
				if(!this.pos_choice.equals("Any") && !player.getPositionName().equals(this.pos_choice)){
>>>>>>> parent of 74cfc3e... push to pull
					continue;
				}
				
				// If the values go through the filter, add them.
				data[i][0] = player.getName();
				data[i][1] = team.getName();
				data[i][2] = player.getPositionName();
				data[i][3] = player.getPrice();
<<<<<<< HEAD
				
				if(is.hi.f2a.backend.MainGame.getInstance().getCurrentUser().getRoster().isInRoster(player)){
					data[i++][4] = "Sell";
				} else {
					data[i++][4] = "Buy";
				}
				results.add(player);
=======
				data[i][4] = "Buy";
				i++;
>>>>>>> parent of 74cfc3e... push to pull
			}
			
		}
		Object[][] subdata = Arrays.copyOfRange(data, 0, i);
		return subdata;
		
	}
<<<<<<< HEAD
	
	private String positionToString(Position position){
		if(position.equals(Position.GOALKEEPER))
			return "Goalkeeper";
		else if(position.equals(Position.DEFENDER))
			return "Defender";
		else if(position.equals(Position.MIDFIELDER))
			return "Midfielder";
		else
			return "Forward";
	}
=======

>>>>>>> parent of 74cfc3e... push to pull
}
