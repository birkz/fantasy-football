package frontend;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NameChange extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public NameChange() {
		final JTextField name = new JTextField();
		JButton change = new JButton("Change Name");
		
		change.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  backend.MainGame.getCurrentUser().changeName(name.getText());
	        }
		});
		
		name.setText(backend.MainGame.getCurrentUser().getName());
		name.setPreferredSize(new Dimension(200, 30));
		add(name);
		add(change);
	}

}
