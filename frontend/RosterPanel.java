package frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import tests.InvalidPlayer;
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
	private JLabel num_players;
	private final Integer IS_ON_FIELD_COLUMN = 2;
	
	/*
	 * Constructor
	 */
	public RosterPanel() throws InvalidPlayer {
		
		setLayout(new GridLayout(5, 1, 5, 10));
		
		this.roster = MainGame.getInstance().getCurrentUser().getRoster();
		
		// Henda út þessu þegar við intergrate-um
		/*if(roster.getPlayersInRoster().get(0).size() == 0){
			addRandomPlayersToRoster();
		}*/
		
		List<List<PlayerInterface>> roster_lists = this.roster.getPlayersInRoster();
		Iterator<List<PlayerInterface>> roster_lists_it = roster_lists.iterator();
		String[] labels = new String[]{"Goalkeepers", "Defenders", "Midfielders", "Forwarders"};
		Integer j = 0;
		
		this.num_players = new JLabel("Number of players on field: "+roster.getNumberOfPlayersOnField()+" (of 11)");
		if(roster.getNumberOfPlayersOnField() == 11){
			num_players.setText(num_players.getText()+" Gratz, you have a full squad!");
		}
		add(this.num_players);
		Integer[] max_in_pos = new Integer[]{1,5,5,3};
		
		while(roster_lists_it.hasNext()){
			String[] columnNames = {labels[j], "Price", "On Field"};
			
			List<PlayerInterface> players = roster_lists_it.next();
			
			int player_size = players.size();
			Object[][] data = new Object[player_size][3];
			
			Iterator<PlayerInterface> player_it = players.iterator();
			int i = 0;
			
			while(player_it.hasNext()){
				PlayerInterface player = player_it.next();
				data[i][0] = player.getName();
				data[i][1] = player.getPrice();
				data[i][2] = roster.isOnField(player);
				i++;
			}
			
			DefaultTableModel dtm = new DefaultTableModel(data,columnNames);
			
			Integer pos_id = j;
			JTable table = new JTable(dtm){
				private static final long serialVersionUID = 1L;

				@Override
			    public boolean isCellEditable(int row, int column) {
			    	//all cells false except column IS_ON_FIELD_COLUMN
					if (column == IS_ON_FIELD_COLUMN && dtm.getValueAt(row, column).equals(true)) {
						return true;
					} else if (column == IS_ON_FIELD_COLUMN && roster.getNumberOfPlayersOnField() < 11 &&
							roster.getPlayersOnField().get(pos_id).size() < max_in_pos[pos_id]){
						return true;
					}
				    return false;
			    }
				
				public Component prepareRenderer(TableCellRenderer renderer,int rowIndex, int vColIndex) {
					Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
					if(vColIndex == IS_ON_FIELD_COLUMN){
						if (isCellEditable(rowIndex, vColIndex)) {//if first column
							if(dtm.getValueAt(rowIndex, vColIndex).equals(false))
								c.setBackground(Color.green);
						} else {
							c.setBackground(Color.red);
						}
					}
					return c;
				}
			};
			
			table.setEnabled(true);
			table.setFocusable(false);
			table.setRowSelectionAllowed(false);
			table.setFillsViewportHeight(true);
			table.getColumn("On Field").setMaxWidth(60);
			
			TableColumn tc = table.getColumnModel().getColumn(IS_ON_FIELD_COLUMN);
		    tc.setCellEditor(table.getDefaultEditor(Boolean.class));
		    tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
		    
		    Integer j_tmp = j;
		    table.getModel().addTableModelListener(new TableModelListener() {
		    	
				@Override
				public void tableChanged(TableModelEvent e) {
					
					PlayerInterface player = roster.getPlayersInRoster().get(j_tmp).get(e.getFirstRow());
					System.out.println(player.getName());
					
					try {
						if (roster.isOnField(player)){
							roster.removePlayerFromField(player);
						} else {
							roster.addPlayerToField(player);
						}
					} catch (InvalidPlayer e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frontend.Main.getInstance().setPanelAsFieldViewer();
					try {
						frontend.Main.getInstance().setPanelAsRoster();
					} catch (InvalidPlayer e1) {
						e1.printStackTrace();
					}
				}
		    	
		    });
		    
			JScrollPane scroll = new JScrollPane(table);
			add(scroll,j++);
		}
		
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }
	
}
