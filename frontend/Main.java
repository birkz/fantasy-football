package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.*;
import backend.MainGame;

public class Main {
	
	private static final Main instance = new Main();
	private JFrame frame;
	private JPanel right;
	private JPanel change;
	
	public static Main getInstance() {
		return instance;
	}
	
	public void createAndShowGUI() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new StartPanel());
		frame.setMinimumSize(new Dimension(800,400));
	    frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	public void startGame(List<String> names) {
		MainGame.getInstance().setNumUsers(names);
		
		HandleButtons actionList = new HandleButtons();
		frame.getContentPane().removeAll();
		frame.setMinimumSize(new Dimension(1200,700));
		frame.setLocationRelativeTo(null);
		
		JPanel buttons = new JPanel();
		JPanel left = new JPanel();
		right = new JPanel();
		change = new JPanel();
		
		String[] newButtons = new String[]{"Market", "Scoreboard", "Roster", "League", "END TURN"};
		JButton[] arrButtons = new JButton[newButtons.length];
		for(int k=0; k<newButtons.length; ++k) {
			arrButtons[k]= new JButton(newButtons[k]);
			arrButtons[k].addActionListener(actionList); 
		}
		
		for(int k=0; k<newButtons.length-1; ++k) {
			buttons.add(arrButtons[k]);
		}
        
        JPanel endPanel = new JPanel();
        endPanel.setSize(50, 50);
        endPanel.add(arrButtons[newButtons.length-1]);
        
        frame.setLayout(new BorderLayout(0, 0));
		frame.add(left, BorderLayout.WEST);
		frame.add(right, BorderLayout.EAST);
		
		left.setLayout(new BorderLayout(0, 0));
		left.add(buttons, BorderLayout.NORTH);
		setPanelAsScore();
		left.add(change, BorderLayout.CENTER);
		
		right.setLayout(new BorderLayout(0, 0));
		right.add(new NameChange(), BorderLayout.NORTH);
		right.add(new FieldViewerPanel(), BorderLayout.CENTER);
		right.add(endPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.validate();
	}
	
	public void restartFrame() {

		setPanelAsScore();
		
		BorderLayout layout = (BorderLayout) right.getLayout();
		right.remove(layout.getLayoutComponent(BorderLayout.NORTH));
		right.add(new NameChange(), BorderLayout.NORTH);
		
		setPanelAsFieldViewer();

        frame.setVisible(true);
        frame.validate();
	}
	
	public void setPanelAsMarket() {
		change.removeAll();
		change.add(new MarketPanel());
		change.setVisible(false);
		change.setVisible(true);
	}
	
	public void setPanelAsScore() {
		change.removeAll();
		change.add(new ScorePanel());
		change.setVisible(false);
		change.setVisible(true);
	}
	
	public void setPanelAsRoster() {
		change.removeAll();
		change.add(new RosterPanel());
		change.setVisible(false);
		change.setVisible(true);
	}
	
	public void setPanelAsLeague() {
		change.removeAll();
		change.add(new LeaguePanel());
		change.setVisible(false);
		change.setVisible(true);
	}
	
	public void setPanelAsFieldViewer() {
		BorderLayout layout = (BorderLayout) right.getLayout();
		right.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		right.add(new FieldViewerPanel(), BorderLayout.CENTER);
		right.setVisible(false);
		right.setVisible(true);
	}
	
	public Dimension returnSizeForPanel() {
		int height = frame.getSize().height-90;
		int width = (frame.getSize().width/2)-20;
		return new Dimension(width, height);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
            	getInstance().createAndShowGUI();
            }
        });
	}
}


