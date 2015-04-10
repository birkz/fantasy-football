package is.hi.f2a.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.*;

import is.hi.f2a.tests.InvalidPlayer;
import is.hi.f2a.tests.InvalidPosition;
import is.hi.f2a.tests.InvalidUser;
import is.hi.f2a.backend.MainGame;

public class Main {
	
	private static final Main instance = new Main();
	private JFrame frame;
	private JPanel right;
	private JPanel left;
	
	//private boolean winlocationset = false; //Breyta til að stöðva endurstaðsetningu glugga
	
	private Main() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = new ImageIcon("src/res/Images/icon.png").getImage();
		frame.setTitle("FANTASY FOOTBALL 2015");
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
		frame.setMinimumSize(new Dimension(800, 150));
		frame.add(new StartPanel());
		frame.setBackground(Color.WHITE);
		frame.setVisible(false);
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		//GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		//int screen_width = gd.getDisplayMode().getWidth();
		//int screen_height = gd.getDisplayMode().getHeight();
		//frame.setLocation((int) (screen_width/2-400), (int) (screen_height/2 - 300));
		//winlocationset = false;

		frame.setLocation(frame.getX(), frame.getY()-200);

        frame.setVisible(true);
        frame.setResizable(false);
	}
	
	public void startGame(List<String> names) throws InvalidPlayer, InvalidPosition, InvalidUser {
		MainGame.getInstance().setNumUsers(names);
		frame.setResizable(true);
		
		HandleButtons actionList = new HandleButtons();
		frame.getContentPane().removeAll();
		frame.setMinimumSize(new Dimension(1200,700));
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(1,2,2,0));
		
		JPanel buttons = new JPanel(){
			private static final long serialVersionUID = 1L;
			protected void paintComponent(Graphics g) {
				Image img = new ImageIcon("src/res/Images/logo_standard.png").getImage();
				g.drawImage(img, 0, 0, this.getSize().width, this.getSize().height , null);
		    }
		};
		left = new JPanel();
		right = new JPanel();
		
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
        
		frame.add(left);
		frame.add(right);
		
		left.setLayout(new BorderLayout(0, 0));
		left.setBorder(BorderFactory.createEmptyBorder(0,10,5,5)); 
		left.add(buttons, BorderLayout.NORTH);
		left.add(new ScorePanel(), BorderLayout.CENTER);
		
		right.setLayout(new BorderLayout(0, 0));
		right.setBorder(BorderFactory.createEmptyBorder(0,5,0,10)); 
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
		BorderLayout layout = (BorderLayout) left.getLayout();
		left.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		left.add(new MarketPanel(scroll, value), BorderLayout.CENTER);
		left.setVisible(false);
		left.setVisible(true);
	}
	
	public void setPanelAsScore() throws InvalidUser {
		BorderLayout layout = (BorderLayout) left.getLayout();
		left.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		left.add(new ScorePanel(), BorderLayout.CENTER);
		left.setVisible(false);
		left.setVisible(true);
	}
	
	public void setPanelAsRoster() throws InvalidPlayer {
		BorderLayout layout = (BorderLayout) left.getLayout();
		left.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		left.add(new RosterPanel(), BorderLayout.CENTER);
		left.setVisible(false);
		left.setVisible(true);
	}
	
	public void setPanelAsLeague() {
		BorderLayout layout = (BorderLayout) left.getLayout();
		left.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		left.add(new LeaguePanel(), BorderLayout.CENTER);
		left.setVisible(false);
		left.setVisible(true);
	}
	
	public void setEndgamePanel() throws InvalidUser {
		frame.getContentPane().removeAll();
		frame.setMinimumSize(new Dimension(1200,700));
		frame.setLocationRelativeTo(null);
		
		frame.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2,5,5));
		panel.add(new ScorePanel());
		panel.add(new LeaguePanel());
		frame.add(panel, BorderLayout.CENTER);
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

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
            	getInstance().createAndShowGUI();
            }
        });
	}

	public void changeFrameHeight(int num_players) {
		/*GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int screen_width = gd.getDisplayMode().getWidth();
		int screen_height = gd.getDisplayMode().getHeight();
		//System.out.println(num_players);
		//frame.setMinimumSize(new Dimension(720, 180+num_players*47));
		//frame.setSize(new Dimension(720, 180+num_players*47));
		if(!this.winlocationset) {
			frame.setLocation((int) (screen_width/2-400), (int) (screen_height/2 - 300));
			this.winlocationset = true;
		}*/
		frame.pack();
		frame.validate();
	}
}


