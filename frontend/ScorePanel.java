package frontend;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.MainGame;
import backend.User;

public class ScorePanel extends JPanel {

	/**
	 * 
	 */
	private final static long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ScorePanel() {
		int numUsers = MainGame.getNumUsers();
		int round = MainGame.getRound();
		if(round>0) round--;
		
		setBorder(new EmptyBorder(50, 50, 50, 50));
		setLayout(new GridLayout(numUsers, 2, 5, 5));
		
		for (int i=0; i<numUsers; ++i) {
			User user = MainGame.getUser(i);
			JLabel userN = new JLabel(user.getName());
			JLabel userS = new JLabel(""+user.getScore()[round]);
			add(userN);
			add(userS);
		}
	}

}
