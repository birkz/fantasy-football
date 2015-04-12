package is.hi.f2a.frontend;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import is.hi.f2a.tests.InvalidUser;
import is.hi.f2a.backend.MainGame;

public class NameChange extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTextField name;

	/**
	 * Create the panel.
	 * @throws InvalidUser 
	 */
	public NameChange() throws InvalidUser {
		JLabel explain = new JLabel("Name: ");
		name = new JTextField();
		name.setText(is.hi.f2a.backend.MainGame.getInstance().getCurrentUser().getName());
		name.setPreferredSize(new Dimension(170, 30));
		addChangeListener();
		
		JLabel money = new JLabel("  Money: "+String.format("%,d", MainGame.getInstance().getCurrentUser().getMoney()));
		JLabel score = new JLabel("  Score: "+MainGame.getInstance().getCurrentUser().getScore());
		
		String placement = "";
		if(MainGame.getInstance().getRound()!=0){
			int place = MainGame.getInstance().getCurrentUserPlacement();
			if(place == 1) placement = "<html><font color='#B29600'>("+ordinal(place)+")</font></html>";
			else if(place == 2) placement = "<html><font color='#909090'>("+ordinal(place)+")</font></html>";
			else if(place == 3) placement = "<html><font color='#8B492E'>("+ordinal(place)+")</font></html>";
			else placement = "<html>("+ordinal(place)+")</font></html>";
		}
		
		JLabel placement_label = new JLabel(placement);
		JLabel round = new JLabel("  Round: "+MainGame.getInstance().getRound());
		
		add(explain);
		add(name);
		add(money);
		add(score);
		add(placement_label);
		add(round);
	}
	
	public void changeName(String newName) {
		if(newName.isEmpty()) newName = "Player"+ (MainGame.getInstance().getCurrendUserID()+1);
		MainGame.getInstance().getCurrentUser().setName(newName);
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
	
	private String ordinal(int i) {
	    String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
	    switch (i % 100) {
	    case 11:
	    case 12:
	    case 13:
	        return i + "th";
	    default:
	        return i + suffixes[i % 10];

	    }
	}

}
