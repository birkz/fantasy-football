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
	
	private int numUsers;
	private static Color[] col = {Color.red, Color.green, Color.blue};

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public GraphData() {
		this.numUsers = backend.MainGame.getNumUsers();
		setBorder(BorderFactory.createLineBorder(Color.black));
		for (int i=0; i<numUsers; ++i) {
			JLabel one = new JLabel("player"+i);
			one.setForeground (col[i]);
			add(one);
		}
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }
	
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D draw = (Graphics2D) g;

		int[] score;
		int round = backend.MainGame.getRound();
		for(int i=0; i<numUsers; ++i) {
			score = backend.MainGame.getUser(i).getScore();
			draw.setColor(col[i]);
	        draw.setStroke(new BasicStroke(3));
	        GeneralPath line = new GeneralPath();
	        line.moveTo(0, 400);
	        for(int k=0; k<round; ++k) {
	        	line.lineTo(k*40+40, 400-(score[k]/2));
	        }
	        draw.draw(line);
		}
    }

}
