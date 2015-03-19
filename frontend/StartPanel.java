package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class StartPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel center = new JPanel();
	private List<String> names = new ArrayList<String>();

	/**
	 * Create the panel.
	 */
	public StartPanel() {
		JTextField field = new JTextField();
		field.setPreferredSize(new Dimension(200, 30));
		
		JButton addPlayer = new JButton("Add Player");
		//Add action listener to button
        addPlayer.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                String name = field.getText();
                if(names.size()<8) {
	                names.add(name);
	                field.setText("");
	                changeCenter();
                }
            }
        }); 
        
		JButton startGame = new JButton("Start Game");
		//Add action listener to button
		startGame.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	Main.startGame(names);
            }
        }); 
		
		setLayout(new BorderLayout(0, 0));
		JPanel north = new JPanel();
		north.add(field);
		north.add(addPlayer);
		north.add(startGame);
		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
	}
	
	public void changeCenter() {
		int size = names.size();
		center.removeAll();
		center.setLayout(new GridLayout(8, 1, 5, 5));
		for(int i=0; i<size; ++i) {
			JPanel panel = new JPanel();
			JLabel label = new JLabel(names.get(i));
			panel.add(label);
			JButton button = new JButton("Remove Player");
			button.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	                int num = center.getComponentCount();
	                for(int i=0; i<num; ++i) {
	                	if(center.getComponent(i).equals(panel)) {
	                		names.remove(i);
	                		changeCenter();
	                		break;
	                	}
	                }
	            }
	        }); 
			panel.add(button);
			center.add(panel);
		}
		center.validate();
		center.repaint();
	}

}
