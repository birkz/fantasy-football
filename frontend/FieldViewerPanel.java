package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import tests.PlayerInterface;
import backend.Roster;

public class FieldViewerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel[] players = new JPanel[]{new JPanel(), new JPanel(), new JPanel(), new JPanel()};
	private final Roster roster;

	/**
	 * Create the panel.
	 */
	public FieldViewerPanel() {
		
		this.roster = backend.MainGame.getInstance().getCurrentUser().getRoster();
		
		setLayout(new GridLayout(8, 1, 5, 5));
		AddToPanels();
		for(int i=0; i<players.length; ++i) {
			JPanel fillup = new JPanel();
			fillup.setOpaque(false);
			add(fillup);
			players[i].setOpaque(false);
			add(players[i]);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Dimension size = Main.getInstance().returnSizeForPanel();
		Image img = new ImageIcon("src/res/Images/field.png").getImage();
		g.drawImage(img, 0, 0, size.width, size.height, null);
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }
	
	public void AddToPanels() {
		Iterator<List<PlayerInterface>> roster_it = this.roster.getPlayersOnField().iterator();
		int i = 3;
		
		while(roster_it.hasNext()){
			List<PlayerInterface> players_in_pos = roster_it.next();
			Iterator<PlayerInterface> players_in_pos_it = players_in_pos.iterator();
			
			while(players_in_pos_it.hasNext()){
				players[i].add(createLabels(players_in_pos_it.next().getName()));
			}
			
			i--;
		}
	}
	
	public JLabel createLabels(String name) {
		JLabel label = new JLabel("<html><div style=\"text-align: center;\">"+name+"</html>");
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		label.setPreferredSize(new Dimension(104, 50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		return label;
	}

}
