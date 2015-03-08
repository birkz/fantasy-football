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
	
	private static int[] y;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public GraphData(int[] data) {
		y = data;
		setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel one = new JLabel("player0");
		one.setForeground (Color.red);
		add(one);
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }
	
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D draw = (Graphics2D) g;
		GeneralPath line = new GeneralPath();
		
		draw.setColor(Color.RED);
        draw.setStroke(new BasicStroke(2));
        line.moveTo(0, 400);
        for(int i=0; i<y.length; ++i) {
        	line.lineTo(i*40, 400-y[i]);
        }
        draw.draw(line);
    }

}
