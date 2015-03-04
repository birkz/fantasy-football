package frontend;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main {
	
	private static JFrame frame;
	private static JPanel left;
	private static JPanel right;
	private static JPanel change;
	
	public static void createAndShowGUI() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new StartPanel());
	    frame.pack();
        frame.setVisible(true);
	}
	
	public static void startGame(int i) {
		backend.MainGame.setNumUsers(i);
		
		HandleButtons actionList = new HandleButtons();
		frame.getContentPane().removeAll();
		
		AddImage panel = new AddImage(new ImageIcon("src/Images/CetpbfB.png").getImage());
		AddImage panel3 = new AddImage(new ImageIcon("src/Images/jetpack_speeding.png").getImage());
		
		JPanel buttons = new JPanel();
		left = new JPanel();
		right = new JPanel();
		change = new JPanel();
		
		JButton marketButton = new JButton("Market");
		//Add action listener to button
		marketButton.addActionListener(actionList); 
        
        JButton scoreButton = new JButton("Scoreboard");
        //Add action listener to button
        scoreButton.addActionListener(actionList); 
        
        JButton rosterButton = new JButton("Roster");
        //Add action listener to button
        rosterButton.addActionListener(actionList); 
        
        JButton leagueButton = new JButton("League");
        //Add action listener to button
        leagueButton.addActionListener(actionList); 
        
        JButton endTurnButton = new JButton("END TURN");
        //Add action listener to button
        endTurnButton.addActionListener(actionList); 

        buttons.add(marketButton);
        buttons.add(scoreButton);
        buttons.add(rosterButton);
        buttons.add(leagueButton);
        
        JPanel endPanel = new JPanel();
        endPanel.setSize(50, 50);
        endPanel.add(endTurnButton);
        
        frame.setLayout(new BorderLayout(0, 0));
		frame.add(left, BorderLayout.WEST);
		frame.add(right, BorderLayout.EAST);
		
		left.setBorder(new EmptyBorder(5, 5, 5, 5));
		left.setLayout(new BorderLayout(0, 0));
		left.add(buttons, BorderLayout.NORTH);
		change.add(panel);
		left.add(change, BorderLayout.CENTER);
		
		right.setBorder(new EmptyBorder(5, 5, 5, 5));
		right.setLayout(new BorderLayout(0, 0));
		right.add(new NameChange(), BorderLayout.NORTH);
		right.add(panel3, BorderLayout.CENTER);
		right.add(endPanel, BorderLayout.SOUTH);
		
	    frame.pack();
        frame.setVisible(true);
        frame.validate();
	}
	
	public static void restartFrame() {

		setPanelAsScore();
		
		BorderLayout layout = (BorderLayout) right.getLayout();
		right.remove(layout.getLayoutComponent(BorderLayout.NORTH));
		right.add(new NameChange(), BorderLayout.NORTH);
		
		setPanelAsFieldViewer(layout);
		
	    frame.pack();
        frame.setVisible(true);
        frame.validate();
	}
	
	public static void switchImage(AddImage panel) {
		change.removeAll();
		change.add(panel);
		frame.pack();
        frame.setVisible(true);
	}
	
	public static void setPanelAsMarket() {
		change.removeAll();
		//change.add(new MarketPanel());
		change.add(new AddImage(new ImageIcon("src/Images/jetpack_speeding.png").getImage()));
		frame.pack();
        frame.setVisible(true);
	}
	
	public static void setPanelAsScore() {
		change.removeAll();
		//change.add(new ScorePanel());
		change.add(new AddImage(new ImageIcon("src/Images/CetpbfB.png").getImage()));
		frame.pack();
        frame.setVisible(true);
	}
	
	public static void setPanelAsRoster() {
		change.removeAll();
		//change.add(new RosterPanel());
		change.add(new AddImage(new ImageIcon("src/Images/hair_dryer_breakfast.png").getImage()));
		frame.pack();
        frame.setVisible(true);
	}
	
	public static void setPanelAsLeague() {
		change.removeAll();
		//change.add(new LeaguePanel());
		change.add(new AddImage(new ImageIcon("src/Images/jetpack_speeding.png").getImage()));
		frame.pack();
        frame.setVisible(true);
	}
	
	public static void setPanelAsFieldViewer(BorderLayout layout) {
		AddImage panel3 = new AddImage(new ImageIcon("src/Images/jetpack_speeding.png").getImage());
		
		right.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		right.add(panel3, BorderLayout.CENTER);
		//right.add(new FieldViewerPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                createAndShowGUI();
            }
        });
	}
}


