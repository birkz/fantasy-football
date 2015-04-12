package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import backend.MainGame;
import tests.InvalidPlayer;
import tests.InvalidUser;

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
				backend.MainGame.getInstance().nextUser();
			} catch (InvalidUser e1) {
				e1.printStackTrace();
			}
	}

}
