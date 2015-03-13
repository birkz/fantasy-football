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
	
	private final int numUsers;
	private final Color[] col = {Color.red, Color.green, Color.blue, Color.CYAN};
	private final int height;
	private final int width;

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
			JLabel one = new JLabel(backend.MainGame.getUser(i).getName());
			one.setForeground (col[i]);
			add(one);
		}
		height = 2*Main.getFrameSize().height/3;
		width = Main.getFrameSize().width/2;
		setSize(new Dimension(width, height));
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
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
