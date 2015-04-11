package is.hi.f2a.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

import is.hi.f2a.backend.FontUtil;
import is.hi.f2a.tests.InvalidPlayer;
import is.hi.f2a.tests.InvalidPosition;
import is.hi.f2a.tests.InvalidUser;
import is.hi.f2a.res.Constants;


public class StartPanel extends JPanel {

	/**
	 * Constants
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instance variables
	 */
	private JPanel players = new JPanel();
	private final JTextField playername_field;
	private List<String> names = new ArrayList<String>();
	private int numEmpty = 1;
	private JButton startGame;
	private JButton addPlayer;

	/**
	 * Create the panel.
	 */
	public StartPanel() {
		playername_field = new JTextField();
		JPanel fieldButt = new JPanel();
		playername_field.setPreferredSize(new Dimension(200, 30));
		
		Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true);
		playername_field.setBorder(border);
		playername_field.setFont(FontUtil.getFont("kalinga", Font.PLAIN, 16));
		
		addPlayer = DesignedButton.orangeStyle("  ADD PLAYER  ", Font.PLAIN, 20);

        addPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	addPlayerHandler();
            	Main.getInstance().packFrame();

            }
        }); 
        playername_field.addKeyListener(new KeyListener(){
        	
			@Override
			public void keyReleased(KeyEvent e) {
				// If enter is released, add the player
				if(e.getKeyCode() == 10) {
					addPlayerHandler();
					Main.getInstance().packFrame();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {/* Not used*/}

			@Override
			public void keyPressed(KeyEvent arg0) {/* Not used*/}
			
		});
        
		startGame = DesignedButton.orangeStyle("  START GAME  ", Font.PLAIN, 20);
		//Add action listener to button
		startGame.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
           
				try {
					Main.getInstance().startGame(names);
				} catch (InvalidPlayer | InvalidPosition | InvalidUser | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
            }
        }); 
		
		Image img = new ImageIcon("src/is/hi/f2a/res/Images/logo_standard.png").getImage();
		JLabel logo = new JLabel(new ImageIcon(img), JLabel.CENTER);;
	
		setLayout(new BorderLayout(0, 0));

		// Set all panels white
		setBackground(Color.WHITE);
		players.setBackground(Color.WHITE);
		fieldButt.setBackground(Color.WHITE);
		
		fieldButt.add(playername_field);
		fieldButt.add(addPlayer);
		fieldButt.add(startGame);
		add(logo, BorderLayout.NORTH);
		add(players, BorderLayout.SOUTH);
		add(fieldButt, BorderLayout.CENTER);
		
		// If we don't allow zero players to play, disable the "Start Game" button.
		if(Constants.MIN_USERS>0){
			startGame.setEnabled(false);
		}
	}

	/*
	 * Handle events when a player is added, by pressing "ENTER" and by clicking the "Add Player" button.
	 */
	private void addPlayerHandler() {
		//this.centersize += 25;
		String name = playername_field.getText();
    	if(name.isEmpty()) name = "Player" + numEmpty++;
        names.add(name);
        playername_field.setText("");
        changeCenter();
        
        // If we already have MAX_USERS, disable the "Add Player" button.
        if(names.size()==Constants.MAX_USERS){
        	addPlayer.setEnabled(false);
        	playername_field.setEnabled(false);
        }
        
        // If we have enough users we can enable the "Start Game" button.
        if(names.size()>=Constants.MIN_USERS){
        	startGame.setEnabled(true);
        }
	}
	
	/*
	 *  Keeps the center panel nicely looking
	 */
	private void changeCenter() {
		int size = names.size();
		players.removeAll();
		players.setLayout(new GridLayout(size, 1, 5, 5));
		for(int i=0; i<size; ++i) {
			final JPanel panel = new JPanel();
			JLabel label = new JLabel(names.get(i));
			label.setFont(FontUtil.getFont("kalinga", Font.PLAIN, 20));
			panel.setBackground(Color.WHITE);
			panel.add(label);
			JButton removePlayer = DesignedButton.deleteStyle(" REMOVE ", Font.PLAIN, 12);
			removePlayer.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	                int num = players.getComponentCount();
	                for(int i=0; i<num; ++i) {
	                	if(players.getComponent(i).equals(panel)) {
	                		names.remove(i);
	                		changeCenter();
	                		break;
	                	}
	                }
	                
	                // Make sure the "Add Player" button and field is enabled
	                addPlayer.setEnabled(true);
	                playername_field.setEnabled(true);
	                
	                // Check if we have fewer than MIN_USERS players
	                if(names.size()<Constants.MIN_USERS){
	                	startGame.setEnabled(false);
	                }
	                Main.getInstance().packFrame();
	            }
	        }); 
			panel.add(removePlayer);
			players.add(panel);
		}
		players.validate();
		players.repaint();
	}

}
