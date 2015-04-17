package is.hi.f2a.frontend;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import is.hi.f2a.tests.InvalidUser;
import is.hi.f2a.backend.FontUtil;
import is.hi.f2a.backend.MainGame;
import is.hi.f2a.backend.StatsHistory;
import is.hi.f2a.backend.User;

public class GraphData extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final Color[] col= {new Color(255,0,0), new Color(0,200,0), new Color(0,0,255), new Color(196,126,27), new Color(0,210,210), 
			 new Color(255,0,255), new Color(192,192,192), new Color(128,0,0), new Color(128,128,0), new Color(0,128,0),
			 new Color(128,0,128), new Color(0,128,128), new Color(0,0,128), new Color(128,128,128), new Color(255,127,80),
			 new Color(255,140,0), new Color(124,252,0), new Color(0,100,0), new Color(0,255,255), new Color(32,178,170),
			 new Color(100,149,237), new Color(138,43,226), new Color(139,0,139), new Color(255,182,193), new Color(139,69,19),
			 new Color(210,105,30), new Color(244,164,96), new Color(188,143,143), new Color(127,255,212), new Color(0,100,0)};
	
	private Image background;
	private JLabel[] labels;
	
	/**
	 * Create the panel.
	 */
	public GraphData() {
		List<User> users = MainGame.getInstance().getUsers();
		this.labels = new JLabel[users.size()];
		
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		//setLayout(new GridLayout(8,1)); // Breyting
		for (int i=0; i<users.size(); ++i) {
			this.labels[i] = new JLabel(users.get(i).getName());// + ": " + users.get(i).getScore());
			this.labels[i].setFont(FontUtil.getFont("kalinga", Font.PLAIN, 12));
			this.labels[i].setForeground (col[i]);
			add(this.labels[i]);
		}
		
		this.background = new ImageIcon("src/is/hi/f2a/res/Images/graphbackground.png").getImage();
	}

	@Override 
	public void paintComponent(Graphics g) {
		
		List<User> users = MainGame.getInstance().getUsers();
		int numUsers = users.size();
		int width = this.getSize().width;
		int height = this.getSize().height;
		super.paintComponent(g);
		
		int fontsize = width/40;
		for(int i = 0; i < labels.length; i++) {
			//this.labels[i].setFont(FontUtil.getFont("kalinga", Font.PLAIN, fontsize));
		}
		
		Graphics2D draw = (Graphics2D) g;
		draw.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//draw.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY)); 
		
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
		double maxscore = (Math.ceil(((double)highscore) /10)*10.0);
		
		draw.setColor(Color.WHITE);
		draw.fill(new Rectangle2D.Double(0, 0, width, height));
		
		///////////////////////
		// Draw background logo
		int imgwidth = this.background.getWidth(null);
		int imgheight = this.background.getHeight(null);
		int base = width/8;
		int scaledwidth = base*imgwidth/imgheight;
		int scaledheight = base;
		int imgxpos = (width/2)-scaledwidth/2;
		int imgypos = (height/2)-scaledheight/2;
		draw.drawImage(this.background, imgxpos, imgypos, scaledwidth, scaledheight, null);
		///////////////////////
		
		StatsHistory stats = MainGame.getInstance().getStatsHistory();
		List<Integer> allscores;
		
		draw.setColor(new Color(0, 0, 0, 50));
		draw.setStroke(new BasicStroke(1));
		for(int i=1; i<18; ++i) {
			draw.drawLine(i*width/18, 0, i*width/18, height);
		}
		double num = height/maxscore*5;
		for(int i=1; (int) (i*num)<height; ++i) {
			draw.drawLine(0, (int) (i*num), width,(int) (i*num));
		}

		draw.setStroke(new BasicStroke(2));
		for(int i=0; i<numUsers; ++i) {
			try {
				allscores = stats.getTotalUserScores(users.get(i));
		
				int lastpointx = 0;
				int lastpointy = 0;
				int lastscore = 0;
				draw.setColor(col[i]);
		        GeneralPath line = new GeneralPath();
		        line.moveTo(0, height+minScore);
		        for(int k=0; k<allscores.size(); ++k) 
		        {
		        	lastpointx = (k+1)*width/18;
		        	lastpointy = (int) (height-height/(maxscore-minScore)*(allscores.get(k))+minScore);
		        	lastscore = allscores.get(k);
		        	
		        	line.lineTo((k+1)*width/18, (height-height/(maxscore-minScore)*(allscores.get(k))+minScore));
		        }
		        draw.draw(line);
		        
		        // Scorelabel at the end of the line
		        if(allscores.size() > 0) {
			        // Calculate number of numbers in points
					int numlength;
					if(lastscore == 0) numlength = 1;
					else numlength = (int)(Math.log10(lastscore)+1);
					
					int extralength;
					if(numlength == 1) extralength = 8;
					else extralength = numlength*8;
					
					int xoffset;
					if(allscores.size() == 1) xoffset = -3;
					else if(allscores.size() == 18) xoffset = -7-extralength;
					else xoffset = -10;
					
					int labelheight = 16;
					int labelwidth = extralength+12;
					
					draw.setPaint(col[i].darker());
					draw.fill(new RoundRectangle2D.Double(lastpointx+xoffset-6, lastpointy-labelheight/2, labelwidth, labelheight, labelheight, labelheight));
			        
					draw.setPaint(Color.WHITE);
			        draw.setFont(FontUtil.getFont("kalinga", Font.PLAIN, 14));
			        draw.drawString(Integer.toString(lastscore), lastpointx+xoffset, lastpointy+5); //BARA HUGMYND
		        }
				
			} catch (InvalidUser e) {
				e.printStackTrace();
			}
			
		}
    }

}
