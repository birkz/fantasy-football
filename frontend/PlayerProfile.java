package is.hi.f2a.frontend;

import is.hi.f2a.backend.FontUtil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PlayerProfile extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private static final Map<URL, Image> photos = new HashMap<URL, Image>();
	
	private int diameter = 100;
	private Image img;
	private URL url;
	private boolean loadfailed = false;
	private JPanel north;
	private JPanel south;
	private JLabel name;

	public PlayerProfile(String path, String playername) throws IOException {
		
		this.north = new JPanel();
		this.south = new JPanel();
		this.name = createLabel(playername);
		
		try {
			
			this.url = new URL(path);
			// Check if image is in the hashmap for fast loading
			if (photos != null && photos.get(path) != null) {
				this.img = photos.get(path);
				//System.out.println("loaded from hash");
			}
			else {

				InnerThread loadImage = new InnerThread();
				loadImage.start();
				this.img = new ImageIcon("src/is/hi/f2a/res/Images/playerplaceholder.png").getImage();
				this.loadfailed = true;
			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Unable to load image from: " + path);
			this.img = new ImageIcon("src/is/hi/f2a/res/Images/playerplaceholder.png").getImage();
			this.loadfailed = true;
		}
	
		setLayout(new BorderLayout(0, 0));
		north.setPreferredSize(new Dimension(diameter, diameter));
		north.setOpaque(false);
		south.setOpaque(false);
		south.add(this.name);
		
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		
	}
	
	private void loadImageFromWeb() throws IOException {
		
		BufferedImage bufferedImage = ImageIO.read(this.url);
		this.img = new ImageIcon(bufferedImage).getImage();
		//ImageIO.write((RenderedImage) this.img, "jpg", new File("src/is/hi/f2a/res/cache/" + playername + ".jpg"));
		photos.put(this.url, this.img);
		this.loadfailed = false;
		Main.getInstance().refreshRightPanel();
	}
	
	private class InnerThread extends Thread {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				loadImageFromWeb();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY)); 
		
		int imgwidth = this.img.getWidth(null);
		int imgheight = this.img.getHeight(null);
		int base = this.diameter+10;
		int scaledwidth = base*imgwidth/imgheight;
		int scaledheight = base;
		int xoffset = -scaledwidth/14;
		int yoffset = 1;
		int circleoffset = 5;
		
		Shape circle = new Ellipse2D.Double(circleoffset,0, this.diameter, this.diameter);
		g2.setClip(circle);
		if(!this.loadfailed){
			g2.drawImage(this.img, xoffset, yoffset, scaledwidth, scaledheight, null);
		} else {
			g2.setPaint(new Color(255,255,255,204));
			g2.fill(new Rectangle2D.Double(xoffset, yoffset, scaledwidth, scaledheight));
			g2.drawImage(this.img, xoffset, yoffset, scaledwidth, scaledheight, null);
		}
		g2.setClip(null);
		
		g2.setPaint(Color.WHITE);
		g2.draw(new Ellipse2D.Double(circleoffset, 0, diameter, diameter));
	}
	
	private JLabel createLabel(String name) {
		JLabel label = new JLabel("<html><div style=\"text-align: center;\">"+name+"</html>");
		//label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		label.setBackground(new Color(255, 255, 255, 204));
		label.setFont(FontUtil.getFont("kalinga", Font.PLAIN, 14));
		label.setPreferredSize(new Dimension(this.diameter, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		return label;
	}

}
