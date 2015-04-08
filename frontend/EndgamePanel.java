package frontend;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EndgamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public EndgamePanel() {
		JButton newgame = new JButton("NEW GAME");
		newgame.addActionListener(new HandleButtons());
		add(newgame);
	}

}
