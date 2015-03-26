package frontend;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import tests.PlayerInterface;
import backend.MainGame;
import backend.Roster;

public class RosterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param game 
	 */
	private Roster roster;
	
	/*
	 * Constructor
	 */
	public RosterPanel() {
		
		setLayout(new GridLayout(4, 1, 5, 10));
		
		this.roster = MainGame.getInstance().getCurrentUser().getRoster();
		
		// Henda út þessu þegar við intergrate-um
		/*if(roster.getPlayersInRoster().get(0).size() == 0){
			addRandomPlayersToRoster();
		}*/
		
		List<List<PlayerInterface>> roster_lists = this.roster.getPlayersInRoster();
		Iterator<List<PlayerInterface>> roster_lists_it = roster_lists.iterator();
		String[] Labels = new String[]{"Goalkeepers", "Defenders", "Midfielders", "Forwarders"};
		int j = 0;
		
		while(roster_lists_it.hasNext()){
			String[] columnNames = {Labels[j], "Price", "On Field"};
			
			List<PlayerInterface> players = roster_lists_it.next();
			
			int player_size = players.size();
			Object[][] data = new Object[player_size][3];
			
			Iterator<PlayerInterface> player_it = players.iterator();
			int i = 0;
			
			while(player_it.hasNext()){
				PlayerInterface player = player_it.next();
				data[i][0] = player.getName();
				data[i][1] = player.getPrice();
				data[i][2] = Boolean.FALSE;
				i++;
			}
			
			DefaultTableModel dtm = new DefaultTableModel(data,columnNames);
			JTable table = new JTable(dtm){
				private static final long serialVersionUID = 1L;

				@Override
			    public boolean isCellEditable(int row, int column) {
			    	//all cells false except column 2
				    return column == 2;
			    }
			};
			
			table.setEnabled(true);
			table.setFillsViewportHeight(true);
			TableColumn tc = table.getColumnModel().getColumn(2);
		    tc.setCellEditor(table.getDefaultEditor(Boolean.class));
		    tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
			JScrollPane scroll = new JScrollPane(table);
			add(scroll,j++);
		}
		
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }
	
}
