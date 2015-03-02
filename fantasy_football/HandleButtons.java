package fantasy_football;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleButtons implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand(); // ætti kannski að setja þetta inn í switch
		
		if(arg == "One Player") Main.startGame();
		
		if(arg == "Two Players") Main.startGame();
		
		if(arg == "Three Players") Main.startGame();
		
		if(arg == "Market") Main.setPanelAsMarket();
		
		if(arg == "Scoreboard") Main.setPanelAsScore();
		
		if(arg == "Roster") Main.setPanelAsRoster();
		
		if(arg == "League") Main.setPanelAsLeague();
	}

}
