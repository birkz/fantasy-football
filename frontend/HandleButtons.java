package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleButtons implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand();
		
		if(arg == "One Player") Main.startGame(1);
		
		if(arg == "Two Players") Main.startGame(2);
		
		if(arg == "Three Players") Main.startGame(3);
		
		if(arg == "Market") Main.setPanelAsMarket();
		
		if(arg == "Scoreboard") Main.setPanelAsScore();
		
		if(arg == "Roster") Main.setPanelAsRoster();
		
		if(arg == "League") Main.setPanelAsLeague();
		
		if(arg == "END TURN") System.out.println("ending turn");
	}

}
