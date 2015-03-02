package fantasy_football;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class HandleButtons implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand(); // ætti kannski að setja þetta inn í switch
		if(arg == "One Player") Main.startGame();
		
		if(arg == "Two Players") Main.startGame();
		
		if(arg == "Three Players") Main.startGame();
		
		if(arg == "New Panel") {
			Main.switchImage(new AddImage(new ImageIcon("src/Images/jetpack_speeding.png").getImage()));
		}
		
		if(arg == "Old Panel") {
			Main.switchImage(new AddImage(new ImageIcon("src/Images/CetpbfB.png").getImage()));
		}
		
	}

}
