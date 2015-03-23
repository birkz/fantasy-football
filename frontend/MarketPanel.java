package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

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
		setBackground(Color.ORANGE);
		setLayout(new GridLayout(8, 1, 5, 5));
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }

}
