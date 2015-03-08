package frontend;

import java.awt.Dimension;

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

	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }

}
