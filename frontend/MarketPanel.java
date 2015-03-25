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
	private final JTextField field;
	private LeagueMock league;


	/**
	 * Create the panel.
	 */
	public MarketPanel() {
		this.league = new LeagueMock();
		
		setLayout(new BorderLayout(0, 0)); 
		
		field = new JTextField();
		field.setPreferredSize(new Dimension(150, 30));
		field.addKeyListener(new KeyListener(){
        	
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					System.out.println(field.getText() );
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println(field.getText() );
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JButton search = new JButton("SEARCH");
		search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(e.getActionCommand() );
            }
        }); 

		List<TeamMock> teams = this.league.getTeams();
		Iterator<TeamMock> teams_it = teams.iterator();
		List<String> choices = new ArrayList<String>();
		
		while(teams_it.hasNext()){
			choices.add(teams_it.next().getName());
		}

		List<String> choices2 = Arrays.asList("Goalkeeper","Defender","Midfielder","Striker");
		
		String[] columnNames = {"Player","Team","Position","Price"};
		Object[][] data = getTableData();
		JTable table = new JTable(data, columnNames);
		
		table.setEnabled(false);
		table.getColumn("Player").setPreferredWidth(250);
		JScrollPane scroll = new JScrollPane(table);
		add(scroll);
		
		JPanel wrapper = new JPanel();
		wrapper.add(field);
		wrapper.add(addComboBox(choices));
		wrapper.add(addComboBox(choices2));
		wrapper.add(search);
		
		add(wrapper, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
	}
	
	public JPanel createEntry() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("hello what's up?"));
		return panel;
	}
	
	public JComboBox<String> addComboBox(List<String> choices) {
		String[] choose = new String[choices.size()];
		for(int i=0; i<choices.size(); ++i) {
			choose[i] = choices.get(i);
		}
		final JComboBox<String> cb = new JComboBox<String>(choose);
		cb.setVisible(true);
		cb.addActionListener(new ActionListener() {
            @SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e)
            {
            	JComboBox<String> cb = (JComboBox<String>) e.getSource();
                String chosen = (String)cb.getSelectedItem();
                System.out.println(chosen);
            }
        }); 
		return cb;
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }
	
	private Object[][] getTableData(){
		Object[][] data = new Object[180][4];
		
		List<TeamMock> teams = this.league.getTeams();
		Iterator<TeamMock> teams_it = teams.iterator();
		
		// i is the player counter
		int i = 0;
		
		while(teams_it.hasNext()){
			TeamMock team = teams_it.next();
			List<PlayerInterface> players_in_team = team.getPlayers();
			Iterator<PlayerInterface> players_it = players_in_team.iterator();
			
			while(players_it.hasNext()){
				PlayerMock player = (PlayerMock) players_it.next();
				
				data[i][0] = player.getName();
				data[i][1] = team.getName();
				data[i][2] = player.getPositionName();
				data[i][3] = player.getPrice();
				i++;
			}
			
		}
		return data;
		
	}

}
