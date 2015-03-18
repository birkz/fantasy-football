package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FieldViewerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel[] players = new JPanel[]{new JPanel(), new JPanel(), new JPanel(), new JPanel()};

	/**
	 * Create the panel.
	 */
	public FieldViewerPanel() {
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
		Dimension size = Main.returnSizeForPanel();
		Image img = new ImageIcon("src/Images/field.png").getImage();
		g.drawImage(img, 0, 0, size.width, size.height, null);
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.returnSizeForPanel();
    }
	
	public void AddToPanels() {
		players[0].add(createLabels("Striker1"));
		players[0].add(createLabels("Striker2"));
		players[0].add(createLabels("Striker3"));
		players[1].add(createLabels("Midfielder1"));
		players[1].add(createLabels("Midfielder2"));
		players[1].add(createLabels("Midfielder3"));
		players[1].add(createLabels("Midfielder4"));
		players[2].add(createLabels("Defender1"));
		players[2].add(createLabels("Defender2"));
		players[2].add(createLabels("Defender3"));
		players[3].add(createLabels("Goaly"));
	}
	
	public JLabel createLabels(String name) {
		JLabel label = new JLabel(name);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		label.setPreferredSize(new Dimension(100, 50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		return label;
	}

}
