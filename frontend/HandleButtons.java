package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleButtons implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand();
		
		if(arg == "Market") Main.getInstance().setPanelAsMarket();
		
		if(arg == "Scoreboard") Main.getInstance().setPanelAsScore();
		
		if(arg == "Roster") Main.getInstance().setPanelAsRoster();
		
		if(arg == "League") Main.getInstance().setPanelAsLeague();
		
		if(arg == "END TURN") backend.MainGame.getInstance().nextUser();
	}

}
