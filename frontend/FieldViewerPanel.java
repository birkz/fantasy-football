package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.awt.Image;
>>>>>>> parent of 896621e... changed package location
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;
=======
import java.awt.Image;
>>>>>>> parent of 74cfc3e... push to pull

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

<<<<<<< HEAD
<<<<<<< HEAD
import is.hi.f1a.Player;
import is.hi.f2a.backend.Roster;
=======
import tests.PlayerInterface;
import backend.Roster;
>>>>>>> parent of 896621e... changed package location

=======
>>>>>>> parent of 74cfc3e... push to pull
public class FieldViewerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel[] players = new JPanel[]{new JPanel(), new JPanel(), new JPanel(), new JPanel()};

	/**
	 * Create the panel.
	 */
	public FieldViewerPanel() {
<<<<<<< HEAD
		
		this.roster = backend.MainGame.getInstance().getCurrentUser().getRoster();
		
=======
>>>>>>> parent of 74cfc3e... push to pull
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
<<<<<<< HEAD
		Dimension size = Main.getInstance().returnSizeForPanel(); // ÞETTA ER EKKI AÐ GEFA RÉTTAR TÖLUR
		int w_offset = 2;  // Það þarf að minnka breiddina svo ramminn sem er teiknaður fari ekki útfyrir panel
		int h_offset = 2; // Furðulega mikið offset á hæðinni
		int width = size.width-w_offset;
		int height = size.height-h_offset;
		
		// Völlurinn sem png mynd
		//Image img = new ImageIcon("src/res/Images/field.png").getImage();
		//g.drawImage(img, 0, 0, size.width, size.height, null);
		
		// Völlurinn teiknaður með java graphics
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(new Color(23, 74, 146)); //Litur vallar
		// THE FIELD
		g2.fill(new Rectangle2D.Double(0, 0, width, height));
		
		g2.setPaint(Color.WHITE); //Litur línu
		g2.setStroke(new BasicStroke(2));
		int line_offset = 6;
		int halfwidth = width/2;
		int halfheight = height/2;
		
		// CENTER
		// Center line
		g2.draw(new Line2D.Double(line_offset+1, halfheight+line_offset+2, width-2*line_offset+4, halfheight+line_offset+2));
		// Center circle
		int diameter = (width+height)/10;
		g2.draw(new Ellipse2D.Double(halfwidth-diameter/2, halfheight+line_offset-diameter/2, diameter, diameter));
		
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
		int pen_offset = height-2*line_offset-pen_height;
		g2.draw(new Rectangle2D.Double(pen_center, line_offset+pen_offset, pen_width, pen_height));
		// Goal area
		int goal_offset = height-2*line_offset-goal_height;
		g2.draw(new Rectangle2D.Double(goal_center, line_offset+goal_offset, goal_width, goal_height));
		// Penalty arc
		int arc_offset = height-2*line_offset-2*pen_height;
		int arc_start_offset = -180;
		g2.draw(new Arc2D.Double(arc_xpos, arc_ypos+arc_offset, arc_width, arc_height, arc_start+arc_start_offset, arc_length, Arc2D.OPEN));
		
		// FRAME
		g2.draw(new Rectangle2D.Double(line_offset, line_offset, width-2*line_offset, height-2*line_offset));
		
		
=======
		Dimension size = Main.getInstance().returnSizeForPanel();
		Image img = new ImageIcon("src/Images/field.png").getImage();
		g.drawImage(img, 0, 0, size.width, size.height, null);
>>>>>>> parent of 74cfc3e... push to pull
	}
	
	@Override
    public Dimension getPreferredSize() {
        return Main.getInstance().returnSizeForPanel();
    }
	
	public void AddToPanels() {
<<<<<<< HEAD
<<<<<<< HEAD
		Iterator<List<Player>> roster_it = this.roster.getPlayersOnField().iterator();
=======
		Iterator<List<PlayerInterface>> roster_it = this.roster.getPlayersOnField().iterator();
>>>>>>> parent of 896621e... changed package location
		int i = 3;
		
		while(roster_it.hasNext()){
			List<PlayerInterface> players_in_pos = roster_it.next();
			Iterator<PlayerInterface> players_in_pos_it = players_in_pos.iterator();
			
			while(players_in_pos_it.hasNext()){
				players[i].add(createLabels(players_in_pos_it.next().getName()));
			}
			
			i--;
		}
=======
		players[0].add(createLabels("Striker1"));
		players[0].add(createLabels("Striker2"));
		players[0].add(createLabels("Striker3"));
		players[1].add(createLabels("Midfielder1"));
		players[1].add(createLabels("Midfielder2"));
		players[1].add(createLabels("Midfielder3"));
		players[1].add(createLabels("Midfielder4"));
		players[2].add(createLabels("Defender1"));
		players[2].add(createLabels("Defender2"));
		players[2].add(createLabels("Defender3"));
		players[3].add(createLabels("Goaly"));
>>>>>>> parent of 74cfc3e... push to pull
	}
	
	public JLabel createLabels(String name) {
		JLabel label = new JLabel(name);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		label.setPreferredSize(new Dimension(100, 50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		return label;
	}

}
