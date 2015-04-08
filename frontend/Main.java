package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.util.List;

import javax.swing.*;

import tests.InvalidPlayer;
import tests.InvalidPosition;
import tests.InvalidUser;
import backend.MainGame;

public class Main {
	
	private static final Main instance = new Main();
	private JFrame frame;
	private JPanel right;
	private JPanel change;
	private MainGame game;
	
	private Main() {
		this.game = MainGame.getInstance();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = new ImageIcon("src/res/Images/icon.png").getImage();
		frame.setIconImage(icon);
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public void createAndShowGUI() {
		restartGame();
	}
	
	public void restartGame() {
		frame.getContentPane().removeAll();
		frame.add(new StartPanel());
		frame.setBackground(Color.WHITE);
        frame.setVisible(true);
	}
	
	public void startGame(List<String> names) throws InvalidPlayer, InvalidPosition, InvalidUser {
		game.setNumUsers(names);
		
		HandleButtons actionList = new HandleButtons();
		frame.getContentPane().removeAll();
		frame.setMinimumSize(new Dimension(1200,700));
		frame.setLocationRelativeTo(null);
		
		JPanel buttons = new JPanel(){
			private static final long serialVersionUID = 1L;
			protected void paintComponent(Graphics g) {
				Image img = new ImageIcon("src/res/Images/logo_standard.png").getImage();
				g.drawImage(img, 0, 0, this.getSize().width, this.getSize().height , null);
		    }
		};
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
	
	public void restartFrame() throws InvalidUser {

		setPanelAsScore();
		
		BorderLayout layout = (BorderLayout) right.getLayout();
		right.remove(layout.getLayoutComponent(BorderLayout.NORTH));
		right.add(new NameChange(), BorderLayout.NORTH);
		
		setPanelAsFieldViewer();

        frame.setVisible(true);
        frame.validate();
	}
	
	public void setPanelAsMarket(JScrollPane scroll, int value) {
		change.removeAll();
		change.add(new JScrollPane(new MarketPanel(scroll, value)));
		change.setVisible(false);
		change.setVisible(true);
	}
	
	public void setPanelAsScore() throws InvalidUser {
		change.removeAll();
		change.add(new ScorePanel());
		change.setVisible(false);
		change.setVisible(true);
	}
	
	public void setPanelAsRoster() throws InvalidPlayer {
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
	
	public void setEndgamePanel() throws InvalidUser {
		frame.getContentPane().removeAll();
		frame.setMinimumSize(new Dimension(1200,700));
		frame.setLocationRelativeTo(null);
		
		frame.setLayout(new BorderLayout(0, 0));
		frame.add(new ScorePanel(), BorderLayout.CENTER);
		frame.add(new EndgamePanel(), BorderLayout.SOUTH);
		
		frame.setVisible(true);
        frame.validate();
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

	public void changeFrameHeight(int num_players) {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int screen_width = gd.getDisplayMode().getWidth();
		int screen_height = gd.getDisplayMode().getHeight();
		System.out.println(num_players);
		frame.setMinimumSize(new Dimension(720, 140+num_players*47));
		frame.setSize(new Dimension(720, 140+num_players*47));
		frame.setLocation((int) (screen_width/2-frame.getWidth()/2), (int) (screen_height/2 - 300));
		frame.validate();
	}
}


