package frontend;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
<<<<<<< HEAD

<<<<<<< HEAD
import is.hi.f2a.tests.InvalidUser;
import is.hi.f2a.backend.MainGame;
=======
import backend.MainGame;
>>>>>>> parent of 74cfc3e... push to pull
=======
import tests.InvalidUser;
import backend.MainGame;
>>>>>>> parent of 896621e... changed package location

public class NameChange extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTextField name;

	/**
	 * Create the panel.
	 */
	public NameChange() {
		JLabel explain = new JLabel("Name: ");
		name = new JTextField();
		name.setText(backend.MainGame.getInstance().getCurrentUser().getName());
		name.setPreferredSize(new Dimension(200, 30));
		addChangeListener();
		
<<<<<<< HEAD
<<<<<<< HEAD
		JLabel money = new JLabel("  Money: "+is.hi.f2a.backend.MainGame.getInstance().getCurrentUser().getMoney());
		JLabel score = new JLabel("  Score: "+is.hi.f2a.backend.MainGame.getInstance().getCurrentUser().getScore());
		JLabel round = new JLabel("  Round: "+is.hi.f2a.backend.MainGame.getInstance().getRound());
=======
		JLabel money = new JLabel("  Money: "+backend.MainGame.getInstance().getCurrentUser().getMoney());
		JLabel score = new JLabel("  Score: "+backend.MainGame.getInstance().getCurrentUser().getScore());
		JLabel round = new JLabel("  Round: "+backend.MainGame.getInstance().getRound());
>>>>>>> parent of 896621e... changed package location
		
=======
>>>>>>> parent of 74cfc3e... push to pull
		add(explain);
		add(name);
	}
	
	public void changeName(String newName) {
		if(newName.isEmpty()) newName = "Player"+ (MainGame.getInstance().getCurrendUserID()+1);
		MainGame.getInstance().getCurrentUser().changeName(newName);
	}
	
	public void addChangeListener() {
		name.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				changeName(name.getText());
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
		});
	}

}
