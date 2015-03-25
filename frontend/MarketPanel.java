package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

import tests.LeagueMock;
import tests.PlayerInterface;
import tests.PlayerMock;
import tests.TeamMock;

public class MarketPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTextField field = new JTextField();
	private LeagueMock league;
	private String player_choice;
	private String team_choice;
	private String pos_choice;
	private JTable jtable;
	private JScrollPane scroll;
	private JPanel wrapper;
	private String text;

	/**
	 * Create the panel.
	 */
	public MarketPanel() {
		this.league = new LeagueMock();
		this.player_choice = "";
		this.team_choice = "Any";
		this.pos_choice = "Any";
		this.jtable = null;
		this.scroll = null;
		this.wrapper = null;
		this.text = "";
		
		setLayout(new BorderLayout(0, 0)); 
		
		field.setPreferredSize(new Dimension(150, 30));
		field.setFocusable( true );
		field.addKeyListener(new KeyListener(){
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(text+"  "+field.getText());
				// Workaround for the head slamming problem
				if(field.getText().equals(text) || field.getText().length() > text.length()+2 || field.getText().length() < text.length()-2){
					e.consume();
					return;
				}
				text = field.getText();
				char ch = e.getKeyChar();
				//System.out.println("Char: "+ch);
				
				if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')){
					//System.out.println(text);
					player_choice = text;
					refreshJTable();
				// If backspace is pressed
				} else if(e.getKeyCode() == 8 || e.getKeyCode() == 32) {
					if(text.length() >= 1){
						System.out.println(text.substring(0, text.length()));
						player_choice = text.substring(0, text.length());
					} else {
						player_choice = "";
						
					}
					
					refreshJTable();
				} else {
					System.out.println("Strange button: "+e.getKeyCode()+"  "+text);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
			
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

		List<TeamMock> teams = this.league.getTeams();
		Iterator<TeamMock> teams_it = teams.iterator();
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
		Object[][] data = getTableData();
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
		
		Action buy_or_sell_action = new AbstractAction()
		{
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
		    {
		        // Buy (or sell) player 
		    }
		};
		
		new ButtonColumn(table, buy_or_sell_action, 4);
		
		return table;
	}
	
	/*
	 *  get the table data given some filters
	 */
	private Object[][] getTableData(){
		Object[][] data = new Object[180][5];
		
		List<TeamMock> teams = this.league.getTeams();
		Iterator<TeamMock> teams_it = teams.iterator();
		
		// i is the counter for matched players
		int i = 0;
		
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
					continue;
				}
				
				// If the values go through the filter, add them.
				data[i][0] = player.getName();
				data[i][1] = team.getName();
				data[i][2] = player.getPositionName();
				data[i][3] = player.getPrice();
				data[i][4] = "Buy";
				i++;
			}
			
		}
		Object[][] subdata = Arrays.copyOfRange(data, 0, i);
		return subdata;
		
	}

}
