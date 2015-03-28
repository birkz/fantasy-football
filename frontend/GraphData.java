package frontend;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tests.InvalidUser;
import backend.MainGame;
import backend.StatsHistory;
import backend.User;

public class GraphData extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final Color[] col= {new Color(255,0,0), new Color(0,255,0), new Color(0,0,255), new Color(255,255,0), new Color(0,255,255), 
			 new Color(255,0,255), new Color(192,192,192), new Color(128,0,0), new Color(128,128,0), new Color(0,128,0),
			 new Color(128,0,128), new Color(0,128,128), new Color(0,0,128), new Color(128,128,128), new Color(255,127,80),
			 new Color(255,140,0), new Color(124,252,0), new Color(0,100,0), new Color(0,255,255), new Color(32,178,170),
			 new Color(100,149,237), new Color(138,43,226), new Color(139,0,139), new Color(255,182,193), new Color(139,69,19),
			 new Color(210,105,30), new Color(244,164,96), new Color(188,143,143), new Color(127,255,212), new Color(0,100,0)};

	/**
	 * Create the panel.
	 */
	public GraphData() {
		List<User> users = MainGame.getInstance().getUsers();
		setBorder(BorderFactory.createLineBorder(Color.black));
		for (int i=0; i<users.size(); ++i) {
			JLabel label = new JLabel(users.get(i).getName());
			label.setForeground (col[i]);
			add(label);
		}
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }
	
	@Override 
	public void paintComponent(Graphics g) {
		List<User> users = MainGame.getInstance().getUsers();
		StatsHistory stats = MainGame.getInstance().getStatsHistory();
		int numUsers = users.size();
		int width = this.getWidth();
		int height = this.getHeight();
		super.paintComponent(g);
		Graphics2D draw = (Graphics2D) g;
		List<Integer> allscores;
		int highscore = 10;
		for(int i=0; i<numUsers; ++i) {
			//score = users.get(i).getScore();
			int size = 0;
			try {
				allscores = stats.getTotalUserScores(users.get(i));
				
				if(size>0) {
					int lastscore = allscores.get(allscores.size()-1)/10;
					if(highscore < lastscore) {
						highscore = lastscore;
					}
				}
				
			} catch (InvalidUser e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		int maxscore = (int) (Math.ceil(((double)highscore) /10)*10.0);
		for(int i=0; i<numUsers; ++i) {
			//score = users.get(i).getScore();
			try {
				allscores = stats.getTotalUserScores(users.get(i));
		
				draw.setColor(col[i]);
		        draw.setStroke(new BasicStroke(2));
		        GeneralPath line = new GeneralPath();
		        line.moveTo(0, height);
		        for(int k=0; k<allscores.size(); ++k) {
		        	line.lineTo((k+1)*width/10, height-height/maxscore*(allscores.get(k)/10));
		        }
		        draw.draw(line);
				
			} catch (InvalidUser e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    }

}
