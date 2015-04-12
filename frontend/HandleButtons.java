package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

<<<<<<< HEAD
<<<<<<< HEAD
import is.hi.f2a.backend.MainGame;
import is.hi.f2a.tests.InvalidPlayer;
import is.hi.f2a.tests.InvalidUser;
=======
import backend.MainGame;
import tests.InvalidPlayer;
import tests.InvalidUser;
>>>>>>> parent of 896621e... changed package location

=======
>>>>>>> parent of 74cfc3e... push to pull
public class HandleButtons implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand();
		
		if(arg == "Market") Main.getInstance().setPanelAsMarket();
		
		if(arg == "Scoreboard") Main.getInstance().setPanelAsScore();
		
		if(arg == "Roster") Main.getInstance().setPanelAsRoster();
		
		if(arg == "League") Main.getInstance().setPanelAsLeague();
		
<<<<<<< HEAD
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
=======
		if(arg == "END TURN") backend.MainGame.getInstance().nextUser();
>>>>>>> parent of 74cfc3e... push to pull
	}

}
