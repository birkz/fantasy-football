package is.hi.f2a.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import is.hi.f2a.backend.MainGame;
import is.hi.f2a.tests.InvalidPlayer;
import is.hi.f2a.tests.InvalidUser;

public class HandleButtons implements ActionListener{
	
	//private static String[] navbuttonsargs = Main.getInstance().getNavButtonArg();
	private static JButton[] navbuttons;
	private static JButton endbutton;

	@Override
	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand(); // Muna að uppfæra þetta
		
		navbuttons = Main.getInstance().getNavButtons();
		endbutton = Main.getInstance().getEndTurnButton();
		
		
		if(e.getSource().equals(navbuttons[0])) {
			Main.getInstance().setPanelAsMarket(null, 0, null, "", "Any Team", "Any Position");

		}
		
		if(e.getSource().equals(navbuttons[1])) {
			try {
				Main.getInstance().setPanelAsScore();
			} catch (InvalidUser e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		}
		
		if(e.getSource().equals(navbuttons[2])) {
			try {
				Main.getInstance().setPanelAsRoster();
			} catch (InvalidPlayer e1) {
				e1.printStackTrace();
			}

		}
		
		if(e.getSource().equals(navbuttons[3])) {
			Main.getInstance().setPanelAsLeague(false);

		}
		
		if(arg == "NEW GAME") {
			MainGame.getInstance().resetGame();
			Main.getInstance().restartGame();
		}
		
		if(e.getSource().equals(endbutton))
			try {
				is.hi.f2a.backend.MainGame.getInstance().nextUser();
			} catch (InvalidUser | IOException | InvalidPlayer e1) {
				e1.printStackTrace();
			}
	}

}
