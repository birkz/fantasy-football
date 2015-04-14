package is.hi.f2a.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import is.hi.f1a.Player;
import is.hi.f2a.tests.InvalidPlayer;
import is.hi.f2a.backend.MainGame;
import is.hi.f2a.backend.Roster;

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
	//private JLabel num_players;
	private final Integer IS_ON_FIELD_COLUMN = 7;
	
	/*
	 * Constructor
	 */
	public RosterPanel() throws InvalidPlayer {
		setLayout(new BorderLayout(0, 0));
		
		this.roster = MainGame.getInstance().getCurrentUser().getRoster();
		List<List<Player>> roster_lists = this.roster.getPlayersInRoster();
		String[] labels = new String[]{"Goalkeepers", "Defenders", "Midfielders", "Forwarders"};
		Integer j = 0;
		
		/*this.num_players = new JLabel("Number of players on field: "+roster.getNumberOfPlayersOnField()+" (of 11)");
		if(roster.getNumberOfPlayersOnField() == 11){
			num_players.setText(num_players.getText()+" Gratz, you have a full squad!");
		}
		
		add(this.num_players, BorderLayout.NORTH);*/
		final Integer[] max_in_pos = new Integer[]{1,5,5,3};
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1, 5, 5));
		
		for(List<Player> players : roster_lists){
			String[] columnNames = {labels[j], "Price", "RC", "YC", "Injury", "Points", "Available", "On Field"};
			
			int player_size = players.size();
			Object[][] data = new Object[player_size][IS_ON_FIELD_COLUMN+1];
			
			int i = 0;
			
			for(Player player : players){
				data[i][0] = player.getName();
				data[i][1] = player.getPrice();
				
				if(player.getRedCards()>0) data[i][2] = " ";
				else data[i][2] = "";
				if(player.getYellowCards()>0) data[i][3] = player.getYellowCards();
				else data[i][3] = "";
				if(player.getInjuryLength()>0) data[i][4] = player.getInjuryLength();
				data[i][5] = player.getTotalPoints();
				if(player.isAvailable(false)){
					data[i][6] = "Yes";
				} else {
					data[i][6] = "No";
				}
				
				if(roster.isOnField(player)) {
					if(!player.isAvailable(false)){
						roster.removePlayerFromField(player);
						try {
							Main.getInstance().setPanelAsFieldViewer();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						data[i][IS_ON_FIELD_COLUMN] = false;
					} else {
						data[i][IS_ON_FIELD_COLUMN] = true;
					}
				} else {
					data[i][IS_ON_FIELD_COLUMN] = false;
				}
				i++;
			}
			
			final DefaultTableModel dtm = new DefaultTableModel(data,columnNames);
			
			final Integer pos_id = j;
			JTable table = new JTable(dtm){
				private static final long serialVersionUID = 1L;

				@Override
			    public boolean isCellEditable(int row, int column) {
			    	//all cells false except column IS_ON_FIELD_COLUMN
					if(column != IS_ON_FIELD_COLUMN) return false;
					else if(dtm.getValueAt(row, column).equals(true)) {
						// Ef leikmaður er inná vellinum
						return true;
					} else if(pos_id == 0 && roster.getNumberOfPlayersOnField() < 11 &&
							roster.getPlayersOnField().get(0).size() < max_in_pos[0] && 
							dtm.getValueAt(row, column-1).equals("Yes")){
						// Ef leikmaður er markmaður (og færri en 11 á vellinum)
						return true;
					} else if (roster.getNumberOfPlayersOnField() < 10+roster.getPlayersOnField().get(0).size() &&
							roster.getPlayersOnField().get(pos_id).size() < max_in_pos[pos_id] && 
							dtm.getValueAt(row, column-1).equals("Yes")){
						// Ef leikmaður er ekki inná vellinum  (og færri en 10 á vellinum)
						return true;
					}
				    return false;
			    }
				
				public Component prepareRenderer(TableCellRenderer renderer,int rowIndex, int vColIndex) {
					Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
					if(vColIndex == IS_ON_FIELD_COLUMN){
						if (isCellEditable(rowIndex, vColIndex) && dtm.getValueAt(rowIndex, vColIndex).equals(false)
								&& dtm.getValueAt(rowIndex, vColIndex-1).equals("Yes")){
							c.setBackground(new Color(0,255,0,155));
						} else {
							c.setBackground(new Color(255,0,0,155));
						}
					} else if (vColIndex == 2 && !dtm.getValueAt(rowIndex, vColIndex).equals("")) {
						c.setBackground(Color.red);
					} else if (vColIndex == 3 && !dtm.getValueAt(rowIndex, vColIndex).equals("")) {
						c.setBackground(Color.yellow);
					} else if (rowIndex % 2 == 0) {
			          c.setBackground(new Color(0,0,255,32));
			        } else {
			          c.setBackground(getBackground());
			        }
					
					return c;
				}
			};
			
			table.setEnabled(true);
			table.setFocusable(false);
			table.setShowGrid(false);
			table.setRowSelectionAllowed(false);
			//table.setFillsViewportHeight(true);
			table.getColumn("On Field").setMaxWidth(50);
			table.getColumn("RC").setMaxWidth(22);
			table.getColumn("YC").setMaxWidth(22);
			
			TableColumn tc = table.getColumnModel().getColumn(IS_ON_FIELD_COLUMN);
		    tc.setCellEditor(table.getDefaultEditor(Boolean.class));
		    tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
		    
		    final Integer j_tmp = j;
		    table.getModel().addTableModelListener(new TableModelListener() {
		    	
				@Override
				public void tableChanged(TableModelEvent e) {
					
					Player player = roster.getPlayersInRoster().get(j_tmp).get(e.getFirstRow());
					System.out.println(player.getName());
					
					try {
						if (roster.isOnField(player)){
							roster.removePlayerFromField(player);
						} else {
							roster.addPlayerToField(player);
						}
					} catch (InvalidPlayer e1) {
						e1.printStackTrace();
					}
					try {
						is.hi.f2a.frontend.Main.getInstance().setPanelAsFieldViewer();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					try {
						is.hi.f2a.frontend.Main.getInstance().setPanelAsRoster();
					} catch (InvalidPlayer e1) {
						e1.printStackTrace();
					}
				}
		    	
		    });
		    
			JScrollPane scroll = new JScrollPane(table);
			panel.add(scroll,j++);
		}
		add(panel, BorderLayout.CENTER);
		
	}
}
