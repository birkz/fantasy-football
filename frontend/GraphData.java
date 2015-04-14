package is.hi.f2a.frontend;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import is.hi.f2a.tests.InvalidUser;
import is.hi.f2a.backend.MainGame;
import is.hi.f2a.backend.StatsHistory;
import is.hi.f2a.backend.User;

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
	public GraphData(int width0, int height0) {
		List<User> users = MainGame.getInstance().getUsers();
		setBorder(BorderFactory.createLineBorder(Color.black));
		for (int i=0; i<users.size(); ++i) {
			JLabel label = new JLabel(users.get(i).getName());
			label.setForeground (col[i]);
			add(label);
		}
	}

	@Override 
	public void paintComponent(Graphics g) {
		List<User> users = MainGame.getInstance().getUsers();
		int numUsers = users.size();
		int width = this.getSize().width;
		int height = this.getSize().height;
		super.paintComponent(g);
		Graphics2D draw = (Graphics2D) g;
		draw.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		int highscore = 10;
		int minScore = -20; 
		for(int i=0; i<numUsers; ++i) {
			int score = users.get(i).getScore();	
			if(highscore < score) {
				highscore = score;
			}
			if(minScore > score) {
				minScore = score;
			}
		}
		int maxscore = (int) (Math.ceil(((double)highscore) /10)*10.0);
		
		draw.setColor(Color.WHITE);
		draw.fill(new Rectangle2D.Double(0, 0, width, height));
		
		StatsHistory stats = MainGame.getInstance().getStatsHistory();
		List<Integer> allscores;

		for(int i=0; i<numUsers; ++i) {
			try {
				allscores = stats.getTotalUserScores(users.get(i));
		
				draw.setColor(col[i]);
		        draw.setStroke(new BasicStroke(2));
		        GeneralPath line = new GeneralPath();
		        line.moveTo(0, height+minScore);
		        for(int k=0; k<allscores.size(); ++k) {
		        	line.lineTo((k+1)*width/10, (height-height/(maxscore-minScore)*(allscores.get(k))+minScore));
		        }
		        draw.draw(line);
				
			} catch (InvalidUser e) {
				e.printStackTrace();
			}
			
		}
    }

}
