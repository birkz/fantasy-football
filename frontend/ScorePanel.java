package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
		setLayout(new BorderLayout(0, 0));
		
		JPanel players = new JPanel();
		players.setBorder(new EmptyBorder(50, 50, 50, 50));
		players.setLayout(new GridLayout(numUsers, 2, 5, 5));
		for (int i=0; i<numUsers; ++i) {
			User user = MainGame.getUser(i);
			JLabel userN = new JLabel(user.getName());
			JLabel userS = new JLabel(""+user.getScore()[round]);
			players.add(userN);
			players.add(userS);
		}
		
		add(new GraphData(), BorderLayout.CENTER);
		add(players, BorderLayout.SOUTH);
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.returnSizeForPanel();
    }

}
