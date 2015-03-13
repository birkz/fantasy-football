package frontend;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import backend.MainGame;

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
		name.setText(backend.MainGame.getCurrentUser().getName());
		name.setPreferredSize(new Dimension(200, 30));
		addChangeListener();
		
		add(explain);
		add(name);
	}
	
	public void changeName(String newName) {
		if(newName.isEmpty()) newName = "Player"+ (MainGame.getCurrendUserID()+1);
		MainGame.getCurrentUser().changeName(newName);
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
