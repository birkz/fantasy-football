package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tests.InvalidPlayer;
import tests.InvalidPosition;

public class HandleButtons implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand();
		
		if(arg == "Market") Main.getInstance().setPanelAsMarket();
		
		if(arg == "Scoreboard") Main.getInstance().setPanelAsScore();
		
		if(arg == "Roster")
			try {
				Main.getInstance().setPanelAsRoster();
			} catch (InvalidPlayer e1) {
				e1.printStackTrace();
			} catch (InvalidPosition e1) {
				e1.printStackTrace();
			}
		
		if(arg == "League") Main.getInstance().setPanelAsLeague();
		
		if(arg == "END TURN") backend.MainGame.getInstance().nextUser();
	}

}
