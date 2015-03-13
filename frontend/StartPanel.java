package frontend;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StartPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public StartPanel() {
		HandleButtons actionList = new HandleButtons();
		
		JButton startButton = new JButton("One Player");
		JButton startButton2 = new JButton("Two Players");
		JButton startButton3 = new JButton("Three Players");
		JButton startButton4 = new JButton("Four Players");
		
        //Add action listener to buttons
		startButton.addActionListener(actionList);
		startButton2.addActionListener(actionList);
		startButton3.addActionListener(actionList);
		startButton4.addActionListener(actionList);
		
		setBorder(new EmptyBorder(100, 100, 100, 100));
		setLayout(new GridLayout(4, 1, 5, 5));
		add(startButton);
		add(startButton2);
		add(startButton3);
		add(startButton4);
	}

}
