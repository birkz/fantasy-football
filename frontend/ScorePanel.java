package is.hi.f2a.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import is.hi.f2a.tests.InvalidUser;
import is.hi.f2a.backend.FontUtil;
import is.hi.f2a.backend.MainGame;
import is.hi.f2a.backend.User;

public class ScorePanel extends JPanel {

	/**
	 * 
	 */
	private final static long serialVersionUID = 1L;
	private int width = 0;
	private int height = 0;

	/**
	 * Create the panel.
	 * @throws InvalidUser 
	 */
	public ScorePanel() throws InvalidUser {

		width = this.getWidth();
		height = this.getHeight();
		List<User> users = MainGame.getInstance().getUsers();
		int numUsers = users.size();
		setLayout(new BorderLayout(0, 0));
		
		JPanel players = new JPanel();
		players.setBackground(Color.WHITE);
		players.setBorder(new EmptyBorder(50, 50, 50, 50));
		players.setLayout(new GridLayout(numUsers, 2, 5, 5));
		for (int i=0; i<numUsers; ++i) {
			User user = users.get(i);
			JLabel userN = new JLabel(user.getName());
			userN.setFont(FontUtil.getFont("kalinga", Font.PLAIN, 16));
			JLabel userS = new JLabel("0");
			//userS.setFont(FontUtil.getFont("kalinga", Font.PLAIN, 18));
			userS = new JLabel(""+user.getScore() );
			players.add(userN);
			players.add(userS);
		}
		
		add(new GraphData(width, height), BorderLayout.CENTER);
		//TÓK ÞETTTA BARA AF TIL AÐ FÁ EKKI SCOREPANEL
		//add(players, BorderLayout.SOUTH);
	}
}
