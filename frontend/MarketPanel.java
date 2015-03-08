package frontend;

import java.awt.Dimension;

import javax.swing.JPanel;

public class MarketPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MarketPanel() {

	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }

}
