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
	private final Color[] col = {Color.red, Color.green, Color.blue, Color.CYAN, Color.DARK_GRAY,
			Color.ORANGE, Color.PINK, Color.LIGHT_GRAY};

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
