package is.hi.f2a.frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

<<<<<<< HEAD
import is.hi.f2a.tests.InvalidUser;
import is.hi.f2a.backend.MainGame;
import is.hi.f2a.backend.User;
=======
import backend.MainGame;
import backend.User;
>>>>>>> parent of 74cfc3e... push to pull

public class ScorePanel extends JPanel {

	/**
	 * 
	 */
	private final static long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ScorePanel() {
		int numUsers = MainGame.getInstance().getNumUsers();
		int round = MainGame.getInstance().getRound();
		if(round>0) round--;
		setLayout(new BorderLayout(0, 0));
		
		JPanel players = new JPanel();
		players.setBorder(new EmptyBorder(50, 50, 50, 50));
		players.setLayout(new GridLayout(numUsers, 2, 5, 5));
		for (int i=0; i<numUsers; ++i) {
			User user = MainGame.getInstance().getUser(i);
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
        return Main.getInstance().returnSizeForPanel();
    }

}
