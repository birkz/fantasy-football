package is.hi.f2a.frontend;

import is.hi.f1a.League;
import is.hi.f1a.Player;
import is.hi.f1a.Player.Position;
import is.hi.f1a.Team;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;
import javax.swing.RowSorter.SortKey;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import is.hi.f2a.backend.MainGame;
import is.hi.f2a.frontend.ButtonColumn;
import is.hi.f2a.res.Constants;
import is.hi.f2a.tests.InvalidPlayer;
import is.hi.f2a.tests.InvalidPosition;
import is.hi.f2a.tests.InvalidUser;

public class MarketPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTextField field = new JTextField();
	private static League league = is.hi.f1a.FantasyFootballBackend.getInstance().getLeague();
	private String player_choice;
	private String team_choice;
	private String pos_choice;
	private JTable jtable;
	private JScrollPane scroll = null;
	private JPanel wrapper;
	private String text;
	private List<Player> results;
	private List<? extends SortKey> sortkeys;

	/**
	 * Create the panel.
	 * @throws InvalidPlayer 
	 */
	public MarketPanel(final JScrollPane scroll, final int value, List<? extends SortKey> sortkeys) {
		this.player_choice = "";
		this.team_choice = "Any";
		this.pos_choice = "Any";
		this.jtable = null;
		this.sortkeys = sortkeys;
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

		List<Team> teams = MarketPanel.league.getTeams();
		Iterator<Team> teams_it = teams.iterator();
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
		
		DefaultTableModel m = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;

			@Override
		    public Class<?> getColumnClass(int column) {
		        if (column == 3) {
		            return Integer.class;
		        }
		        return super.getColumnClass(column);
		    }
		};
		m.setDataVector(data, columnNames);
		
		final JTable table = new JTable(m){
			
			private static final long serialVersionUID = 1L;
			
			@Override
		    public boolean isCellEditable(int row, int column) {
		    	//all cells false except column 4 (button)
			    return (column==4);
		    }
		};
		
		table.setEnabled(true);
		table.getColumn("Player").setPreferredWidth(140);
		table.getColumn("Team").setPreferredWidth(140);
		
		/*
		 * Action when the "Buy" or "Sell" buttons are pressed
		 */
		Action buy_or_sell_action = new AbstractAction()
		{
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e)
		    {
				Player player = results.get(Integer.parseInt(e.getActionCommand()));
				String buy_or_sell = null;
				try {
					if(MainGame.getInstance().getCurrentUser().getRoster().isInRoster(player))
						buy_or_sell = "Sell";
					else
						buy_or_sell = "Buy";
				} catch (InvalidPlayer e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(Constants.VERBOSE)
					System.out.println("You pressed "+buy_or_sell+" on player "+player.getName());
	        	
	        	// Get the current scroll position
	        	Integer value = scroll.getVerticalScrollBar().getValue();
	        	
		        if(buy_or_sell == "Buy"){
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
				} catch (InvalidUser | IOException e1) {
					e1.printStackTrace();
				}
		        
		        RowSorter<?> sorter = table.getRowSorter();
		        
		        Main.getInstance().setPanelAsMarket(scroll,value, sorter.getSortKeys());
		        try {
					Main.getInstance().setPanelAsFieldViewer();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		};
		
		new ButtonColumn(table, buy_or_sell_action, 4);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		table.setAutoCreateRowSorter(true);
		
		RowSorter<?> sorter = table.getRowSorter();
		sorter.setSortKeys(sortkeys);
		
		return table;
	}
	
	/*
	 *  get the table data given some filters
	 */
	private Object[][] getTableData() throws InvalidPlayer{
		this.results = new ArrayList<Player>(710);
		
		Object[][] data = new Object[710][5];
		
		List<Team> teams = MarketPanel.league.getTeams();
		
		// i is the counter for matched players (i.e. size of results table)
		int i = 0;
		
		for(Team team : teams){
			List<Player> players_in_team = team.getPlayers();
			
			for(Player player : players_in_team ){
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
				//data[i][3] = String.format("%,d", player.getPrice());
				
				if(MainGame.getInstance().getCurrentUser().getRoster().isInRoster(player)){
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
}
