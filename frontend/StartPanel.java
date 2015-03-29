package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

import backend.FontUtil;
import tests.InvalidPlayer;
import tests.InvalidPosition;
import tests.InvalidUser;
import res.Constants;


public class StartPanel extends JPanel {

	/**
	 * Constants
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instance variables
	 */
	private JPanel north = new JPanel();
	private JPanel center = new JPanel();
	private JPanel south = new JPanel();
	private final JTextField field;
	private List<String> names = new ArrayList<String>();
	private int numEmpty = 1;
	private JButton startGame;
	private JButton addPlayer;
	private static final int frameheightchange = 47;

	/**
	 * Create the panel.
	 */
	public StartPanel() {
		field = new JTextField();
		field.setPreferredSize(new Dimension(200, 30));
		
		Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true);
		field.setBorder(border);
		field.setFont(FontUtil.getFont("kalinga", Font.PLAIN, 16));
		
		addPlayer = DesignedButton.orangeStyle("  ADD PLAYER  ", Font.PLAIN, 20);

        addPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	addPlayerHandler();
            	Main.getInstance().increaseFrameHeight(frameheightchange);

            }
        }); 
        field.addKeyListener(new KeyListener(){
        	
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					addPlayerHandler();
					Main.getInstance().increaseFrameHeight(frameheightchange);
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
        
		startGame = DesignedButton.orangeStyle("  START GAME  ", Font.PLAIN, 20);
		//Add action listener to button
		startGame.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	try {
					Main.getInstance().startGame(names);
				} catch (InvalidPlayer | InvalidPosition | InvalidUser e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        }); 
		
		setLayout(new BorderLayout(0, 0));
		north.setPreferredSize(new Dimension(800, 100));
		north.setOpaque(false);
		
		// Set all panels white
		north.setBackground(Color.WHITE);
		center.setBackground(Color.WHITE);
		south.setBackground(Color.WHITE);
		
		south.add(field);
		south.add(addPlayer);
		south.add(startGame);
		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.SOUTH);
		add(south, BorderLayout.CENTER);
		
		// If we don't allow zero players to play, disable the "Start Game" button.
		if(Constants.MIN_USERS>0){
			startGame.setEnabled(false);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Dimension size = Main.getInstance().returnSizeForPanel();
		Image img = new ImageIcon("src/res/Images/logo_standard.png").getImage();
		int imagehalfwidth = img.getWidth(null)/2;
		int framehalfwidth = size.width;
		int centeroffset = framehalfwidth-imagehalfwidth;
		g.drawImage(img, centeroffset+5, 5, null);
	}
	
	/*
	 * Handle events when a player is added, by pressing "ENTER" and by clicking the "Add Player" button.
	 */
	private void addPlayerHandler() {
		//this.centersize += 25;
		String name = field.getText();
    	if(name.isEmpty()) name = "Player" + numEmpty++;
        names.add(name);
        field.setText("");
        changeCenter();
        
        // If we already have MAX_USERS, disable the "Add Player" button.
        if(names.size()==Constants.MAX_USERS){
        	addPlayer.setEnabled(false);
        	field.setEnabled(false);
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
		center.removeAll();
		center.setLayout(new GridLayout(size, 1, 5, 5));
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
	                
	                if(names.size()<Constants.MIN_USERS){
	                	startGame.setEnabled(false);
	                }
	                Main.getInstance().decreaseFrameHeight(frameheightchange);
	            }
	        }); 
			panel.add(removePlayer);
			center.add(panel);
		}
		center.validate();
		center.repaint();
	}

}
