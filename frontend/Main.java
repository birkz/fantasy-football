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

import is.hi.f1a.FantasyFootballBackend;
import is.hi.f2a.res.Constants;
import is.hi.f2a.tests.InvalidPlayer;
import is.hi.f2a.tests.InvalidPosition;
import is.hi.f2a.tests.InvalidUser;
import is.hi.f2a.backend.MainGame;

public class Main {
	
	private static final Main instance = new Main();
	private static FantasyFootballBackend simulation;
	private boolean simstatus = false;
	private boolean startgame = false;
	
	private JFrame frame;
	private JPanel right;
	private JPanel left;
	private JPanel buttons;
	
	private JButton[] arrButtons;
	private String[] navButtons = new String[]{"SCORES", "MARKET", "ROSTER", "LEAGUE",};
	private JButton endTurnButton;
	private String endButtonArg;
	
	private int buttonON = Constants.SCORE_BUTTON; //Leikur opnast á SCORE
	
	private FieldViewerPanel field;
	private StartPanel startpanel;
	private Image icon;
	
	private Main() {
		this.icon = new ImageIcon("src/is/hi/f2a/res/Images/icon.png").getImage();
		// Loadum hermuninu í nýjum þræði þegar forritið er ræst
        InnerThread2 initSimulationBackend = new InnerThread2();
        initSimulationBackend.start();
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public static FantasyFootballBackend getMainSimulation() {
		return simulation;
	}
	
	public boolean isSimulationReady() {
		return this.simstatus;
	}
	
	public void updateSimulationStatus() {
		this.simstatus = true;
	}
	
	public boolean shouldGameStart() {
		return this.startgame;
	}
	
	public void updateGameStart() {
		this.startgame = true;
	}
	
	private void basicFrameSetup() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("FANTASY FOOTBALL 2015");
		frame.setIconImage(icon);
	}
	
	public void createAndShowGUI() {
		basicFrameSetup();
		newGame();
	}
	
	public void restartGame() {
		disposeFrame();
		newGame();
	}
	
	public JButton[] getNavButtons() {
		return this.arrButtons;
	}
	
	public JButton getEndTurnButton() {
		return this.endTurnButton;
	}
	
	public void toggleButton(int num) {
		((CustomButton) arrButtons[this.buttonON]).toggleOFF();
		((CustomButton) arrButtons[num]).toggleON();
		buttonON = num;
	}
	
	private void disposeFrame() {
		frame.dispose();
		basicFrameSetup();
	}
	
	private void newGame() {
		frame.getContentPane().removeAll();
		frame.setMinimumSize(new Dimension(800, 150));
		
		this.startpanel = new StartPanel();
		frame.add(this.startpanel);
		
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
		disposeFrame(); //Hreinsar frame og búum til nýjan.
		
		MainGame.getInstance().setNumUsers(names);
		frame.setResizable(true);
		frame.setVisible(false);
		
		//HandleButtons actionList = new HandleButtons();
		frame.getContentPane().removeAll();
		frame.setMinimumSize(new Dimension(1080, 630));
		frame.setSize(new Dimension(1200, 700));
		
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(1,2,2,0));
		
		left = new JPanel();
		right = new JPanel();
        
		frame.add(left);
		frame.add(right);
		
		buttons = new JPanel();
		setupButtons();
		
		left.setLayout(new BorderLayout(0, 0));
		left.setBorder(BorderFactory.createEmptyBorder(0,10,5,5)); 
		left.add(buttons, BorderLayout.NORTH);
		left.add(new GraphData(), BorderLayout.CENTER);
		
		right.setLayout(new BorderLayout(0, 0));
		right.setBorder(BorderFactory.createEmptyBorder(0,5,0,10)); 
		right.add(new NameChange(), BorderLayout.NORTH);
		
		this.field = new FieldViewerPanel();
		right.add(this.field, BorderLayout.CENTER);
		right.add(this.endTurnButton, BorderLayout.SOUTH);
		
		//White backgrounds everywhere
		frame.getContentPane().setBackground(Color.WHITE);
		left.setBackground(Color.WHITE);
		right.setBackground(Color.WHITE);
		buttons.setBackground(Color.WHITE);
		
		toggleButton(Constants.SCORE_BUTTON); // Score takkinn innsettur þegar leikur byrjar

        frame.setVisible(true);
        
        // Birtum PlayerProfile í nýjum þræði í byrjun til að flýta fyrir opnun leiksins
        InnerThread profileloading = new InnerThread();
        profileloading.start();
        
        frame.validate();
      
	}
	
	private void setupButtons() {
		
		HandleButtons actionList = new HandleButtons();
		///////////////
		//NAV BUTTONS
		///////////////
		// Grid for 4 buttons side by side
		this.buttons.setLayout(new GridLayout(1,4,2,2));
		int buttonsheight = 40;
		this.buttons.setPreferredSize(new Dimension(this.left.getWidth(), buttonsheight));
		
		this.arrButtons = new CustomButton[navButtons.length];
		for(int k=0; k<navButtons.length; ++k) {
			this.arrButtons[k] = DesignedButton.orangeStyle(navButtons[k], Font.PLAIN, 20);
			this.arrButtons[k].setBackground(Color.WHITE);
			this.arrButtons[k].addActionListener(actionList); 
		}
		
		for(int k=0; k<navButtons.length; ++k) {
			this.buttons.add(arrButtons[k]);
		}	
		
		///////////////////
		// END TURN BUTTON
		///////////////////
		int playerid = MainGame.getInstance().getCurrendUserID()+1;
		int numofplayers = MainGame.getInstance().getUsers().size();
		this.endButtonArg = "END TURN ("+playerid+"/"+numofplayers+")";
		this.endTurnButton = DesignedButton.endStyle(endButtonArg, Font.PLAIN, 20);
		this.endTurnButton.addActionListener(actionList);

	}
	
	private void updateEndButton() {
		int playerid = MainGame.getInstance().getCurrendUserID()+1;
		int numofplayers = MainGame.getInstance().getUsers().size();
		int round = MainGame.getInstance().getRound()+1;
		this.endButtonArg = "END TURN ("+playerid+"/"+numofplayers+")";
		((CustomButton) this.endTurnButton).changeText(this.endButtonArg);
		if(playerid == numofplayers) {
			
			if(round == Constants.MAX_ROUNDS){	
				String hovertext = "END GAME";
				((CustomButton) this.endTurnButton).changeTextOnHover(hovertext);
			}
			else {
				String hovertext = "NEW ROUND";
				((CustomButton) this.endTurnButton).changeTextOnHover(hovertext);
			}
		}
	}
	
	// Köllum á þetta alltaf eftir "end turn" til að uppfæra GUI
	public void refreshFrame() throws InvalidUser, IOException, InvalidPlayer {
		
		//Vinstri hlið
		if(buttonON == Constants.SCORE_BUTTON) setPanelAsScore();
		else if(buttonON == Constants.MARKET_BUTTON) setPanelAsMarket(null, 0, null, "", "Any Team", "Any Position");
		else if(buttonON == Constants.ROSTER_BUTTON) setPanelAsRoster();
		else if(buttonON == Constants.LEAGUE_BUTTON)setPanelAsLeague(false);
		
		//Hægri hlið
		BorderLayout rightlayout = (BorderLayout) right.getLayout();
		right.remove(rightlayout.getLayoutComponent(BorderLayout.NORTH));
		right.add(new NameChange(), BorderLayout.NORTH);
		setPanelAsFieldViewer();
		updateEndButton();
		
	}

	
	public void restartFrame() throws InvalidUser, IOException {

		// Vinstri hlið
		setPanelAsScore();
		
		// Hægri hlið
		BorderLayout layout = (BorderLayout) right.getLayout();
		right.remove(layout.getLayoutComponent(BorderLayout.NORTH));
		right.add(new NameChange(), BorderLayout.NORTH);
		setPanelAsFieldViewer();
		updateEndButton();

	}
	
	public void setPanelAsScore() throws InvalidUser {
		BorderLayout layout = (BorderLayout) left.getLayout();
		left.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		left.add(new GraphData(), BorderLayout.CENTER);
		toggleButton(Constants.SCORE_BUTTON);
		
		refreshLeftPanel();
	}
	
	public void setPanelAsMarket(JScrollPane scroll, int value, List<? extends SortKey> sortkeys, String pl_choice, String team_choice, String pos_choice) {
		BorderLayout layout = (BorderLayout) left.getLayout();
		left.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		left.add(new MarketPanel(scroll, value, sortkeys, pl_choice, team_choice, pos_choice), BorderLayout.CENTER);
		toggleButton(Constants.MARKET_BUTTON);
		
		refreshLeftPanel();
	}
	
	public void setPanelAsRoster() throws InvalidPlayer {
		BorderLayout layout = (BorderLayout) left.getLayout();
		left.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		left.add(new RosterPanel(), BorderLayout.CENTER);
		toggleButton(Constants.ROSTER_BUTTON);
		
		refreshLeftPanel();
	}
	
	public void setPanelAsLeague(boolean isEnd) {
		BorderLayout layout = (BorderLayout) left.getLayout();
		left.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		left.add(new LeaguePanel(isEnd), BorderLayout.CENTER);
		toggleButton(Constants.LEAGUE_BUTTON);
		
		refreshLeftPanel();
	}
	
	public void setEndgamePanel(boolean isEnd) throws InvalidUser {
		frame.getContentPane().removeAll();
		frame.setMinimumSize(new Dimension(1200,700));
		frame.setLocationRelativeTo(null);
		
		frame.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new GridLayout(1,2,5,5));
		panel.add(new GraphData());
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
		// Þá komum við í veg fyrir að völlurinn birtist(flökktir) í sekúndubrot á undan leikmönnum
		loadFieldProfiles();
		refreshRightPanel();

	}
	
	public void refreshRightPanel() {
		right.setVisible(false);
		right.setVisible(true);
	}
	
	public void refreshLeftPanel() {
		left.setVisible(false);
		left.setVisible(true);
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
	
	////////////////////////////////////////////////
	// Thread for loading backend and starting game
	////////////////////////////////////////////////
	private class InnerThread2 extends Thread {
		@Override
		public void run() {
			simulation = is.hi.f1a.FantasyFootballBackend.getInstance();
			updateSimulationStatus();
			try {
				if(shouldGameStart()) startGame(startpanel.getNames());
			} catch (InvalidPlayer | InvalidPosition | InvalidUser | IOException e) {
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


