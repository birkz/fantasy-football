package frontend;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tests.InvalidPlayer;
import tests.InvalidPosition;
import tests.PlayerInterface;
import tests.PlayerMock;
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
	public RosterPanel(MainGame game) throws InvalidPlayer, InvalidPosition {
		
		setLayout(new GridLayout(8, 1, 5, 5));
		
		this.roster = game.getCurrentUser().getRoster();
		
		// Henda út þessu þegar við intergrate-um
		if(roster.getPlayersInRoster().get(0).size() == 0){
			addRandomPlayersToRoster();
		}
		
		String[] columnNames = {"Name", "Price"};
		
		List<List<PlayerInterface>> roster_lists = this.roster.getPlayersInRoster();
		Iterator<List<PlayerInterface>> roster_lists_it = roster_lists.iterator();
		String[] Labels = new String[]{"Goalkeepers", "Defenders", "Midfielders", "Forwarders"};
		int j = 0;
		
		while(roster_lists_it.hasNext()){
			JLabel label = new JLabel(Labels[j++]);
			add(label);
			
			List<PlayerInterface> players = roster_lists_it.next();
			
			int player_size = players.size();
			Object[][] data = new Object[player_size][2];
			
			Iterator<PlayerInterface> player_it = players.iterator();
			int i = 0;
			while(player_it.hasNext()){
				PlayerInterface player = player_it.next();
				data[i][0] = player.getName();
				data[i][1] = player.getPrice();
				i++;
			}
			
			JTable table = new JTable(data, columnNames);
			table.setEnabled(true);
			JScrollPane scroll = new JScrollPane(table);
			add(scroll);
		}
		
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }
	
	private void addRandomPlayersToRoster() throws InvalidPlayer, InvalidPosition{
		this.roster.addPlayerToRoster(new PlayerMock("Svampur Sveinsson", "Goalkeeper"));
		this.roster.addPlayerToRoster(new PlayerMock("Pétur", "Goalkeeper"));
		this.roster.addPlayerToRoster(new PlayerMock("Sigmar", "Defender"));
		this.roster.addPlayerToRoster(new PlayerMock("Harpa", "Midfielder"));
		this.roster.addPlayerToRoster(new PlayerMock("Klemmi", "Midfielder"));
	}
}
