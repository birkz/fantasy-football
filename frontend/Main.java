package is.hi.f2a.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.List;

import javax.swing.*;
import javax.swing.RowSorter.SortKey;

import is.hi.f2a.tests.InvalidPlayer;
import is.hi.f2a.tests.InvalidPosition;
import is.hi.f2a.tests.InvalidUser;
import is.hi.f2a.backend.MainGame;

public class Main {
	
	private static final Main instance = new Main();
	private JFrame frame;
	private JPanel right;
	private JPanel left;
	
	private JButton[] arrButtons;
	private String[] navButtons = new String[]{"MARKET", 
											   "SCORES", 
											   "ROSTER", 
											   "LEAGUE",};
	private String endButton = "END TURN";
	
	private int buttonON = 1; //Score takkinn
	
	private FieldViewerPanel field;
	
	private Main() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = new ImageIcon("src/is/hi/f2a/res/Images/icon.png").getImage();
		frame.setTitle("FANTASY FOOTBALL 2015");
		frame.setIconImage(icon);
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public void createAndShowGUI() {
		restartGame();
	}
	
	public String[] getNavButtonArg() {
		return this.navButtons;
	}
	
	public JButton[] getNavButtons() {
		return this.arrButtons;
	}
	
	public String getEndButtonArg() {
		return this.endButton;
	}
	
	public void toggleButton(int num) {
		((CustomButton) arrButtons[this.buttonON]).toggleOFF();
		((CustomButton) arrButtons[num]).toggleON();
		buttonON = num;
	}
	
	public void restartGame() {
		frame.getContentPane().removeAll();
		frame.setMinimumSize(new Dimension(800, 150));
		frame.add(new StartPanel());
		frame.setBackground(Color.WHITE);
		frame.setVisible(false);
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setLocation(frame.getX(), frame.getY()-200);

        frame.setVisible(true);
        frame.validate();
        frame.setResizable(false);
	}
	
	public void startGame(List<String> names) throws InvalidPlayer, InvalidPosition, InvalidUser, IOException {
		MainGame.getInstance().setNumUsers(names);
		frame.setResizable(true);
		frame.setVisible(false);
		
		HandleButtons actionList = new HandleButtons();
		frame.getContentPane().removeAll();
		frame.setMinimumSize(new Dimension(1200,700));
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(1,2,2,0));
		
		left = new JPanel();
		right = new JPanel();
        
		frame.add(left);
		frame.add(right);
		
		
		///////////////
		//NAV BUTTONS
		///////////////
		JPanel buttons = new JPanel();
	
		// Grid for 4 buttons side by side
		buttons.setLayout(new GridLayout(1,4,2,2));
		int buttonsheight = 40;
		buttons.setPreferredSize(new Dimension(left.getWidth(), buttonsheight));
		
		arrButtons = new CustomButton[navButtons.length];
		for(int k=0; k<navButtons.length; ++k) {
			arrButtons[k] = DesignedButton.orangeStyle(navButtons[k], Font.PLAIN, 20);
			arrButtons[k].setBackground(Color.WHITE);
			arrButtons[k].addActionListener(actionList); 
		}
		
		for(int k=0; k<navButtons.length; ++k) {
			buttons.add(arrButtons[k]);
		}
		///////////////////
        
		///////////////////
		// END TURN BUTTON
		///////////////////
        //JPanel endPanel = new JPanel();
        //endPanel.setSize(50, 50);
        JButton endturn = DesignedButton.endStyle(endButton, Font.PLAIN, 20);
        endturn.addActionListener(actionList);
        //endPanel.add(endturn, BorderLayout.CENTER);
        ///////////////////

		
		left.setLayout(new BorderLayout(0, 0));
		left.setBorder(BorderFactory.createEmptyBorder(0,10,5,5)); 
		left.add(buttons, BorderLayout.NORTH);
		left.add(new ScorePanel(), BorderLayout.CENTER);
		
		right.setLayout(new BorderLayout(0, 0));
		right.setBorder(BorderFactory.createEmptyBorder(0,5,0,10)); 
		right.add(new NameChange(), BorderLayout.NORTH);
		
		this.field = new FieldViewerPanel();
		right.add(this.field, BorderLayout.CENTER);
		right.add(endturn, BorderLayout.SOUTH);
		
		//White backgrounds everywhere
		frame.getContentPane().setBackground(Color.WHITE);
		left.setBackground(Color.WHITE);
		right.setBackground(Color.WHITE);
		buttons.setBackground(Color.WHITE);
		
		toggleButton(1); // Score takkinn

        frame.setVisible(true);
        
        // Birtum PlayerProfile í nýjum þræði í byrjun til að flýta fyrir opnun leiksins
        InnerThread profileloading = new InnerThread();
        profileloading.start();
        
        frame.validate();
      
	}
	
	// Er að reyna hérna refresha left panelið eftir hverja turn
	// Kalla á þetta fall í MainGame
	public void refreshFrame() throws InvalidUser, IOException, InvalidPlayer {
		BorderLayout rightlayout = (BorderLayout) right.getLayout();
		right.remove(rightlayout.getLayoutComponent(BorderLayout.NORTH));
		right.add(new NameChange(), BorderLayout.NORTH);
		

		if(buttonON == 0) setPanelAsMarket(null, 0, null, "", "Any Team", "Any Position");
		else if(buttonON == 1) setPanelAsScore();
		else if(buttonON == 2) setPanelAsRoster();
		else setPanelAsLeague(false);
		
		setPanelAsFieldViewer();
		
		frame.setVisible(true);
        frame.validate();
	}

	
	public void restartFrame() throws InvalidUser, IOException {

		setPanelAsScore();
		
		BorderLayout layout = (BorderLayout) right.getLayout();
		right.remove(layout.getLayoutComponent(BorderLayout.NORTH));
		right.add(new NameChange(), BorderLayout.NORTH);
		
		setPanelAsFieldViewer();

        frame.setVisible(true);
        frame.validate();
	}
	
	public void setPanelAsMarket(JScrollPane scroll, int value, List<? extends SortKey> sortkeys, String pl_choice, String team_choice, String pos_choice) {
		BorderLayout layout = (BorderLayout) left.getLayout();
		left.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		left.add(new MarketPanel(scroll, value, sortkeys, pl_choice, team_choice, pos_choice), BorderLayout.CENTER);
		toggleButton(0);
		
		left.setVisible(false);
		left.setVisible(true);
	}
	
	public void setPanelAsScore() throws InvalidUser {
		BorderLayout layout = (BorderLayout) left.getLayout();
		left.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		left.add(new ScorePanel(), BorderLayout.CENTER);
		toggleButton(1);
		
		left.setVisible(false);
		left.setVisible(true);
	}
	
	public void setPanelAsRoster() throws InvalidPlayer {
		BorderLayout layout = (BorderLayout) left.getLayout();
		left.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		left.add(new RosterPanel(), BorderLayout.CENTER);
		toggleButton(2);
		
		left.setVisible(false);
		left.setVisible(true);
	}
	
	public void setPanelAsLeague(boolean isEnd) {
		BorderLayout layout = (BorderLayout) left.getLayout();
		left.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		left.add(new LeaguePanel(isEnd), BorderLayout.CENTER);
		toggleButton(3);
		
		left.setVisible(false);
		left.setVisible(true);
	}
	
	public void setEndgamePanel(boolean isEnd) throws InvalidUser {
		frame.getContentPane().removeAll();
		frame.setMinimumSize(new Dimension(1200,700));
		frame.setLocationRelativeTo(null);
		
		frame.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2,5,5));
		panel.add(new ScorePanel());
		panel.add(new LeaguePanel(isEnd));
		frame.add(panel, BorderLayout.CENTER);
		
		//////
		//NEW
		//////
		JButton newgame = DesignedButton.newStyle("NEW GAME", Font.PLAIN, 20);
		frame.add(newgame, BorderLayout.SOUTH);
		newgame.addActionListener(new HandleButtons());
		//////
		
		//OLD
		//frame.add(new EndgamePanel(), BorderLayout.SOUTH);
		
		frame.setVisible(true);
        frame.validate();
	}
	
	public void setPanelAsFieldViewer() throws IOException {
		BorderLayout layout = (BorderLayout) right.getLayout();
		right.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		right.add(this.field, BorderLayout.CENTER);
		// Þarf ekki að loada hér í nýjum þræði því hverri mynd fyrir sig er loadað í nýjum þræði
		// Þá komum við í veg fyrir að völlurinn birtist í sekúndubrot á undan leikmönnum
		loadFieldProfiles();
		right.setVisible(false);
		right.setVisible(true);

	}

	public void packFrame() {
		frame.pack();
	}
	
	public FieldViewerPanel getFieldViewer() {
		return this.field;
	}
	
	/////////////////////////
	// Football field stuff
	/////////////////////////
	private void loadFieldProfiles() throws IOException {
		field.addProfiles();
	}
	
	public void refreshRightPanel() {
		right.setVisible(false);
		right.setVisible(true);
		right.validate();
	}
	
	public void refreshLeftPanel() {
		left.setVisible(false);
		left.setVisible(true);
		left.validate();
	}
	
	private class InnerThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				//repaintField();
				loadFieldProfiles();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	///////
	//MAIN
	///////
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
            	getInstance().createAndShowGUI();
            }
        });
	}
}


