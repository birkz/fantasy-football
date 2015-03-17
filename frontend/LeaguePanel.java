package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeaguePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public LeaguePanel() {
		addPanels();
	}
	
	public void addPanels() {
		this.setLayout(new GridLayout(11, 1, 5, 5));
		add(createPanels(new String[]{"Name", "Wins", "Losses", "Points", "Goals For", "Goals Against"}));
		for(int i=0; i<10; ++i) {
			JPanel panel = new JPanel();
			//panel.setBorder(BorderFactory.createLineBorder(Color.black));
			if(i%2==1) panel.setBackground(Color.LIGHT_GRAY);
			add(panel);
		}
	}
	
	public JPanel createPanels(String[] team) {
		JPanel panel = new JPanel();
		for(int i=0; i<team.length; ++i) {
			JLabel label = new JLabel(team[i]);
			if(i==0) label.setPreferredSize(new Dimension(100, 60));
			else label.setPreferredSize(new Dimension(80, 60));
			panel.add(label);
		}
		return panel;
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.returnSizeForPanel();
    }

}
