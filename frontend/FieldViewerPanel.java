package is.hi.f2a.frontend;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import is.hi.f1a.Player;
import is.hi.f2a.backend.Roster;

public class FieldViewerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel[] players = new JPanel[]{new JPanel(), new JPanel(), new JPanel(), new JPanel()};
	private final Roster roster;

	/**
	 * Create the panel.
	 */
	public FieldViewerPanel() {
		
		this.roster = is.hi.f2a.backend.MainGame.getInstance().getCurrentUser().getRoster();
		
		setLayout(new GridLayout(8, 1, 5, 5));
		AddToPanels();
		for(int i=0; i<players.length; ++i) {
			JPanel fillup = new JPanel();
			fillup.setOpaque(false);
			add(fillup);
			players[i].setOpaque(false);
			add(players[i]);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		int w_offset = 2;  // Það þarf að minnka breiddina svo völlurinn sem er teiknaður fari ekki útfyrir panel
		int h_offset = 2; 
		int width = this.getSize().width-w_offset;
		int height = this.getSize().height-h_offset;
		int halfwidth = width/2;
		int halfheight = height/2;
		int line_offset = 6;
		
		// Völlurinn sem png mynd
		//Image img = new ImageIcon("src/res/Images/field.png").getImage();
		//g.drawImage(img, 0, 0, size.width, size.height, null);
		
		// Völlurinn teiknaður með java graphics
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// THE FIELD
		g2.setPaint(new Color(23, 74, 146)); //Litur vallar
		drawField(g2, width, height, line_offset);
	
		// THE LINES
		g2.setPaint(Color.WHITE); //Litur lína
		g2.setStroke(new BasicStroke(2)); // Þykkt lína
		drawFieldCenterWithFrame(g2, width, height, line_offset);
		drawAttackingDefendingAreas(g2, halfwidth, halfheight, line_offset);
		
	}
	
	private void drawAttackingDefendingAreas(Graphics2D g2, int halfwidth, int halfheight, int line_offset) {
		// ATTACKING AREA (top)
		// Penalty area
		int pen_center = halfwidth-halfwidth/2+line_offset;
		int pen_width = halfwidth-2*line_offset;
		int pen_height = halfheight/3;
		g2.draw(new Rectangle2D.Double(pen_center, line_offset, pen_width, pen_height));
		// Goal area
		int goal_center = halfwidth-halfwidth/6+line_offset;
		int goal_width = halfwidth/3-2*line_offset;
		int goal_height = halfheight/8;
		g2.draw(new Rectangle2D.Double(goal_center, line_offset, goal_width, goal_height));
		// Penalty arc
		int arc_width = halfwidth/4-2*line_offset;;
		int arc_height = goal_height;
		int arc_xpos = halfwidth-arc_width/2;
		int arc_ypos = pen_height+line_offset-goal_height/2;
		int arc_start = 182;
		int arc_length = 176;
		g2.draw(new Arc2D.Double(arc_xpos, arc_ypos, arc_width, arc_height, arc_start, arc_length, Arc2D.OPEN));
		
		// DEFENDING AREA (bottom)
		// Penalty area
		int height = 2*halfheight;
		int pen_offset = height-2*line_offset-pen_height;
		g2.draw(new Rectangle2D.Double(pen_center, line_offset+pen_offset, pen_width, pen_height));
		// Goal area
		int goal_offset = height-2*line_offset-goal_height;
		g2.draw(new Rectangle2D.Double(goal_center, line_offset+goal_offset, goal_width, goal_height));
		// Penalty arc
		int arc_offset = height-2*line_offset-2*pen_height;
		int arc_start_offset = -180;
		g2.draw(new Arc2D.Double(arc_xpos, arc_ypos+arc_offset, arc_width, arc_height, arc_start+arc_start_offset, arc_length, Arc2D.OPEN));
	}
	
	private void drawFieldCenterWithFrame(Graphics2D g2, int width, int height, int line_offset) {
		int halfwidth = width/2;
		int halfheight = height/2;
		int diameter = (width+height)/10;

		g2.draw(new Line2D.Double(line_offset+1, halfheight+line_offset+2, width-2*line_offset+4, halfheight+line_offset+2)); // Center line
		g2.draw(new Ellipse2D.Double(halfwidth-diameter/2, halfheight+line_offset-diameter/2, diameter, diameter)); // Center circle
		g2.draw(new Rectangle2D.Double(line_offset, line_offset, width-2*line_offset, height-2*line_offset)); // Frame
	}
	
	private void drawField(Graphics2D g2, int width, int height, int line_offset) {
		g2.fill(new Rectangle2D.Double(0, 0, width, height)); 
	}
/*	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }
 */  
	public void AddToPanels() {
		Iterator<List<Player>> roster_it = this.roster.getPlayersOnField().iterator();
		int i = 3;
		
		while(roster_it.hasNext()){
			List<Player> players_in_pos = roster_it.next();
			Iterator<Player> players_in_pos_it = players_in_pos.iterator();
			
			while(players_in_pos_it.hasNext()){
				players[i].add(createLabels(players_in_pos_it.next().getName()));
			}
			
			i--;
		}
	}
	
	public JLabel createLabels(String name) {
		JLabel label = new JLabel("<html><div style=\"text-align: center;\">"+name+"</html>");
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		label.setPreferredSize(new Dimension(104, 50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		return label;
	}

}
