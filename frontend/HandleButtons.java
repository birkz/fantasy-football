package is.hi.f2a.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import is.hi.f2a.backend.MainGame;
import is.hi.f2a.tests.InvalidPlayer;
import is.hi.f2a.tests.InvalidUser;

public class HandleButtons implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand();
		
		if(arg == "Market")
			Main.getInstance().setPanelAsMarket(null, 0);
		
		if(arg == "Scoreboard")
			try {
				Main.getInstance().setPanelAsScore();
			} catch (InvalidUser e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		if(arg == "Roster")
			try {
				Main.getInstance().setPanelAsRoster();
			} catch (InvalidPlayer e1) {
				e1.printStackTrace();
			}
		
		if(arg == "League") Main.getInstance().setPanelAsLeague();
		
		if(arg == "NEW GAME") {
			MainGame.getInstance().resetGame();
			Main.getInstance().restartGame();
		}
		
		if(arg == "END TURN")
			try {
				is.hi.f2a.backend.MainGame.getInstance().nextUser();
			} catch (InvalidUser e1) {
				e1.printStackTrace();
			}
	}

}
