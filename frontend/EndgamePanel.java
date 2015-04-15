package is.hi.f2a.frontend;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EndgamePanel extends JPanel {

	/**
	 * TIL AÐ LÁTA NEW GAME TAKKANN FYLLA RAMMANN Á BREIDDINA, ÁKVAÐ ÉG AÐ NOTA EKKI ÞENNAN KLASA LENGUR
	 * KOMMENTAÐI ÞETTA BARA ÚT Í MAIN OG EKKERT MÁL AÐ LAGA TIL BAKA
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public EndgamePanel() {
		JButton newgame = DesignedButton.newStyle("NEW GAME", Font.PLAIN, 20);
		newgame.addActionListener(new HandleButtons());
		add(newgame);
	}

}
