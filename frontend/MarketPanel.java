package frontend;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
		JPanel main = new JPanel();
		main.add(createEntry());
		main.add(createEntry());
		JScrollPane scroll = new JScrollPane(main);
		add(scroll);
	}
	
	public JPanel createEntry() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("hello what´s up?"));
		return panel;
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }

}
