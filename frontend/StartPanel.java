package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class StartPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel center = new JPanel();
	private final JTextField field;
	private List<String> names = new ArrayList<String>();
	private int numEmpty = 1;

	/**
	 * Create the panel.
	 */
	public StartPanel() {
		field = new JTextField();
		field.setPreferredSize(new Dimension(200, 30));
		
		JButton addPlayer = new JButton("Add Player");
		//Add action listener to button
        addPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	action();
            }
        }); 
        field.addKeyListener(new KeyListener(){
        	
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					action();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
        
		JButton startGame = new JButton("Start Game");
		//Add action listener to button
		startGame.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	Main.getInstance().startGame(names);
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
	
	public void action() {
		String name = field.getText();
        if(names.size()<8) {
        	if(name.isEmpty()) name = "Player" + numEmpty++;
            names.add(name);
            field.setText("");
            changeCenter();
        }
	}
	
	public void changeCenter() {
		int size = names.size();
		center.removeAll();
		center.setLayout(new GridLayout(8, 1, 5, 5));
		for(int i=0; i<size; ++i) {
			final JPanel panel = new JPanel();
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
