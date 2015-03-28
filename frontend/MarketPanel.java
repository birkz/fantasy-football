package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

import tests.InvalidPlayer;
import tests.InvalidPosition;
import tests.InvalidUser;
import tests.LeagueMock;
import tests.PlayerInterface;
import tests.PlayerInterface.Position;
import tests.TeamMock;

public class MarketPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTextField field = new JTextField();
	// Þetta static er bara til bráðabirgða
	private static LeagueMock league = new LeagueMock();
	private String player_choice;
	private String team_choice;
	private String pos_choice;
	private JTable jtable;
	private JScrollPane scroll = null;
	private JPanel wrapper;
	private String text;
	private List<PlayerInterface> results;
	
	public static LeagueMock getLeague(){
		return league;
	}

	/**
	 * Create the panel.
	 * @throws InvalidPlayer 
	 */
	public MarketPanel(JScrollPane scroll, int value) {
		this.player_choice = "";
		this.team_choice = "Any";
		this.pos_choice = "Any";
		this.jtable = null;
		if(scroll!=null){
			this.scroll = scroll;
			Runnable doScroll = new Runnable() {
	             public void run() {
	            	 scroll.getVerticalScrollBar().setValue(value);
	             }
	        };
			SwingUtilities.invokeLater(doScroll);
		}
		else{
			this.scroll = new JScrollPane(jtable);
		}
		
		this.wrapper = null;
		this.text = "";
		
		setLayout(new BorderLayout(0, 0)); 
		
		field.setPreferredSize(new Dimension(150, 30));
		field.setFocusable( true );
		field.addKeyListener(new KeyListener(){
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				System.out.println("Before: "+text+"  After: "+field.getText());
				// If enter or backspace is pressed, update is forced
				if(e.getKeyCode() != 8 && e.getKeyCode() != 10){
					char ch = e.getKeyChar();
					if((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z') && (ch < '0' || ch > '9') && e.getKeyCode() != 32){
						e.consume();
						return;
					}
					
					String local_text = field.getText();
					
					if(local_text.equals(text)){
						return;
					} else if(local_text.length() >= text.length()+2 ){
						text += local_text.substring(text.length(),text.length()+1);
						return;
					} else if(local_text.length() <= text.length()-2 ){
						text = text.substring(0,text.length()-1);
						return;
					}
					text = local_text;
					player_choice = local_text;
				} else {
					text = field.getText();
					player_choice = text;
				}
				try {
					refreshJTable();
				} catch (InvalidPlayer e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {/* Not used */}
			
			@Override
			public void keyPressed(KeyEvent e) {/* Not used */}
		});
		
		try {
			refreshJTable();
		} catch (InvalidPlayer e1) {
			e1.printStackTrace();
		}
	}
	
	private JComboBox<String> addComboBox(List<String> choices, String flag) {
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
                	try {
						refreshJTable();
					} catch (InvalidPlayer e1) {
						e1.printStackTrace();
					}
                	
                } else if(flag.equals("Pos") && !pos_choice.equals(chosen)){
                	System.out.println("POS: "+chosen);
                	pos_choice = chosen;
                	try {
						refreshJTable();
					} catch (InvalidPlayer e1) {
						e1.printStackTrace();
					}
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
	private void refreshJTable() throws InvalidPlayer{
		
		if(jtable!=null){
			remove(jtable);
			//remove(scroll);
			remove(wrapper);
		}
		
		jtable = getJTable(player_choice,team_choice,pos_choice);
		
		// scroll = new JScrollPane(jtable);
		jtable.invalidate();
		scroll.getViewport().add(jtable);
		scroll.validate();
		scroll.repaint();
		
		add(scroll, BorderLayout.CENTER);

		List<TeamMock> teams = MarketPanel.league.getTeams();
		Iterator<TeamMock> teams_it = teams.iterator();
		List<String> team_choices = new ArrayList<String>();
		team_choices.add("Any");
		
		while(teams_it.hasNext()){
			team_choices.add(teams_it.next().getName());
		}

		List<String> pos_choices = Arrays.asList("Any","Goalkeeper","Defender","Midfielder","Forward");
		wrapper = new JPanel();
		wrapper.add(field);
		wrapper.add(addComboBox(team_choices,"Team"));
		wrapper.add(addComboBox(pos_choices,"Pos"));
		
		add(wrapper, BorderLayout.NORTH);
		
		field.requestFocus();
		
		validate();
	}
	
	/*
	 * get a new JTable object
	 */
	private JTable getJTable(String player_searched, String team_searched, String pos_searched){
		String[] columnNames = {"Player","Team","Position","Price",""};
		Object[][] data = null;
		
		try {
			data = getTableData();
		} catch (InvalidPlayer e2) {
			e2.printStackTrace();
		}
		
		JTable table = new JTable(data, columnNames){
			
			private static final long serialVersionUID = 1L;
			
			@Override
		    public boolean isCellEditable(int row, int column) {
		    	//all cells false except column 4 (button)
			    return (column==4);
		    }
		};
		
		table.setEnabled(true);
		table.getColumn("Player").setPreferredWidth(220);
		
		/*
		 * Action when the "Buy" or "Sell" buttons are pressed
		 */
		Action buy_or_sell_action = new AbstractAction()
		{
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e)
		    {
				PlayerInterface player = results.get(Integer.parseInt(e.getActionCommand()));
				if(res.Constants.VERBOSE)
					System.out.println("You pressed "+table.getValueAt(Integer.parseInt(e.getActionCommand()), 4)+" on player "+player.getName());
	        	
	        	// Get the current scroll position
	        	Integer value = scroll.getVerticalScrollBar().getValue();
	        	
		        if(table.getValueAt(Integer.parseInt(e.getActionCommand()), 4) == "Buy"){
		        	// If buy is pressed
		        	try {
						backend.MainGame.getInstance().getCurrentUser().getRoster().buyPlayer(player);
					} catch (InvalidPosition e1) {
						e1.printStackTrace();
					} catch (InvalidPlayer e1) {
						e1.printStackTrace();
					}
		        } else {
		        	// If sell is pressed
		        	try {
						backend.MainGame.getInstance().getCurrentUser().getRoster().sellPlayer(player);
					} catch (InvalidPlayer e1) {
						e1.printStackTrace();
					}
		        }
		        
		        // Update the panels to show the changes
		        try {
					frontend.Main.getInstance().restartFrame();
				} catch (InvalidUser e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        frontend.Main.getInstance().setPanelAsMarket(scroll,value);
		        frontend.Main.getInstance().setPanelAsFieldViewer();
		    }
		};
		
		new ButtonColumn(table, buy_or_sell_action, 4);
		
		return table;
	}
	
	/*
	 *  get the table data given some filters
	 */
	private Object[][] getTableData() throws InvalidPlayer{
		this.results = new ArrayList<PlayerInterface>(180);
		
		Object[][] data = new Object[180][5];
		
		List<TeamMock> teams = MarketPanel.league.getTeams();
		
		// i is the counter for matched players (i.e. size of results table)
		int i = 0;
		
		for(TeamMock team : teams){
			List<PlayerInterface> players_in_team = team.getPlayers();
			
			for(PlayerInterface player : players_in_team ){
				// Filter out players
				if(!player.getName().toLowerCase().contains(player_choice.toLowerCase())
						|| (!this.team_choice.equals("Any") && !team.getName().equals(this.team_choice))
						|| (!this.pos_choice.equals("Any") && !positionToString(player.getPosition()).equals(this.pos_choice)))
					continue;
				
				// If the values go through the filter, add them to the table.
				data[i][0] = player.getName();
				data[i][1] = team.getName();
				data[i][2] = positionToString(player.getPosition());
				data[i][3] = player.getPrice();
				
				if(backend.MainGame.getInstance().getCurrentUser().getRoster().isInRoster(player)){
					data[i++][4] = "Sell";
				} else {
					data[i++][4] = "Buy";
				}
				results.add(player);
			}
			
		}
		Object[][] subdata = Arrays.copyOfRange(data, 0, i);
		return subdata;
		
	}
	
	private String positionToString(Position pos){
		if(pos.equals(PlayerInterface.Position.GOALKEEPER))
			return "Goalkeeper";
		else if(pos.equals(PlayerInterface.Position.DEFENDER))
			return "Defender";
		else if(pos.equals(PlayerInterface.Position.MIDFIELDER))
			return "Midfielder";
		else
			return "Forward";
	}
}
