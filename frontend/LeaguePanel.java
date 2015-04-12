package is.hi.f2a.frontend;

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
		String[] columnNames = {"POS", "CLUB", "P", "W", "D", "L", "GF", "GA", "GD", "PTS"};
		Object[][] data = {
			    {new Integer(1), "Chelsea", new Integer(29), new Integer(20), new Integer(7), new Integer(2),
			    	new Integer(61), new Integer(25), new Integer(36), new Integer(67)},
			    {new Integer(2), "Manchester City", new Integer(30), new Integer(18), new Integer(7), new Integer(5),
			    	new Integer(62), new Integer(28), new Integer(34), new Integer(61)},
			    {new Integer(3), "Arsenal", new Integer(30), new Integer(18), new Integer(6), new Integer(6),
			    	new Integer(58), new Integer(31), new Integer(27), new Integer(60)},
			    {new Integer(4), "Manchester United", new Integer(30), new Integer(17), new Integer(8), new Integer(5),
			    	new Integer(52), new Integer(27), new Integer(25), new Integer(59)},
			    {new Integer(5), "Liverpool", new Integer(30), new Integer(16), new Integer(8), new Integer(8),
			    	new Integer(44), new Integer(32), new Integer(12), new Integer(54)}
			};
		JTable table = new JTable(data, columnNames);
		table.setEnabled(false);
		table.getColumn("CLUB").setPreferredWidth(250);
		JScrollPane scroll = new JScrollPane(table);
		add(scroll);
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }

}
