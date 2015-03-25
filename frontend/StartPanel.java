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
	 * Constants
	 */
	private static final long serialVersionUID = 1L;
	private final int MAX_USERS = 8;
	private final int MIN_USERS = 1;
	
	/**
	 * Instance variables
	 */
	private JPanel center = new JPanel();
	private final JTextField field;
	private List<String> names = new ArrayList<String>();
	private int numEmpty = 1;
	private JButton startGame;
	private JButton addPlayer;

	/**
	 * Create the panel.
	 */
	public StartPanel() {
		field = new JTextField();
		field.setPreferredSize(new Dimension(200, 30));
		
		addPlayer = new JButton("Add Player");
		//Add action listener to button
        addPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	addPlayerHandler();
            }
        }); 
        field.addKeyListener(new KeyListener(){
        	
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					addPlayerHandler();
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
        
		startGame = new JButton("Start Game");
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
		
		// If we don't allow zero players to play, disable the "Start Game" button.
		if(MIN_USERS>0){
			startGame.setEnabled(false);
		}
	}
	
	/*
	 * Handle events when a player is added, by pressing "ENTER" and by clicking the "Add Player" button.
	 */
	private void addPlayerHandler() {
		String name = field.getText();
    	if(name.isEmpty()) name = "Player" + numEmpty++;
        names.add(name);
        field.setText("");
        changeCenter();
        
        // If we already have MAX_USERS, disable the "Add Player" button.
        if(names.size()==MAX_USERS){
        	addPlayer.setEnabled(false);
        	field.setEnabled(false);
        }
        
        // If we have enough users we can enable the "Start Game" button.
        if(names.size()>=MIN_USERS){
        	startGame.setEnabled(true);
        }
	}
	
	/*
	 *  Keeps the center panel nicely looking
	 */
	private void changeCenter() {
		int size = names.size();
		center.removeAll();
		center.setLayout(new GridLayout(8, 1, 5, 5));
		for(int i=0; i<size; ++i) {
			final JPanel panel = new JPanel();
			JLabel label = new JLabel(names.get(i));
			panel.add(label);
			JButton removePlayer = new JButton("Remove Player");
			removePlayer.addActionListener(new ActionListener() {
				 
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
	                
	                // Make sure the "Add Player" button and field is enabled
	                addPlayer.setEnabled(true);
	                field.setEnabled(true);
	                
	                if(names.size()<MIN_USERS){
	                	startGame.setEnabled(false);
	                }
	            }
	        }); 
			panel.add(removePlayer);
			center.add(panel);
		}
		center.validate();
		center.repaint();
	}

}
