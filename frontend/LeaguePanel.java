package frontend;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class LeaguePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public LeaguePanel() {
		String[] columnNames = {"Name", "Last Name", "Sport", "# of Years", "Vegetarian"};
		Object[][] data = {
			    {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}
			};
		JTable table = new JTable(data, columnNames);
		table.setEnabled(false);
		table.getColumn("Name").setPreferredWidth(160);
		JScrollPane scroll = new JScrollPane(table);
		add(scroll);
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }

}
