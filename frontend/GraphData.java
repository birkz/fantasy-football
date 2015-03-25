package frontend;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphData extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final int numUsers;
	private final Color[] col= {new Color(255,0,0), new Color(0,255,0), new Color(0,0,255), new Color(255,255,0), new Color(0,255,255), 
			 new Color(255,0,255), new Color(192,192,192), new Color(128,0,0), new Color(128,128,0), new Color(0,128,0),
			 new Color(128,0,128), new Color(0,128,128), new Color(0,0,128), new Color(128,128,128), new Color(255,127,80),
			 new Color(255,140,0), new Color(124,252,0), new Color(0,100,0), new Color(0,255,255), new Color(32,178,170),
			 new Color(100,149,237), new Color(138,43,226), new Color(139,0,139), new Color(255,182,193), new Color(139,69,19),
			 new Color(210,105,30), new Color(244,164,96), new Color(188,143,143), new Color(127,255,212), new Color(0,100,0)};
			// = {Color.red, Color.green, Color.blue, Color.CYAN, Color.DARK_GRAY,
			//Color.ORANGE, Color.PINK, Color.LIGHT_GRAY, new Color(250, 50, 250)};

	/**
	 * Create the panel.
	 */
	public GraphData() {
		this.numUsers = backend.MainGame.getInstance().getNumUsers();
		setBorder(BorderFactory.createLineBorder(Color.black));
		for (int i=0; i<numUsers; ++i) {
			JLabel one = new JLabel(backend.MainGame.getInstance().getUser(i).getName());
			one.setForeground (col[i]);
			add(one);
		}
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }
	
	@Override 
	public void paintComponent(Graphics g) {
		int width = this.getWidth();
		int height = this.getHeight();
		super.paintComponent(g);
		Graphics2D draw = (Graphics2D) g;
		int[] score;
		int round = backend.MainGame.getInstance().getRound();
		for(int i=0; i<numUsers; ++i) {
			score = backend.MainGame.getInstance().getUser(i).getScore();
			draw.setColor(col[i]);
	        draw.setStroke(new BasicStroke(2));
	        GeneralPath line = new GeneralPath();
	        line.moveTo(0, height);
	        for(int k=0; k<round; ++k) {
	        	line.lineTo((k+1)*width/10, height-(score[k]));
	        }
	        draw.draw(line);
		}
    }

}
